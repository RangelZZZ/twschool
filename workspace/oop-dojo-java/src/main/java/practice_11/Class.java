package practice_11;

import java.util.ArrayList;

public class Class {

    private int number;
    private ArrayList<Student> students = new ArrayList<Student>();
    private Student leader;

    public Class(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void appendMember(Student student) {
        if (!this.isExist(student)) {
            this.students.add(student);

        }
    }

    public void assginLeader(Student student) {
        if (this.isExist(student)) {
            this.leader = student;
        }
    }

    public Boolean isExist(Student student) {
        if (this.leader.isSamePeople(student)) {
            return true;
        }

        return false;
    }
}
