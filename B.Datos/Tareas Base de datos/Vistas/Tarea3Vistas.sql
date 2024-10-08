-- Trabajamos en una librería (bd_libreria) que tiene las siguientes tablas:
-- Editoriales(codigo, nombre_editorial, direccion, codigo_postal, telefono, email)
-- Libros(ISBN, titulo, autor, editorial, precio, fecha_edicion)
-- Autores(codigo, nombre, apellidos, fecha_nacimiento)
DROP SCHEMA bd_libreria;
CREATE SCHEMA bd_libreria;
USE bd_libreria;

CREATE TABLE Editoriales(
codigo VARCHAR(10) PRIMARY KEY,
nombre_editorial VARCHAR(25),
direccion VARCHAR(50),
codigo_postal CHAR(5),
telefono CHAR(9),
email VARCHAR(50)
);

-- Drop table autores;
CREATE TABLE autores(
codigo VARCHAR(8) PRIMARY KEY,
nombre VARCHAR(15),
apellidos VARCHAR(45),
fecha_nacimiento DATE
);

CREATE TABLE libros(
ISBN CHAR(14) PRIMARY KEY,
titulo VARCHAR(20),
autor VARCHAR(8),
editorial VARCHAR(10),
precio DECIMAL(16,2),
fecha_edicion DATE,
	FOREIGN KEY (autor) REFERENCES autores(codigo) ON UPDATE CASCADE ON DELETE RESTRICT,
	FOREIGN KEY (editorial) REFERENCES editoriales(codigo) ON UPDATE CASCADE ON DELETE CASCADE
);

ALTER TABLE libros
MODIFY ISBN VARCHAR(14);
-- Crea las tablas correspondientes. Especificando claves foráneas y cómo tratar las eliminaciones y actualizaciones de las mismas. 
 -- (ON UPDATE | DELETE CASCADE | RESTRICT | SET NULL ...)
-- Crea cinco editoriales(Santillana, McGraw Hill, Ra-Ma, Prentice-Hall, Garceta) con códigos (E001, E002, E003, E004, E005) y tres libros de cada editorial. 
-- Utiliza el mismo autor en al menos 4 libros. 

INSERT INTO Editoriales (nombre_editorial, codigo)
VALUES
('Santillana','E001'),
('McGraw','E002'),
('Ra-Ma','E003'),
('Prentice-Hall','E004'),
('Garceta','E005');

INSERT INTO autores (codigo, nombre, apellidos)
VALUES 
('MAC1', 'Mac', 'ApellidoMac'),
('CEC', 'Cecilio', 'ApellidoCecilio'),
('RAM', 'Ramon', 'ApellidoRamon'),
('MAC', 'Mac', 'ApellidoMac'),
('BET', 'Bertin', 'ApellidoBet');

INSERT INTO libros (isbn,editorial, titulo, autor)
VALUES
-- ('1','E001', 'Lengua', 'MAC1'),
('2','E001', 'Cono', 'MAC1'),
('3','E001', 'Mates', 'MAC1'),
('4','E002', 'Las Artes Oscuras', 'MAC1'),
('5','E002', 'Mas alla', 'CEC'),
('6','E002', 'Menos alla', 'CEC'),
('7','E003', 'Las ramas', 'RAM'),
('8','E003', 'Ramas mas alla', 'RAM'),
('9','E003', 'Asi es la vida', 'RAM'),
('10','E004', 'Hall de la fama', 'BET'),
('11','E004', 'Historias Corrientes', 'BET'),
('12','E004', 'Menos alla', 'BET'),
('13','E005', 'SubAquas', 'BET'),
('14','E005', 'Viaje al exterior', 'BET'),
('15','E005', 'Vuelta en 1 dia', 'BET');

-- Actualiza las filas existentes en la tabla libros para agregar el valor de precio
UPDATE libros
SET precio = CASE 
    WHEN ISBN = '2' THEN 20.00
    WHEN ISBN = '3' THEN 24.00
    WHEN ISBN = '4' THEN 23.00
    WHEN ISBN = '5' THEN 21.00
    WHEN ISBN = '6' THEN 20.00
    WHEN ISBN = '7' THEN 10.00
    WHEN ISBN = '8' THEN 40.00
    WHEN ISBN = '9' THEN 20.50
    WHEN ISBN = '10' THEN 21.30
    WHEN ISBN = '11' THEN 33.00
    WHEN ISBN = '12' THEN 33.33
    WHEN ISBN = '13' THEN 17.10
    WHEN ISBN = '14' THEN 20.10
    WHEN ISBN = '15' THEN 29.99
    ELSE precio
END;

