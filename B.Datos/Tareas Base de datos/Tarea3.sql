CREATE SCHEMA tarea3;
USE tarea3;

CREATE TABLE Pelicula(
ID INT PRIMARY KEY,
Título VARCHAR(50),
Productora VARCHAR(25),
Nacionalidad VARCHAR(20),
Fecha DATE,
Director VARCHAR(30)
);

ALTER TABLE Pelicula
MODIFY Título VARCHAR(50) NOT NULL,
ADD FOREIGN KEY (Director) REFERENCES Director(Nombre);


CREATE TABLE Director(
Nombre VARCHAR(50) PRIMARY KEY,
Nacionalidad VARCHAR(30)
);


CREATE TABLE Ejemplar(
ID_Peli INT NOT NULL,
Numero INT NOT NULL,
Estado BIT,
	PRIMARY KEY(ID_Peli,Numero)
);

ALTER TABLE Ejemplar
ADD FOREIGN KEY(ID_Peli) REFERENCES Pelicula(ID);


CREATE TABLE Alquila(
DNI CHAR(10),
ID_Peli INT NOT NULL,
Numero INT NOT NULL,
FechaAlquiler DATE,
FechaDevolucion DATE,
	PRIMARY KEY(DNI,ID_Peli,Numero,FechaAlquiler),
    CHECK(FechaAlquiler < FechaDevolucion)
);

ALTER TABLE Alquila
ADD  FOREIGN KEY(DNI) REFERENCES Socio(DNI);

ALTER TABLE Alquila
ADD  FOREIGN KEY(ID_Peli, Numero) REFERENCES Ejemplar(ID_Peli, Numero);


CREATE TABLE Socio(
DNI CHAR(10) NOT NULL UNIQUE,
Nombre VARCHAR(50) NOT NULL,
Direccion VARCHAR(50),
Telefono CHAR(9) NOT NULL,
Avalador INT NOT NULL);

ALTER TABLE Socio
MODIFY Avalador CHAR(10) NOT NULL,
ADD FOREIGN KEY (Avalador) REFERENCES Socio(DNI);


CREATE TABLE Actua(
Actor VARCHAR(50),
ID_Peli INT,
Prota CHAR(1),
	PRIMARY KEY(Actor,ID_Peli),
    CHECK (Prota = 'S' OR 'N')
);

ALTER TABLE Actua
ADD FOREIGN KEY(ID_Peli) REFERENCES Pelicula(ID),
ADD FOREIGN KEY(Actor) REFERENCES Actores(Nombre);


CREATE TABLE Actores(
Nombre VARCHAR(50) PRIMARY KEY,
Nacionalidad VARCHAR(50),
Sexo CHAR(1),
	CHECK (Sexo = 'H' OR 'M')
);