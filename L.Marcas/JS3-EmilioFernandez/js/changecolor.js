// Texto del titulo
document.getElementById('tit').innerHTML = ("Este es el titulo de la página");
document.getElementById('tit').style.color = ('#6ed8ff');
document.getElementById('tit').style.display = ('flex');
document.getElementById('tit').style.justifyContent = ('center');
document.getElementById('tit').style.alignItems = ('center');
document.getElementById('tit').style.marginTop = ('2vh');
document.getElementById('tit').style.marginBottom = ('2vh');
document.getElementById('tit').style.fontSize = ('8vh');
document.getElementById('tit').style.fontFamily = ('Bebas Neue');
document.getElementById('tit').style.width = ('100vw');

// Cambia imagen
let contadorImagen = 2;
// Bucle para que puedas cambiar de imagen siempreF
function cambiarImagen() {
  if ((contadorImagen % 2) == 0) {
    document.getElementById('fotoCambiante').src = ('images/rioLandscape.jpg');
    contadorImagen++;
  } else {
    document.getElementById('fotoCambiante').src = ('images/greenLandscape.jpg');
    contadorImagen++;
  }
}


let btnRojo = document.getElementById('btnrojo');
let btnVerde = document.getElementById('btnverde');
let btnAzul = document.getElementById('btnazul');
let btnAmarillo = document.getElementById('btnamarillo');
let btnReset = document.getElementById('btnreset');
let box = document.querySelector('.box');
// Color añadido
let btnMorado = document.getElementById('btnmorado');

//Cambio de colores
function setColorRojo() {
  if (btnRojo.value == "rojo") {
    box.style.background = "#FF3232";
    tit.style.color = "#FF3232";
  }
}

function setColorVerde() {
  if (btnVerde.value == "verde") {
    box.style.background = "#84ff6e";
    tit.style.color = "#84ff6e";
  }
}

function setColorAzul() {
  if (btnAzul.value == "azul") {
    box.style.background = "#6ed8ff";
    tit.style.color = "#6ed8ff";
  }
}

function setColorAmarillo() {
  if (btnAmarillo.value == "amarillo") {
    box.style.background = "#F4FA4B";
    tit.style.color = "#F4FA4B";

  }
}

function setColorReset() {
  if (btnReset.value == "reset") {
    box.style.background = "white";
    tit.style.color = "#6ed8ff";
  }
}

// Funcion de color añadida
function setColorMorado() {
  if (btnMorado.value == "morado") {
    box.style.background = "#952FFA";
    tit.style.color = "#952FFA";
  }
}


function changeColor(element, bgColor, fontColor) {
  element.style.background = bgColor;
  element.style.color = fontColor;
}

function changeColorReset(element) {
  element.style.background = "";
  element.style.color = "";
}

// Reloj
function actualizarReloj() {
  var reloj = new Date()
  var horas = reloj.getHours();
  var minutos = reloj.getMinutes();
  var segundos = reloj.getSeconds();
  var diaSemana = reloj.toLocaleDateString('es-ES', { weekday: 'long' })
  var fecha = reloj.toLocaleDateString('es-ES', { year: 'numeric', month: 'long', day: "2-digit" })

  var horaCompleta = horas + " : " + (minutos < 10 ? '0' + minutos : minutos) + " : " + (segundos < 10 ? '0' + segundos : segundos) + " " + diaSemana.toUpperCase() + " " + fecha.toUpperCase();

  document.getElementById("reloj").innerHTML = horaCompleta;
}

//Para actualizar el reloj
setInterval(actualizarReloj, 1000);

// Inicializar el reloj al cargar la página
actualizarReloj();



function preguntaTiempo() {
  let confirmar = confirm("¿Desea salir de la página?");
  if (confirmar) {
    window.location.href = 'https://www.formula1.com';
  }
}

// 1 intervalo es = 1 milisegundo --> 1000 milisegundos = 1 seg
// Por lo tanto 3 minutos = 180.000
// Pregunta cada 3 minutos
setInterval(preguntaTiempo, 180000);



// Cuadro en la página que indique su ancho y su alto y si este cambia, que esos
//cambios se vean reflejados

let cuadro = document.getElementById('cuadrado');

function actualizarCuadro() {
  // Actualiza el cuadro cada vez que se cambia la altura o el ancho
  let ancho = cuadro.clientWidth;
  let alto = cuadro.clientHeight;

  cuadro = document.getElementById('contenedor');
  cuadro.innerHTML = ('Ancho ' + ancho + 'px, Alto ' + alto + 'px');
}

actualizarCuadro();


window.addEventListener('resize', function () {
  cuadro = document.getElementById('cuadrado');
  actualizarCuadro();
});


//Ej 5 Boton que al pulsarlo desaparezca

let btnFantasma = document.getElementById('boo');

btnFantasma.addEventListener('click', function () {
  btnFantasma.style.display = 'none';
})


// Ej 8 Modo oscuro
function toggleDarkMode() {
  let body = document.body;
  // Se seleccionan todos los input, de tipo boton.
  let botones = document.querySelectorAll('input[type="button"]');
  body.classList.toggle("dark-mode");
  botones.forEach(boton => {
    boton.classList.toggle("dark-input");
  });
}


// Ejercicio 6
document.getElementById('textoDesaparecer').innerHTML = ('Texto que desaparece')
document.getElementById('textoDesaparecer').style.color = ('#6ed8ff');
document.getElementById('textoDesaparecer').style.fontSize = ('8vh');
document.getElementById('textoDesaparecer').style.fontFamily = ('Bebas Neue');


let borrarTexto = document.getElementById('btnBorraTexto');
let contadorClicks = 2;

borrarTexto.addEventListener('click', function () {

  if (contadorClicks % 2 == 0) {
    textoDesaparecer.style.display = 'none';
    contadorClicks++;
  } else {
    textoDesaparecer.style.display = 'inline'
    contadorClicks++;
  }

})

// Ejercicio 7

let alerta1 = document.getElementById('btnTexto1');
let alerta2 = document.getElementById('btnTexto2');

alerta1.addEventListener('click', function(){
  alert('Buenos dias')
})

 let contadorClicks2 = 2;
  alerta2.addEventListener('click', function(){
  if(contadorClicks2 % 2 == 0){
    alert('Hola')
    alert('Adios')
    contadorClicks2++;
  } else {
    alert('Hola')
  }

})