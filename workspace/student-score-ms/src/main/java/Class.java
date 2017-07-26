import java.util.ArrayList;

public class Class {


    private ArrayList<Student> students = new ArrayList<>();

    public ArrayList addStudent(Student student) {

        this.students.add(student);

        return this.students;
    }
}
