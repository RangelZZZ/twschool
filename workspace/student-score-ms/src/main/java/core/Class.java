package core;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Class {
    private ArrayList<Student> students = new ArrayList<>();

    public ArrayList addStudent(Student student) {

        this.students.add(student);

        return students;
    }

    public int getTotalScore() {
        int totalScore = 0;
        for (Student student : getStudents()) {
            totalScore += student.getTotalScore();
        }
        return totalScore;
    }

    public int getMedianScore() {
        ArrayList<Student> sortedStudents = sortStudentsByTotalScore();

        int MedianSize = sortedStudents.size();
        if (MedianSize % 2 == 0) {

            return (sortedStudents.get(MedianSize / 2).getTotalScore() + sortedStudents.get(MedianSize / 2 - 1).getTotalScore()) / 2;
        }

        return sortedStudents.get(MedianSize / 2).getTotalScore();
    }

    private ArrayList<Student> sortStudentsByTotalScore() {
        return (ArrayList<Student>) students.stream().sorted((s1, s2) -> s1.getTotalScore() - s2.getTotalScore()).collect(toList());

    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public List<Student> getSelectedStudent(ArrayList<String> studentIds) {
        return students.stream().filter(stu -> this.isExits(studentIds, stu)).collect(toList());
    }

    private boolean isExits(ArrayList<String> studentIds, Student stu) {
        String id = studentIds.stream().filter(s -> s.equals(stu.getId())).findAny().orElse(null);
        if (id == null) {
            return false;
        }
        return true;

    }
}


