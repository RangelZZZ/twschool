package core;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Class {

    private List<Grade> students = new ArrayList<>();
    private List<StudentInfo> studentInfos = new ArrayList<>();

    public List<Grade> getStudents() {
        return students;
    }

    public Class() {

    }

    public List<Grade> addStudentGrade(Grade student) {
        student.setId((String.valueOf(students.size() + 1)));
        students.add(student);
        return students;
    }

    public List<Grade> selectStudents(ArrayList<String> studentIds) {
        students = students.stream().filter(stu -> isExits(studentIds, stu)).collect(toList());

        return students;
    }

    private boolean isExits(ArrayList<String> studentIds, Grade stu) {
        String id = studentIds.stream().filter(s -> s.equals(stu.getId())).findAny().orElse(null);
        if (id == null) {
            return false;
        }

        return true;
    }

    public List<StudentInfo> addStudentInfo(StudentInfo studentInfo){
        studentInfos.add(studentInfo);

        return studentInfos;
    }
}



