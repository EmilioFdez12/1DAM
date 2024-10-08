-- 1.- Muestra todos los campos de socio y un campo llamado clave, ignorando los registros que no tengan informado Código postal.
-- El campo clave está formado por el código de provincia (que son los dos primeros dígitos del CP) seguido de un guión, seguido de la localidad, y
-- del CP completo entre paréntesis. Para los socios cuyo CP y localidad no estén vacíos.
-- Ejemplo: 29-Málaga(29004)

SELECT socios.*, concat(LEFT(CP,2), '-', localidad, '(', CP, ')') as clave
FROM socios;


-- 2.- El campo contPrest, “contador de préstamos”, de cada ejemplar debería ser igual al número de registros de préstamos de cada libro / ejemplar.
-- Muestra la signatura, el título y el ejemplar de los libros que tengan el valor del campo ContPrest erróneo.
SELECT Signatura, Titulo,
FROM libros
INNER JOIN eje


-- 3.- Queremos saber la media de los días de retraso de los préstamos de cada libro, así como la desviación estándar.