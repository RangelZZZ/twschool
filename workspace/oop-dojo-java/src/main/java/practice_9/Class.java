package practice_9;

public class Class {
    private int number;
    private Student leader;

    public Class(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void assignLeader(Student student) {
        this.leader = student;
    }

    public Boolean isLeader( Student student){
        return student.isSamePeople(this.leader);
    }
}
