// Requirement
/*
* Use them ALL !
*
* */

var firstName = "Ionut";
var secondName = "Miclaus"
var blankSpace = " ";
var newLine = "\n";
var fullName = firstName + blankSpace + secondName;
var years = 21;
years ++;
var parYears = years % 2;

function par(check) {
    if (check % 2 === 0) {
        return "Par";
    } else {
        return "Impar";
    }
}

console.log(fullName + newLine
    + years + blankSpace + par(parYears) + newLine
    + fullName.length + blankSpace + fullName[0] + newLine);

fullName = "Alexandru Radu";
var secondLetter = fullName[1];
var myName = ["Ionut", "Miclaus"];
var moreNamesAndAge = [["Andrei", "Apostol", 23], ["Codrin", "Sekely", 25]];

console.log(fullName + blankSpace + secondLetter + newLine
    + myName + newLine
    + moreNamesAndAge + newLine);

moreNamesAndAge[1][2] = 20;
var newName = ["Adriana", "Apostol", 19];
moreNamesAndAge.push(newName);

console.log(moreNamesAndAge + newLine);

moreNamesAndAge.pop();
moreNamesAndAge.shift();

console.log(moreNamesAndAge + newLine);

moreNamesAndAge.unshift(newName);

console.log(moreNamesAndAge + newLine);

var global = 10;

function addTwo() {
    global += 2;
}

addTwo();

if (global > 10) {
    console.log(global + newLine);
}

function testEquality(var1, var2) {
    if (var1 === var2) {
        return "The values " + typeof var1 + var1 + " and " + typeof var2 + var2 + " are equal when we use ===."
    } else if (var1 == var2) {
        return "The values " + typeof var1 + var1 + " and " + typeof var2 + var2 + " are equal when we use ==. "
    } else {
        return "The values " + typeof var1 + var1 + " and " + typeof var2 + var2 + " are not equal."
    }
}

function testEqualityUsingSwitch(var1, var2) {
    switch(var1 === var2) {
        case true:
            return "The values " + typeof var1 + var1 + " and " + typeof var2 + var2 + " are equal when we use ===.";
        case false: switch(var1 == var2) {
            case true:
                return "The values " + typeof var1 + var1 + " and " + typeof var2 + var2 + " are equal when we use ==. ";
            case false:
                return "The values " + typeof var1 + var1 + " and " + typeof var2 + var2 + " are not equal.";
        }
    }
}

console.log(testEquality(2, 2) + newLine
    + testEquality(2, "2") + newLine
    + testEquality(2,3) + newLine);

console.log(testEqualityUsingSwitch(2, 2) + newLine
    + testEqualityUsingSwitch(2, "2") + newLine
    + testEqualityUsingSwitch(2,3) + newLine);

var myObject = {
    "Full Name" : "Ionut Miclaus",
    "Age" : 21,
    "Languages" : [
        "English",
        "French",
        "Romanian"
    ],
    "Birth Year" : 1998
};

var yearOfBirth = myObject["Birth Year"];

var name = myObject["Full Name"];

var age = myObject.Age;

console.log(name + blankSpace + age + blankSpace + yearOfBirth + newLine);

myObject["Age"] = 22;
myObject.newProperty = "This is a empty property";

if (myObject.hasOwnProperty("newProperty")) {
    console.log("The new property was added successfully!")
}

console.log(myObject["Age"] + blankSpace + myObject.newProperty + newLine);

//Accessing the romanian language

console.log(myObject["Languages"][2] + newLine);

var dog = "Rex";

function singleReverse(name) {
    for (var i = name.length - 1; i >= 0; i--) {
        console.log(name[i]);
    }
    console.log(newLine);
}

singleReverse(dog);
singleReverse("Buna ziua!");

function randomNumber(number) {
    return Math.floor(Math.random() * number);
}

console.log(randomNumber(10) + newLine);

function convertToInteger(string) {
    return parseInt(string);
}

var number = convertToInteger("221");

console.log(typeof number + blankSpace + "is " + number + newLine);

function compare(a, b) {
    return a > b ? true : a === b ? 0 : false;
}

console.log(compare(1, 2) + newLine
    + compare(2,1) + newLine
    + compare(2, 2) + newLine);

//Recursion

function oddNumbersReverse(n) {
    if(n%2 === 1) {
        console.log(n);
    } else if (n > 0 ) {
        console.log(n-1);
    } else {
        return 0;
    }

    return oddNumbersReverse(n-2);
}

oddNumbersReverse(10);

console.log(newLine);

oddNumbersReverse(13);