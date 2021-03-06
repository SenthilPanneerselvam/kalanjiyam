CREATE DATABASE `kalanjiyam` DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;
  
use `kalanjiyam`;
--test 2

CREATE TABLE `category`
(
 cat_id INTEGER(11) NOT NULL AUTO_INCREMENT,
 cat_name VARCHAR(100) NOT NULL DEFAULT '',
 cat_desc VARCHAR(100) DEFAULT '',
 cat_author varchar(100) DEFAULT '',
 cat_pub_year varchar(100) DEFAULT '',
 PRIMARY KEY(cat_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `item`
(
	item_id INTEGER(11) NOT NULL AUTO_INCREMENT,
	item_name VARCHAR(100) NOT NULL,
	item_content VARCHAR(1000) NOT NULL,
	item_exp VARCHAR(1000) DEFAULT '',
	item_exp_by VARCHAR(100) DEFAULT '',
	item_situation VARCHAR(100) DEFAULT '',
	item_genre VARCHAR(100) DEFAULT '',
	cat_id INTEGER(11) NOT NULL,
	PRIMARY KEY(item_id),
	CONSTRAINT `FK_item_category` FOREIGN KEY (`cat_id`) REFERENCES `category` (`cat_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

