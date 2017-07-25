package practice_10;

public class Teacher extends Person{

    private Class klass;

    public Teacher(String name, int age, int id) {
        super(name, age, id);
    }

    public Teacher(String name, int age, int id, Class klass) {
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
