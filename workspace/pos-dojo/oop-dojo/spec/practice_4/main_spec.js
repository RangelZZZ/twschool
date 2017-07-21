"use strict";
import {Person,Student} from "../../main/practice_4";

describe("OO入门", function () {
    it("覆盖父类的方法-1", function () {
        const person = new Person("guoru", "21");
        const expectString = `My name is guoru.I am 21 years old`;

        expect(person.introduce()).toBe(expectString);
    });

    it("覆盖父类的方法-2", function () {
        const student = new Student("guoru", "21", "class 2");
        const expectString = `I am a Student. I am at class 2.`;

        expect(student.introduce()).toBe(expectString);

    });
});