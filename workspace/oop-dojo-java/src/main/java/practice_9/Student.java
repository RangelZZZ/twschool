package practice_9;


public class Student extends Person {

    private Class klass;

    public Student(String name, int age, int id, Class klass) {
        super(name, age, id);
        this.klass = klass;
    }

    public String introduce() {
        if (this.klass.isLeader(this)) {
            return super.introduce() + " I am a Student. I am Leader of Class " + this.klass.getNumber() + ".";
        }
        return super.introduce() + " I am a Student. I am at Class " + this.klass.getNumber() + ".";
    }

    public int getId() {
        return super.getId();
    }
}
