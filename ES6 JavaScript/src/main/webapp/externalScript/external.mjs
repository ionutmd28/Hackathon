//Play with import/export

let keyValue = 1000;
let fct = () => {
    console.log("Works!!");
    keyValue = 2000;
}

let abc = "Some text";

export {keyValue, fct};
export default abc;
