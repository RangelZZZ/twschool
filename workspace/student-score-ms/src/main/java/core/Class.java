package core;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Class {

    private List<Student> students = new ArrayList<>();

    public List<Student> addStudent(Student student) {

        students.add(student);

        return students;
    }

    public List<Student> getSelectedStudents(ArrayList<String> studentIds) {
        List<Student> selectedStudents = students.stream().filter(stu -> isExits(studentIds, stu)).collect(toList());

        return selectedStudents;
    }

    private boolean isExits(ArrayList<String> studentIds, Student stu) {
        String id = studentIds.stream().filter(s -> s.equals(stu.getId())).findAny().orElse(null);
        if (id == null) {
            return false;
        }

        return true;
    }
}



