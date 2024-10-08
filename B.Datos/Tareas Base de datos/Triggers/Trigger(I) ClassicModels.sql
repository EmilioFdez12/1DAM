DELIMITER //
CREATE TRIGGER productos_trigger
BEFORE INSERT
ON products FOR EACH ROW 
BEGIN
	IF productLine = 'Classic Cars' THEN
		-- Update aqui??
		SET new.htmlDescription = CONCAT('<Strong>', OLD.txtDescription, '</Strong>')
	ELSEIF productLine = 'Planes' THEN
		SET  new.htmlDescription = CONCAT('<Strong><em>', OLD.txtDescription,>'</em>''</Strong'>)
	END IF;
END;
DELIMITER ;


DELIMITER //
CREATE TRIGGER productos_trigger
AFTER UPDATE
ON products FOR EACH ROW 
	BEGIN
		IF OLD.productCode <> NEW.productCode THEN
			INSERT INTO orders (comments) VALUES (CONCAT(NOW(), ' Campo:', productCode, 'Valor_anterior:', OLD.productCode, '. Valor_actual:', NEW.productCode, '.'));
        ELSEIF OLD.productName <> NEW.productName THEN
			INSERT INTO orders (comments) VALUES (CONCAT(NOW(), ' Campo:', productName, ' Valor_anterior:', OLD.productName, '. Valor_actual:', NEW.productName, '.'));
		ELSEIF OLD.productLine <> NEW.productLine THEN
			INSERT INTO orders (comments) VALUES (CONCAT(NOW(), ' Campo: ', productLine, '. Valor_anterior:', OLD.productLine, '. Valor_actual:', NEW.productLine, '.'));
		ELSEIF OLD.productScale <> NEW.productScale THEN
			INSERT INTO orders (comments) VALUES (CONCAT(NOW(), ' Campo: ', productScale, '. Valor_anterior:', OLD.productScale, '. Valor_actual:', NEW.productScale, '.'));
		ELSEIF OLD.productVendor <> NEW.productVendor THEN
			INSERT INTO orders (comments) VALUES (CONCAT(NOW(), ' Campo: ', productVendor, '. Valor_anterior:', OLD.productVendor, '. Valor_actual:', NEW.productVendor, '.'));
		ELSEIF OLD.productDescription <> NEW.productDescription THEN
			INSERT INTO orders (comments) VALUES (CONCAT(NOW(), ' Campo: ', productDescription, '. Valor_anterior:', OLD.productDescription, '. Valor_actual:', NEW.productDescription, '.'));
		ELSEIF OLD.quantityInStock <> NEW.quantityInStock THEN
			INSERT INTO orders (comments) VALUES (CONCAT(NOW(), ' Campo: ', quantityInStock, '. Valor_anterior:', OLD.quantityInStock, '. Valor_actual:', NEW.quantityInStock, '.'));
		ELSEIF OLD.buyPrice <> NEW.buyPrice THEN
			INSERT INTO orders (comments) VALUES (CONCAT(NOW(), ' Campo: ', buyPrice, '. Valor_anterior:', OLD.buyPrice, '. Valor_actual:', NEW.buyPrice, '.'));
		ELSEIF OLD.MSRP <> NEW.MSRP THEN
			INSERT INTO orders (comments) VALUES (CONCAT(NOW(), ' Campo: ', MSRP, '. Valor_anterior:', OLD.MSRP, '. Valor_actual:', NEW.MSRP, '.'));
		END IF;
	END;
        
DELIMITER ;

