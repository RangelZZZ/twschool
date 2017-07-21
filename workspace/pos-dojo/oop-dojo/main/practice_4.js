'use strict';

class Person {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }

    introduce() {
        return `My name is ${this.name}.I am ${this.age} years old`;
    }
}

class Student extends Person {
    constructor(name, age, className) {
        super(name, age);
        this.className = className;
    }

    introduce() {
        return `I am a Student. I am at ${this.className}.`;
    }
}

class Worker extends Person {
    constructor(name, age) {
        super(name, age);
    }

    introduce() {
        return `I am a Worker. I have a job.`;
    }
}

module.exports = {
    Person,
    Student,
    Worker
};