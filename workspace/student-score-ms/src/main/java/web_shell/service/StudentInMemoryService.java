package web_shell.service;

import core.Grade;
import core.Class;
import core.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentInMemoryService implements StudentService {

    private Class klass = new Class();

    @Override
    public List<Grade> selectStudents(ArrayList<String> studentIds) {
        return klass.selectStudents(studentIds);
    }


    @Override
    public String addStudent(Student student) {
        return klass.addStudent(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return klass.getStudents();
    }

    @Override
    public Student getStudentsById(int id) {
        return klass.getStudentsById(id);
    }

    @Override
    public Boolean addStudentGrade(Grade studentGrade, int id) {
        return klass.addStudentGrade(studentGrade,id);
    }

    @Override
    public boolean updateStudentGrade(Grade studentGrade, int id) {
        return klass.updateStudentGrade(studentGrade, id);
    }

    @Override
    public List<Grade> getAllStudentGrades() {
        return klass.getStudentGrades();
    }

}
