package practice_5;


public class Worker extends Person {
    public Worker(String name, int age) {
        super(name, age);
    }

    public String introduce() {
        return super.basicIntroduce();
    }
}
