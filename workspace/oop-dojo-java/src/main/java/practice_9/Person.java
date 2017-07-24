package practice_9;

public class Person {
    private int id;
    private String name;
    private int age;

    public int getId() {
        return id;
    }

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String introduce() {
        return "My name is " + this.name + ". I am " + this.age + " years old.";
    }

    public Boolean isSamePeople(Student student){
        return this.id == student.getId();
    }

}
