"use strict";

import {Person, Student, Teacher} from "../../main/practice_8";

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
    });

    it("对象之间交互-8-3", function () {
        const teacher = new Teacher("guoru", "21", 2);
        const expectString = `My name is guoru.I am 21 years old.I am a Teacher.I teach Class 2.`;

        expect(teacher.introduce()).toBe(expectString);
    });

    it("对象之间交互-8-4", function () {
        const teacher = new Teacher("guoru", "21");
        const expectString = `My name is guoru.I am 21 years old.I am a Teacher.I teach No Class.`;

        expect(teacher.introduce()).toBe(expectString);
    });

    it("对象之间交互-8-5", function () {
        const student = new Student("Jerry","21",2);
        const teacher = new Teacher("guoru", "21",2);
        const expectString = `My name is guoru.I am 21 years old.I am a Teacher. I teach Jerry.`;

        expect(teacher.introduceWith(student)).toBe(expectString);
    });

    it("对象之间交互-8-6", function () {
        const student = new Student("Jerry","21",3);
        const teacher = new Teacher("guoru", "21",2);
        const expectString = `My name is guoru.I am 21 years old.I am a Teacher. I don't teach Jerry.`;

        expect(teacher.introduceWith(student)).toBe(expectString);
    });

});