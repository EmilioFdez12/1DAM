SELECT orders.orderNumber, orderDate, requiredDate, shippedDate, status, orders.customerNumber, customerName, country, count(productCode) AS numProductos
FROM orders
INNER JOIN customers ON orders.customerNumber = customers.customerNumber
INNER JOIN orderdetails ON orders.orderNumber = orderdetails.orderNumber
WHERE requiredDate BETWEEN '2003-01-06' AND '2003-06-16'
GROUP BY 1
HAVING count(orders.orderNumber) = 4;

DELIMITER //

CREATE PROCEDURE export_orders_csv(
	IN p_fecha_inicio DATE,
    IN p_fecha_fin DATE,
    IN p_numeroProductos INT
    )
BEGIN
		IF p_fecha_inicio >= p_fecha_fin THEN
			SELECT 'ERROR: La fecha de inicio debe ser anterior a la fecha de fin.' AS error_message;
		ELSEIF numeroProductos <= 0 THEN
			SELECT "ERROR: El número de prodcutos debe de ser mayor de 0";
		ELSE      
			SELECT CONCAT(orders.orderNumber, ";",  orderDate,  ";", requiredDate,  ";", shippedDate,  ";",  status, ";"
            , orders.customerNumber, ";", customerName, ";", country, count(productCode))AS numProductos
			FROM orders
			INNER JOIN customers ON orders.customerNumber = customers.customerNumber
			INNER JOIN orderdetails ON orders.orderNumber = orderdetails.orderNumber
			WHERE requiredDate BETWEEN p_fecha_inicio AND p_fecha_fin
			GROUP BY 1
			HAVING count(orders.orderNumber) = p_numeroProductos;
		END IF;
END//

DELIMITER ;