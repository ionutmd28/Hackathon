function checkCredentials(form) {
    if(form.userEmail.value === "ionutmd28@yahoo.com" && form.userPassword.value === "miclausid1") {
        window.close();
        window.open("HomePage.html");
    }
    else {
        alert("Wrong username and/or password, please try again!")
    }
}