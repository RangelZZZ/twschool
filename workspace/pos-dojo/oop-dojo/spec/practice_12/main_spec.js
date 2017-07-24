"use strict";
import {Person, Class, Student, Teacher} from "../../main/practice_12";

describe("OO入门", function () {
    it("对象之间的交互-12-1", function () {
        const person = new Person("Tom", "21", "1");
        const expectString = `My name is Tom.I am 21 years old.`;

        expect(person.introduce()).toBe(expectString);
    });

    it("对象之间交互-12-2", function () {
        const student = new Student("Tom", "21", 1, new Class(2));
        const expectString = `My name is Tom.I am 21 years old.I am a Student.I am at Class 2.`;

        expect(student.introduce()).toBe(expectString);

    });

    it("对象之间交互-12-3", function () {
        const classInfo = new Class(2);
        const student = new Student("Tom", "21", 1, classInfo);
        classInfo.assignLeader(new Class("rangel", "21", 2, new Class(1)));
        const expectString = `My name is Tom.I am 21 years old.I am a Student.I am at Class 2.`;

        expect(student.introduce()).toBe(expectString);

    });


    it("对象之间交互-12-4", function () {
        const classInfo = new Class(2);
        const student = new Student("Tom", "21", 1, classInfo);
        classInfo.assignLeader(student);
        const expectString = `My name is Tom.I am 21 years old.I am a Student.I am Leader of Class 2.`;

        expect(student.introduce()).toBe(expectString);

    });

    it("对象之间交互-12-5", function () {
        const classInfo = new Class(2);
        const student = new Student("Tom", "21", 1, classInfo);
        classInfo.assignLeader(student);
        const expectString = `My name is Tom.I am 21 years old.I am a Student.I am Leader of Class 2.`;

        expect(student.introduce()).toBe(expectString);

    });

    it("对象之间交互-12-6", function () {
        const classInfo = new Class(2);
        const student1 = new Student("rangel", "22", 4, new Class(1));
        const expectedString = `It is not one of us.`;

        expect(classInfo.assignLeader(student1)).toBe(expectedString);

    });

    it("对象之间交互-12-7", function () {
        const class2 = new Class(2);
        const class3 = new Class(3);
        const teacher = new Teacher("Tom", "21", 1, [class2, class3]);
        const expectString = `My name is Tom.I am 21 years old. I am a Teacher.I teach Class 2,3.`;
        expect(teacher.introduce()).toBe(expectString);
    });


    it("对象之间交互-12-8", function () {
        const teacher = new Teacher("Tom", "21", 1);
        const expectString = `My name is Tom. I am 21 years old. I am a Teacher.I teach No Class.`;
        expect(teacher.introduce()).toBe(expectString);
    });

    it("对象之间交互-12-9", function () {
        const class2 = new Class(2);
        const class3 = new Class(3);
        const teacher = new Teacher("Tom", "21", 1, [class2, class3]);
        const expectResult = teacher.isTeaching(new Student("rangel", "21", 3, new Class(2)));

        expect(expectResult).toBe(true);
    });

    it("对象之间交互-12-10", function () {
        const class2 = new Class(2);
        const class3 = new Class(3);
        const teacher = new Teacher("Tom", "21", 1, [class2, class3]);
        const expectResult = teacher.isTeaching(new Student("rangel", "21", 3, new Class(4)));

        expect(expectResult).toBe(false);
    });

    it("对象之间的交互-12-11", function () {
        const class2 = new Class(2);
        const class3 = new Class(3);
        const teacher = new Teacher("Tom", "21", 1, [class2, class3]);

        const student = new Student("Jerry", "21", 1, class2);
        const resultString = class3.assignLeader(new Student("Jerry", "21", 1, class2));


        expect(student).toBe(`I am Tom. I know Jerry has joined Class 2.`);
        expect(resultString).toBe(`I am Tom. I know Jerry become Leader of Class 2.`);
    });

});

