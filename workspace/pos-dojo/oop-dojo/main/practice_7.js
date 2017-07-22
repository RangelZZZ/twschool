'use strict';

class Person {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }

    introduce() {
        return `My name is ${this.name}.I am ${this.age} years old.`;
    }
}

class Student extends Person {
    constructor(name, age, className) {
        super(name, age);
        this.className = className;
    }

    introduce(className) {
        return `${super.introduce()}I am a Student.I am at ${this.className}.`;
    }
}

class Teacher extends Person {
    constructor(name, age, className) {
        super(name, age);
        this.className = className;
    }

    introduce() {
        if (this.className) {
            return `${super.introduce()}I am a Teacher.I teach ${this.className}.`
        }
    }
}

module.exports = {Person, Student, Teacher};