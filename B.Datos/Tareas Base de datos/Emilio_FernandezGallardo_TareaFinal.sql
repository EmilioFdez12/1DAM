CREATE SCHEMA Tarea_Final;
USE Tarea_Final;

CREATE TABLE Partidos(
siglas VARCHAR(4) PRIMARY KEY,
denominacion VARCHAR(40),
fecha_creacion DATE,
num_afiliados INT
);

INSERT INTO Partidos
VALUES
('PP','Partido Popular','1989-01-20',50000),
('PSOE','Partido Socialista Obrero Español','1979-05-02',65000),
('VOX','Vox España','2013-12-17',15000),
('UP','Unidas Podemos','2016-05-12',18500),
('CS','Ciudadanos ','2016-07-09',2400);

CREATE TABLE Politicos(
id INT AUTO_INCREMENT PRIMARY KEY,
apellidos VARCHAR(50) NOT NULL,
nombre VARCHAR(50) NOT NULL,
partido VARCHAR(4),
cargo VARCHAR(30),
	FOREIGN KEY (partido) REFERENCES partidos(siglas) 
);

INSERT INTO Politicos (apellidos,nombre,partido,cargo)
VALUES 
('Nuñez Feijóo','Alberto','PP','Presidente'),
('Diaz Ayuso','Isabel','PP','Presidenta de Madrid'),
('Sánchez','Pedro','PSOE','Presidente del Gobierno'),
('Montero Cuadrado','María Jesús','PSOE','Vicesecretaria General'),
('Montero', 'Irene', 'UP', 'Vicepresidenta del gobierno'),
('Echenique','Pablo','UP','Diputado Parlamento Europeo'),
('Rivera','Albert','CS','Diputado Parlamento Cataluña'),
('123','Maquinista','VOX', null),
('Abascal','Santiago','VOX', 'Presidente VOX');

DROP TABLE encuestas;

CREATE TABLE Encuestas(
id_encuestado INT AUTO_INCREMENT PRIMARY KEY,
edad INT NOT NULL, 
ciudad VARCHAR(30) NOT NULL, 
partido_a_votar VARCHAR(4) NOT NULL, 
programa_leido tinyINT(1) NOT NULL,
partido_votado_antes VARCHAR(4), 
fecha_encuesta DATE NOT NULL,
	FOREIGN KEY (partido_a_votar) REFERENCES partidos(siglas)
);

INSERT INTO Encuestas (edad, ciudad, partido_a_votar, programa_leido, partido_votado_antes, fecha_encuesta) VALUES
(17, 'Sevilla', 'PP', true, 'PP', '2019-04-10'),
(17, 'Sevilla', 'PP', true, 'PP', '2019-04-10'),
(17, 'Sevilla', 'PP', true, 'PP', '2019-04-10'),
(20, 'Sevilla', 'PP', true, 'PP', '2019-04-10'),
(20, 'Sevilla', 'PSOE', true, 'PSOE', '2019-04-10'),
(20, 'Sevilla', 'PSOE', true, 'PSOE', '2019-04-10'),
(20, 'Sevilla', 'PP', true, 'PP', '2019-04-10'),
(20, 'Sevilla', 'PP', true, 'PP', '2019-04-10'),
(20, 'Sevilla', 'CS', true, 'CS', '2019-04-10'),
(20, 'Sevilla', 'CS', true, 'CS', '2019-04-10'),
(20, 'Sevilla', 'PP', true, 'PP', '2019-04-20'),
(20, 'Sevilla', 'CS', true, 'CS', '2019-04-20'),
(20, 'Sevilla', 'CS', true, 'CS', '2019-04-20'),
(20, 'Sevilla', 'CS', true, 'PP', '2019-04-20'),
(20, 'Sevilla', 'PSOE', true, 'PSOE', '2019-04-20'),
(20, 'Sevilla', 'PP', true, 'PP', '2019-04-20'),
(20, 'Sevilla', 'PP', true, 'UP', '2019-04-20'),
(20, 'Sevilla', 'PSOE', true, 'PSOE', '2019-04-20'),
(20, 'Sevilla', 'PSOE', true, 'PSOE', '2019-04-20'),
(20, 'Sevilla', 'PSOE', true, 'PSOE', '2019-04-20'),
(20, 'Sevilla', 'PSOE', true, 'PSOE', '2019-04-20'),
(20, 'Malaga', 'PSOE', true, 'PSOE', '2019-04-20'),
(20, 'Sevilla', 'PSOE', true, 'PSOE', '2019-04-20'),
(20, 'Sevilla', 'PSOE', true, 'PSOE', '2019-04-20'),
(20, 'Malaga', 'PP', true, 'PP', '2019-04-20'),
(20, 'Sevilla', 'UP', true, 'UP', '2019-04-20'),
(20, 'Sevilla', 'PP', true, 'VOX', '2019-04-20'),
(20, 'Sevilla', 'PP', true, 'VOX', '2019-04-20'),
(20, 'Malaga', 'CS', true, 'PP', '2019-04-20'),
(20, 'Sevilla', 'PSOE', true, 'PSOE', '2019-04-20'),
(20, 'Sevilla', 'UP', true, 'UP', '2019-04-20'),
(20, 'Malaga', 'PP', true, 'PP', '2019-04-20'),
(20, 'Sevilla', 'VOX', true, 'VOX', '2019-04-20'),
(20, 'Sevilla', 'VOX', true, 'VOX', '2019-04-20'),
(20, 'Sevilla', 'PP', true, 'PP', '2019-04-20'),
(20, 'Sevilla', 'VOX', true, 'VOX', '2019-04-20'),
(20, 'Malaga', 'PP', true, 'PP', '2019-04-20'),
(20, 'Sevilla', 'PP', true, 'PP', '2019-04-20'),
(20, 'Malaga', 'PP', true, 'PP', '2019-04-20'),
(20, 'Sevilla', 'PP', true, 'PP', '2019-04-20');

