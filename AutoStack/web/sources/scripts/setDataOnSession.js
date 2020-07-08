let listOfItems = [];
function setData() {

    if(document.getElementById("createOrUpdate").innerText === "Create") {

        let file = document.getElementById("image").files[0];

        if (file) {
            let reader = new FileReader();
            reader.onload = function (e) {
                let data = {
                    partName: document.getElementById("partName").value,
                    imageSrc: e.target.result.toString(),
                    partDescription: document.getElementById("partDescription").value,
                    price: document.getElementById("price").value + "$"
                };

                if (sessionStorage.getItem('list') != null) {
                    listOfItems = JSON.parse(sessionStorage.getItem('list'));
                    listOfItems.push(data);
                    sessionStorage.setItem('list', JSON.stringify(listOfItems));
                } else {
                    listOfItems.push(data);
                    sessionStorage.setItem('list', JSON.stringify(listOfItems));
                }
            }
            reader.readAsDataURL(file);

        }
    } else {

        listOfItems = JSON.parse(sessionStorage.getItem('list'));

        listOfItems[parseInt(sessionStorage.getItem("updateItemIndex"))].partName =  document.getElementById("partName").value;

        let file = document.getElementById("image").files[0];

        if(file) {
            let reader = new FileReader();
            reader.onload = function (e) {
                listOfItems[parseInt(sessionStorage.getItem("updateItemIndex"))].imageSrc =  e.target.result.toString();
            }
            reader.readAsDataURL(file);
        }

        listOfItems[parseInt(sessionStorage.getItem("updateItemIndex"))].partDescription = document.getElementById("partDescription").value;

        listOfItems[parseInt(sessionStorage.getItem("updateItemIndex"))].price = document.getElementById("price").value + "$";

        sessionStorage.setItem('list', JSON.stringify(listOfItems));

        sessionStorage.setItem("updateItemIndex", "-1");
    }
}
