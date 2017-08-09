package web_shell.service;

import core.Grade;
import core.Student;

import java.util.ArrayList;
import java.util.List;

public interface StudentService {
    List<Grade> selectStudents(ArrayList<String> studentIds);

    String addStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentsById(int id);

    Boolean addStudentGrade(Grade studentGrade, int id);

    boolean updateStudentGrade(Grade studentGrade, int id);
}
