<?php
// Configuración de la base de datos
$server = "localhost:3307"; 
$bd = "miBD";
$user = "root";
$password = "";

// Conexión a la base de datos utilizando mysqli_connect
// hay que tener en cuenta que la BD no está creada
$connection = mysqli_connect($server, $user, $password);

// Verificar la conexión. EN el caso que no se establezca conexión salimos
// die() muestra un mensaje y finaliza el script
if (!$connection) {
    die ("Error al conectar a la base de datos: ". mysqli_connect_error());
}else{
    echo "Base de datos creada correctamente ";
}

// Creamos la base de datos si no existe
$crearBD = "CREATE DATABASE IF NOT EXISTS miBD";
mysqli_query($connection, $crearBD);

// Establecemos la conexión con la BD recién creada
$connection2 = mysqli_connect($server, $user, $password, $bd);
if (!$connection2) {
    die ("Error al conectar a la base de datos: ". mysqli_connect_error($connection2));
}
// Creamos la tabla si no existe
$crearTabla = "CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    edad INT NOT NULL
)";
mysqli_query($connection2, $crearTabla);


// Cerrar la conexión
mysqli_close($connection);
mysqli_close($connection2);
?>