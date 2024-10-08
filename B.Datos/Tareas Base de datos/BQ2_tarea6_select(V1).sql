DROP DATABASE IF EXISTS actividadExtra;
CREATE DATABASE IF NOT EXISTS actividadExtra;
USE actividadExtra;

CREATE TABLE Socios (
	CodSocio INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(30),
    Direccion VARCHAR(30),
    Localidad VARCHAR(30),
    CP INT,
    Tlfn CHAR(9),
    FechaNacimiento DATE
);

CREATE TABLE Libros (
	Signatura VARCHAR(30) PRIMARY KEY, 
    Titulo VARCHAR(30),
    Autor VARCHAR(30)
);

CREATE TABLE Ejemplares (
	Signatura VARCHAR(30),
    Ejemplar INT,
    Disponible boolean,
    Editorial VARCHAR(30),
    AñoEdicion INT,
    ContPrest INT,
    PRIMARY KEY (Signatura, Ejemplar),
    FOREIGN KEY (Signatura) REFERENCES Libros(Signatura)
);

CREATE TABLE Prestamos (
	IdPrestamo INT PRIMARY KEY AUTO_INCREMENT,
    Signatura VARCHAR(30),
    Ejemplar INT,
    CodSocio INT,
    FechaSalida DATE,
    Diaslimite INT,
    FechaEntrada DATE,
    FOREIGN KEY (Signatura, Ejemplar) REFERENCES Ejemplares(Signatura, Ejemplar),
    FOREIGN KEY (CodSocio) REFERENCES Socios(CodSocio)
);

INSERT INTO Libros (Signatura, Titulo, Autor)
VALUES
('A-001RATGAT', 'El ratón y el gato', 'James Martin'),
('B-001CAPROJ', 'Caperucita roja', 'Samuel Pérez'),
('C-001VACNEG', 'La vaca negra', 'Samuel Pérez'),
('D-001SISBD', 'Sistemas de Bases de Datos', 'C.J. Date'),
('E-001SISBD', 'Sistemas de Bases de Datos', 'Korth, Silberschatz'),
('F-001LOQVIE', 'Lo que el viento se llevó', 'Margaret Mitchell');

INSERT INTO Socios (Nombre, Direccion, Localidad, CP, Tlfn, FechaNacimiento)
VALUES
('Antonio Ramírez', 'C/ Conejito de Málaga', 'Málaga', '29004', '626275336', '2000-12-26'),
('José López', 'Avenida Velázquez', 'Málaga', '29002', '742356902', '1994-03-10'),
('Mauricio Vázquez', 'C/ Ortega y Gasset', 'Málaga', '29009', '654867123', '1992-01-12');

INSERT INTO Socios VALUES (22, 'El que ha leido todo', 'C/ figura', 'Málaga', '29009', '654811123', '1992-01-12');

INSERT INTO Ejemplares (Signatura, Ejemplar, Disponible, Editorial, AñoEdicion, ContPrest)
VALUES
('A-001RATGAT', 1, true, 'McGraw-Hill', 2004, 1),
('B-001CAPROJ', 1, true, 'McGraw-Hill', 1992, 6),
('B-001CAPROJ', 2, false, 'McGraw-Hill', 1993, 0),
('B-001CAPROJ', 3, false, 'McGraw-Hill', 1994, 2),
('C-001VACNEG', 1, true, 'Planeta Cómic', 2004, 3),
('D-001SISBD', 1, true, 'McGraw-Hill', 1992, 6),
('E-001SISBD', 1, true, 'McGraw-Hill', 1992, 6),
('E-001SISBD', 2, false, 'McGraw-Hill', 1994, 2),
('F-001LOQVIE', 1, true, 'ECC Ediciones', 2001, 9);

INSERT INTO Prestamos (Signatura, Ejemplar, CodSocio, FechaSalida, Diaslimite, FechaEntrada)
VALUES
('A-001RATGAT', 1, 22, '2021-11-29', 10, null),
('B-001CAPROJ', 1, 22, '2021-11-29', 10, '2021-11-30'),
('C-001VACNEG', 1, 22, '2021-11-29', 10, '2021-11-30'),
('D-001SISBD', 1, 22, '2021-11-29', 10, null),
('E-001SISBD', 1, 22, '2021-11-29', 10, null),
('F-001LOQVIE', 1, 22, '2021-11-29', 10, null),
('A-001RATGAT', 1, 1, NULL, 6, CURRENT_DATE()),
('B-001CAPROJ', 2, 2, '2021-11-29', 10, null),
('C-001VACNEG', 1, 1, '2021-11-28', 10, '2021-12-2'),
('F-001LOQVIE', 1, 3, '2021-11-10', 70, '2021-12-30'),
('D-001SISBD', 1, 1, '2021-11-10', 70, '2021-12-30'),
('F-001LOQVIE', 1, 2, '2021-10-10', 20, '2021-10-10');



-- 1. La signatura de los libros cuya editorial sea ‘McGraw-Hill’ 
SELECT Editorial, Signatura 
FROM Ejemplares
WHERE editorial = 'McGraw-Hill';

-- 2. Los títulos de los libros cuya editorial sea ‘McGraw-Hill’ 
SELECT Titulo, editorial 
FROM Libros
INNER JOIN ejemplares ON libros.signatura = ejemplares.signatura
WHERE editorial = 'McGraw-Hill';

