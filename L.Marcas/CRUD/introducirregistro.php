<?php
// Configuración de la base de datos
$server = "localhost:3307"; 
$bd = "miBD";
$user = "root";
$password = "";

// Conexión a la base de datos utilizando mysqli_connect
// hay que tener en cuenta que la BD no está creada
$connection2 = mysqli_connect($server, $user, $password, $bd);

// Verificar la conexión
if (!$connection2) {
    die ("Error al conectar a la base de datos: "). mysqli_connect_error($connection2);
}

function createRecord ($connection2, $nombre, $edad) {
    $crearRegistro = "INSERT INTO usuarios (nombre, edad) VALUES ('$nombre', '$edad')";
    mysqli_query($connection2 , $crearRegistro);
}

// Crear un registro nuevo con los datos introducidos en el formulario
$name = $_POST['nombre'];
$age = $_POST['edad'];
createRecord($connection2, $name, $age);

// Cerrar la conexión
mysqli_close($connection2);
?>