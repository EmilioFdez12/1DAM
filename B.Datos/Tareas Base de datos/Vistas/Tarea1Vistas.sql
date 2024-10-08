-- A partir de la base de datos Neptuno, crea cuatro vistas con diferentes consultas. Las que tú quieras. 
-- 1 Consulta que filtre por más de dos campos.
-- Los productos de la categoria 3, y su precio por unidad sea mayor a 20.
CREATE VIEW p_categoria3_20 AS
SELECT *
FROM productos
WHERE categoria_id =  3
and precio_unidad > 20;

SELECT *
FROM p_categoria3_20;

-- 2 Consulta que muestre únicamente x campos de una tabla.
CREATE VIEW info_importante_cliente AS
SELECT id, codigo, contacto, ciudad, pais, cp, telefono
FROM clientes;

SELECT *
FROM info_importante_cliente;

-- 3 Consulta que use una subconsulta.
CREATE VIEW p_cantidad_maxima AS
SELECT *
FROM productos 
WHERE unidades_pedido = (SELECT MAX(cantidad) FROM detalles);

SELECT *
 FROM p_cantidad_maxima;

 
-- 4 Consulta que haga join de cuatro tablas.
CREATE VIEW tres_joins AS
SELECT empleados.id ID_Empleado, empleados.apellidos Apellido_Empleado, pedidos.cliente_id, pedidos.destinatario, envios.empresa, clientes.fax
FROM empleados
INNER JOIN pedidos ON empleados.id = pedidos.empleado_id
INNER JOIN envios ON pedidos.cliente_id = envios.id
INNER JOIN clientes ON pedidos.cliente_id = clientes.id
WHERE empleados.id BETWEEN 4 AND 8
ORDER BY empleado_id ASC;
 
 SELECT *
 FROM tres_joins;




