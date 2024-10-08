
// alert("Hola Mundo!!!");

/* let num1 = 1;
let num2 = 2;
let num3 = 'cero "es cero"'; */

/* let num1 = 2, num2 = 5, num3 = 12 */

/* alert(typeof num1);
alert(num2);
alert(num3); */

/*let edad = Number(prompt("Escriba su edad"));*/

/*let gusta = confirm("Te gusta la pagina?");*/

/* alert(typeof edad); /*Con el prompt lo lee como String hay que pasarlo a numero antes
alert(edad[0]);
alert(edad); */

/*
if(edad > 25){
    alert("Eres muy mayor");
} else {
    alert("Eres muy joven");
}
*/

/* for (let i = 0; i <= 5; i++){
    valores[i] = prompt("Introduzca el valor");
} */

/*Array*/
let valores = [];

for (let i = 0; i <= 4; i++){
    valores.push(prompt("Introduzca el valor"));
}


let maximo = valores[0];
let suma = 0;

for(let i = 0; i <= 4;i++){
    if(maximo < valores[i])
        maximo = valores[i];
    suma += valores[i];
}

alert(valores);
alert("El numero " + maximo + " es el mayor")
alert(suma / 5);


/*let i = 0;

let caracter = "Hola Mundo";

let vari = false;
*/

//const constante

// let variable "local"

//var variable "global" 