-- 1 Modifica el precio de los libros de los autores que nacieron antes de 01-01-1980. El nuevo precio debe ser un 5% más barato.
SELECT * 
FROM bd_libreria.libros;

-- 2 Inserta en la tabla Autores todos los registros de la tabla Actor de la BBDD Sakila. Usa los campos first_name y last_name. Estos nuevos autores tendrán el campo fecha_nacimiento vacío. 
UPDATE libros
SET precio = precio + (precio * 0.05)
WHERE autor = (
    select autor
    from autores
    where fecha_nacimiento < '1980-01-01' );

-- 2 Inserta en la tabla Autores todos los registros de la tabla Actor de la BBDD Sakila. Usa los campos first_name y last_name. 
-- Estos nuevos autores tendrán el campo fecha_nacimiento vacío. 
INSERT INTO autores (codigo, nombre, apellidos)
SELECT actor_id, first_name, last_name
FROM Sakila.Actor;

-- 3 Realiza una vista v_autores que haga una select sobre todos los campos de la tabla Autores.
-- En la columna fecha_nacimiento deberá mostrar 'Sin fecha nacimiento' en el caso de que el valor sea null.
SELECT *
from autores;

CREATE VIEW v_autor AS
SELECT codigo, nombre, apellidos, coalesce(fecha_nacimiento, 'Sin fecha nacimiento')
from autores;

-- 4 Crea una vista v_editoriales donde se muestren todos los campos de editoriales, 
-- y un nuevo campo Ciudad que indique la Ciudad dependiendo del campo código postal. (Usa la sentencia CASE).
DROP view v_editoriales;

CREATE VIEW v_editoriales AS
SELECT *,
    CASE
        WHEN LEFT(codigo_postal, 2) = '29' THEN 'Malaga'
        WHEN LEFT(codigo_postal, 2) = '30' THEN 'Sevilla'
        WHEN LEFT(codigo_postal, 2) = '31' THEN 'Cordoba'
        WHEN LEFT(codigo_postal, 2) = '13' THEN 'Barcelona'
        WHEN LEFT(codigo_postal, 2) = '19' THEN 'Badajoz'
        WHEN LEFT(codigo_postal, 2) = '25' THEN 'Merida'
        WHEN LEFT(codigo_postal, 2) = '23' THEN 'Toledo'
    END AS Ciudad
FROM editoriales;

SELECT *
FROM v_editoriales;
    
UPDATE editoriales
SET codigo_postal = CASE 
    WHEN codigo = 'ED001' THEN 29730
    WHEN codigo = 'ED002' THEN 30730
    WHEN codigo = 'ED003' THEN 29730
    WHEN codigo = 'ED004' THEN 31730
    WHEN codigo = 'ED005' THEN 13730
    WHEN codigo = 'ED006' THEN 19730
    WHEN codigo = 'ED007' THEN 25730
    WHEN codigo = 'ED008' THEN 23730
END;


-- 5 Crea el usuario 'invitado' que tendrá todos los permisos para la BBDD librería, 
-- y los permisos de selección y modificación para la BBDD World. Realiza pruebas que confirmen que los permisos están funcionando.

--  creo los ususarios y concedo todos los permisos para la base de datos 'libreria'
CREATE USER 'invitado'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON bd_libreria TO 'invitado'@'localhost';





