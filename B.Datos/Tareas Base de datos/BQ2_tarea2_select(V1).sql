-- 1. Ver estructura de la tabla
DESCRIBE city;

-- 2. Ver todas las tuplas de la tabla
SELECT * FROM city;

-- 3. Ver todos los nombres y distritos de las ciudades
SELECT Name,district FROM city;
-- 4. Ver todas las ciudades que tienen el código ESP
SELECT * FROM city WHERE CountryCode = 'ESP';

-- 5. Ver todas las ciudades y sus códigos de pais, ordenados por código de país
SELECT name,CountryCode FROM city ORDER BY CountryCode;

-- 6. Ver cuántas ciudades tiene cada país
SELECT CountryCode, count(CountryCode) from city GROUP BY CountryCode;

-- 7. Sacar la población menor
SELECT  MIN(Population) FROM city ;

-- 8. Sacar el nombre de la ciudad con más habitantes
SELECT name,max(Population) FROM city GROUP BY Name; -- no es asi////(////////////////

-- 9. Averigua la suma de todas los habitantes
SELECT sum(Population) FROM city;

-- 10. Saca la suma de habitantes agrupadas por países
SELECT CountryCode ,SUM(Population) from city GROUP BY CountryCode;

-- 11. Saca los distintos códigos de país
SELECT DISTINCT CountryCode FROM city;

-- 12. Cuenta los distintos códigos de país
SELECT DISTINCT CountryCode, count(CountryCode) FROM city GROUP BY CountryCode;

-- 13. Saca las ciudades del país usa, que su población sea mayor de 10000
SELECT name,Population FROM city where CountryCode = "USA" and Population > 10000;

-- 14. Cuenta todos los códigos de países
SELECT CountryCode, count(CountryCode) FROM city GROUP BY CountryCode;

-- 15. Suma todas las poblaciones distintas
SELECT SUM(DISTINCT Population) FROM city;

-- 16. Saca el nombre de la ciudad con menos habitantes
SELECT min(Population) FROM city;

-- 17. Saca la media de habitantes
SELECT AVG(Population) FROM city;

-- 18. Saca la ciudad que tenga exactamente la media de habitantes
SELECT name FROM city where Population = (SELECT AVG(Population) FROM city) ; -- ni idea

-- 19. Saca todas las provincias (Distritos) de España
SELECT name FROM city WHERE CountryCode = 'ESP' ORDER BY Name ;

-- 20. Saca sólo las provincias distintas de España
SELECT DISTINCT name FROM city WHERE CountryCode = 'ESP' ORDER BY Name ;

-- 21. Saca el número de ciudades por provincia
SELECT COUNT(Name), District FROM city GROUP BY District;

-- 22. Saca todas las ciudades de Extremadura.
SELECT Name, District FROM city where District = 'Extremadura';

-- 23. Saca la cuenta de las ciudades agrupadas por provincias y por países.
SELECT COUNT(ID),CountryCode,District FROM city GROUP BY CountryCode,District;

-- 24. Saca la suma de la población de todos los distritos de España
SELECT SUM(Population) FROM city WHERE CountryCode = 'ESP'; 

-- 25. Cual es el distrito español con más habitantes.
SELECT District 
FROM city 
WHERE CountryCode = 'ESP'
AND Population = (SELECT max(Population) FROM city WHERE CountryCode = 'ESP');


-- Consultas sobre la tabla Country
DESCRIBE country;
SELECT * FROM country ;

-- 1. ¿Cuál es la esperanza de vida máxima?
SELECT MAX(LifeExpectancy) FROM country;

-- 2. Saca la lista de las capitales de todos los paises
SELECT Name, Capital FROM country ORDER BY Name;

-- 3. Saca la lista de las capitales europeas
SELECT Name, Capital FROM country  WHERE Continent = 'Europe' ORDER BY Name;

-- 4. Saca las lista de las capitales africanas y norteamericanas
SELECT Name, Capital FROM country WHERE Continent = 'North America'
UNION
SELECT Name, Capital FROM country WHERE Continent = 'Africa' ORDER BY Name;


-- 5. Halla la población media
-- 6. Saca los países con mayor y menor esperanza de vida
-- 7. Saca una lista de continentes ordenadas por la esperanza de vida media de forma descendente.
-- 8. Cuál es la mayor esperanza de vida (Dos formas de hacerlo, con una variable y de una forma nueva, usar una select como tabla)
-- 9. Sacar el país con mayor extensión de terreno
-- 10. Cuántas regiones distintas tenemos
-- 11. Saca el nombre local de todos los países
-- 12. Saca el nombre local de todos los países Europeos y asiáticos
-- 13. Saca las distintas formas de gobierno.
-- 14. ¿Qué forma de gobierno tienen, España, Francia, China? Saca los países ordenados por forma de gobierno.
-- 15. Saca todos los países islámicos.
-- 16. Saca el país que antes se independizó.
-- 17. Cuál es el país con menor extensión.
-- 18. Cuál es el país con mayor población.

