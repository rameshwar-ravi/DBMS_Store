DROP DATABASE `online_grocerystore_management_system`;

CREATE DATABASE `online_grocerystore_management_system` ;


CREATE TABLE `online_grocerystore_management_system`.`admin` (
  `admin_id` INT NOT NULL,
  `admin_name` VARCHAR(45) NULL,
  `admin_userid` VARCHAR(45) NULL unique,
  `admin_password` VARCHAR(45) NULL,
  PRIMARY KEY (`admin_id`));
select count(*) from orders;
CREATE TABLE `online_grocerystore_management_system`.`invoice` (
  `invoice_id` INT NOT NULL,
  `order_id` INT NOT NULL,
  `payment_mode` VARCHAR(45) NULL,
  `paid` INT NULL,
  PRIMARY KEY (`invoice_id`));
  
  CREATE TABLE `online_grocerystore_management_system`.`cart` (
  `customer_id` INT NOT NULL,
  `total_amount` INT NULL,
  `number_of_products` INT(5) NULL);

CREATE TABLE `online_grocerystore_management_system`.`feedback` (
	`f_id` int NOT NULL AUTO_INCREMENT,
  `customer_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  `supplier_id` INT ,
  `delivery_executive_id` INT ,
  `product_rating` INT NULL,
  `supplier_rating` INT NULL,
  `delivery_executive_rating` INT NULL,
  `submission_date` TIMESTAMP NULL,
  PRIMARY KEY(`f_id`));
   

  drop table feedback;
  INSERT INTO feedback (customer_id,product_id,product_rating) VALUES (1,20,5);
  select * from products where product_name='Bro Code';
  CREATE TABLE `online_grocerystore_management_system`.`supplier` (
  `supplier_id` INT NOT NULL,
  `supplier_name` VARCHAR(45) NULL,
  `pin_code` INT(10) NULL,
  `contact_number` VARCHAR(15) NULL,
  `country_code` INT NULL,
  `supplier_rating` VARCHAR(5) NULL,
  PRIMARY KEY (`supplier_id`));
  
  CREATE TABLE `online_grocerystore_management_system`.`delivery_executive` (
  `delivery_executive_id` INT NOT NULL,
  `delivery_executive_name` VARCHAR(45) NULL,
  `delivery_executive_phone` VARCHAR(15) NOT NULL,
  `photo_id_type` VARCHAR(15) NULL,
  `photo_id_number` VARCHAR(25) NULL,
  `raring` VARCHAR(5) NULL,
  PRIMARY KEY (`delivery_executive_id`));
  
CREATE TABLE `online_grocerystore_management_system`.`categories` (
  `category_id` INT NOT NULL,
  `category_name` VARCHAR(45) NULL,
  PRIMARY KEY (`category_id`));
  
CREATE TABLE `online_grocerystore_management_system`.`return_order` (
  `return_order_id` INT NOT NULL,
  `order_id` INT NOT NULL,
  `create_date` TIMESTAMP(2) NULL,
  `return_order_status` VARCHAR(45) NULL,
  `total` INT NULL,
  PRIMARY KEY (`return_order_id`));
  
CREATE TABLE `online_grocerystore_management_system`.`customer` (
  `customer_id` INT NOT NULL AUTO_INCREMENT,
  `login_id` VARCHAR(45) NULL unique,
  `login_password` VARCHAR(45) NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `address_line1` VARCHAR(45) NOT NULL,
  `address_line2` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `pin_code` INT NULL,
  `contact` VARCHAR(10) NULL,
  `country_code` INT NULL,
  `credit_limit` DECIMAL(12,5) NULL,
  `joined_at` TIMESTAMP NULL,
  PRIMARY KEY (`customer_id`));
ALTER TABLE `online_grocerystore_management_system`.`customer` AUTO_INCREMENT=100;

CREATE TABLE `online_grocerystore_management_system`.`orders` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `customer_id` INT NOT NULL,
  `status` VARCHAR(45) NULL,
  `order_ship_address_line1` VARCHAR(45) NULL,
  `order_ship_address_line2` VARCHAR(45) NULL,
  `order_ship_city_pincode` INT(10) NULL,
  `order_ship_country` VARCHAR(45) NULL,
  `order_delivery_partner` INT NULL,
  `created_at` TIMESTAMP NULL,
  PRIMARY KEY (`order_id`));

CREATE TABLE `online_grocerystore_management_system`.`products` ( 
  `product_id` INT NOT NULL,
  `product_name` VARCHAR(150) NULL,
  `supplier_id` INT NOT NULL,
  `product_price` INT NOT NULL,
  `quantity_available` INT NULL,
  `created_at` DATETIME NULL,
  `category_id` INT NOT NULL,
  `product_rating` VARCHAR(5) NULL,
  PRIMARY KEY (`product_id`));
  
CREATE TABLE `online_grocerystore_management_system`.`order_status` (
  `order_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  `quantity` INT NULL,
  `total_price` DECIMAL(10,4) NULL,
  `total_discount` DECIMAL(10,4) NULL,
  `sum_total` INT NULL);
