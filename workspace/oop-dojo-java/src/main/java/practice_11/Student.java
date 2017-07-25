package practice_11;

public class Student extends Person {
    private Class klass;

    public Student(String name, int age, int id, Class klass) {
        super(name, age, id);
        this.klass = klass;
    }

    public String introduce() {
        if (this.klass != null){
            return super.introduce() + " I am a Teacher. I teach Class " + this.klass.getNumber() + ".";

        }
        return super.introduce() + " I am a Teacher. I teach No Class.";
    }
}
