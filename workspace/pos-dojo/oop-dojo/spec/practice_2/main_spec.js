"use strict";
import Person from "../../main/practice_2";

describe("OO入门", function () {
    it("写一个类-2", function () {
        const person = new Person("guoru", "21");
        const expectString = `My name is guoru.I am 21 years old`;
        expect(person.introduce()).toBe(expectString);
    });
});