ALTER TABLE `online_grocerystore_management_system`.`order_status` 
RENAME TO  `online_grocerystore_management_system`.`order_items` ;
SELECT p.product_name from orders as o,order_items as od,products as p where o.customer_id=100 and od.order_id=o.order_id and p.product_id=od.product_id;
select * from orders;
select * from order_items;
# insert values into tables
INSERT into `online_grocerystore_management_system`.`return_order` VALUES (1,03,'2020-02-03 10:07:31','Done',300);
INSERT into `online_grocerystore_management_system`.`return_order` VALUES (2,06,'2020-02-03 10:07:31','Pending',600);

 INSERT into `online_grocerystore_management_system`.`admin` VALUES (1,'AmanPreet Singh','Aman17217','aman1234');
 INSERT into `online_grocerystore_management_system`.`admin` VALUES (2,'Rameshwar Mishra','ramesh17180','ramesh1234');
 INSERT into `online_grocerystore_management_system`.`admin` VALUES (3,'Ayush Kapoor','ayush17334','ayush1234');
 INSERT into `online_grocerystore_management_system`.`admin` VALUES (4,'Chhavi Keshwani','chhavi17227','chhavi1234');
 INSERT into `online_grocerystore_management_system`.`admin` VALUES (5,'Jayant Jain','jayant17155','jayant1234');
 
INSERT into `online_grocerystore_management_system`.`invoice` VALUES (1,01,'Cash',0);
INSERT into `online_grocerystore_management_system`.`invoice` VALUES (2,02,'Credit/Debit Card Payment',1);
INSERT into `online_grocerystore_management_system`.`invoice` VALUES (3,03,'Bank Transfer',1);
INSERT into `online_grocerystore_management_system`.`invoice` VALUES (4,04,'Cash',1);
INSERT into `online_grocerystore_management_system`.`invoice` VALUES (5,05,'Bank Transfer',1);
INSERT into `online_grocerystore_management_system`.`invoice` VALUES (6,06,'Bank Transfer',0);
INSERT into `online_grocerystore_management_system`.`invoice` VALUES (7,07,'Cash',0);
INSERT into `online_grocerystore_management_system`.`invoice` VALUES (8,08,'Credit/Debit Card Payment',1);

INSERT into `online_grocerystore_management_system`.`cart` VALUES (5,80,2);
INSERT into `online_grocerystore_management_system`.`cart` VALUES (8,403,1);
INSERT into `online_grocerystore_management_system`.`cart` VALUES (1,120,4);
INSERT into `online_grocerystore_management_system`.`cart` VALUES (3,80,2);

INSERT into `online_grocerystore_management_system`.`feedback` VALUES (1,6,6,3,7,3,5,4.5,'2020-02-03 10:07:31');
INSERT into `online_grocerystore_management_system`.`feedback` VALUES (2,5,19,7,8,4,5,4,'2020-02-03 10:07:31');
INSERT into `online_grocerystore_management_system`.`feedback` VALUES (3,2,41,9,4,3.9,3,4,'2020-02-03 10:07:31');
INSERT into `online_grocerystore_management_system`.`feedback` VALUES (4,9,8,8,1,5,2,4.5,'2020-02-03 10:07:31');
INSERT into `online_grocerystore_management_system`.`feedback` VALUES (5,4,32,11,2,5,3,4.5,'2020-02-03 10:07:31');


