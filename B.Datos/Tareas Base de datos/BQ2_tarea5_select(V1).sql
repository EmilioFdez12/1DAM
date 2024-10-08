-- Si la region es null, se pone 'N/A'
SELECT id, codigo, empresa, contacto, cargo_contacto, coalesce(region,'N/A')
FROM clientes;


-- Une Nombre y Apellidos, y selecciona los empleados que fueron contratados a partir de 1994.
SELECT id, CONCAT(nombre, ' ', apellidos) as Nombre_y_Apellidos, cargo, fecha_contratacion 
FROM empleados
WHERE fecha_contratacion > '1993-12-31';

-- Redondea los precios
SELECT ROUND(precio_unidad), cantidad, descuento
FROM detalles
WHERE descuento = 0 and  precio_unidad > 20
ORDER BY cantidad ASC;


-- SELECT clientes.id, clientes.codigo, empresa, clientes.direccion, fecha_entrega, detalles.pedido_id, 
-- FROM pedidos
-- INNER JOIN clientes ON pedidos.cliente_id = clientes.id
-- INNER JOIN detalles ON pedidos.id = detalles.pedido_id
-- WHERE pais = 'España'


	

