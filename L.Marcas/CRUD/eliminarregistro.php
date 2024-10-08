<?php

function eliminarRegistro($id) {
    global $connection2;
    $borrado = "DELETE FROM usuarios WHERE id=$id";
    return mysqli_query($connection2, $borrado);
} 

$server = "localhost:3307"; 
$bd = "miBD";
$user = "root";
$password = "";
$valor = $_POST['identificador'];

$connection2 = mysqli_connect($server, $user, $password, $bd);
if (!$connection2) {
    die ("Error al conectar a la base de datos: ". mysqli_connect_error());
}else

eliminarRegistro ($valor);

mysqli_close($connection2);
?>