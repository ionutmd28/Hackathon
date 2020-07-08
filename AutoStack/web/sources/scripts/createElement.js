function createItems(item, index) {
    let divElement = document.createElement("div");
    divElement.classList.add("part-identifier");

    let h4 = document.createElement("h4");
    let link = document.createElement("a");

    link.innerText = item.partName;

    h4.appendChild(link);
    divElement.appendChild(h4);

    let image = document.createElement("img");
    image.setAttribute("src", item.imageSrc);

    divElement.appendChild(image);

    let p = document.createElement('p');
    p.classList.add("text-parts");
    p.innerText = item.partDescription;

    let p2 = document.createElement('p');
    p2.classList.add("text-parts");
    p2.innerText = item.price;

    divElement.appendChild(p);
    divElement.appendChild(p2);

    let button = document.createElement("button");
    button.setAttribute("type", "submit");
    button.setAttribute("onclick", "addElement(this)");
    button.innerText = "Add this part";

    let deleteButton = document.createElement("button");
    deleteButton.setAttribute("type", "submit");
    deleteButton.setAttribute("id", index);
    deleteButton.setAttribute("onclick", "deleteItem(this)");
    deleteButton.innerText = "Delete this part";

    let updateButton = document.createElement("button");
    updateButton.setAttribute("type", "submit");
    updateButton.setAttribute("id", index);
    updateButton.setAttribute("onclick", "updateItem(this)");
    updateButton.innerText = "Update this part";

    let buttonsForm = document.createElement("form");

    buttonsForm.appendChild(button);
    buttonsForm.appendChild(deleteButton);
    buttonsForm.appendChild(updateButton);

    let line = document.createElement("div");
    line.classList.add("line");

    line.appendChild(buttonsForm);
    divElement.appendChild(line);

    if(parseInt(sessionStorage.getItem("updateItemIndex")) > -1) {
        let itemToUpdate = JSON.parse(sessionStorage.getItem('list'))[parseInt(sessionStorage.getItem("updateItemIndex"))];
        document.getElementById("partName").value = itemToUpdate.partName;
        document.getElementById("partDescription").value = itemToUpdate.partDescription;
        document.getElementById("price").value = parseInt(itemToUpdate.price);
        document.getElementById("createOrUpdate").innerText = "Update";
    } else {
        document.getElementById("createOrUpdate").innerText = "Create";
    }

    document.getElementById("second-half").appendChild(divElement)
}

function create() {
    if(JSON.parse(sessionStorage.getItem('list')) != null) {
        JSON.parse(sessionStorage.getItem('list')).forEach(createItems);
    }
}