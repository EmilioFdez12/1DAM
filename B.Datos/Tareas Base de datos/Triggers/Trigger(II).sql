
DELIMITER //
CREATE TRIGGER productos_trigger
BEFORE INSERT
ON products FOR EACH ROW 
BEGIN
	IF productLine = 'Classic Cars' THEN
		SET new.htmlDescription = CONCAT('<Strong>', OLD.txtDescription, '</Strong>')
	ELSEIF productLine = 'Planes' THEN
		SET  new.htmlDescription = CONCAT('<Strong><i>', OLD.txtDescription, '</Strong></i>'>)
	END IF;

DELIMITER ;