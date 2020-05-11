function myFunction() {
    //
    var carImages = document.querySelector(".images");

    carImages.addEventListener("click", function image(e) {
        if(e.target.classList.contains("img-responsive")) {

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
                }
            }

            window.addEventListener("click", function removeO(e) {
                if (e.target.classList.contains("onClick")) {
                    removeOverlay();
                    removeEventListener("click", removeO);
                }
            });

            window.onkeyup = function removeK(event) {
                    if (event.key === "Escape") {
                        if(typeof(overlay) !== 'undefined') {
                            removeOverlay();
                            window.removeEventListener("keyup", removeK);
                        }
                    }
            }

            document.body.appendChild(overlay);
        }
    }); //Event listener for the div width class of image

    console.log("Works!")
}

myFunction();