-- 1. Obtener los nombres de los Residentes que no tengan la enfermedad ‘Hipertensión’.
SELECT DISTINCT nombre 
FROM residentes
INNER JOIN residentescronicos ON residentes.NSS = residentes.NSS
INNER JOIN enfermedades ON residentescronicos.IdEnfermedad = enfermedades.IdEnfermedad
WHERE residentes.NSS NOT IN (
	SELECT NSS 
    FROM residentescronicos 
    WHERE enfermedad = 'Hipertensión'
);

-- 2. Obtener el nombre de cada Residente junto con el número de enfermedades crónicas que padece, 
-- teniendo en cuenta que pueden existir Residentes que no padezcan ninguna enfermedad crónica que
-- también deberán aparecer. Mostrar la información ordenada por número de enfermedades que padece de forma descendente.
SELECT residentes.nombre, count(residentescronicos.NSS) as NºEnfermedades
FROM residentescronicos
INNER JOIN residentes ON residentescronicos.NSS  = residentes.NSS
GROUP BY nombre;

-- 3. Modificar las observaciones de los Residentes crónicos que padecen la enfermedad ‘Hipertensión’. 
-- El nuevo valor de Observaciones será la fecha detección concatenado con la palabra 'Revisar enfermedad'.
UPDATE residentescronicos
INNER JOIN enfermedades ON residentescronicos.IdEnfermedad = enfermedades.IdEnfermedad
SET observaciones = CONCAT(fechadeteccion, '- Revisar Enfermedad')
WHERE enfermedad = 'Hipertensión';

-- 4. Mostrar el residente de mayor edad junto con su edad.
SELECT nombre, timestampdiff(year,fechanacimiento, curdate()) as Edad
FROM residentes
ORDER BY Edad DESC
Limit 1;

-- 5. Mostrar los Residentes que padezcan todas las enfermedades crónicas catalogadas en la tabla de Enfermedades.
SELECT residentes.*
FROM residentes
INNER JOIN residentescronicos ON residentes.NSS = residentescronicos.NSS
WHERE IdEnfermedad IN (1,2,3)
GROUP BY residentescronicos.NSS
HAVING COUNT(residentescronicos.NSS) = 3;

-- 6. Mostrar los nombres de los Residentes que sólo tengan una única persona de contacto.
SELECT residentes.nombre
FROM residentes
INNER JOIN contactos ON residentes.NSS = contactos.NSSResidente
GROUP BY residentes.nombre
HAVING COUNT(NSSResidente) = 1;

-- 7. Volcar a una tabla ya existente denominada Cronicos(Nombre, Enfermedad) el nombre de cada Residente con las enfermedades que padece.
CREATE TABLE cronicos(
Nombre varchar(30) ,
Enfermedad varchar(20)
);

INSERT INTO cronicos
SELECT residentes.nombre, enfermedades.enfermedad
FROM residentes
INNER JOIN residentescronicos ON residentes.NSS = residentescronicos.NSS
INNER JOIN enfermedades ON residentescronicos.IdEnfermedad = enfermedades.IdEnfermedad;

SELECT * FROM cronicos;

-- 8. Mostrar el nombre de cada Enfermedad con la cantidad de Residentes que la padecen.
SELECT enfermedad, COUNT(residentescronicos.NSS) as NºEnfermos
FROM enfermedades
INNER JOIN residentescronicos ON enfermedades.IdEnfermedad = residentescronicos.IdEnfermedad
GROUP BY enfermedad;

-- 9. Suponiendo que, en todas las relaciones, se ha exigido integridad referencial on delete restrict. 
-- Qué sentencias SQL ejecutarías para borrar el residente ‘Juan Ortega’.
DELETE FROM residentes
WHERE nombre = 'Juan Ortega';

-- 10. Crea un rol residencia con los siguientes permisos:
-- Acceso a todas las tablas y vistas, con permisos de lectura. 
-- Permiso de inserción y modificación de registros para la tabla Residentes.
-- Asigna el rol a un usuario prueba con contraseña '1234'.
-- Elimina el rol.
-- Elimina el usuario.
CREATE ROLE rl_residencia;

GRANT SELECT ON residencia.* TO rl_residencia; 
GRANT INSERT, UPDATE ON residencia.residentes TO rl_residencia;


CREATE USER 'antonio'@'localhost' IDENTIFIED BY '1234';
GRANT 'antonio'@'localhost' TO rl_residencia;

GRANT SELECT ON residencia.* TO 'antonio'@'localhost';

DROP ROLE rl_residencia;
DROP USER 'antonio@localhost';

SHOW GRANTS FOR 'antonio'@'localhost';

use mysql;
select user from user;
residentes