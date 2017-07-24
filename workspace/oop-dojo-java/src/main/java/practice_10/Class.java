package practice_10;

public class Class {
    private int number;
    private Student leader;

    public int getNumber() {
        return number;
    }

    public Class(int number) {
        this.number = number;
    }

    public void assignLeader(Student student) {

        this.leader = student;
    }

    public Boolean isLeader(Student student) {
        return this.leader.isSamePeople(student);
    }
}
