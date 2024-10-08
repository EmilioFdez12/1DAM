/* Ejercicio 1 */
let numeracion = {
  1: "primero",
  2: "segundo",
  3: "tercero",
  4: "cuarto",
  5: "quinto",
  6: "sexto",
  7: "septimo",
  8: "octavo",
  9: "noveno",
  10: "decimo"
}

let numeroAIntroducir;

do {
  numeroAIntroducir = prompt("Introduce un número ordinal del 1 al 10:");

  // Si es un número se ejecuta el bucle, si no se termina el bucle 
  if (Number(numeroAIntroducir)) {
    if (numeroAIntroducir >= 1 && numeroAIntroducir <= 10) {
      for (let i in numeracion) {
        if (numeroAIntroducir == i) {
          alert(numeracion[i]);
        }
      }
    }
  }    
} while (numeroAIntroducir >= 1 && numeroAIntroducir <= 10);


/*Ejercicio 2 */

// Solicitamos al usuario ingresar el primer número decimal

let a, b;
[a, b]

do {
  a = prompt("Ingrese el primer número decimal:");
  a = parseInt(a);

  // Verificamos si el valor es un número válido
  if (isNaN(a)) {
    alert("Por favor, ingrese un número válido.");
  }
} while (isNaN(a));

do {
  b = prompt("Ingrese el segundo número decimal:");
  b = parseInt(b);

  // Verificamos si el valor es un número válido
  if (isNaN(b)) {
    alert("Por favor, ingrese un número válido.");
  }
} while (isNaN(b));

let suma = a + b;

// Convertimos el resultado a binario y hexadecimal
let sumaBinario = suma.toString(2);
let sumaHexadecimal = suma.toString(16);

// Mostramos los resultados
alert(`Resultado de la suma:
    Decimal: ${suma}
    Binario: ${sumaBinario}
    Hexadecimal: ${sumaHexadecimal}`);


/*Ejercicio 4 */

let entrada1 = prompt("Introduzca una cadena de texto")
let entrada2 = prompt("Introduzca otra cadena de texto")

if (entrada1.includes(entrada2)) {
  alert("La segunda cadena es subcadena de la primera");
} else {
  alert("La segunda cadena no es subcadena de la primera");
}

alert("La cadena 1 tiene " + entrada1.length + " carácteres " + " y la segunda tiene " + entrada2.length + " carácteres");

let vocales = ['a', 'e', 'i', 'o', 'u'];

for (let vocal of vocales) {
  entrada1 = entrada1.split(vocal).join(vocal.toUpperCase());
}

if (entrada1.length > 5) {
  alert(entrada1.substring(0, 5) + "...");
} else {
  alert(entrada1);
}


/*Ejercicio 5*/
//Funcion para calcular las potencias
function potencia(base, exponente) {
  let resultado = 1;
  //Bucle se multiplica el mismo numero tantas veces como grande sea el exponente
  for (let i = 1; i <= exponente; i++) {
    resultado *= base;
  }
  return resultado;
}

let base = prompt("Indique la base");
let exponente = prompt("Indique el exponente");

// La base y el exponente deben ser enteros
base = parseInt(base);
exponente = parseInt(exponente);

// Condicionales para indeterminaciones, o si se deja en blanco.
if (isNaN(base) || isNaN(exponente)) {
  alert("Error. Debe completar los campos");
} else if (base == 0 && exponente == 0) {
  alert("Error");
} else if (base != 0 && exponente == 0) {
  alert(1);
} else if (base != 0 && exponente != 0) {
  // Utilizamos la funcion para calcular la potencia cuando los campos son correctos
  alert(potencia(base, exponente));
}

/*Ejercicio 6 */

// Función flecha para mostrar la tabla de multiplicar
let mostrarTablaMultiplicar = (numero, inicio, fin) => {
  alert("Tabla de multiplicar del " + numero + ": ");
  for (let i = inicio; i <= fin; i++) {
    alert(numero + " x " + i + " = " + numero * i);
  }
};

// Preguntamos si se desea continuar
let deseaContinuar = (numero) => {
  let respuesta = confirm("¿Desea continuar?");
  return respuesta;
};

let continuar;

do {
  let inputNumero = prompt("Introduzca un número para mostrar su tabla de multiplicar:");

  if (!isNaN(inputNumero)) {
    let inicio = 1;
    let fin = 10;

    do {
      mostrarTablaMultiplicar(inputNumero, inicio, fin);
      continuar = deseaContinuar(inputNumero);
      inicio = fin + 1;
      fin += 10;
    } while (continuar);

  } else {
    alert("Por favor, ingresa un número válido.");
    continuar = true;
  }
} while (continuar);


