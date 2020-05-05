(function () {

    var carImages = document.querySelector(".carimages");

    carImages.addEventListener("click", function(e){
        // console.log(console.log(carImages));

        var overlay = document.createElement("div");
        overlay.id = "overlay";

        //set style
        overlay.style.position = "absolute";
        overlay.style.top = 0;
        overlay.style.background = "rgba(0,0,0,0.7)";
        overlay.style.cursor = "pointer";

        //set sizes
        overlay.style.width = window.innerWidth + "px";
        overlay.style.height = window.innerHeight + "px";

        //get image source
        var imageSrc = e.target.src;

        //create the image

        var popUpImage =document.createElement('img');
        popUpImage.id = "popimage";
        popUpImage.src = imageSrc;

        //style the image

        popUpImage.style.display = "block";
        popUpImage.style.width = "58%";
        popUpImage.style.margin = "0 auto";
        popUpImage.style.marginTop = "10%";

        overlay.appendChild(popUpImage);

        popUpImage.addEventListener("click", function () {
           if(overlay) {
               overlay.parentElement.removeChild(overlay);
           }
        });

        //set image to follow window scroll
        window.addEventListener("scroll", function () {
            if(overlay) {
                overlay.style.top = window.pageYOffset + "px";
                overlay.style.left = window.pageXOffset + "px";
            }
        });

        //set overlay to resize when the window is resized
        window.addEventListener("resize", function () {
            if(overlay) {
                overlay.style.width = window.innerWidth + "px";
                overlay.style.height = window.innerHeight + "px";
            }
        });

        document.body.appendChild(overlay);


        console.log(popUpImage);
        console.log(e.target);

    }); //Enent listener for the div width class of carImage

    console.log("Works!")
})(); //load the document first