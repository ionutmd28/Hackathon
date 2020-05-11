function myFunction() {
    //images list
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

            //remove the new created overlay including the new image
            function removeOverlay() {
                if (popUpImage && overlay) {
                    overlay.parentElement.removeChild(overlay);
                }
            }

            //remove the events listeners to close the actions and avoid conflicts
            function removeClickAndEscapeEvents() {
                window.removeEventListener("click", removeByClick);
                window.removeEventListener("keyup", removeByEscape);
            }

            //remove overlay and click and escape events
            function removeByClick(e) {
                if (e.target.classList.contains("onClick")) {
                    removeOverlay();
                    removeClickAndEscapeEvents();
                }
            }


            //remove overlay and click and escape events
            function removeByEscape(event) {
                if (event.key === "Escape") {
                    removeOverlay();
                    removeClickAndEscapeEvents();

                }
            }

            window.addEventListener("click", removeByClick);

            window.addEventListener("keyup", removeByEscape);

            document.body.appendChild(overlay);
        }
    }); //Event listener for the div width class of image

    console.log("Works!")
}

myFunction();