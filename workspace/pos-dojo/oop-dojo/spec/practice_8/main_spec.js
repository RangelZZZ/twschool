"use strict";

import {Person, Student, ClassNumber} from "../../main/practice_8";

describe("OO入门", function () {
    it("对象之间交互-8-1", function () {
        const person = new Person("guoru", "21");
        const expectString = `My name is guoru.I am 21 years old.`;

        expect(person.introduce()).toBe(expectString);
    });

    it("对象之间交互-8-2", function () {
        const student = new Student("guoru", "21", 2);
        const expectString = `My name is guoru. I am 21 years old. I am a Student. I am at Class 2.`;
        expect(student.introduce()).toBe(expectString);
    })
});