UPDATE libros
SET fecha_edicion = CASE 
	WHEN ISBN = '1' THEN '2005-03-01'
    WHEN ISBN = '2' THEN '2006-03-01'
    WHEN ISBN = '3' THEN '2002-03-01'
    WHEN ISBN = '4' THEN '2023-03-01'
    WHEN ISBN = '5' THEN '2015-05-01'
    WHEN ISBN = '6' THEN '2016-06-01'
    WHEN ISBN = '7' THEN '2008-08-01'
    WHEN ISBN = '8' THEN '2005-03-01'
    WHEN ISBN = '9' THEN '2005-03-02'
    WHEN ISBN = '10' THEN '2000-03-01'
    WHEN ISBN = '11' THEN '2005-03-01'
    WHEN ISBN = '12' THEN '2001-03-01'
    WHEN ISBN = '13' THEN '1999-01-10'
    WHEN ISBN = '14' THEN '2005-01-04'
    WHEN ISBN = '15' THEN '2003-07-02'
    ELSE precio
END;

-- Verifica que se han actualizado los precios en la tabla de libros
SELECT * FROM libros;

-- 3 Modifica el código de la editorial Garceta a E007. Verifica que se ha modificado en la tabla libros
UPDATE editoriales
SET codigo = 'E007'
WHERE nombre_editorial = 'Garceta';

-- 4 Inserta una nueva Editorial con código E006 y los mismos campos que la editorial E001. Sólo cambiará el nombre_editorial que será "Santillana - iberoamericana".
INSERT INTO Editoriales (nombre_editorial, codigo)
VALUES
('Santillana-iberoamericana','E006');

-- 5 Modifica todos los códigos de la tabla Editoriales, cambia "E" por "ED".
SELECT * FROM editoriales;
UPDATE editoriales
SET codigo = REPLACE (codigo,'E','ED');

-- 6 Modifica el precio de todos los libros de la editorial Garceta, incrementándolos en un 10%
UPDATE libros
SET precio = precio + (precio * 0.10)
WHERE editorial = 'ED007';

-- 7 Elige el ISBN de uno de tus libros y modifica la fecha de edición, añadiendo un año a la fecha_edicion original.
UPDATE libros
SET fecha_edicion = fecha_edicion + INTERVAL 1 YEAR
WHERE ISBN = '1';

-- 8 Elimina todos los libros de un autor.
DELETE FROM libros
WHERE autor = 'MAC1';

-- 9 Elimina a los autores que tenga un único libro.
DELETE FROM autores
WHERE codigo in (
	SELECT autor 
	FROM Libros 
	GROUP BY autor
	HAVING COUNT(isbn) = 1
);

-- 10 Verifica que se han eliminado los autores en la tabla de autores
SELECT * FROM autores;

-- 11 Crea una vista (Vista_1) con todos los campos de libros y un campo NombreCompleto donde aparezca el nombre completo del autor con el formato "Apellidos, Nombre"
CREATE VIEW Vista_1 AS
SELECT libros.*, CONCAT(autores.nombre, ' ', autores.apellidos) NombreCompleto
FROM libros INNER JOIN autores ON libros.autor = autores.codigo;

SELECT *
FROM vista_1;

--  12 Crea una vista (Vista_2) con todos los campos de libros y un campo NombreConIniciales donde aparezca el nombre completo del autor con el formato "Inicial_Nombre. Apellidos".
CREATE VIEW Vista_2 AS
SELECT libros.*,CONCAT(UPPER(LEFT(autores.nombre, 3)),'_' ,autores.nombre, '. ' , autores.apellidos)
FROM libros INNER JOIN autores ON libros.autor = autores.codigo;

SELECT *
FROM Vista_2;

-- 13 Renombra la vista Vista_1 a V_libros_nombrecompleto.
RENAME TABLE Vista_1 
TO V_libros_nombrecompleto;

-- 14 Renombra la vista Vista_2 a V_libros_nombreconiniciales.
RENAME TABLE Vista_2
TO V_libros_nombreconiniciales;

-- 15 Muestra las vistas que haya creadas en bd_libreria.
SHOW FULL TABLES
WHERE table_type = 'VIEW';

-- 16 Elimina las dos vistas anteriores.
DROP VIEW v_libros_nombrecompleto;
DROP VIEW v_libros_nombreconiniciales;

-- 17 Muestra las vistas que haya creadas en la base de datos classicmodels
SHOW FULL TABLES in classicmodels
WHERE TABLE_TYPE = 'VIEW';

 -- 16. Muestra las vistas que haya creadas en la base de datos üassicmodels
SELECT table_name view_name
FROM information_schema.tables
WHERE table_type = 'VIEW'
AND table_schema = 'classicmodels';

