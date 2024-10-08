let maximoValor;
do {
    maximoValor = parseInt(prompt("Introduce un valor numérico entre 1 y 20:"));
} while (isNaN(maximoValor) || maximoValor < 1 || maximoValor > 20);

let contador = 1;
let estudioMachos = 0;
let estudioHembras = 0;
let estudioIndefinido = 0;

do {
    let arrayNumeros = [];

    for (let i = 0; i < 250; i++) {
        let numeroAleatorio = Math.random() * maximoValor;
        arrayNumeros.push(numeroAleatorio);
    }

    let cantidadNumerosMenores = 0;
    let cantidadNumerosMayores = 0;
    let cantidadIndefinidos = 0;

    arrayNumeros.forEach(numeroDeArray => {
        if (numeroDeArray < (maximoValor * 0.45)) {
            cantidadNumerosMenores++;
        } else if (numeroDeArray > (maximoValor * 0.55)) {
            cantidadNumerosMayores++;
        } else {
            cantidadIndefinidos++;
        }
    });

    alert("Estudio número " + contador + " resultados: \n El numero de machos es: " + cantidadNumerosMenores +
        "\n El numero de hembras es: " + cantidadNumerosMayores +
        "\n El numero de indefinidos es: " + cantidadIndefinidos);

    if (cantidadIndefinidos > cantidadNumerosMayores && cantidadIndefinidos > cantidadNumerosMenores) {
        alert("Estudio numero " + contador + ": INDEFINIDO")
        estudioIndefinido++;
    } else {
        if (cantidadNumerosMenores > cantidadNumerosMayores) {
            alert("Estudio numero " + contador + ": MACHOS ");
            estudioMachos++;
        } else if (cantidadNumerosMenores < cantidadNumerosMayores) {
            alert("Estudio numero " + contador + ": HEMBRAS ");
            estudioHembras++;
        }
    }
    contador++;
} while (contador < 4);

let resultado;

function obtenerResultados() {
    alert("Tras realizar los tres estudios hemos obtenido estos resultados");
    if (estudioMachos > estudioHembras && estudioMachos > estudioIndefinido) {
        alert("RESULTADO FINAL MACHOS")
        resultado = "macho";
    }

    if (estudioMachos < estudioHembras && estudioHembras > estudioIndefinido) {
        alert("RESULTADO FINAL HEMBRAS")
        resultado = "hembra";
    }

    if (estudioMachos < estudioIndefinido && estudioHembras < estudioIndefinido) {
        alert("RESULTADO FINAL INDEFINIDO")
        resultado = "indefinido";
    }

    if (estudioMachos == 1 && estudioHembras == 1 && estudioIndefinido == 1) {
        alert("RESULTADO FINAL INDEFINIDO")
        resultado = "indefinido";
    }
}

obtenerResultados();

// cabecera
if (resultado == "macho") {
    document.getElementById('cabeceraEstudio').style.backgroundColor = ("#40bbf5");
    document.getElementById('imagen').src = 'images/hombre.png';
    document.getElementById('imagen').style.width = ('10vw');
    document.getElementById('imagen').style.height = ('auto');
}


if (resultado == "hembra") {
    document.getElementById('cabeceraEstudio').style.backgroundColor = ("pink");
    document.getElementById('imagen').src = 'images/mujer.png'
    document.getElementById('imagen').style.width = ('15vw');
    document.getElementById('imagen').style.height = ('auto');
}


if (resultado == "indefinido") {
    document.getElementById('cabeceraEstudio').style.backgroundColor = ("#3ae868");
    document.getElementById('imagen').src = 'images/indefinido.png'
    document.getElementById('imagen').style.width = ('15vw');
    document.getElementById('imagen').style.height = ('auto');
}

let boton = document.getElementById('btnCambio');
let textoGrande = document.getElementById('textoGrande');

function setColor() {
    if (boton.value == "boton") {
      textoGrande.style.color = "#7d3a13";
    }
  }

  let botonCambiarImagen = document.getElementById('btnCambiaImagen');
  let foto = document.getElementById('imagen');
  
  function setImagen() {   
    document.getElementById('imagen').src = 'images/estudio.png';
  }
  
  botonCambiarImagen.addEventListener('click', function() {
      setImagen();
  });

  
  function cambiaTexto(){
    let texto = document.querySelectorAll('p');
    for(let i = 0; i < texto.length; i++) {
      texto[i].style.color = "yellow";
    }
  }

  
let segundos = 0;
let intervalo;

function actualizarContador() {
  segundos++;
  let horas = Math.floor(segundos / 3600);
  let minutos = Math.floor((segundos % 3600) / 60);
  let seg = segundos % 60;

  let contador = horas + " : " + (minutos < 10 ? '0' + minutos : minutos) + " : " + (seg < 10 ? '0' + seg : seg);
  document.getElementById("contador").innerHTML = contador;
}

function iniciarContador() {
  intervalo = setInterval(actualizarContador, 1000);
}

function pausarContador() {
  clearInterval(intervalo);
}

function reiniciarContador() {
  clearInterval(intervalo);
  segundos = 0;
  actualizarContador();
}
   
actualizarContador();

