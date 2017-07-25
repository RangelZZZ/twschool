package practice_10;

import java.util.ArrayList;

public class Class {
    private int number;
    private Student leader;
    private ArrayList<Student> students = new ArrayList<>();

    public Student getLeader() {

        return leader;
    }


    public int getNumber() {

        return number;
    }

    public Class(int number) {
        this.number = number;
    }

    public void assignLeader(Student student) {
        if (isExist(student)) {
            this.leader = student;

        } else {
            System.out.println("It is not one of us.");
        }
    }

    public Boolean isExist(Student student) {
        for (Student student1 : this.students) {
            if (student1.isSamePeople(student)) {

                return true;
            }
        }

        return false;
    }

    public Boolean isLeader(Student student) {
        if (isExist(student)) {
            return this.leader.isSamePeople(student);
        }

        return false;
    }

    public void appendMember(Student student) {
        this.students.add(student);
    }
}
