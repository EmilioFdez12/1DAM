<?php
function actualizarRegistro($id, $nombre, $edad) {
    global $connection2;
    $actualizar = "UPDATE usuarios SET nombre='$nombre', edad='$edad' WHERE id=$id";
    return mysqli_query($connection2, $actualizar);
} 

$server = "localhost:3307"; 
$bd = "miBD";
$user = "root";
$password = "";
$valor = $_POST['id'];
$nvoNombre = $_POST['nombrenvo']; 
$nvaEdad = $_POST['edadnva'];

$connection2 = mysqli_connect($server, $user, $password, $bd);
if (!$connection2) {
    die ("Error al conectar a la base de datos: ". mysqli_connect_error());
}

actualizarRegistro($valor, $nvoNombre, $nvaEdad);

mysqli_close($connection2);
?>