-- 3. El título de los libros cuyo autor tenga como apellido ‘Date’ 
SELECT titulo, autor
FROM libros
WHERE Autor LIKE ("%Date%");

-- 4. Los títulos y editoriales de los libros cuyo autor sea ‘James Martin’ 
SELECT autor, titulo, editorial
FROM libros
INNER JOIN ejemplares ON libros.signatura = ejemplares.signatura
WHERE autor LIKE "James Martin";

-- 5. Las editoriales de todos los libros de la biblioteca, sin que aparezcan duplicados. 
SELECT DISTINCT editorial
FROM ejemplares;

-- 6. Las editoriales de todos los libros junto con el número de ejemplares que hay de cada editorial. 
SELECT editorial, count(ejemplares)
FROM ejemplares
GROUP BY editorial;

-- 7. La signatura y código de los socios de los préstamos que hayan excedido el número de días límite y aún no hayan sido devueltos.  
SELECT Signatura, CodSocio
FROM prestamos
WHERE FechaEntrada is null
AND datediff(curdate(), fechaSalida) > diaslimite;

-- 8. El título, el autor y el número de ejemplar de los ejemplares que no estén disponibles. 
SELECT titulo, autor, ejemplar 
FROM libros
INNER JOIN ejemplares ON libros.signatura = ejemplares.signatura
WHERE Disponible = false;

-- 9. El título de los libros que haya sacado alguna vez el socio 22.
SELECT titulo 
FROM libros
INNER JOIN prestamos ON prestamos.signatura = libros.signatura
WHERE prestamos.CodSocio = '22';

-- 10. El título de los libros que tenga en su poder el socio 22. 
SELECT titulo 
FROM libros
INNER JOIN Prestamos ON prestamos.Signatura = libros.Signatura
INNER JOIN Socios ON prestamos.CodSocio = socios.CodSocio
and fechaEntrada is null;

-- 11. El título de los libros que haya sacado alguna vez el socio ‘José López’. 
SELECT titulo 
FROM libros
INNER JOIN Prestamos ON prestamos.Signatura = Libros.Signatura
INNER JOIN Socios ON prestamos.CodSocio = socios.CodSocio
WHERE socios.nombre = 'José López';


-- 12. Los nombres de los socios que hayan sacado algún ejemplar del libro ‘Sistemas de Bases de Datos’ del autor ‘C.J. Date’. 
SELECT socios.nombre, prestamos.*, libros.titulo 
FROM socios
INNER JOIN Prestamos ON Socios.CodSocio = prestamos.CodSocio 
INNER JOIN Libros ON prestamos.Signatura = libros.Signatura 
WHERE libros.titulo = 'Sistemas de Bases de Datos' 
AND libros.autor = 'C.J Date';

-- 13. El nombre del socio, el teléfono y el título del libro de los préstamos que hayan excedido el número de días límite y que aún no han sido devueltos. 
-- Ordenado en primer lugar por nombre de socio y en segundo lugar por título del libro. 
SELECT Nombre, Tlfn, libros.titulo
FROM socios
INNER JOIN prestamos ON prestamos.CodSocio = prestamos.CodSocio
INNER JOIN ejemplares ON prestamos.signatura = ejemplares.signatura AND prestamos.ejemplar = ejemplares.ejemplar
INNER JOIN libros ON ejemplares.signatura = libros.signatura
WHERE FechaEntrada > Diaslimite
GROUP BY 1 , 2;


-- 14. El nombre de los socios que hayan sacado al menos un ejemplar de todos los libros. 
-- Se podría expresar como: “los nombres de los socios tales que no exista un libro que no hayan sacado”. 
SELECT Nombre
FROM socios
INNER JOIN prestamos ON socios.CodSocio = prestamos.CodSocio
INNER JOIN ejemplares ON prestamos.signatura = ejemplares.signatura AND prestamos.ejemplar = ejemplares.ejemplar
WHERE CodSocio ...;

-- 15. El título de los libros que hayan sido sacados por todos los socios. 
SELECT titulo 
FROM libros
INNER JOIN ejemplares ON libros.signatura = ejemplares.signatura
INNER JOIN prestamos ON ejemplares.signatura = prestamos.signatura and ejemplares.ejemplar = prestamos.ejemplar
INNER JOIN socios ON ejemplares.CodSocio = socios.CodSocio
WHERE eje

16. El nombre de los socios que no hayan sacado el libro con signatura ‘SIS-DAT’. 

17. Cuántos socios tiene la biblioteca. 

18. Cuál es el nombre del socio más joven de la biblioteca. 

19. El título de los dos libros más prestados junto con el acumulado de veces que se han prestado, ordenados de mayor a menor por esta cantidad. (sin distinguir entre los distintos ejemplares de un libro). 

20. El número de veces que se ha solicitado el libro de signatura ‘SIS-DAT’ sin distinguir entre sus distintos ejemplares. Utilizando el atributo ContPrestamos. 

21. La signatura, el título, junto con el número de veces que se ha solicitado cada ejemplar. Ordenado por signatura. Utilizando el atributo ContPrest (contador de préstamos). 

22. Igual que el anterior, pero que sólo se muestren aquellos libros que hayan sido sacados más de 50 veces.





