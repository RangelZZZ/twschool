package core;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Class {

    private List<Student> students = new ArrayList<>();
    private List<Grade> studentGrades = new ArrayList<>();

    public List<Grade> getStudentGrades() {
        return studentGrades;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Class() {

    }

    public boolean addStudentGrade(Grade studentGrade, int id) {
        for (Student student : students) {
            if (student.getStudentId().equals(String.valueOf(id))) {
                studentGrades.add(studentGrade);
                return true;
            }
        }
        return false;
    }

    public List<Grade> selectStudents(ArrayList<String> studentIds) {
        studentGrades = studentGrades.stream().filter(stu -> isExits(studentIds, stu)).collect(toList());

        return studentGrades;
    }

    private boolean isExits(ArrayList<String> studentIds, Grade stu) {
        String id = studentIds.stream().filter(s -> s.equals(stu.getStudentId())).findAny().orElse(null);
        if (id == null) {
            return false;
        }

        return true;
    }

    public String addStudent(Student student) {
        student.setStudentId((String.valueOf(students.size() + 1)));
        students.add(student);

        return student.getStudentId();
    }

    public Student getStudentsById(int id) {
        for (Student student : students) {
            if (student.getStudentId().equals(String.valueOf(id))) {
                return student;
            }
        }

        return null;
    }

    public boolean updateStudentGrade(Grade studentGrade, int id) {
        for (Grade sg : studentGrades)
            if (studentGrade.getStudentId().equals(String.valueOf(id))) {
                sg.setChineseScore(studentGrade.getChineseScore());
                sg.setEnglishScore(studentGrade.getEnglishScore());
                sg.setMathScore(studentGrade.getChineseScore());
                sg.setProgramScore(studentGrade.getProgramScore());

                return true;
            }

        return false;
    }
}