INSERT into `online_grocerystore_management_system`.`supplier` VALUES (	1,'Harvest Gold',110087,'9823787645',+91,4.6);
INSERT into `online_grocerystore_management_system`.`supplier` VALUES (	2,'Glucon-D',110031,'8867587679',+91,4.1);
INSERT into `online_grocerystore_management_system`.`supplier` VALUES (	3,'Real Juice',110067,'7834537645',+91,3.9);
INSERT into `online_grocerystore_management_system`.`supplier` VALUES (	4,'Beer',110008,'8939911645',+91,4.9);
INSERT into `online_grocerystore_management_system`.`supplier` VALUES (	5,'Cookies',110011,'9986622475',+91,4.2);
INSERT into `online_grocerystore_management_system`.`supplier` VALUES (	6,'Origami',110057,'9823787645',+91,4.3);
INSERT into `online_grocerystore_management_system`.`supplier` VALUES (	7,'Liao',110053,'9823993321',+91,4.6);
INSERT into `online_grocerystore_management_system`.`supplier` VALUES (	8,'Fresho',110031,'9822649221',+91,4.1);
INSERT into `online_grocerystore_management_system`.`supplier` VALUES (	9,'Beeta',110085,'9823832901',+91,4.4);
INSERT into `online_grocerystore_management_system`.`supplier` VALUES (	10,'TAJ',110013,'9804932321',+91,4.3);
INSERT into `online_grocerystore_management_system`.`supplier` VALUES (	11,'UNIBIC',110049,'9823993321',+91,4.0);
INSERT into `online_grocerystore_management_system`.`supplier` VALUES (	12,'Parle',110010,'8329399321',+91,4.1);
INSERT into `online_grocerystore_management_system`.`supplier` VALUES (	13,'Haldiram',110006,'9893830321',+91,4.1);

INSERT into `online_grocerystore_management_system`.`delivery_executive` VALUES (1,'Vijay','9823787645','Aadhar Card','635284333347',4.6);
INSERT into `online_grocerystore_management_system`.`delivery_executive` VALUES (2,'Ramesh','886343679','Aadhar Card','630425678870',4.1);
INSERT into `online_grocerystore_management_system`.`delivery_executive` VALUES (3,'John','8434537645','Aadhar Number','987356490081',3.9);
INSERT into `online_grocerystore_management_system`.`delivery_executive` VALUES (4,'Alex','8939911645','Aadhar Number','392903203810',4.9);
INSERT into `online_grocerystore_management_system`.`delivery_executive` VALUES (5,'Akshat','9986622475','Aadhar Number','445798723345',4.2);
INSERT into `online_grocerystore_management_system`.`delivery_executive` VALUES (6,'Khushwat','9823787645','Aadhar Number','546592230973',4.3);
INSERT into `online_grocerystore_management_system`.`delivery_executive` VALUES (7,'Gurjot','9823993321','Aadhar Number','676790346123',4.6);
INSERT into `online_grocerystore_management_system`.`delivery_executive` VALUES (8,'Fresho','9822649221','Aadhar Number','498623467098',4.1);
INSERT into `online_grocerystore_management_system`.`delivery_executive` VALUES (9,'Beeta','9823832901','Aadhar Number','602398735671',4.4);
INSERT into `online_grocerystore_management_system`.`delivery_executive` VALUES (10,'TAJ','9804971341','Aadhar Number','093257891234',4.3);
INSERT into `online_grocerystore_management_system`.`delivery_executive` VALUES (11,'UNIBIC','9822783321','Aadhar Number','129087894531',4.0);
INSERT into `online_grocerystore_management_system`.`delivery_executive` VALUES (12,'Parle','8329238321','Aadhar Number','612309855674',4.1);
INSERT into `online_grocerystore_management_system`.`delivery_executive` VALUES (13,'Haldiram','9837830321','Aadhar Number','394598012765',4.1);

INSERT into `online_grocerystore_management_system`.`categories` VALUES (1,'Beverages');
INSERT into `online_grocerystore_management_system`.`categories` VALUES (2,'Bread and Bakery');
INSERT into `online_grocerystore_management_system`.`categories` VALUES (4,'Cokkies, Snacks and Candies');
INSERT into `online_grocerystore_management_system`.`categories` VALUES (3,'Beer, Wine and Spirit');
INSERT into `online_grocerystore_management_system`.`categories` VALUES (5,'Paper Products');
INSERT into `online_grocerystore_management_system`.`categories` VALUES (6,'Cleaning Supplies');

