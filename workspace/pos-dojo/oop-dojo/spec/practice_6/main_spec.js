"use strict";

import {Person, Student, Worker} from "../../main/practice_6";

describe("OO入门", function () {
    it("覆盖父类的方法-1", function () {
        const person = new Person("guoru", "21");
        const expectString = `My name is guoru.I am 21 years old.`;

        expect(person.introduce()).toBe(expectString);
    });

    it("覆盖父类的方法-2", function () {
        const student = new Student("guoru", "21", "Class 2");
        const expectString = `My name is guoru.I am 21 years old.I am at Class 2.`;

        expect(student.introduce()).toBe(expectString);
    });

    it("覆盖父类的方法-3", function () {
        const worker = new Worker("guoru", "21");
        const expectString = `My name is guoru.I am 21 years old.I am a Worker. I have a job.`;

        expect(worker.introduce()).toBe(expectString);
    });
});