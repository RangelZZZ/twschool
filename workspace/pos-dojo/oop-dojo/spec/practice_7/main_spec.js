"use strict";

describe("OO入门", function () {
    it("对象之间交互-1", function () {
        const person = new Person("guoru", "21");
        const expectString = `My name is guoru.I am 21 years old.`;

        expect(person.introduce()).toBe(expectString);
    });
});