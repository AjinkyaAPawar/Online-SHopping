CREATE TABLE `Retailers` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(100),
	`email` varchar(100),
	`phone` int,
	`password` varchar(100) NOT NULL,
	`address` varchar(100),
	`city` varchar(100),
	`state` varchar(100),
	`postalcode` int,
	`discount` int(100) DEFAULT '0',
	`admin_id` int NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Products` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` int,
	`brand` varchar(25),
	`description` varchar(500),
	`price` int,
	`rank` int,
	`size` FLOAT,
	`weight` FLOAT,
	`color` varchar(20),
	`units` int,
	`picture` varchar(255),
	`retailer_id` int,
	`category_id` int,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Categories` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(100),
	PRIMARY KEY (`id`)
);

CREATE TABLE `Shippers` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(25),
	`email` varchar(50),
	`phone` int,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Admins` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL,
	`email` varchar(50) NOT NULL,
	`password` varchar(100) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `User` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(100),
	`email` varchar(100),
	`phone` int,
	`password` varchar(100) NOT NULL,
	`house_name` varchar(40),
	`address` varchar(100),
	`city` varchar(100),
	`state` varchar(100),
	`postalcode` int,
	`joindate` DATE,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Orders` (
	`id` int NOT NULL AUTO_INCREMENT,
	`number` int NOT NULL,
	`sales_tax` int,
	`customer_id` int NOT NULL,
	`order_date` DATE,
	`payment_date` DATE,
	`paid` BOOLEAN,
	`shipper_id` int NOT NULL,
	`payment_id` int NOT NULL,
	`shipment_date` DATE,
	`fulfilled` BOOLEAN,
	`cancel` BOOLEAN,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Payment` (
	`id` int NOT NULL AUTO_INCREMENT,
	`type` varchar(30) NOT NULL,
	`allowed` BOOLEAN,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Order_Details` (
	`id` int NOT NULL AUTO_INCREMENT,
	`product_id` int NOT NULL,
	`order_id` int NOT NULL,
	`number` int,
	`price` int,
	`quantity` int,
	`discount` int DEFAULT '0',
	`total` int NOT NULL,
	`fulfilled` BOOLEAN NOT NULL,
	`shipment_date` DATE,
	`bill_date` DATE,
	PRIMARY KEY (`id`)
);

ALTER TABLE `Retailers` ADD CONSTRAINT `Retailers_fk0` FOREIGN KEY (`admin_id`) REFERENCES `Admins`(`id`);

ALTER TABLE `Products` ADD CONSTRAINT `Products_fk0` FOREIGN KEY (`retailer_id`) REFERENCES `Retailers`(`id`);

ALTER TABLE `Products` ADD CONSTRAINT `Products_fk1` FOREIGN KEY (`category_id`) REFERENCES `Categories`(`id`);

ALTER TABLE `Orders` ADD CONSTRAINT `Orders_fk0` FOREIGN KEY (`customer_id`) REFERENCES `User`(`id`);

ALTER TABLE `Orders` ADD CONSTRAINT `Orders_fk1` FOREIGN KEY (`shipper_id`) REFERENCES `Shippers`(`id`);

ALTER TABLE `Orders` ADD CONSTRAINT `Orders_fk2` FOREIGN KEY (`payment_id`) REFERENCES `Payment`(`id`);

ALTER TABLE `Order_Details` ADD CONSTRAINT `Order_Details_fk0` FOREIGN KEY (`product_id`) REFERENCES `Products`(`id`);

ALTER TABLE `Order_Details` ADD CONSTRAINT `Order_Details_fk1` FOREIGN KEY (`order_id`) REFERENCES `Orders`(`id`);










