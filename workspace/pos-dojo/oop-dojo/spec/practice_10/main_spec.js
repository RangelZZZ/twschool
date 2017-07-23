"use strict";

import Person from "../../main/practice_10";

describe("OO入门", function () {
    it("对象之间交互-10-1", function () {
        const person = new Person("Tom", "21", 1);
        const expectString = `My name is Tom.I am 21 years old.`;

        expect(person.introduce()).toBe(expectString);
    });

});