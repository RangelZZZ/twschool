package practice_10;

public class Student extends Person {

    private Class klass;

    public Class getKlass() {
        return klass;
    }

    public Student(String name, int age, int id, Class klass) {
        super(name, age, id);
        this.klass = klass;
    }

    public String introduce() {
        if (this.getKlass().isLeader(this)) {
            return super.introduce() + " I am a Student. I am Leader of Class " + this.klass.getNumber() + ".";
        }
        return super.introduce() + " I am a Student. I am at Class " + this.klass.getNumber() + ".";
    }
}
