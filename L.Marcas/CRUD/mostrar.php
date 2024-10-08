<?php
function mostrarRegistros() {

    $server = "localhost:3307"; 
    $bd = "miBD";
    $user = "root";
    $password = "";

    $connection2 = mysqli_connect($server, $user, $password, $bd);
    if (!$connection2) {
        die ("Error al conectar a la base de datos: ". mysqli_connect_error());
    }

    $consulta = "SELECT * FROM usuarios";
    $result = mysqli_query($connection2, $consulta);
    $registros = [];

    // La siguiente instrucción llama al método mysqli_fetch_assoc() y el resultado
    // se le asigna a $row. En cada iteración se recupera un registro de la tabla. 
    // En el caso de que no haya más registros, devuelve NULL y se sale del bucle  
    while ($row = mysqli_fetch_assoc($result)) {
        $registros[] = $row;
    }
    return $registros;
}

$registros = mostrarRegistros();

// El método mysqli_fetch_assoc() devuelve un array asociativo en el valor de cada registro corresponde 
// con el nombre del cada registro. 
// Para recorrer el array se hace uso del bucle foreach que, en cada iteración devuelve un registro de la tabla
foreach ($registros as $registro) {
    echo "ID: " . $registro['id'] . ", Nombre: " . $registro['nombre'] . ", Edad: " . $registro['edad'] . "<br />";
} 
?>