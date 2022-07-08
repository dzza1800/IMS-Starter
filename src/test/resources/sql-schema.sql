DROP TABLE IF EXISTS `customers`;
DROP TABLE IF EXISTS `items`;
DROP TABLE IF EXISTS `Orders`;


CREATE TABLE IF NOT EXISTS customers (
	id INT(11) NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(40) DEFAULT NULL,
    surname VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS items (
    items_id INT(11) NOT NULL AUTO_INCREMENT,
    Item_Name VARCHAR(40) DEFAULT NULL,
    Item_Price  DECIMAL(8, 2) NOT NULL,
    PRIMARY KEY (items_id)
);

CREATE TABLE IF NOT EXISTS Orders (
    order_id INT(11) NOT NULL AUTO_INCREMENT,
    customer_id INT(11) NOT NULL 
    REFERENCES customers (id),
    itemsID INT(11) NOT NULL
    REFERENCES items (items_id),
    itemsQuantity INT(11) NOT NULL,
    PRIMARY KEY (order_id)
);

CREATE TABLE IF NOT EXISTS Users (
    User_id INT(11) NOT NULL AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    UserPassword VARCHAR(255) NOT NULL,
    PRIMARY KEY (User_id)
);

CREATE or replace VIEW FinalOrders as SELECT order_id, customer_id, itemsID, customers.first_name, customers.surname, items.Item_Name, itemsQuantity, itemsQuantity * Item_Price as Total_Item_Price FROM Orders LEFT JOIN customers ON id = customer_id LEFT JOIN items on items_id = itemsID;