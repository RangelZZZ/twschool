"use strict";

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
        return `${super.introduce()}I am at ${this.className}.`;
    }
}

class Worker extends Person {
    constructor(name, age) {
        super(name, age)
    }

    introduce() {
        return `${super.introduce()}I am a Worker. I have a job.`;
    }
}

module.exports = {Person, Student,Worker};