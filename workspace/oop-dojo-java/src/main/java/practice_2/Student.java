package practice_2;

public class Student {

    private final String name;
    private final String age;
    private final int klass;

    public Student(String name, String age, int klass) {
        this.name = name;
        this.age = age;
        this.klass = klass;

    }

    public String introduce() {
        return "My name is " + this.name + ". I am " + this.age + " years old.I am at Class " + this.klass +"\n ";
    }
}
