function myFunction() {

    var carImages = document.querySelector(".images");

    carImages.addEventListener("click", function (e) {

        //create a new div
        var overlay = document.createElement("div");
        overlay.id = "overlay";

        //set style for div
        overlay.className = "onClick";

        //get image source
        var imageSrc = e.target.src;

        //create the image
        var popUpImage = document.createElement('img');
        popUpImage.id = "popimage";
        popUpImage.src = imageSrc;

        //style the image
        popUpImage.style.display = "block";
        popUpImage.style.width = "58%";
        popUpImage.style.margin = "0 auto";

        //append the image to the new div
        overlay.appendChild(popUpImage);

        function removeOverlay() {
            if(popUpImage) {
                overlay.parentElement.removeChild(overlay);
            }
        }

        overlay.addEventListener("click", function () {
            removeOverlay();
        });

        window.onkeyup = function (event) {
            if (event.keyCode === 27) {
                removeOverlay();
            }
        }

        document.body.appendChild(overlay);


        console.log(popUpImage);
        console.log(e.target);

    }); //Event listener for the div width class of image

    console.log("Works!")
}

myFunction();