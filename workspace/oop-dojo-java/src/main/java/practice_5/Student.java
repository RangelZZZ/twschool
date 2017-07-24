package practice_5;

public class Student extends Person {
    private int klass;

    public Student(String name, int age, int klass) {
        super(name, age);
        this.klass = klass;
    }

    public String introduce() {
        return super.introduce() + "I am at Class " + this.klass + "\n ";
    }
}
