"use strict";

import {Person, Class, Student,Teacher} from "../../main/practice_10";

describe("OO入门", function () {
    it("对象之间交互-10-1", function () {
        const person = new Person("Tom", "21", 1);
        const expectString = `My name is Tom.I am 21 years old.`;

        expect(person.introduce()).toBe(expectString);
    });

    it("对象之间交互-10-2", function () {
        const classInfo = new Class(2);
        const student = new Student("Tom", "21", 1, classInfo);
        const expectString = `My name is Tom.I am 21 years old. I am a Student. I am at Class 2.`;

        expect(student.introduce()).toBe(expectString);
    });

    it("对象之间交互-10-3", function () {
        const classInfo = new Class(2);
        const student = new Student("Tom", "21", 1, classInfo);

        classInfo.assignLeader(new Student("rangel", "22", 2, classInfo));
        const expectString = `My name is Tom.I am 21 years old. I am a Student. I am at Class 2.`;
        expect(student.introduce()).toBe(expectString);

        classInfo.assignLeader(student);
        let expectedString = `My name is Tom.I am 21 years old. I am a Student. I am Leader of Class 2.`;
        expect(student.introduce()).toBe(expectedString);

        const student1 = new Student("rangel", "22", 4, new Class(1));
        expectedString = `It is not one of us.`;
        expect(classInfo.assignLeader(student1)).toBe(expectedString);
    });

    it("对象之间交互-10-3", function () {
        const classInfo = new Class(2);
        const teacher = new Teacher("Tom", "21", 1,classInfo);
        const expectString = `My name is Tom. I am 21 years old. I am a Teacher.I teach Class 2.`;
        expect(teacher.introduce()).toBe(expectString);
    });


    it("对象之间交互-10-4", function () {
        const teacher = new Teacher("Tom", "21", 1);
        const expectString = `My name is Tom. I am 21 years old. I am a Teacher.I teach No Class.`;
        expect(teacher.introduce()).toBe(expectString);
    });

});