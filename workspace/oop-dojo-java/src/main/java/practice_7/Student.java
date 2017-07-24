package practice_7;


public class Student extends Person {
    private int klass;

    public Student(String name, int age, int klass) {
        super(name, age);
        this.klass = klass;
    }

    public String introduce(){
        return super.introduce() + "I am a Student. I am at Class " + this.klass + ".";
    }
}
