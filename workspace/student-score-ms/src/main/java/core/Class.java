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
}


