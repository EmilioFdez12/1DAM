/*
1.- Crea un procedure modifica_horas_mensuales que incremente o decremente el precio hora y las horas trabajadas en un año y mes concreto, para un empleado concreto.
El procedure recibirá los siguientes parámetros:
p_incremento_precio_hora
p_incremento_horas_trabajadas
p_year
p_mes
p_idempleado: si es null se incrementará o decrementará el precio hora y las horas trabajadas para todos los empleados.
Si alguno de los campos (excepto p_idempleado) no está informado, el procedure no hará nada. */

SELECT * FROM horas_mensuales;


DELIMITER //

CREATE PROCEDURE modifica_horas_mensuales(
    IN p_incremento_precio_hora DECIMAL(8,2),
    IN p_incremento_horas_trabajadas INT,
    IN p_year INT,
    IN p_mes INT,
    IN p_idempleado INT
)
BEGIN
    -- Si algún campo es nulo no hacemos nada
    IF p_incremento_precio_hora IS NULL OR p_incremento_horas_trabajadas IS NULL OR p_year IS NULL OR p_mes IS NULL THEN
		  SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Rellena todos los campos obligatorios';
    END IF;

    -- Si se especifica empleado
    IF p_idempleado IS NOT NULL THEN
        UPDATE horas_mensuales
        SET precio_hora = precio_hora + p_incremento_precio_hora,
            horas_trabajadas = horas_trabajadas + p_incremento_horas_trabajadas
        WHERE año = p_year 
          AND mes = p_mes 
          AND id_empleado = p_idempleado;
    ELSE
        -- Si no hay id_empleado se les cambia a todos
        UPDATE horas_mensuales
        SET precio_hora = precio_hora + p_incremento_precio_hora,
            horas_trabajadas = horas_trabajadas + p_incremento_horas_trabajadas
        WHERE año = p_year
          AND mes = p_mes; 
    END IF;
END//

DELIMITER ;

SELECT * FROM horas_mensuales;
CALL modifica_horas_mensuales(2.5, 8, 2021, 1, 1);

/* 2.- Crea una función tipo_de_via que reciba como parámetro un VARCHAR genérico (por ejemplo el campo Direccion). 
La función buscará las palabras clave “Avda”, “Avenida”, “Calle”, “Camino”, “Plaza”. Devolverá el primer tipo de dirección que encuentre. 
Si no encuentra ninguna de estas palabras clave, devolverá “NA”.*/
DROP FUNCTION tipo_de_via;

DELIMITER //

CREATE FUNCTION tipo_de_via(c_direccion VARCHAR(100))
RETURNS VARCHAR(255)
DETERMINISTIC
BEGIN
    DECLARE resultado VARCHAR(255);

    SET resultado = CASE
        WHEN LOCATE('Avda', c_direccion) > 0 THEN 'Avda'
        WHEN LOCATE('Avenida', c_direccion) > 0 THEN 'Avenida'
        WHEN LOCATE('Calle', c_direccion) > 0 THEN 'Calle'
        WHEN LOCATE('Camino', c_direccion) > 0 THEN 'Camino'
        WHEN LOCATE('Plaza', c_direccion) > 0 THEN 'Plaza'
        ELSE 'NA'
    END;

    RETURN resultado;
END//

DELIMITER ;

SELECT tipo_de_via("Plaza Delfino") as Tipo_Via


 -- 3.- Crea una función total_pedido que calcule el precio total de un pedido. 
