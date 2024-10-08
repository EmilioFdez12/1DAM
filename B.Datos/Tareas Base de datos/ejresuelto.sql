USE ejresuelto,

CREATE TABLE region(
CodRegion int Primary Key,
Nombre varchar(25) not null,
);

CREATE TABLE provincia(
CodProvincia int Primary Key,
Nombre varchar(25) not null,
CodRegion int,
Foreign Key (CodRegion) references region(CodRegion)
);

CREATE TABLE localidad(
CodLocalidad int Primary Key,
Nombre varchar(25) not null,
CodProvincia int,
Foreign Key (CodProvincia) references provincia(CodProvincia)
);

CREATE TABLE empleado(
ID int Primary Key,
DNI char(10) not null unique,
Nombre varchar(25) not null,
FechaNacimiento date,
Telefono char(9) not null,
Salario decimal(16,2),
CodLocalidad int,
Foreign Key (CodLocalidad) references Localidad(CodLocalidad)
);






