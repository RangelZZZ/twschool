package web_shell.service;

import core.Student;
import core.StudentInfo;

import java.util.ArrayList;
import java.util.List;

public interface StudentService {
    boolean addStudent(Student student);

    List<Student> selectStudents(ArrayList<String> studentIds);

    void addStudentInformation(StudentInfo studentInfo);

}
