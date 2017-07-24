package practice_3;

public class Person {
    private final String name;
    private final int age;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }



    public String introduce() {
        return "My name is " + this.name + ". I am " + this.age + " years old.\n";
    }
}
