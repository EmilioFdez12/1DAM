-- 1.- Crea una función Prefijo que tenga como parámetro de entrada una cadena de caracteres (CADENA) y un número de caracteres (NUM_CHAR). La función deberá devolver los primeros NUM_CHAR caracteres de CADENA en mayúsculas, seguido de un guión.
-- Prueba la función sobre el campo Categoría de la tabla Categorías.
DELIMITER //
CREATE FUNCTION Prefijo (p_cadena varchar(255), p_numchar int)
RETURNS INTEGER
DETERMINISTIC
-- Devuelve los primeros NUM_CHAR caracteres de CADENA en mayúsculas, seguido de un guión.
-- RETURNS: Máximo 10 carácteres
BEGIN
	DECLARE salida varchar(10);
    -- Controlo que p_numchar no sea mayor de 10
    IF p_numchar > 10 THEN
		SET salida = 'Max 10char';
	ELSE
		SET salida = CONCAT(UPPER(LEFT(p_cadena, p_numchar)), '-');    
	END IF;
    
RETURN salida;
END//

DELIMITER ;

select * FROM empleados
-- 2.- Crea una función Iniciales_Empleado que devuelva las iniciales en mayúsculas a partir de un id de Empleado.
-- Ejemplo: El empleado Pepe López con id=8 (Nombre "Pepe", Apellido "López") devolverá "PL".

DELIMITER //
CREATE FUNCTION Iniciales_Empleado (id_empleado int)
RETURNS varchar(2)
DETERMINISTIC
BEGIN
	DECLARE nombre_empleado varchar(50);
    DECLARE apellidos_empleado varchar(50);
    DECLARE iniciales varchar(2);
    
    SELECT nombre, apellidos INTO nombre_empleado, apellidos_empleado FROM empleados WHERE id = id_empleado;
    SET iniciales = UPPER(CONCAT(LEFT(nombre_empleado, 1), LEFT(apellidos_empleado, 1)));	
RETURN iniciales ;
END//
DELIMITER ;

SELECT Iniciales_Empleado(2);

-- 3.- Crea una función Edad_Empleado que devuelva la edad de un empleado. El parámetro de entrada será el id del empleado.
DELIMITER //
CREATE FUNCTION Edad_Empleado (id_empleado int)
RETURNS varchar(2)
DETERMINISTIC
BEGIN
	DECLARE fcha_nacimiento DATE;
    DECLARE edad int;
    
    SELECT fecha_nacimiento INTO fcha_nacimiento FROM empleados WHERE id = id_empleado;
    SET edad = TIMESTAMPDIFF(year, fcha_nacimiento, CURDATE());	
RETURN edad;
END//
DELIMITER ;Edad_Empleado

SELECT Edad_Empleado(2);

-- 4.- Crea un procedimiento Empleados_por_sexo que tenga como entrada un parámetro con dos posibles valores: "HOMBRE", "MUJER".
-- Deberá mostrar por pantalla los datos de los empleados del sexo solicitado. Así como la edad de cada empleado.

DELIMITER //
CREATE PROCEDURE Empleados_por_sexo (IN p_sexo varchar(6))
BEGIN
	-- Sr.// Dr.// Srta. // Sra.//
        IF p_sexo = 'HOMBRE' THEN
			SELECT *, Edad_Empleado(id) as Edad FROM empleados WHERE tratamiento = ('Sr.', 'Dr.');
		ELSEIF p_sexo = 'MUJER' THEN
			SELECT *, Edad_Empleado(id) as Edad FROM empleados WHERE tratamiento = ('Sra.', 'Srta.');
		ELSE 
			SELECT 'El parametro debe ser HOMBRE O MUJER';
		END IF;
END//
DELIMITER ;

DROP PROCEDURE Empleados_por_sexo;

CALL Empleados_por_sexo('lfsfs');

-- 5.- Crea un procedimiento Actualizar_Stock que tenga como entrada una descripción de Producto, un id de Categoria y una cantidad.
-- Si existe el producto, se incrementará el campo unidades_existencia (sumando el parámetro cantidad) si es mayor que cero.
-- Si no existe el producto se creará un nuevo Producto en la tabla Productos. Se le asignará la categoría del parámetro de entrada, y unidades_existencia será la cantidad.
DELIMITER $$
CREATE PROCEDURE Actualizar_Stock (IN v_descripcion varchar(40), IN v_categoria_id INT, IN v_cantidad INT)
BEGIN   
	-- Si el producto existe hago UPDATE
    IF (SELECT count(*) FROM productos WHERE producto = v_descripcion) = 1 THEN
		UPDATE productos
		SET unidades_existencia = unidades_existencia + v_cantidad
        WHERE producto = v_descripcion
        AND unidades_existencia > 0;
    ELSE
		INSERT INTO productos (producto, categoria_id, unidades_existencia) VALUES (v_descripcion, v_categoria_id, v_cantidad);
	END IF;
END$$
DELIMITER ;

DROP PROCEDURE Actualizar_Stock;
CALL Actualizar_Stock('Queso de Cabra Albanes', 3, 400);

-- 6.- Crea un campo IVA (dos decimales) no nulo por defecto cero, y un campo Notas (de tipo TEXT) en la tabla Productos.
-- Realiza un procedimiento que reciba como parámetro un IVA. Se deberá actualizar el campo IVA con el parámetro de entrada.
-- Y en el campo Notas deberá aparecer la descripción del producto, el precio_unidad, el iva y el precio_unidad con iva.
ALTER TABLE productos
DROP COLUMN IVA,
DROP COLUMN notas;

ALTER TABLE productos
ADD IVA DECIMAL(8,2) DEFAULT 0 not null,
ADD Notas TEXT;

DELIMITER $$
CREATE PROCEDURE notas_IVA (IN p_IVA decimal(8,2))
BEGIN   
	UPDATE productos
    SET IVA = p_IVA;
    
    UPDATE productos
    SET notas = CONCAT("Producto: ", producto, "  Precio Unidad: ", precio_unidad, "  IVA: ", IVA,"%",
    "  Precio Unidad con IVA: ", ROUND(precio_unidad + (precio_unidad * (IVA / 100)),2));
END$$

DELIMITER ;

DROP PROCEDURE notas_IVA;
CALL notas_IVA(21);


