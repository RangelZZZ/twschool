package web_shell.service;

import core.Student;

import java.util.ArrayList;
import java.util.List;

public interface StudentService {
    boolean addStudent(Student student);

    List<Student> getSelectStudents(ArrayList<String> studentIds);
}
