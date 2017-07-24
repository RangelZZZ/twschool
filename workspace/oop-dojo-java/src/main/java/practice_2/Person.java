package practice_2;

public class Person {

    private String age;
    private String name;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }


    public String introduce() {
        return "My name is " + this.name + ". I am " + this.age + " years old.\n";
    }
}