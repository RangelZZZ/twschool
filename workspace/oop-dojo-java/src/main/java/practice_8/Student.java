package practice_8;

public class Student extends Person {

    private Class klass;

    public Class getKlass() {
        return klass;
    }

    public Student(String name, int age, Class klass) {
        super(name,age);
        this.klass = klass;
    }
    public String introduce(){
        return super.introduce() + " I am a Student. I am at Class " + this.klass.getNumber() + ".";
    }
}
