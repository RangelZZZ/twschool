'use strict';

class Person {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }

    introduce() {
        return this.basic_Introduce();
    }

    basic_Introduce() {
        return `My name is ${this.name}.I am ${this.age} years old.`;
    }
}

class Student extends Person {
    constructor(name, age, className) {
        super(name, age);
        this.className = className;
    }

    introduce(className) {
        return `${this.basic_Introduce()}I am at ${this.className}.`;
    }
}

module.exports = {Person, Student};