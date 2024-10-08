CREATE SCHEMA BQ2_tarea1_Select;
USE  BQ2_tarea1_Select;

CREATE TABLE empleado(
emp_no INT PRIMARY KEY,
apellido VARCHAR(30) NOT NULL,
oficio VARCHAR(20),
dir INT ,
fecha_alt DATE,
salario DECIMAL(16,2),
comision DECIMAL(16,2),
dept_no SMALLINT
);

ALTER TABLE empleado
ADD FOREIGN KEY (dept_no) REFERENCES departamento(dept_no);

CREATE TABLE departamento(
dept_no SMALLINT,
dnombre VARCHAR(30),
loc VARCHAR(50)
);

ALTER TABLE departamento
MODIFY dept_no SMALLINT PRIMARY KEY;

-- Insertar 5 registros	
INSERT INTO departamento VALUES (10,'CONTABILIDAD','SEVILLA');
INSERT INTO departamento VALUES (20,'INVESTIGACIÓN','MADRID');
INSERT INTO departamento VALUES (30,'VENTAS','BARCELONA');
INSERT INTO departamento VALUES (40,'PRODUCCIÓN','BILBAO');

INSERT INTO empleado VALUES (7369, 'SÁNCHEZ' ,'EMPLEADO',7902,'1980-12-17',104000,null,20);
INSERT INTO empleado VALUES (7499, 'ARROYO' ,'VENDEDOR',7698,'1980-02-18',208000,39000,30);
INSERT INTO empleado VALUES (7521, 'SALA' ,'DIRECTOR',7839,'1981-06-30',162500,162500,30);
INSERT INTO empleado VALUES (7566, 'JIMENEZ' ,'ANALISTA',7566,'1982-09-25',386750,null,20);
INSERT INTO empleado VALUES (7654, 'MARTÍN' ,'PRESIDENTE',7788,'1979-01-20',162500,182000,30);

-- 1. Mostrar el apellido, oficio y número de departamento de cada empleado
select apellido, oficio,dept_no FROM empleado;

-- 2. Mostrar el número, nombre y localización de cada departamento.
SELECT dept_no,dnombre, loc FROM departamento;

-- 3. Mostrar todos los datos de todos los empleados.
SELECT * FROM empleado;

-- 4. Datos de los empleados ordenados por apellidos.
SELECT * FROM empleado ORDER BY apellido;

--  5. Datos de los empleados ordenados por número de departamento descendentemente.
SELECT * FROM empleado ORDER BY dept_no DESC;

-- 6. Datos de los empleados ordenados por número de departamento descendentemente y dentro de cada departamento ordenados por apellido ascendentemente.
SELECT * FROM empleado ORDER BY dept_no, apellido DESC;

-- 8. Mostrar los datos de los empleados cuyo salario sea mayor que 2000000.
SELECT * FROM empleado where salario > 2000000;

-- 9. Mostrar los datos de los empleados cuyo oficio sea ‘ANALISTA’.
SELECT * FROM empleado where oficio = 'ANALISTA';

-- 10. Seleccionar el apellido y oficio de los empleados del departamento número 20.
SELECT apellido,oficio FROM empleado where dept_no = 20;

-- 11. Mostrar todos los datos de los empleados ordenados por apellidos
SELECT * FROM empleado ORDER BY apellido;




