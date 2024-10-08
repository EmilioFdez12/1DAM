  -- 1 Mostrar el nombre del producto y el nombre de la categoría de todos los productos que contengan la letra Q en el nombre.
SELECT producto, categorias.categoria
FROM productos
JOIN categorias ON productos.categoria_id = categorias.id
WHERE producto LIKE 'Q%';

-- 2 Mostrar el número de pedido y el país del cliente de los pedidos de mayo del año 1997.
SELECT pedidos.id,clientes.pais, fecha_pedido
FROM pedidos
INNER JOIN clientes ON pedidos.cliente_id = clientes.id
WHERE fecha_pedido BETWEEN '1997-05-01' AND '1997-05-31';

-- 3 Mostrar fecha del pedido, cantidad y el nombre producto, y el código del pedido para los códigos de pedido 10285 o 10298.
SELECT pedidos.fecha_pedido, count(detalles.cantidad) as Cantidad, productos.producto
FROM pedidos
JOIN detalles ON pedidos.id = detalles.pedido_id
JOIN productos ON pedidos.id = productos.id
GROUP BY productos.producto;

-- 4 Mostrar el importe total (cantidad x precio x descuento en tanto por 1) de los pedidos 10285 y 10298 usando únicamente la tabla detalles. 
-- Verifica el resultado mostrando el detalle para cada pedido en otra consulta.
SELECT DISTINCT cantidad , precio_unidad , 
cantidad * precio_unidad precioporunidad, 
cantidad * precio_unidad*descuento dto_real,
(cantidad * precio_unidad) - (cantidad * precio_unidad*descuento) precio
FROM detalles
WHERE pedido_id IN (10285, 10298);

-- 5 ¿Cuánto se factura cada mes? Mostrar el año, el mes y el total.
SELECT year(fecha_pedido) año, month(fecha_pedido) mes,
SUM(cantidad * precio_unidad *(1 - descuento)) total
FROM pedidos INNER JOIN detalles ON id = pedido_id;

-- 6 Los pedidos que hizo la empleada Nancy.
SELECT pedidos.id , empleados.nombre
FROM empleados
INNER JOIN pedidos ON empleados.id = pedidos.cliente_id
WHERE empleados.id = 1;

-- 7 Mostrar los pedidos de Anton (código cliente).
SELECT pedidos.id ,clientes.id, clientes.codigo
FROM clientes
INNER JOIN pedidos ON clientes.id = pedidos.cliente_id
WHERE cliente_id = 3;

-- 08 Cuántos productos hay de cada categoría y el precio medio.
SELECT categoria, COUNT(p.id), AVG(precio_unidad) precio_medio
FROM productos p
  inner JOIN categorias c ON p.categoria_id = c.id
GROUP BY categoria;

-- 09 Mostrar los pedidos que tienen productos en la categoría 2 o 3.
SELECT detalles.pedido_id
FROM productos
INNER JOIN detalles ON productos.id = detalles.producto_id
WHERE productos.categoria_id in (2,3)
ORDER BY 1;

-- 10 Clientes que pidieron queso en julio de 1996.
SELECT DISTINCT clientes.id Cliente_id, productos.producto
FROM clientes
INNER JOIN pedidos ON clientes.id = pedidos.cliente_id
INNER JOIN productos ON clientes.id = productos.id
WHERE pedidos.fecha_pedido BETWEEN '1996-07-01' and '1996-07-31' =(
			SELECT productos.producto
            WHERE productos.producto like 'Queso %');
