package web_shell.service;

import core.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentImpService implements StudentService {

    private List<Student> studentList = new ArrayList<Student>();

    @Override
    public boolean addStudent(Student student) {
        for (Student student1 : studentList) {
            if (student1.getId().equals(student.getId())) {
                return false;
            }
        }

        studentList.add(student);
        return true;
    }
}
