package practice_1;

public class Person {
    private final String name;
    private final String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String introduce() {
        return "My name is " + this.name + ". I am " + this.age + " years old.\n";
    }

    @Override
    public String toString() {
        return this.introduce();
    }
}
