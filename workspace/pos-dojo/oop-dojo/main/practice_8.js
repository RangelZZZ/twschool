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

class ClassNumber {
    constructor(number) {
        this.number = number;
    }
}


class Student extends Person {
    constructor(name, age, classNumber) {
        super(name, age);
        this.classNumber = new ClassNumber(classNumber);
    }

    introduce(className) {
        return `My name is guoru. I am 21 years old. I am a Student. I am at Class ${this.classNumber.number}.`;
    }
}


class Teacher extends Person {
    constructor(name, age, className) {
        super(name, age);
        this.classNumber = className;
    }

    introduce() {
        if (this.classNumber) {
            return `${super.introduce()}I am a Teacher.I teach Class ${this.classNumber}.`
        }

        return `${super.introduce()}I am a Teacher.I teach No Class.`
    }

    introduceWith(student) {
        if (student.classNumber.number === this.classNumber) {
            return `${super.introduce()}I am a Teacher. I teach ${student.name}.`;
        }

        return `${super.introduce()}I am a Teacher. I don't teach ${student.name}.`;

    }
}

module.exports = {Person, Student, Teacher};