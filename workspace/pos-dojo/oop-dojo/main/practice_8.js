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


class Teacher extends Person {
    constructor(name, age, className) {
        super(name, age);
        this.className = className;
    }

    introduce() {
        if (this.className) {
            return `${super.introduce()}I am a Teacher.I teach ${this.className}.`
        }

        return `${super.introduce()}I am a Teacher.I teach No Class.`
    }
}


module.exports = {Person, Student, Teacher};