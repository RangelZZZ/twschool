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
        this.students = [];
    }

    assignLeader(student) {
        if (!this.isExist(student)) {
            return `It is not one of us.`;
        }
        this.leader = student;
    }

    isLeader(student) {
        return this.leader && student.judgeTheSame(this.leader);
    }

    appendMember(student) {
        if (!this.isExist(student)) {
            this.students.push(student);
        }
    }

    isExist(student) {
        for (let stu of this.students) {
            if (stu.judgeTheSame(student)) {
                return true;
            }
        }
        return false;
    }


}

class Student extends Person {
    constructor(name, age, id, classInfo) {
        super(name, age, id);
        this.classInfo = classInfo;
        this.classInfo.appendMember(this);
    }

    introduce() {
        let resultString = `${super.introduce()}I am a Student.`;

        if (this.classInfo.isLeader(this)) {
            return `${resultString}I am Leader of Class ${this.classInfo.number}.`;
        } else {
            return `${resultString}I am at Class ${this.classInfo.number}.`;
        }
    }
}

module.exports = {Person, Class, Student};