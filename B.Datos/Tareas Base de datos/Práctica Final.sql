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
        WHEN LOCATE('Avda', c_direccion) THEN 'Avda'
        WHEN LOCATE('Avenida', c_direccion) THEN 'Avenida'
        WHEN LOCATE('Calle', c_direccion) THEN 'Calle'
        WHEN LOCATE('Camino', c_direccion)  THEN 'Camino'
        WHEN LOCATE('Plaza', c_direccion) THEN 'Plaza'
        ELSE 'NA'
    END;

    RETURN resultado;
END//

DELIMITER ;

SELECT tipo_de_via("Plaza Delfino") as Tipo_Via;

-- CAMBIAMOS A NEPTUNO
 -- 3.- Crea una función total_pedido que calcule el precio total de un pedido. 
USE bd_neptuno2;

SELECT * from detalles;

DROP FUNCTION total_pedido;
DELIMITER //

CREATE FUNCTION total_pedido(p_idpedido INT)
RETURNS DECIMAL(8,2)
DETERMINISTIC

BEGIN 
	DECLARE total DECIMAL(8,2);
    
    SELECT SUM(precio_unidad * cantidad * ( 1 - descuento / 100))
	INTO total
    FROM detalles
    WHERE pedido_id = p_idpedido;
    
    RETURN total;
END//

DELIMITER ;

SELECT total_pedido(10248);


/* 4.- Queremos que los datos referidos al destinatario de un pedido se rellenen de forma automática.
Para ello, cada vez que se inserte un nuevo pedido, se debe buscar, en la tabla Clientes, el domicilio (dirección, ciudad, región, código postal...) 
e incluiremos dichos datos en el registro de pedidos a insertar.
OPCIONAL: Haz que cada valor se incluya únicamente en el caso en el que no se haya especificado por el propio usuario.*/

SELECT * FROM pedidos;
SELECT * FROM clientes;

SELECT direccion_destinatario, ciudad_destinatario, region_destinatario, cp_destinatario, pais_destinatario FROM pedidos WHERE cliente_id = 90;

DELIMITER //
CREATE TRIGGER relleno_automatico_domicilio
AFTER INSERT ON pedidos FOR EACH ROW
BEGIN
    DECLARE direccion_cliente VARCHAR(255);
    DECLARE ciudad_cliente VARCHAR(255);
    DECLARE region_cliente VARCHAR(255);
    DECLARE cp_cliente VARCHAR(255);
    DECLARE pais_cliente VARCHAR(255);

    SELECT direccion, ciudad, region, codigo_postal, pais
    INTO direccion_cliente, ciudad_cliente, region_cliente, cp_cliente, pais_cliente
    FROM clientes
    WHERE cliente_id = NEW.cliente_id;

    UPDATE pedidos 
    SET direccion_destinatario = direccion_cliente,
        ciudad_destinatario = ciudad_cliente,
        region_destinatario = region_cliente,
        cp_destinatario = cp_cliente,
        pais_destinatario = pais_cliente
    WHERE id = NEW.id;

END//

DELIMITER ;


/*5.- Crear los disparadores necesarios para que, al realizar un pedido, se decremente el número de existencias en almacén de cada uno de los productos que aparecen 
relacionados con dicho pedido. Recuerda que los productos de un pedido se encuentran en la tabla Detalles.
En el caso de que no existan suficientes existencias de un producto para cubrir el pedido, la cantidad pedida de dicho producto se debe reducir, haciéndola coincidir 
con las unidades existentes en el almacén.*/
SELECT * FROM productos;
SELECT * FROM pedidos;

DELIMITER //
CREATE TRIGGER update_pedidos
AFTER INSERT ON pedidos FOR EACH ROW

UPDATE productos
SET unidades_existencia

DELIMITER ;
