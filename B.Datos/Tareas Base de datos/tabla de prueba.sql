

CREATE TABLE  prueba (
ID_prueba int PRIMARY KEY,
nombre_prueba VARCHAR(35) NOT NULL,
fecha_nacimiento DATE NOT NULL,
region_prueba CHAR(5) NULL, 
FOREIGN KEY (region_prueba)
);
