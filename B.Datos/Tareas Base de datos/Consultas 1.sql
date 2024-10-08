-- 1ver la estructura de la tabla
describe city;

-- 2 ver todas las tuplas de la tabla

select * from city;

-- 3 grg 
select name, district
from city;

-- 4 Ver todad las ciudades que tienen el codigo ESP
select * from city
where CountryCode = 'ESP';

-- 5 Ver todas las ciudades y sus códigos de país, ordenados por codigos de pais

select countrycode, name 
from city
order by countrycode;





