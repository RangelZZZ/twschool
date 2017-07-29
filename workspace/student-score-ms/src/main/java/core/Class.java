package core;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Class {
    private List<Student> students = new ArrayList<>();

    public List<Student> addStudent(Student student) {

        this.students.add(student);

        return students;
    }

    public int getTotalScore(ArrayList<Student> students) {
        int totalScore = 0;
        for (Student student : students) {
            totalScore += student.getTotalScore();
        }
        return totalScore;
    }

    public int getMedianScore(ArrayList<Student> selectedStudents) {
        ArrayList<Student> sortedStudents = sortStudentsByTotalScore(selectedStudents);
        int MedianSize = sortedStudents.size();

        if (MedianSize % 2 == 0) {

            return (sortedStudents.get(MedianSize / 2).getTotalScore() + sortedStudents.get(MedianSize / 2 - 1).getTotalScore()) / 2;
        }

        return sortedStudents.get(MedianSize / 2).getTotalScore();
    }

    private ArrayList<Student> sortStudentsByTotalScore(ArrayList<Student> selectedStudents) {
        return (ArrayList<Student>) selectedStudents.stream().sorted((s1, s2) -> s1.getTotalScore() - s2.getTotalScore()).collect(toList());

    }

    public List<Student> getSelectedStudents(ArrayList<String> studentIds) {
        List<Student> selectedStudents = students.stream().filter(stu -> this.isExits(studentIds, stu)).collect(toList());

        return selectedStudents;
    }

    private boolean isExits(ArrayList<String> studentIds, Student stu) {
        String id = studentIds.stream().filter(s -> s.equals(stu.getId())).findAny().orElse(null);
        if (id == null) {
            return false;
        }
        return true;

    }
}


