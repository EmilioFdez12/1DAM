CREATE SCHEMA Tarea1;
USE Tarea1;

CREATE TABLE cliente(
NIF CHAR(10),
Nombre VARCHAR(50), 
Direccion VARCHAR(70),
Telefono  CHAR(9)
);

ALTER TABLE cliente
MODIFY NIF CHAR(10) Primary Key,
MODIFY Nombre varCHAR(50) NOT NULL;

CREATE TABLE ModeloDormitorio(
Cod CHAR(10) Primary Key
);

CREATE TABLE Montador(
NIF CHAR(10) Primary Key,
Nombre VARCHAR(50) NOT NULL,
Direccion VARCHAR(70),
Telefono CHAR(9)
);

CREATE TABLE compra(
NIF_C CHAR(10),
Modelo CHAR(15),
FechaCompra DATE,
PRIMARY KEY(NIF_C,Modelo,FechaCompra)
);

CREATE TABLE monta(
Modelo CHAR(15),
NIF_M CHAR(10),
FechaMontaje DATE,
PRIMARY KEY(NIF_M,Modelo,FechaMontaje)
);

ALTER TABLE compra
ADD FOREIGN KEY (NIF_C) references cliente(Nif),
ADD FOREIGN KEY (Modelo) references ModeloDormitorio(Cod);


ALTER TABLE monta
ADD FOREIGN KEY (Modelo) references ModeloDormitorio(Cod),
ADD FOREIGN KEY (NIF_M) references Montador(NIF);

ALTER TABLE cliente 	 
ADD COLUMN edad TINYINT CHECK(edad > 18 and edad < 99),
MODIFY Direccion VARCHAR(150);

CREATE INDEX index_cliente on cliente(Nombre);

ALTER TABLE compra
DROP foreign key compra_ibfk_3,
DROP foreign key compra_ibfk_4