create database tarea1;
use tarea1;

-- Creación de tablas
CREATE TABLE ALUMNO (
  NUMMATRICULA    int PRIMARY KEY,
  NOMBRE          VARCHAR(50),
  FECHANACIMIENTO DATE,
  TELEFONO        CHAR(9) 
);

CREATE TABLE PROFESOR (
  IDPROFESOR   int PRIMARY KEY,
  NIF_P        CHAR(9) UNIQUE,
  NOMBRE       VARCHAR(50),
  ESPECIALIDAD VARCHAR(50),
  TELEFONO     CHAR(9) 
);

CREATE TABLE ASIGNATURA (
  CODASIGNATURA  CHAR(6) PRIMARY KEY,
  NOMBRE         VARCHAR(50),
  IDPROFESOR     int,
  foreign key(IDPROFESOR) REFERENCES PROFESOR(IDPROFESOR) 
);


CREATE TABLE RECIBE (
  NUMMATRICULA  int,
  CODASIGNATURA CHAR(6),
  CURSOESCOLAR  CHAR(9),
  PRIMARY KEY (NUMMATRICULA, CODASIGNATURA, CURSOESCOLAR),
  foreign key(NUMMATRICULA) REFERENCES ALUMNO(NUMMATRICULA),
  foreign key(CODASIGNATURA) REFERENCES ASIGNATURA(CODASIGNATURA)
);

-- Inserción de datos
INSERT into profesor values
(1, '12345678H', 'Pepe', 'Informática', '666123456'),
(2, '12345678M', 'Novato', 'Informática', '666444456');

INSERT INTO asignatura values 
('LLMM', 'Lenguajes de marcas', 1),
('BBDD', 'Bases de datos', 1),
('PROG', 'Programación', 1),
('PPMM', 'Programación dispositivos móviles', 2);

INSERT INTO alumno values 
(1, 'Alumno1', '1999-01-01', '12345678'),
(2, 'Alumno2', '1999-01-01', '12345679'),
(3, 'Alumno3', '1999-01-01', '12345678'),
(4, 'Alumno4', '1999-01-01', '12345678'),
(5, 'Alumno5', '1999-01-01', '12345678'),
(6, 'Alumno5', '2000-01-01', '12145678'),
(7, 'Alumno7', '2000-01-01', '12225678'),
(8, 'Alumno8', '2000-01-01', '62345678'),
(9, 'Alumno9', '2000-01-01', '92345678'),
(10, 'Alumno10', '2000-01-01', '82345678');

INSERT INTO recibe values 
(1, 'LLMM', '1dam'),
(1, 'PROG', '1dam'),
(1, 'BBDD', '1dam'),
(1, 'PPMM', '2dam'),
(2, 'LLMM', '1dam'),
(2, 'BBDD', '1dam'),
(3, 'LLMM', '1dam'),
(3, 'BBDD', '1dam'),
(4, 'LLMM', '1dam'),
(4, 'BBDD', '1dam'),
(5, 'LLMM', '1dam'),
(5, 'BBDD', '1dam'),
(6, 'LLMM', '1dam'),
(6, 'BBDD', '1dam'),
(7, 'LLMM', '1dam'),
(7, 'BBDD', '1dam'),
(8, 'LLMM', '1dam'),
(8, 'BBDD', '1dam'),
(9, 'LLMM', '1dam'),
(9, 'BBDD', '1dam'),
(10, 'LLMM', '1dam'),
(10, 'BBDD', '1dam');

-- 1 Introduce tres alumnos para los cuales no conocemos el número de teléfono.
INSERT INTO alumno values 
(11, 'Alumno11', '2000-01-01', null),
(12, 'Alumno12', '2000-01-01', null),
(13, 'Alumno13', '2000-01-01', null);

-- 2 Modifica los datos de los tres alumnos anteriores para establecer un número de teléfono para cada uno.
UPDATE alumno
SET telefono = '952222222'
WHERE nummatricula = 11;

UPDATE alumno
SET telefono = '953333333'
WHERE nummatricula = 12;

UPDATE alumno
SET telefono = '953333333'
WHERE nummatricula = 13;

-- 3 Para todos los alumnos, poner 2000 como año de nacimiento.
UPDATE alumno
SET fechanacimiento = concat('2000-', month(fechanacimiento), '-', day(fechanacimiento));

-- 4 Para los profesores que tienen número de teléfono y NIF no comience por 9, poner “Informática” como especialidad.
UPDATE profesor
SET especialidad = 'Informatica'
WHERE telefono <> '9%' and nif_p <> '9%';

-- 5 Cambia la asignación de asignaturas para los profesores. Es decir, las asignaturas impartidas por un profesor las dará el otro profesor y viceversa.
ALTER TABLE asignatura
ADD COLUMN idprofesor_aux CHAR(6);

UPDATE asignatura
SET idprofesor_aux = idprofesor;

UPDATE asignatura
SET idprofesor = 1
WHERE idprofesor = 2;

UPDATE asignatura
SET idprofesor = 2
WHERE idprofesor_aux = 1;

-- 5 En la tabla Recibe borra todos los registros que pertenecen a una de las asignaturas.
DELETE FROM recibe
WHERE CODASIGNATURA = 'BBDD';

-- 6 En la tabla Asignatura borra dicha asignatura.
DELETE FROM asignatura
WHERE CODASIGNATURA = 'BBDD';

-- 7 Borra el resto de asignaturas. ¿Qué sucede? ¿Cómo lo solucionarías?
DELETE FROM asignatura
WHERE CODASIGNATURA = 'LLMM' and 'PPMM' and 'PROG';
-- No deja, en la foreging key correspondiente haber puesto un cascade

-- 8 Borra todos los profesores. ¿Qué sucede? ¿Cómo lo solucionarías?
DELETE FROM profesor
WHERE IDPROFESOR = 1 and 2;
-- No me deja ya que la foreign key no esta preparada para eso
alter table asignatura drop constraint asignatura_ibfk_1;
-- borramos las foreing key y añadimos otra con delete cascade
alter table asignatura 
add constraint asignatura_ibfk_1 
foreign key(IDPROFESOR) REFERENCES PROFESOR(IDPROFESOR) on delete set null on update cascade;

-- Borra todos los alumnos. ¿Qué sucede? ¿Cómo lo solucionarías?
DELETE FROM alumno
WHERE NUMMATRICULA BETWEEN 1 and 13;

alter table recibe drop constraint recibe_ibfk_1;

ALTER TABLE recibe 
add constraint recibe_ibfk_1
FOREIGN KEY (NUMMATRICULA) REFERENCES profesor(IDPROFESOR) ON DELETE CASCADE;
