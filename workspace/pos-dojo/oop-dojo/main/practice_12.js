"use strict";

class Person {
    constructor(name, age, id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    introduce() {
        return `My name is Tom.I am 21 years old.`;
    }

    judgeTheSame(person) {
        return this.id === person.id;
    }
}

class Class {
    constructor(number) {
        this.number = number;
        this.students = [];
        this.teacher = '';
    }

    assignLeader(student) {
        if (!this.isExist(student)) {
            return `It is not one of us.`;
        }
        this.leader = student;
        this.becomeLeader(student);
    }

    becomeLeader(student) {
        if (this.teacher) {
            this.teacher.printBecomeLeader(student, this);
        }
    }

    isLeader(student) {
        return this.leader && student.judgeTheSame(this.leader);
    }

    appendMember(student) {
        if (!this.isExist(student)) {
            this.students.push(student);
            student.classInfo = this;
            this.joinClass(student);
        }
    }

    joinClass(student) {
        if (this.teacher) {
            this.teacher.printJoinClass(student, this);
        }
    }

    isExist(student) {
        return this.students.find(element => element.judgeTheSame(student) === true);
    }

    isIn(student) {
        return this.students.find(element => element.judgeTheSame(student) === true);
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
            return `${resultString}I am Leader of Class ${this.classInfo.number}.`
        }
        return `${resultString}I am at Class ${this.classInfo.number}.`
    }
}

class Teacher extends Person {
    constructor(name, age, id, classes) {
        super(name, age, id);
        this.classes = classes;
        for (let classInfo of this.classes) {
            classInfo.teacher = this;
        }
    }


    isTeaching(student) {
        return this.classes.find(element => element.isIn(student) === true);
    }

    printJoinClass(student, classInfo) {
        return `I am ${this.name}. I know ${student.name} has joined Class ${classInfo.number}.`;
    }

    printBecomeLeader(student, classInfo) {
        return `I am ${this.name}. I know ${student.name} become Leader of Class ${classInfo.number}.`;
    }

    introduce() {
        let resultString = `${super.introduce()} I am a Teacher.`;
        let classNumbers = [];

        if (this.classes) {
            for (let classInfo of this.classes) {
                classNumbers.push(classInfo.number);
            }

            return `${resultString}I teach Class ${classNumbers.toString()}.`;
        }

        return `${resultString}I teach No Class.`;
    }
}

module.exports = {Person, Class, Student, Teacher};