"use strict";

import {Person,Class,Student} from "../../main/practice_11";

describe("OO入门", function () {
    it("对象之间交互-11-1", function () {
        const person = new Person("Tom", "21", 1);
        const expectString = `My name is Tom.I am 21 years old.`;

        expect(person.introduce()).toBe(expectString);
    });

    it("对象之间交互-11-1",function () {
        const student = new Student("Tom", "21", 1,new Class(2));
        const expectString = `My name is Tom.I am 21 years old.I am a Student.I am at Class 2.`;

        expect(student.introduce()).toBe(expectString);

    });

    it("对象之间交互-10-3", function () {
        const classInfo = new Class(2);
        const student = new Student("Tom", "21", 1, classInfo);

        classInfo.assignLeader(new Student("rangel", "22", 2, classInfo));
        const expectString = `My name is Tom.I am 21 years old.I am a Student.I am at Class 2.`;
        expect(student.introduce()).toBe(expectString);

        classInfo.assignLeader(student);
        let expectedString = `My name is Tom.I am 21 years old.I am a Student.I am Leader of Class 2.`;
        expect(student.introduce()).toBe(expectedString);

        const student1 = new Student("rangel", "22", 4, new Class(1));
        expectedString = `It is not one of us.`;
        expect(classInfo.assignLeader(student1)).toBe(expectedString);
    });
});

