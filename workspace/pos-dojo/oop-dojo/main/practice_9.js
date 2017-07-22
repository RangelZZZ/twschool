"use strict";

class Person {
    constructor(name, age, id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    introduce() {
        return `My name is ${this.name}.I am ${this.age} years old.`;
    }

    judgeTheSame(person) {
        return (this.id === person.id);
    }
}

class Class {
    constructor(number) {
        this.number = number;
    }

    assignLeader(student) {
        this.leader = student;
    }

    isLeader(student) {
        return (this.leader && (student.judgeTheSame(this.leader)));
    }
}

class Student extends Person {
    constructor(name, age, id, classInfo) {
        super(name, age, id);
        this.classInfo = classInfo;
    }

    introduce() {
        let resultString = `${super.introduce()} I am a Student.`;

        if (this.classInfo.isLeader(this)) {
            return `${resultString} I am Leader of Class ${this.classInfo.number}.`;
        }

        return `${resultString} I am at Class ${this.classInfo.number}.`;
    }
}

class Teacher extends Person {
    constructor(name, age, id, classInfo) {
        super(name, age, id);
        this.classInfo = classInfo;
    }

    introduce() {
        let resultString = `My name is Tom. I am 21 years old. I am a Teacher.`;
        if (this.classInfo) {
            return `${resultString}I teach Class 2.`;
        }

        return `${resultString}I teach No Class.`;
    }

}

module.exports = {Person, Student, Class,Teacher};