-- 5. Crea la vista v_resultados, donde aparezca el total de votos estimados por partido.
CREATE VIEW v_resultados AS
SELECT partidos.siglas, COUNT(partido_a_votar) suma
FROM encuestas
INNER JOIN partidos ON encuestas.partido_a_votar = partidos.siglas
GROUP BY 1;

-- 6 Elimina los registros de la tabla encuestas cuando la fecha de la encuesta esté entre el 1 y el 15 de abril de 2019, y la edad del encuestado sea menor de 18.
DELETE FROM encuestas
WHERE fecha_encuesta BETWEEN '2019-04-01' AND '2019-04-15'
AND edad < 18; 

-- 7 Incrementa en un 10% los afiliados del partido que tenga una estimación de voto mayor. Usando la vista v_resultados.
SELECT *
FROM v_resultados;


UPDATE partidos
SET num_afiliados = num_afiliados + (num_afiliados * 0.1)
WHERE siglas = (SELECT siglas
                FROM v_resultados
                GROUP BY siglas
                ORDER BY suma DESC
                LIMIT 1);
            
-- 8 Crea los siguientes usuarios. Y realiza las pruebas que corroboran que los permisos son correctos.
-- Usuario 'simple'@'localhost' que únicamente podrá insertar y consultar la tabla Encuestas.
-- Usuario 'gestor'@'localhost' que podrá crear y modificar tablas, así como consultar, añadir y modificar registros de todas las tablas de la BBDD "Tarea_final", excepto de la tabla
-- Partidos, que sólo podrá consultar y modificar registros.
-- Muestra los permisos del usuario 'gestor'.
-- Elimina el permiso de consulta para el usuario 'simple'@'localhost'

CREATE USER 'simple'@'localhost' IDENTIFIED BY '1234';
GRANT SELECT, INSERT ON tarea_final.encuestas TO 'simple'@'localhost';
SHOW GRANTS FOR 'simple'@'localhost';

CREATE USER 'gestor'@'localhost' IDENTIFIED BY '1234';
GRANT CREATE, ALTER, SELECT, INSERT ON tarea_final.* TO 'gestor'@'localhost';
GRANT SELECT,ALTER ON tarea_final.partidos TO 'gestor'@'localhost';
SHOW GRANTS FOR 'gestor'@'localhost';

REVOKE SELECT ON tarea_final.encuestas FROM 'simple'@'localhost';	

-- 9  Crea una tabla Ciudades(id_ciudad, nombre_ciudad, prefijo_ccaa, ccaa, poblacion).
CREATE TABLE ciudades(
id_ciudad INT AUTO_INCREMENT PRIMARY KEY, 
nombre_ciudad VARCHAR(50), 
prefijo_ccaa CHAR(3), 
ccaa VARCHAR(50), 
poblacion INT
);

ALTER TABLE encuestas
ADD FOREIGN KEY (ciudad) REFERENCES ciudades(id_ciudad);

INSERT INTO ciudades (nombre_ciudad, prefijo_ccaa, ccaa, poblacion)
SELECT name, UPPER(LEFT(district, 3)), District, Population
FROM world.city
WHERE CountryCode = 'ESP';

-- 10 Modifica los valores del campo Ciudad, de la tabla Encuestas.
-- El valor que debe aparecer es el id_ciudad de la tabla Ciudades, para cada campo Encuestas.Ciudad.



