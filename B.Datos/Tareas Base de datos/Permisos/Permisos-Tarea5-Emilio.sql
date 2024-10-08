-- Vamos a crear los siguientes usuarios:
-- adminbd
-- aperez_ventas
-- lmartin_ventas
-- p_cuevas_ventas
-- arodriguez_administracion
-- El primero deberá tener los mismos permisos que root.
-- Los que tienen el sufijo "ventas" accederán con el rol dpto_ventas.
-- Los que tienen el sufijo "administracion" accederán con el rol dpto_administracion.
use mysql;
CREATE USER  'adminbd'@'localhost' IDENTIFIED BY '1234';

-- Borro los usuarios porque me he equivocado 
DROP USER 'adminbd'@'hostname';
DROP USER 'aperez_ventas'@'hostname';
DROP USER 'lmartin_ventas'@'hostname';
DROP USER 'p_cuevas_administracion'@'hostname';
DROP USER 'arodriguez_administracion'@'hostname';

GRANT ALL PRIVILEGES ON *.* TO 'adminbd'@'localhost';
FLUSH PRIVILEGES;

CREATE USER  'aperez_ventas'@'localhost' IDENTIFIED BY '1234';
CREATE USER  'lmartin_ventas'@'localhost' IDENTIFIED BY '1234';
CREATE USER  'p_cuevas_administracion'@'localhost' IDENTIFIED BY '1234';
CREATE USER  'arodriguez_administracion'@'localhost' IDENTIFIED BY '1234';

CREATE ROLE
	dpto_ventas,
    dpto_administracion;
    
-- Departamento de ventas. Únicamente accederán a la base de datos neptuno con las siguientes restricciones:
-- Podrán acceder a todas las tablas con permisos de lectura. 
-- Podrán insertar y modificar registros de las tablas clientes, envios y pedidos.
-- Podrán eliminar registros de la tabla envíos, detalles y pedidos.
-- Muestra permisos para el usuario aperez_ventas.

GRANT SELECT ON bd_neptuno2.* TO dpto_ventas;
GRANT INSERT, UPDATE ON bd_neptuno2.clientes TO dpto_ventas;
GRANT INSERT, UPDATE ON bd_neptuno2.envios TO dpto_ventas;
GRANT INSERT, UPDATE ON bd_neptuno2.pedidos TO dpto_ventas;
GRANT DELETE ON bd_neptuno2.envios TO dpto_ventas;
GRANT DELETE ON bd_neptuno2.detalles TO dpto_ventas;
GRANT DELETE ON bd_neptuno2.pedidos TO dpto_ventas;
FLUSH PRIVILEGES;

SHOW GRANTS FOR 'adminbd'@'localhost';

-- Asigno los roles a sus correspondientes usuarios
GRANT dpto_ventas
TO 'aperez_ventas'@'localhost';
GRANT dpto_ventas
TO 'lmartin_ventas'@'localhost';

SHOW GRANTS FOR 'aperez_ventas'@'localhost';

-- Departamento de administración. Accederán a la base de datos neptuno con las siguientes restricciones:
-- Tendrán todos los permisos para las tablas categorias, productos, empleados y clientes.
-- Para todas las demás únicamente podrán visualizar los registros.
GRANT SELECT ON bd_neptuno2.* to dpto_administracion;
GRANT ALL PRIVILEGES ON bd_neptuno2.categorias to dpto_administracion;
GRANT ALL PRIVILEGES ON bd_neptuno2.productos to dpto_administracion;
GRANT ALL PRIVILEGES ON bd_neptuno2.empleados to dpto_administracion;
GRANT ALL PRIVILEGES ON bd_neptuno2.clientes to dpto_administracion;

GRANT dpto_administracion
TO 'p_cuevas_administracion'@'localhost';
GRANT dpto_administracion
TO 'arodriguez_administracion'@'localhost';


-- Muestra todos los usuarios del sistema.
select user from user;
-- El usuario  arodriguez_administracion también accederá a la base de datos sakila pero sólo para realizar consultas sobre las tablas 
-- customer, category, inventory, payment, rental, staff, store, address.
GRANT SELECT ON sakila.customer TO 'arodriguez_administracion'@'localhost';
GRANT SELECT ON sakila.inventory TO 'arodriguez_administracion'@'localhost';
GRANT SELECT ON sakila.payment TO 'arodriguez_administracion'@'localhost';
GRANT SELECT ON sakila.rental TO 'arodriguez_administracion'@'localhost';
GRANT SELECT ON sakila.staff TO 'arodriguez_administracion'@'localhost';
GRANT SELECT ON sakila.store TO 'arodriguez_administracion'@'localhost';
GRANT SELECT ON sakila.address TO 'arodriguez_administracion'@'localhost';
-- Borra los permisos, me he equivocado
REVOKE SELECT ON sakila.* FROM 'arodriguez_administracion'@'localhost';

-- Modificar la contraseña de arodriguez_administracion 
USE mysql;

SET PASSWORD FOR 'arodriguez_administracion'@'localhost' = 'cambioContraseña';

FLUSH PRIVILEGES;

-- Modifica el usuario aperez_ventas por pperez_ventas.
RENAME USER 'aperez_ventas'@'localhost'
TO 'pperez_ventas'@'localhost';

-- Elimina el permiso de arodriguez_administracion sobre la base de datos sakila.
SHOW GRANTS FOR 'arodriguez_administracion'@'localhost';

REVOKE SELECT ON sakila.address FROM 'arodriguez_administracion'@'localhost';
REVOKE SELECT ON sakila.customer FROM 'arodriguez_administracion'@'localhost';
REVOKE SELECT ON sakila.inventory FROM 'arodriguez_administracion'@'localhost';
REVOKE SELECT ON sakila.payment FROM 'arodriguez_administracion'@'localhost';
REVOKE SELECT ON sakila.staff FROM 'arodriguez_administracion'@'localhost';
REVOKE SELECT ON sakila.store FROM 'arodriguez_administracion'@'localhost';
REVOKE SELECT ON sakila.rental FROM 'arodriguez_administracion'@'localhost';

SHOW GRANTS FOR 'arodriguez_administracion'@'localhost';
-- Elimina el permiso de eliminación del rol de ventas.
REVOKE DELETE ON bd_neptuno2.* FROM dpto_ventas;

