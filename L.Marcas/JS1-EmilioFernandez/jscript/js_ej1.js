/* Ejercicio 1 */
alert("EJERCICIO 1");
let nombre = "Emilio";
let curso = "1º DAM";
alert("Nombre: " + nombre + "\nCurso: " + curso + "\nNo me puedo decidir en algo realmente, "
    + "pero lo que más me gustaría sería: Páginas Web(Interfaces), Desarrollo de Aplicaciones o Desarrollo de videojuegos");

/* Ejercicio 2 */
alert("EJERCICIO 2");
let sumaEj2 = 0;
do {
    numero = Number(prompt("Introduzca números para sumarlos, (0 para terminar el programa)"));
    if (isNaN(numero)) {
        alert("Tienes que introducir números");
    } else {
        sumaEj2 += numero;
    }
} while (numero !== 0);
alert("La suma de los números dados es = " + sumaEj2);

/* Ejercicio 3 */
alert("EJERCICIO 3");
let numeroGrande = '';
for (let i = 1; i <= 4; i++) {
    do {
        numero = prompt("Introduce el número " + i);
        if (isNaN(numero)) {
            alert("Introduce números");
        }
    } while (isNaN(numero));
    numeroGrande += numero;
}
alert("El resultado es " + numeroGrande);

/* /*4. Leer el valor de la nota de un alumno y poner la nota correspondiente en texto. Por ejemplo,
un 7.2 es notable.*/
alert("EJERCICIO 4")
let nota = Number(prompt("Introduce la nota: "))

if (nota < 5) {
    alert("Un " + nota + " esta suspenso")
} else if (nota >= 5 && nota <= 7) {
    alert("Un " + nota + " es un bien")
} else if (nota > 7 && nota < 9) {
    alert("Un " + nota + " es un notable")
} else if (nota >= 9 && nota <= 10) {
    alert("Un " + nota + " es un sobresaliente")
}

/*5. Introducir 10 valores en un array, mostrar la suma de sus valores, el mayor valor, el menor
valor y la media de los valores.*/
alert("EJERCICIO 5")
// 1. Crear un array para almacenar los valores
let valoresArray = [];

// 2. Utilizar un bucle para introducir 10 valores en el array
for (let i = 0; i < 10; i++) {
    // Puedes utilizar prompt para pedir al usuario que ingrese valores
    let numeroArray = parseInt(prompt("Introduce un valor:"));

    // Agregar el valor al array
    valoresArray.push(numeroArray);
}

// 3. Calcular la suma de los valores
let sumar = 0;
for (let i = 0; i < valoresArray.length; i++) {
    sumar += valoresArray[i];
}

// 4. Calcular el mayor y menor valor
let maximo = Math.max(valoresArray); // corregir
let minimo = Math.min(valoresArray);

// 5. Calcular la media de los valores
let media = sumar / valoresArray.length;

// 6. Mostrar los resultados
alert("Suma de los valores: " + sumar);
alert("Mayor valor: " + maximo);
alert("Menor valor: " + minimo);
alert("Media de los valores: " + media);


/*6. Rellenar un array con valores aleatorios mediante una función matemática de 20 elementos
tipo entero entre el 10 y el 20. El programa tendrá que mostrar el total de valores mayores que
15, menores que 15 e iguales a 15.*/
alert("EJERCICIO 6")
let valoresArray2 = [];

// 1. Función para obtener un valor aleatorio entre 10 y 20
function obtenerValorAleatorio() {
    return Math.floor(Math.random() * (20 - 10 + 1)) + 10;
}

// 2. Rellenar el array con 20 valores aleatorios
for (let i = 0; i < 20; i++) {
    valoresArray2.push(obtenerValorAleatorio());
}

// 3. Mostrar el array
alert("Array generado:" + valoresArray2);

// 4. Contar valores mayores, menores e iguales a 15
let mayores15 = 0;
let menores15 = 0;
let iguales15 = 0;

for (let i = 0; i < valoresArray2.length; i++) {
    if (valoresArray2[i] > 15) {
        mayores15++;
    } else if (valoresArray2[i] < 15) {
        menores15++;
    } else {
        iguales15++;
    }
}

// 5. Mostrar resultados
alert("Total de valores mayores que 15: " + mayores15);
alert("Total de valores menores que 15: " + menores15);
alert("Total de valores iguales a 15: " + iguales15);
