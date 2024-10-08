CREATE TABLE Clientes_Historico(
idd int AUTO_INCREMENT PRIMARY KEY,
id int,
codigo varchar(5), 
empresa varchar(40),
contacto varchar(30),
cargo_contacto varchar(30),
direccion varchar(60),
ciudad varchar(15), 
region varchar(15), 
cp varchar(10), 
pais varchar(15), 
telefono varchar(24), 
fax varchar(24),
fecha_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- 1.- Cuando se modifique algún registro de la tabla Clientes, se almacenarán los datos del cliente antiguo en una tabla 
-- lientes_Historico, con los mismos campos que la tabla Clientes y un nuevo campo con la fecha de modificación del Cliente.
DELIMITER //

CREATE TRIGGER Modificacion_Clientes
AFTER UPDATE
ON clientes FOR EACH ROW
BEGIN
    INSERT INTO Clientes_Historico(id, codigo, empresa, contacto, cargo_contacto, direccion, ciudad, region, cp, pais, telefono, fax, fecha_modificacion)
    VALUES(OLD.id, OLD.codigo, OLD.empresa, OLD.contacto, OLD.cargo_contacto, OLD.direccion, OLD.ciudad, OLD.region, OLD.cp, OLD.pais, OLD.telefono, OLD.fax, CURRENT_TIMESTAMP);
END//

DELIMITER ;

INSERT INTO clientes (id, codigo, empresa, contacto, cargo_contacto, direccion, ciudad, region, cp, pais, telefono, fax) 
VALUES 
(99, 'C001', 'Empresa A', 'Juan Perez', 'Gerente de Ventas', 'Calle 123', 'Ciudad A', 'Region A', '12345', 'Pais A', '123456789', '987654321'),
(2999, 'C002', 'Empresa B', 'Maria Lopez', 'Gerente de Marketing', 'Avenida 456', 'Ciudad B', 'Region B', '54321', 'Pais B', '987654321', '123456789');

UPDATE clientes
SET telefono = '555555555'
WHERE id = 99;


-- 2.- Crear un campo Edad en la tabla Empleados.
-- Cada vez que se inserte un empleado, se deberá rellenar el campo Edad a partir del campo Fecha_nacimiento.
-- Cada vez que se actualice un empleado, se deberá revisar si el campo Fecha_nacimiento es uno de los campos que se ha modificado.
-- En ese caso, se deberá recalcular el campo Edad. 

ALTER TABLE empleados
ADD COLUMN Edad int;

DROP TRIGGER edad_empleado_trigger;

DELIMITER //

CREATE TRIGGER edad_empleado_trigger
BEFORE INSERT
ON empleados FOR EACH ROW
BEGIN
SET new.Edad = TIMESTAMPDIFF(YEAR, NEW.fecha_nacimiento, CURDATE());
END//

DELIMITER ;

INSERT INTO empleados (apellidos, nombre, cargo, tratamiento, fecha_nacimiento, fecha_contratacion, direccion, ciudad, region, cp, pais, telefono_domicilio, extension, notas, jefe_id)
VALUES ('López', 'Juan', 'Gerente de Ventas', 'Sr.', '1980-05-15', '2020-01-01', 'Calle 123', 'Ciudad A', 'Región A', '12345', 'Pais A', '123456789', '1234', 'Notas de prueba', NULL);

-- 3.- Controlar en la eliminación de Clientes que también se eliminen los registros de la tabla Clientes_Historico, para ese cliente.

DELIMITER //

CREATE TRIGGER clientes_del
BEFORE DELETE
ON clientes FOR EACH ROW
BEGIN
	DELETE FROM clientes_historico
	WHERE codigo = OLD.codigo;
END //

DELIMITER ;