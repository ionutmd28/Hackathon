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

let symbol = Symbol("debug");

console.log(typeof symbol);

let anotherSymbol = Symbol("debug");

console.log(symbol === anotherSymbol);

let obj = {
    name : "Max",
    [symbol] : 22
}

console.log(obj);
console.log(obj[symbol]);

console.log("----------------------")

let symbol1 = Symbol.for("age");
let symbol2 = Symbol.for("age");
let symbol3 = Symbol.for("age");

if (symbol1 === symbol3 && symbol1 === symbol3) {
    console.log("The " + symbol2.toString() + " is equal to " + symbol3.toString());
}

let woman = {
    name : "Maria",
    age : 30
};
function makeAge(person) {
    let ageSymbol = Symbol.for('age');
    person[ageSymbol] = 27;
}

makeAge(woman);

console.log(woman[symbol1]);
console.log(woman["age"]);

console.log("----------------------")

class Person1 {

}

Person1.prototype[Symbol.toStringTag] = "PersonXX";

let person1 = new Person1();
console.log(person1);

let numbers = [1, 2, 3];

numbers[Symbol.toPrimitive] = function() {
    return 999;
}

console.log(numbers + 1);

//Itterators and Generators

console.log("----------------------")

let array = [1, 2, 3];

console.log(typeof array[Symbol.iterator]);

let it = array[Symbol.iterator]();
console.log(it.next());
console.log(it.next());
console.log(it.next());
console.log(it.next());

let newArray = [1,2,3,4];

newArray[Symbol.iterator] = function () {
    let nextValue = 10;
    return {
        next : function () {
            nextValue++;
            return {
                done : nextValue > 15,
                value : nextValue
            }
        }
    }
}

for( let iterator of newArray) {
    console.log(iterator);
}

let myObj = {
    name : "Ionut",
    hobbies : ['Sports', "Reading"],
    [Symbol.iterator] : function f() {
        let i = 0;
        let hobbies = this.hobbies;
        return {
            next : function () {
                let value = hobbies[i];
                i++;
                return {
                    done: i > hobbies.length,
                    value: value
                }
            },
        };
    }
};

for (let hobby of myObj) {
    console.log(hobby);
}


