package practice_4;

public class Student extends Person{
    private int klass;

    public Student(String name, int age, int klass) {
        super(name,age);
        this.klass = klass;
    }

    public String introduce(){
        return "My name is " + this.getName() + ". I am " + this.getAge() + " years old.I am at Class " + this.klass + "\n ";
    }
}
