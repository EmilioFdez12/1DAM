// Contenido Audi
document.getElementById('audi').addEventListener("click", () => {
    var xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("cont4").innerHTML = this.responseText;
        document.getElementById('fotoPrincipal').src = "./images/audi.jpg";
        document.getElementById('titulo').innerHTML = "Audi";
    };

    xhttp.open("GET", "./txt/audi.txt", true);
    xhttp.send();
});


// Contenido Civic
document.getElementById('civic').addEventListener("click", () => {
    var xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("cont4").innerHTML = this.responseText;
        document.getElementById('fotoPrincipal').src = "./images/civic.jpg";
        document.getElementById('titulo').innerHTML = "Civic";
    };

    xhttp.open("GET", "./txt/civic.txt", true);
    xhttp.send();
});


// Contenido F40
document.getElementById('f40').addEventListener("click", () => {
    var xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("cont4").innerHTML = this.responseText;
        document.getElementById('fotoPrincipal').src = "./images/f40.jpg";
        document.getElementById('titulo').innerHTML = "F40";
    };

    xhttp.open("GET", "./txt/f40.txt", true);
    xhttp.send();
});


// Contenido lambo
document.getElementById('lamborghini').addEventListener("click", () => {
    var xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("cont4").innerHTML = this.responseText;
        document.getElementById('fotoPrincipal').src = "./images/lambo.jpg";
        document.getElementById('titulo').innerHTML = "Lamborghini";
        document.getElementById('titulo').style.fontSize = "6vh";
    };

    xhttp.open("GET", "./txt/lamborghini.txt", true);
    xhttp.send();
});


// Contenido lambo
document.getElementById('porsche').addEventListener("click", () => {
    var xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("cont4").innerHTML = this.responseText;
        document.getElementById('fotoPrincipal').src = "./images/porsche.jpg";
        document.getElementById('titulo').innerHTML = "Porsche";
        document.getElementById('titulo').style.fontSize = "9vh";
    };

    xhttp.open("GET", "./txt/porsche.txt", true);
    xhttp.send();
});