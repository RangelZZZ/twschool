package web_shell.service;

import core.Student;
import core.Class;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentInMemoryService implements StudentService {

    private Class klass = new Class();

    @Override
    public boolean addStudent(Student student) {
        List<Student> students = klass.getStudents();

        for (Student student1 : students) {
            if (student1.getId() == student.getId()) {
                return false;
            }
        }
        klass.addStudent(student);
        return true;
    }

    @Override
    public List<Student> getSelectStudents(ArrayList<String> studentIds) {
        return klass.selectStudents(studentIds);
    }
}
