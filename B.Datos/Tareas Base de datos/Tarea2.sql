USE Tarea2;

CREATE TABLE cliente(
CodCLiente int PRIMARY KEY,
DNI CHAR(10) NOT NULL UNIQUE,
Nombre VARCHAR(30) NOT NULL,
Direccion VARCHAR(50),
Telefono CHAR(9)
);

CREATE TABLE reserva(
Número int PRIMARY KEY AUTO_INCREMENT,
FechaInicio DATE,
FechaFin DATE,
PrecioTotal DECIMAL(16,2),
CodCliente INT, 
FOREIGN KEY (CodCLiente) references cliente(CodCliente)
);

CREATE TABLE Coche(
Matricula CHAR(8) PRIMARY KEY,
Marca VARCHAR(20) NOT NULL,
Modelo VARCHAR(20)NOT NULL,
Color VARCHAR(15),
PrecioHora DECIMAL(16,2)
);

CREATE TABLE avala(
Avalado INT PRIMARY KEY,
Avalador INT, 
FOREIGN KEY (Avalado) references cliente(CodCliente),
FOREIGN KEY (Avalador) references cliente(CodCliente)
);

CREATE TABLE incluye(
Numero int, 
Matricula CHAR(8),
litrosgas DOUBLE,
FOREIGN KEY (Numero) references Reserva(Número),
FOREIGN KEY (Matricula) references Coche(Matricula),
PRIMARY KEY (Numero,Matricula) 
);