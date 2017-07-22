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
        this.className = new ClassNumber(classNumber);
    }

    introduce(className) {
        return `My name is guoru. I am 21 years old. I am a Student. I am at Class ${this.className.number}.`;
    }
}

module.exports = {Person, Student, ClassNumber};