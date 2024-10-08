SELECT * FROM country;
SELECT * FROM city;
SELECT * FROM countrylanguage;

-- countrulanguage.language
-- 1. Enumera todos los idiomas que se hablan en USA
SELECT DISTINCT Language
FROM country
JOIN countrylanguage ON country.Code = countrylanguage.CountryCode
WHERE country.Name = 'United States';

-- 2. Obtén la superficie de cada país y el número de ciudades.
SELECT country.Name, country.SurfaceArea, COUNT(city.Name) AS Numero_Ciudades
FROM country
INNER JOIN city ON country.Code = city.CountryCode
GROUP BY country.Name, country.SurfaceArea;

-- 3. Averigua la longevidad media en todos los países que hablan español.
SELECT country.Name, AVG(country.LifeExpectancy) 
FROM country
INNER JOIN countrylanguage ON country.Code = countrylanguage.CountryCode
WHERE countrylanguage.Language = 'Spanish'
GROUP BY country.Name;


-- 4. Cuántas ciudades tenemos en España.
SELECT COUNT(District)
from city
WHERE city.CountryCode = 'ESP';

-- 5. ¿Cómo puedes averiguar el número de habitantes de cualquier país que no reside en una capital?
SELECT sum(city.Population)
FROM city INNER JOIN country ON city.CountryCode = country.Code
WHERE CountryCode = 'AFG'
and city.ID != country.Capital;

-- 6. ¿Qué países tienen por idioma oficial el inglés? --MAL
SELECT country.Name AS IdiomaIngles
FROM country
INNER JOIN countrylanguage ON country.Code = countrylanguage.CountryCode
WHERE countrylanguage.language = 'English' and IsOfficial = 'T';

-- 7. De todas las ciudades que tenemos en un España, cuáles tienen más de 10.000 habitantes?
SELECT city.name , city.Population
FROM city
WHERE CountryCode = 'ESP'and Population > 10000;

-- 8. Saca cada país con su nombre completo y el número de distritos.
SELECT country.Name, count(city.District) as NumeroDistritos
FROM country
INNER JOIN city ON country.Code = city.CountryCode
GROUP BY country.Name;

-- 9. Saca cada ciudad con el país al que corresponde, ordenado por ciudad.
SELECT city.Name as Ciudad, country.Name as Pais
FROM city 
INNER JOIN country ON city.CountryCode = country.Code
ORDER BY city.name; -- esto no se si va

-- 10. Obtén una lista con los siguientes campos: Ciudad, población, país, superficie, idioma oficial.
SELECT city.Name as Ciudad, city.Population as Poblacion , 
		country.Name as Pais, country.SurfaceArea,
        countrylanguage.Language
FROM city
INNER JOIN country ON city.CountryCode = country.Code
INNER JOIN countrylanguage on city.CountryCode = countrylanguage.CountryCode;

-- 11. Obtén una lista con los siguientes campos: Ciudad, población, país, superficie, idioma oficial. Agrupada por países.
SELECT country.Name as Pais, country.SurfaceArea,
		city.Name as Ciudad, city.Population as Poblacion , 
        countrylanguage.Language
FROM country
INNER JOIN city ON country.Code = city.CountryCode
INNER JOIN countrylanguage on city.CountryCode = countrylanguage.CountryCode
ORDER BY country.Name;

-- 12. Obtén el nombre de la capital de todos los países.
SELECT country.Name as Pais,city.Name as Capital, Capital as CodCapital
FROM city
INNER JOIN country ON city.CountryCode = country.Code
WHERE city.ID = country.Capital;

-- 13. Di el nombre de la capital del país más grande.
SELECT country.Name as Pais,city.Name as Capital, SurfaceArea
FROM city
INNER JOIN country ON city.CountryCode = country.Code
ORDER BY  SurfaceArea DESC
LIMIT 1;

-- 14. Di el nombre de la capital del país con más esperanza de vida.
SELECT country.Name as Pais,city.Name as Capital, LifeExpectancy
FROM city
INNER JOIN country ON city.CountryCode = country.Code
ORDER BY  LifeExpectancy DESC
LIMIT 1;

-- 15. Di el nombre de la capital del país con más población.
SELECT country.Name as Pais,city.Name as Capital, country.Population
FROM city
INNER JOIN country ON city.CountryCode = country.Code
ORDER BY Population DESC
LIMIT 1;

-- 16. Lista todos los países con sus capitales y la lengua oficial
SELECT country.Name as Pais,  city.Name as Capital, countrylanguage.Language, IsOfficial
FROM city
INNER JOIN country ON city.CountryCode = country.Code
INNER JOIN countrylanguage ON city.CountryCode = countrylanguage.CountryCode
WHERE IsOfficial = 'T';

-- 17. Lista todos los países con más de 1 millón de habitantes con sus capitales y la lengua oficial
-- 18. Lista todos los países con más de 1 millón de habitantes con sus capitales y sus lenguas no oficiales.
-- 19. Cuantos idiomas tiene cada país.
-- 20. ¿Tenemos algún país con dos lenguas oficiales? (hacer con having)
-- 21. Saca el jefe de gobierno de un país cuya capital es Madrid. 