INSERT into `online_grocerystore_management_system`.`customer` VALUES (1,'Gurjot123','0123','Gurjot','Singh','Block F Flat Number 24','Greater Kailash', 'Delhi', 110087,'7554773450',91, 500000, '2020-02-01 17:00:01');
INSERT into `online_grocerystore_management_system`.`customer` VALUES (2,'Nishant123','0123','Nishant','Verma','Sector 8 Flat Number 109','Noida', 'Delhi', 110083,'9875346150',91, 500000, '2019-03-11 10:10:01');
INSERT into `online_grocerystore_management_system`.`customer` VALUES (3,'Raghav123','0123','Abhishek','Bacchan','Block c Flat Number 29','Kailash Colony', 'Delhi', 110007,'8382098761',91, 500000, '2019-03-01 13:00:01');
INSERT into `online_grocerystore_management_system`.`customer` VALUES (4,'Abhishek123','0123','Naman','Verma','Sector 2 Flat Number 7','Noia', 'Delhi', 110083,'9973328884',91, 500000, '2019-11-7 00:26:01');
INSERT into `online_grocerystore_management_system`.`customer` VALUES (5,'Naman123','0123','Sarthak','Aggarwal','Block C Flat Number 36A','Lodhi Road', 'Delhi', 110065,'8800361370',91, 500000, '2019-08-11 10:00:01');
INSERT into `online_grocerystore_management_system`.`customer` VALUES (6,'Rohan123','0123','Rohan','Chokara','Block G Flat Number 36A','Pitampura', 'Delhi', 110075,'8809372370',91, 500000, '2020-01-14 11:30:31');
INSERT into `online_grocerystore_management_system`.`customer` VALUES (7,'Aditya123','0123','Aditya','Gupta','Phase II Residents Colony Flat Number 41A','Oakhla', 'Delhi', 110025,'9728782730',91, 500000, '2020-01-18 07:10:51');
INSERT into `online_grocerystore_management_system`.`customer` VALUES (8,'Utkarsh123','0123','Utkarsh','Jha','Block G Flat Number 79','Nre Friends Colony', 'Delhi', 110075,'8803351170',91, 500000, '2019-08-11 11:40:41');
INSERT into `online_grocerystore_management_system`.`customer` VALUES (9,'Piyush123','0123','Piyush','Aggarwal','Block 3 Flat Number 128','Vijay Nagar', 'Delhi', 110038,'8990361370',91, 500000, '2019-09-21 10:20:51');
INSERT into `online_grocerystore_management_system`.`customer` VALUES (10,'Anmol123','0123','Vishal','Yadav','Block * Flat Number 32C','Greater Kailash-2', 'Delhi', 110088,'9800367037',91, 500000, '2019-11-28 09:23:01');

INSERT into `online_grocerystore_management_system`.`orders` VALUES (01,5,'Order Placed','Block C Flat Number 36A','Lodhi Road,Delhi', 110065,'India',7,'2020-02-01 17:00:01' );
INSERT into `online_grocerystore_management_system`.`orders` VALUES (02,2,'Shipping','Sector 8 Flat Number 109','Noida', 110083,'India',5,'2020-01-11 18:10:31' );
INSERT into `online_grocerystore_management_system`.`orders` VALUES (03,7,'Delievered','Phase II Residents Colony Flat Number 41A','Oakhla', 110025,'India',1,'2020-02-01 17:00:01' );
INSERT into `online_grocerystore_management_system`.`orders` VALUES (04,9,'Order Placed','Block 3 Flat Number 128','Vijay Nagar', 110083,'India',2,'2020-02-01 17:00:01' );
INSERT into `online_grocerystore_management_system`.`orders` VALUES (05,1,'Shipping','Block F Flat Number 24','Greater Kailash', 110087,'India',3,'2020-02-01 17:00:01' );
INSERT into `online_grocerystore_management_system`.`orders` VALUES (06,3,'Delievered','Block c Flat Number 29','Kailash Colony', 110007,'India',4,'2020-02-01 17:00:01' );
INSERT into `online_grocerystore_management_system`.`orders` VALUES (07,4,'Order Placed','Sector 2 Flat Number 7','Noida', 110083,'India',8,'2020-02-01 17:00:01' );
INSERT into `online_grocerystore_management_system`.`orders` VALUES (08,8,'Delievered','Block G Flat Number 79','Nre Friends Colony', 110075,'India',3,'2020-02-01 17:00:01' );
select * from orders;

