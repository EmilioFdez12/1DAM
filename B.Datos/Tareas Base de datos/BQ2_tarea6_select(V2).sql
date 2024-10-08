-- 1. La signatura de los libros cuya editorial sea ‘McGraw-Hill’ 
SELECT Signatura 
FROM Ejemplares
WHERE editorial = 'McGraw-Hill';

-- 2. Los títulos de los libros cuya editorial sea ‘McGraw-Hill’ 
SELECT Titulo 
FROM Libros
INNER JOIN editorial ON libros.signatura = ejemplares.signatura
WHERE editorial = 'McGraw-Hill';

-- 3. El título de los libros cuyo autor tenga como apellido ‘Date’ 
SELECT titulo
FROM libros
WHERE Autor = "Date";

-- 4. Los títulos y editoriales de los libros cuyo autor sea ‘James Martin’ 
SELECT titulo, editorial
FROM libros
INNER JOIN ejemplares ON libros.signatura = ejemplares.signatura
WHERE autor = "James Martin";

-- 5. Las editoriales de todos los libros de la biblioteca, sin que aparezcan duplicados. 
SELECT DISTINCT editorial
FROM ejemplares;

-- 6. Las editoriales de todos los libros junto con el número de ejemplares que hay de cada editorial. 
SELECT editorial, SUM(ejemplares)
FROM ejemplares
GROUP BY editorial;

-- 7. La signatura y código de los socios de los préstamos que hayan excedido el número de días límite y aún no hayan sido devueltos.  
SELECT Signatura, CodSocio
FROM prestamos
WHERE FechaEntrada > Diaslimite;

-- 8. El título, el autor y el número de ejemplar de los ejemplares que no estén disponibles. 
SELECT titulo, autor, ejemplar 
FROM libros
INNER JOIN ejemplares ON libros.signatura = ejemplares.signatura
INNER JOIN prestamos ON ejemplares.signatura = prestamos.signatura and ejemplares.ejemplar = prestamos.ejemplar
INNER JOIN socios ON ejemplares.CodSocio = socios.CodSocio
WHERE FechaEntrada = null;

-- 9. El título de los libros que haya sacado alguna vez el socio 22.
SELECT titulo 
FROM libros
INNER JOIN ejemplares ON libros.signatura = ejemplares.signatura
INNER JOIN prestamos ON ejemplares.signatura = prestamos.signatura and ejemplares.ejemplar = prestamos.ejemplar
INNER JOIN socios ON ejemplares.CodSocio = socios.CodSocio
WHERE CodSocio = '22';
-- falta algo??

-- 10. El título de los libros que tenga en su poder el socio 22. 
SELECT titulo 
FROM libros
INNER JOIN ejemplares ON libros.signatura = ejemplares.signatura
INNER JOIN prestamos ON ejemplares.signatura = prestamos.signatura and ejemplares.ejemplar = prestamos.ejemplar
INNER JOIN socios ON ejemplares.CodSocio = socios.CodSocio
WHERE CodSocio = '22' and fechaEntrada > Diaslimite;

-- 11. El título de los libros que haya sacado alguna vez el socio ‘José López’. 
SELECT titulo 
FROM libros
INNER JOIN ejemplares ON libros.signatura = ejemplares.signatura
INNER JOIN prestamos ON ejemplares.signatura = prestamos.signatura and ejemplares.ejemplar = prestamos.ejemplar
INNER JOIN socios ON ejemplares.CodSocio = socios.CodSocio
WHERE socios.nombre = 'José López';


-- 12. Los nombres de los socios que hayan sacado algún ejemplar del libro ‘Sistemas de Bases de Datos’ del autor ‘C.J. Date’. 
SELECT Nombre 
FROM socios
INNER JOIN prestamos ON socios.CodSocio = prestamos.CodSocio
INNER JOIN ejemplares ON prestamos.signatura = ejemplares.signatura AND prestamos.ejemplar = ejemplares.ejemplar
INNER JOIN libros ON ejemplares.signatura = libros.signatura
WHERE libros.titulo = 'Sistemas de Bases de Datos' AND libros.autor = 'C.J Date';

-- 13. El nombre del socio, el teléfono y el título del libro de los préstamos que hayan excedido el número de días límite y que aún no han sido devueltos. 
-- Ordenado en primer lugar por nombre de socio y en segundo lugar por título del libro. 
SELECT Nombre, Tlfn, libros.titulo
FROM socios
INNER JOIN prestamos ON socios.CodSocio = prestamos.CodSocio
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
WHERE ;

-- 16. El nombre de los socios que no hayan sacado el libro con signatura ‘SIS-DAT’. 
SELECT Nombre
FROM socios
INNER JOIN prestamos ON socios.CodSocio = prestamos.CodSocio
INNER JOIN ejemplares ON prestamos.signatura = ejemplares.signatura AND prestamos.ejemplar = ejemplares.ejemplar
INNER JOIN libros ON ejemplares.signatura = libros.signatura
WHERE signatura <> 'SIS-DAT';

-- 17. Cuántos socios tiene la biblioteca. 
SELECT COUNT(CodSocio) NumeroSocios
FROM socios;

-- 18. Cuál es el nombre del socio más joven de la biblioteca. +
SELECT Nombre 
FROM socios
ORDER BY FechaNacimiento ASC
limit 1;


-- 19. El título de los dos libros más prestados junto con el acumulado de veces que se han prestado, ordenados de mayor a menor por esta cantidad. 
-- (sin distinguir entre los distintos ejemplares de un libro). 
SELECT Titulo
FROM libros
INNER JOIN ejemplares ON libros.signatura = ejemplares.signatura
ORDER BY ContPrest DESC
LIMIT 2;

-- 20. El número de veces que se ha solicitado el libro de signatura ‘SIS-DAT’ sin distinguir entre sus distintos ejemplares. Utilizando el atributo ContPrestamos. 
SELECT Count(ContPrest)
FROM ejemplares
WHERE signatura = 'SIS-DAT';


-- 21. La signatura, el título, junto con el número de veces que se ha solicitado cada ejemplar. Ordenado por signatura. Utilizando el atributo ContPrest (contador de préstamos). 
SELECT signatura, titulo , contPrestados
FROM libros
INNER JOIN ejemplares ON libros.signatura = ejemplares.signatura
ORDER BY signatura;

-- 22. Igual que el anterior, pero que sólo se muestren aquellos libros que hayan sido sacados más de 50 veces.
SELECT ejemplares.signatura, titulo , ContPrest
FROM libros
INNER JOIN ejemplares ON libros.signatura = ejemplares.signatura
WHERE contPrest > 50
ORDER BY signatura;





