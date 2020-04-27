let dogObject = {
    name: "Rex",
    legs: 4,
    sayNameANdLegs: function () {
        console.log("The name of the dog is " + this.name + " and the number of the legs is " + dogObject.legs)
    }
};

console.log(dogObject.legs);
dogObject.sayNameANdLegs();

function MyGameConstructor() {
    this.name = "Player1";
    this.game = "CallOfDuty";
    this.hoursPlayed = 45;
}

let maGame = new MyGameConstructor();

console.log(maGame.game);

function Country(city, population) {
    this.city = city;
    this.population = population;
    this.place = "Earth";
}

let myCountry = new Country("Sibiu", 99999);

let myNewCountry = new Country("Cluj", 111111);

console.log(myCountry.city + " " + myCountry.place + " " + myCountry.population);

console.log(myNewCountry.city + " " + myNewCountry.place + " " + myNewCountry.population);

console.log(myCountry instanceof Country);

Country.prototype.name = "Romania";

console.log(myCountry.name);

console.log(myNewCountry.name);

let ownProps = [];
let prototypeProps = [];

for(let property in myCountry) {
    if(myCountry.hasOwnProperty(property)) {
        ownProps.push(property);
    } else {
        prototypeProps.push(property);
    }
}

console.log(ownProps);
console.log(prototypeProps);

function checkIfCountry(candidate) {
    return candidate.constructor === Country;
}

console.log(checkIfCountry(myCountry));
console.log((checkIfCountry(maGame)));

Country.prototype = {
    constructor : Country,
    numberOfCities : 3,
    write : function () {
        console.log(this.numberOfCities);
    }
};

let exampleCountry = new Country("SB", 9);

exampleCountry.write();

console.log(Country.prototype.isPrototypeOf(exampleCountry));
console.log(Country.prototype.isPrototypeOf(myCountry));

console.log(Object.prototype.isPrototypeOf(Country.prototype));

function Earth() { }
    Earth.prototype.galaxy = function () {
        console.log("Hallo");
    };

Country.prototype = Object.create(Earth.prototype);
//better
// let createCountry = Object.create(Country.prototype);

//than
let createNewCountry = new Country("Sib", 99);

createCountry = new Country("Ias", 12);

createCountry.galaxy();

let selectCountry = function (obj) {
    obj.select = function () {
        console.log("Select");
    }
};

selectCountry(createCountry);

createCountry.select();

(function () {
    console.log("FIN!");
})();