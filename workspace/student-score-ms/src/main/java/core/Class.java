package core;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Class {

    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public Class() {

    }

    public List<Student> addStudent(Student student) {

        for (Student student1 : students) {
            if (student1.getId().equals(student.getId())) {
                return null;
            }
        }
        students.add(student);

        return students;
    }

    public List<Student> selectStudents(ArrayList<String> studentIds) {

        return students.stream().filter(stu -> isExits(studentIds, stu)).collect(toList());
    }

    private boolean isExits(ArrayList<String> studentIds, Student stu) {
        String id = studentIds.stream().filter(s -> s.equals(stu.getId())).findAny().orElse(null);
        if (id == null) {
            return false;
        }

        return true;
    }
}



