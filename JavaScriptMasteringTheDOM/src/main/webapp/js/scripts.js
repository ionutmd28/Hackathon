
    var carImages = document.querySelector(".carimages");

    carImages.addEventListener("click", function(e){
        // console.log(console.log(carImages));

        var overlay = document.createElement("div");
        overlay.id = "overlay";

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

        document.body.appendChild(overlay);


        console.log(popUpImage);
        console.log(e.target);

    }); //Enent listener for the div width class of carImage

    console.log("Works!")
