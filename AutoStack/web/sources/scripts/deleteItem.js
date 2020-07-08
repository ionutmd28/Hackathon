function deleteItem(deleteButton) {
    let listOfItemsAfterDelete = [];
    listOfItemsAfterDelete = JSON.parse(sessionStorage.getItem('list'));
    sessionStorage.setItem('list', JSON.stringify(listOfItemsAfterDelete.slice(0, deleteButton.id)
        .concat(listOfItemsAfterDelete.slice(parseInt(deleteButton.id) + 1))));
}