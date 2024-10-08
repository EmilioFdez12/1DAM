<?php

$server = "localhost:3307"; 
$bd = "miBD";
$user = "root";
$password = "";

$borrarBD = "DROP DATABASE IF EXISTS $bd";

$connection2 = mysqli_connect($server, $user, $password);

if (mysqli_query($connection2, $borrarBD)) {
    echo "La base de datos '$bd' ha sido eliminada correctamente.";
} else {
    echo "Error al eliminar la base de datos";
}

mysqli_close($connection2);
?>