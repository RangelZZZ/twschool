package com.student.bean;

public class Employee {
    private int id;
    private int age;
    private String name;
    private Address mailAddress;
    private Address originalAddress;

    public Employee() {

    }

    public Employee(int id, String name, int age, Address mailAddress, Address originalAddress) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mailAddress = mailAddress;
        this.originalAddress = originalAddress;

    }

    public Address getOriginalAddress() {
        return originalAddress;
    }

    public void setOriginalAddress(Address originalAddress) {
        this.originalAddress = originalAddress;
    }

    public Address getMailAddress() {

        return mailAddress;
    }

    public void setMailAddress(Address mailAddress) {
        this.mailAddress = mailAddress;
    }

    public void setId(int id) {

        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
