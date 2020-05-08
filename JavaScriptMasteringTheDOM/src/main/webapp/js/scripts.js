function myFunction() {
    //
    // var carImages = document.querySelector(".images");

    addEventListener("click", function image(e) {
        if(e.target.classList.contains("img-responsive")) {
            //append the image to the new div

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

            overlay.appendChild(popUpImage);

            function removeOverlay() {
                if (popUpImage && overlay) {
                    overlay.parentElement.removeChild(overlay);
                    removeEventListener("click", image,true);
                }
            }

            addEventListener("click", function removeO(e) {
                if (e.target.classList.contains("onClick")) {
                    removeOverlay();
                    removeEventListener("click", removeO,true);
                }
            });

            if (overlay) {
                window.onkeyup = function removeK(event) {
                    if (event.key === "Escape") {
                        removeOverlay();
                        removeEventListener("keypress", removeK,true);
                    }
                }
            }

            document.body.appendChild(overlay);
        }
    }); //Event listener for the div width class of image

    console.log("Works!")
}

myFunction();