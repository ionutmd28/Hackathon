//Play with import/export

import {keyValue as key, fct} from "../externalScript/external.mjs";
import a from "../externalScript/external.mjs";
console.log(key);
fct();
console.log(key);

console.log(a);

// Classes and prototypes

class Helper {
    static logTwice(message) {
        console.log(message);
        console.log(message);
    }
}

Helper.logTwice("Logged!");

class Person {
    constructor(name) {
      this.name = name;
    }

    greet() {
        console.log("Hello, my name is " + this.name +" and I'm " + this.age);
    }
}

class Max extends Person {
    constructor(age) {
        super("Ionut");
        this.age = age;
    }
    greet() {
        console.log("Gotcha!")
    }

    greetTwice() {
        super.greet();
        this.greet();
    }
}

let person = new Person("Ionut");
let max = new Max("21");

person.greet();
max.greetTwice();

console.log(person.__proto__ === Person.prototype);
console.log(max.__proto__ === Max.prototype);

class Man {
    constructor(name) {
        this._name = name;
    }
    get name() {
        return this._name.toUpperCase();
    }
    set name(value) {
        if(value.length > 2) {
            this._name = value;
        }
        console.log("Rejected Value!");
    }
}

let man = new Man("Andrei");
console.log(man);

console.log(man.name);

man.name = "Ma";

class ConvertableArray extends Array {
    convert() {
        let returnArray = [];
        this.forEach(value => returnArray.push("Converted:" + value));
        return returnArray;
    }
}

let numberArray = new ConvertableArray();
numberArray.push(1);
numberArray.push(2);
numberArray.push(3);
console.log(numberArray.convert());