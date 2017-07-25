package practice_10;

import java.util.ArrayList;

public class Class {
    private int number;

    public Student getLeader() {

        return leader;
    }

    private Student leader;
    private ArrayList<Student> students = new ArrayList<>();


    public int getNumber() {

        return number;
    }

    public Class(int number) {
        this.number = number;
    }

    public void assignLeader(Student student) {
        if (isExist(student)) {
            this.leader = student;
        }
    }

    public String judgeLeader() {
        if (this.getLeader() == null) {
            return "It is not one of us.";
        }

        return null;
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
