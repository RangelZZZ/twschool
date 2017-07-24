package practice_8;

public class Teacher extends Person {
    private Class klass = null;

    public Teacher(String name, int age, Class klass) {
        super(name, age);
        this.klass = klass;
    }

    public Teacher(String name, int age) {
        super(name,age);
    }

    public String introduce() {
        if (this.klass != null){
            return super.introduce() + " I am a Teacher. I teach Class " + this.klass.getNumber() + ".";

        }
        return super.introduce() + " I am a Teacher. I teach No Class.";
    }
}
