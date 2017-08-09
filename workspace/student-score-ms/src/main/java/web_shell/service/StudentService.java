package web_shell.service;

import core.Grade;
import core.StudentInfo;

import java.util.ArrayList;
import java.util.List;

public interface StudentService {
    boolean addStudentGrade(Grade studentGrade);

    List<Grade> selectStudents(ArrayList<String> studentIds);

    void addStudentInformation(StudentInfo studentInfo);

}
