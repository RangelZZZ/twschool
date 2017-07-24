package practice_4;

public class Person {

    private int age;
    private String name;

    public String getName() {
        return name;
    }

    public int getAge() {

        return age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }




    public String introduce() {
        return "My name is " + this.name + ". I am " + this.age + " years old.\n";
    }
}