INSERT into `online_grocerystore_management_system`.`products` VALUES (	1,'Harvest Gold: 100% whole wheat',1,30,6,'2020-01-01 10:10:10',2,'4.2');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	2,'Harvest Gold Sandwich Bread',1,50,16,'2020-01-01 12:10:10',2,'4.6');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	3,'Harvest Brown Bread',1,40,10,'2020-01-01 10:15:10',2,'4.3');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	4,'Pepsi 500ml',2,40,17,'2020-01-02 10:10:10',1,'4.9');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	5,'Sprite 500ml',2,40,23,'2020-01-02 11:10:50',1,'4.2');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	6,'Real Juice',3,100,25,'2020-02-01 10:12:10',1,'4');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	7,'Bro Code',4,180,16,'2019-01-01 10:10:10',3,'4.2');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	8,'Beer bong',4,100,6,'2020-01-01 10:10:10',3,'4.2');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	9,'Corona',4,300,6,'2020-01-01 10:10:10',3,'4.2');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	10,'Chables',4,1000,6,'2020-01-01 10:10:10',3,'4.2');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	11,'Dark Fantacy',5,80,6,'2020-01-01 10:10:10',4,'4.2');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	12,'Hide n Seek',5,30,6,'2020-01-01 10:10:10',4,'4.2');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	13,'Parle Milano Chocolate Chip Cokkies',5,30,6,'2020-01-01 10:10:10',4,'4.2');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	14,'Unibac Cokkies',5,90,6,'2020-01-01 10:10:10',4,'4.2');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	15,'Origami: 2 Ply Kitchen Towel',6,240,6,'2020-01-01 10:10:10',5,'4.2');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	16,'Origami: Classic Napkins',6,250,6,'2020-01-01 10:10:10',5,'4.2');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	17,'Origami: Toilet Roll',6,140,6,'2020-01-01 10:10:10',5,'4.2');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	18,'Liao: Toilet Cleaning Plunger',7,139,6,'2020-01-01 10:10:10',6,'4.2');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	19,'Liao: Cleaning Duster',7,99,6,'2020-01-01 10:10:10',6,'4.2');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	20,'Liao: Cleaning Cloth',7,189,6,'2020-01-01 10:10:10',6,'4.2');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	21,'Fresho: Brown Bread- Safe,Preservation free (200gm)',8,25,30,'2020-02-02 11:17:10',2,'4.2');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	22,'Fresho: Whole Wheat Bread- Safe,Preservation free (400gm)',8,40,20,'2020-01-31 18:17:55',2,'3.9');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	23,'Fresho: Sweet Bun- Safe,Preservation free Pack of 4',8,30,20,'2020-02-03 11:10:11',2,'4.1');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	24,'Fresho: Brown Garlic- Safe(200gm)',8,40,30,'2020-02-01 08:17:10',2,'4.4');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	25,'Fresho: Sticks- Jeera Bread(2 X 100gm)',8,40,30,'2020-02-02 11:17:10',2,'4.2');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	26,'Real Activ: Mixed Fruit Juice',3,100,30,'2020-02-02 20:57:10',1 ,'4.2');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	27,'Real Activ: Cranberry Juice',3,210,30,'2020-02-02 10:16:10',1 ,'4.2');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	28,'Real Activ: Pomergranade Juice',3,100,30,'2019-11-08 07:17:19',1 ,'4.2');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	29,'Real Activ: Apple',3,150,30,'2020-01-22 01:16:15',1 ,'4.2');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	30,'UNIBIC: Choclate Chip Cookies',11,30,50,'2020-01-12 13:16:30', 4,'3.8');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	31,'UNIBIC: Honey Oatmeal Cookies',11,30,50,'2020-01-17 17:12:20', 4,'4.0');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	32,'UNIBIC: Fruit and Nut',11,40,20,'2020-01-19 19:56:50', 4,'3.8');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	33,'Parle: Milano Centre Filled Mixed Berries',12,35,50,'2020-01-02 11:11:50', 4,'4.3');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	34,'Parle: Hide & Seek Choclate',12,60,35,'2020-01-22 05:16:50', 4,'4.7');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	35,'UNIBIC: Sugar Free Cashew Cookies Cookies',11,40,30,'2019-12-27 12:02:40', 4,'4.1');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	36,'Haldiram: Namkeen-Moong Dal',13,85,40,'2020-01-10 10:18:47', 4,'4.5');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	37,'Haldiram: Namkeen-Aloo Bhujia(Multi Pack-2X350gm)',13,160,60,'2020-01-13 10:18:47', 4,'4.5');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	38,'Haldiram: Namkeen-Tasty Nuts',13,33,60,'2020-01-14 10:10:47', 4,'4.5');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	39,'Parle: Kacha Mango Candy',12,50,35,'2020-01-26 07:16:47', 4,'4.6');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	40,'Parle: Melody CHoclaty',12,50,35,'2020-01-26 07:16:47', 4,'4.6');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	41,'Beeta: Toilet Roll',9,71,15,'2020-01-11 16:13:11',5,'4.4');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	42,'Beeta: Napkin Tissue',9,32,18,'2020-01-18 18:13:31',5,'4.2');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	43,'TAJ Mahal: Brooke Bond Taj Mahal Tea(1 kg)',10,403,20,'2020-01-28 08:03:51',1,'4.3');
INSERT into `online_grocerystore_management_system`.`products` VALUES (	44,'TAJ Mahal: Gold Tea(1 kg)',10,450,20,'2020-01-28 09:33:51',1,'3.9');

