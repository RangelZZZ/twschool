import java.util.ArrayList;

public class Class {
    private ArrayList<Student> students = new ArrayList<>();
    private int medianScore;

    public ArrayList addStudent(Student student) {

        this.students.add(student);

        return this.students;
    }

    public int getTotalScore() {
        int totalScore = 0;

        for (Student student : getStudents()) {
            totalScore += student.getTotalScore();
        }

        return totalScore;
    }

    public int getMedianScore() {
        int medianLength = students.size() / 2;

        if (students.size() % 2 == 0) {
            return (students.get(medianLength).getTotalScore() + students.get(medianLength - 1).getTotalScore()) / 2;
        }

        return students.get(medianLength).getTotalScore();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
