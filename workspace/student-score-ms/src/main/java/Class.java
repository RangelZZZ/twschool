import java.util.ArrayList;
import java.util.stream.Collectors;

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
        return (ArrayList<Student>) students.stream().sorted((s1, s2) -> s1.getTotalScore() - s2.getTotalScore()).collect(Collectors.toList());

    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
