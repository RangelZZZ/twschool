package web_shell.service;

import core.Grade;
import core.Class;
import core.StudentInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentInMemoryService implements StudentService {

    private Class klass = new Class();

    @Override
    public boolean addStudentGrade(Grade studentGrade) {

        if (klass.addStudentGrade(studentGrade) == null) {
            return false;
        }
        return true;
    }

    @Override
    public List<Grade> selectStudents(ArrayList<String> studentIds) {
        return klass.selectStudents(studentIds);
    }

    @Override
    public void addStudentInformation(StudentInfo studentInfo) {
        klass.addStudentInfo(studentInfo);
    }
}
