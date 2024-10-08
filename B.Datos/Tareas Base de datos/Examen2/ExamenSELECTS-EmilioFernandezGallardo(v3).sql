-- 1.- Muestra todos los campos de socio y un campo llamado clave, ignorando los registros que no tengan informado Código postal.
-- El campo clave está formado por el código de provincia (que son los dos primeros dígitos del CP) seguido de un guión, seguido de la localidad, y
-- del CP completo entre paréntesis. Para los socios cuyo CP y localidad no estén vacíos.
-- Ejemplo: 29-Málaga(29004)

SELECT socios.*, concat(LEFT(CP,2), '-', localidad, '(', CP, ')') as clave
FROM socios
WHERE CP is not null
and Localidad is not null;


-- 2.- El campo contPrest, “contador de préstamos”, de cada ejemplar debería ser igual al número de registros de préstamos de cada libro / ejemplar.
-- Muestra la signatura, el título y el ejemplar de los libros que tengan el valor del campo ContPrest erróneo.
SELECT libros.Signatura, Titulo, ejemplar,ContPrest
FROM libros
INNER JOIN ejemplares ON libros.Signatura = ejemplares.signatura
WHERE ContPrest <> Ejemplar;


-- 3.- Queremos saber la media de los días de retraso de los préstamos de cada libro, así como la desviación estándar.
SELECT prestamos.Signatura,prestamos.FechaSalida, prestamos.fechaentrada, Diaslimite, datediff(fechaentrada,fechasalida)
FROM prestamos;
-- stddev()

select prestamos.*, AVG(datediff(now(), coalesce(fechaSalida,0))) as media,
datediff(now(), fechaSalida) - Diaslimite as diasRetraso,
stddev(datediff(now(), fechaSalida))
FROM prestamos
WHERE FechaEntrada IS NULL
GROUP BY 1;


-- 4.- Muestra el IdPrestamo, la FechaSalida, y el día que era de la semana (si la fechaSalida fue lunes, martes...); 
-- de todos los préstamos que se devolvieron fuera de plazo. Ordenados por FechaSalida descendente.
-- Para cada préstamo también queremos mostrar el ejemplar, el título del libro, el autor, la editorial y el año edición; 
-- así como el nombre del socio, su dirección y su código postal. Si no hay CP mostrará como valor 'Sin CP'. Y la columna se llamará 'Código Postal'
-- Y sólo me interesan los que vivan en Málaga, Sevilla o Cádiz.

SELECT IdPrestamo, FechaSalida, dayofweek(fechaSalida) dia_de_semana, libros.Titulo, 
libros.autor,ejemplares.editorial, ejemplares.AñoEdicion,socios.Nombre,socios.Direccion,coalesce(socios.cp, 'Sin CP') as 'Código Postal'
FROM prestamos
INNER JOIN libros ON prestamos.Signatura = libros.Signatura
INNER JOIN ejemplares ON prestamos.Signatura = ejemplares.Signatura
INNER JOIN socios ON prestamos.CodSocio = socios.CodSocio
WHERE FechaEntrada - FechaSalida > Diaslimite
AND socios.Localidad = 'Málaga' or 'Sevilla' or 'Cádiz'
ORDER BY FechaSalida DESC;
-- DIa 1 es lunes, 4 es jueves.
