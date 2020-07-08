function addElement(element) {
    let firstHalf = document.getElementById('first-half');

    firstHalf.appendChild(element.parentElement.parentElement);

    // element.parentElement.parentElement.style.display = "none";
}