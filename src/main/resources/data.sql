DROP TABLE IF EXISTS product;


CREATE TABLE product (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  value DECIMAL(10,2) NULL,
  currency_code VARCHAR(45) NULL,
  PRIMARY KEY (id));
  
INSERT INTO product (id, name, value, currency_code) VALUES ('15117729', 'Prod1', '100', 'USD');
INSERT INTO product (id, name, value, currency_code) VALUES ('16483589', 'Prod2', '200.34', 'USD');
INSERT INTO product (id, name, value, currency_code) VALUES ('16696652', 'Prod3', '30', 'USD');
INSERT INTO product (id, name, value, currency_code) VALUES ('16752456', 'Prod4', '40', 'USD');
INSERT INTO product (id, name, value, currency_code) VALUES ('15643793', 'Prod5', '18.5', 'USD');
INSERT INTO product (id, name, value, currency_code) VALUES ('13860428', 'The Big Lebowski (Blu-ray) (Widescreen)', '13.49', 'USD');

  