INSERT into `online_grocerystore_management_system`.`order_items` VALUES (01,19,2,198,0,198);
INSERT into `online_grocerystore_management_system`.`order_items` VALUES (02,1,2,60,0,60);
INSERT into `online_grocerystore_management_system`.`order_items` VALUES (03,29,3,300,0,300);
INSERT into `online_grocerystore_management_system`.`order_items` VALUES (04,32,2,80,0,198);
INSERT into `online_grocerystore_management_system`.`order_items` VALUES (05,41,8,568,0,568);
INSERT into `online_grocerystore_management_system`.`order_items` VALUES (06,6,6,600,0,600);
INSERT into `online_grocerystore_management_system`.`order_items` VALUES (07,8,1,100,0,100);
INSERT into `online_grocerystore_management_system`.`order_items` VALUES (08,9,2,600,10,590);

# add foreign keys 
ALTER TABLE `online_grocerystore_management_system`.`feedback` 
ADD INDEX `customer_id` (`customer_id` ASC) INVISIBLE,
ADD INDEX `product_id` (`product_id` ASC) VISIBLE,
ADD INDEX `supplier_id` (`supplier_id` ASC) VISIBLE,
ADD INDEX `delivery_executive_id` (`delivery_executive_id` ASC) VISIBLE;

ALTER TABLE `online_grocerystore_management_system`.`feedback` 
ADD CONSTRAINT `customer_id_fk`
  FOREIGN KEY (`customer_id`)
  REFERENCES `online_grocerystore_management_system`.`customer` (`customer_id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `product_id_fk`
  FOREIGN KEY (`product_id`)
  REFERENCES `online_grocerystore_management_system`.`products` (`product_id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `supplier_id_fk`
  FOREIGN KEY (`supplier_id`)
  REFERENCES `online_grocerystore_management_system`.`supplier` (`supplier_id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `delivery_executive_id_fk`
  FOREIGN KEY (`delivery_executive_id`)
  REFERENCES `online_grocerystore_management_system`.`delivery_executive` (`delivery_executive_id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `online_grocerystore_management_system`.`invoice` 
ADD INDEX `order_id_fk_idx` (`order_id` ASC) VISIBLE;
;
ALTER TABLE `online_grocerystore_management_system`.`invoice` 
ADD CONSTRAINT `order_id_fk`
  FOREIGN KEY (`order_id`)
  REFERENCES `online_grocerystore_management_system`.`orders` (`order_id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `online_grocerystore_management_system`.`cart` 
ADD CONSTRAINT `customer_id_fk1`
  FOREIGN KEY (`customer_id`)
  REFERENCES `online_grocerystore_management_system`.`customer` (`customer_id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `online_grocerystore_management_system`.`return_order` 
ADD CONSTRAINT `order_id_fk1`
  FOREIGN KEY (`order_id`)
  REFERENCES `online_grocerystore_management_system`.`orders` (`order_id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `online_grocerystore_management_system`.`orders` 
ADD CONSTRAINT `customer_id_fk2`
  FOREIGN KEY (`customer_id`)
  REFERENCES `online_grocerystore_management_system`.`customer` (`customer_id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `online_grocerystore_management_system`.`products` 
ADD CONSTRAINT `supplier_id_fk1`
  FOREIGN KEY (`supplier_id`)
  REFERENCES `online_grocerystore_management_system`.`supplier` (`supplier_id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `category_id_fk`
  FOREIGN KEY (`category_id`)
  REFERENCES `online_grocerystore_management_system`.`categories` (`category_id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `online_grocerystore_management_system`.`order_items` 
ADD INDEX `order_id_fk2_idx` (`order_id` ASC) VISIBLE,
ADD INDEX `product_id_fk1_idx` (`product_id` ASC) VISIBLE;
;
ALTER TABLE `online_grocerystore_management_system`.`order_items` 
ADD CONSTRAINT `order_id_fk2`
  FOREIGN KEY (`order_id`)
  REFERENCES `online_grocerystore_management_system`.`orders` (`order_id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `product_id_fk1`
  FOREIGN KEY (`product_id`)
  REFERENCES `online_grocerystore_management_system`.`products` (`product_id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
  -- 
  
USE online_grocerystore_management_system;

-- Proposed working queries  


-- To find price of product
-- Select product_price from products where product_name = ‘01’;   //works
-- To find customer details
-- Select * from customer where customer_id =’05’;   //works


-- To check feedback rating of a product by its name
-- Select F.product_rating from feedback as F, products as P 
-- where P.product_id = F.product_id and P.product_name = 'Beer bong';    //works

-- To find which supplier has supplied the given product
-- Select S.supplier_name from supplier as S, products as P 
-- where P.supplier_id = s.supplier_id and P.product_name ='Corona';  //works

-- For delivery partner to know address where delivery is to be made
-- Select order_id,order_ship_address_line1, order_ship_address_line2 from orders as A, delivery_executive as B 
-- where A.order_delivery_partner = B.delivery_executive_id and A.status = 'Shipping';
-- //works       

--  To find all products in a given category
-- Select product_name from products where products.category_id = '2';  //works

-- To track return order status when you only know order_id of the product
-- Select return_order_status from return_order as A where A.order_id = '03';  //works

-- If the supplier wants to change the contact number.
--              Update supplier set contact_no = 0759 253 542 where supplier_id=10;  //works
-- 		
--    If the customer wants to change there login_password, contact and      address_Line1
--      Update customer set login_password = '111' , contact = 0759253542 , address_line1 = 'IIITD' where login_id = 'Nishant123';    //works

--   To check whether the payment is done by all customers or not for all of their orders?
-- Select C.first_name,C.last_name,paid from invoice as I, orders as O, customer as C
-- Where I.order_id=O.order_id and O.customer_id=C.customer_id;     //works

--  To view all orders of a given customer
--  Select O.order_id, O.created_at, O.status from orders as O 
-- where O.customer_id = '1';                 //works



--  To find details of items in an order
-- Select A.product_id,B.product_name, A.quantity, A.sum_total from order_items as A, products as B  where order_id = '01' and A.product_id = B.product_id;        //works

-- To find the sum total of order for a customer(given the id=123)
-- Select sum(sum_total) from  order_items as A,orders as B
-- where A.order_id=B.order_id and B.customer_id='3';     //works

-- List products with feedback rating <=3.
-- Select P.product_name ,F.product_rating from feedback as F, products as P
-- Where F.product_rating<=3 and F.product_id=P.product_id;     //works

