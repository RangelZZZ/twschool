package practice_10;

public class Student extends Person {

    private Class klass;

    public Student(String name, int age, int id, Class klass) {
        super(name, age, id);
        this.klass = klass;
    }

    public String introduce(){
        return super.introduce() + " I am a Student. I am at Class " + this.klass.getNumber() + ".";
    }
}
