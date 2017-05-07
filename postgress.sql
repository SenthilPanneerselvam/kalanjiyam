CREATE TABLE category
(
 cat_id INTEGER NOT NULL,
 cat_name VARCHAR(100) NOT NULL DEFAULT '',
 cat_desc VARCHAR(100) DEFAULT '',
 cat_author varchar(100) DEFAULT '',
 cat_pub_year varchar(100) DEFAULT '',
 PRIMARY KEY(cat_id)
);

CREATE TABLE item
(
	item_id INTEGER NOT NULL,
	item_name VARCHAR(100) NOT NULL,
	item_content VARCHAR(1000) NOT NULL,
	item_exp VARCHAR(1000) DEFAULT '',
	item_exp_by VARCHAR(100) DEFAULT '',
	item_situation VARCHAR(100) DEFAULT '',
	item_genre VARCHAR(100) DEFAULT '',
	cat_id INTEGER NOT NULL,
	PRIMARY KEY(item_id),
	CONSTRAINT FK_item_category FOREIGN KEY (cat_id) REFERENCES category (cat_id) ON DELETE CASCADE ON UPDATE CASCADE
);

alter table category drop column cat_author;
alter table item add column author varchar(100) NOT NULL DEFAULT '',

create table tag
(
	tag_id INTEGER NOT NULL,
	tag_name varchar(100) not null,
	tag_value varchar(100) not null,
	item_id INTEGER not null,
	primary key(tag_id),
	CONSTRAINT FK_tag_item FOREIGN KEY (item_id) REFERENCES item (item_id) ON DELETE CASCADE ON UPDATE CASCADE
);

alter table item alter column item_content type varchar(5000);
alter table item alter column item_exp type varchar(5000);
alter table item alter column item_situation type varchar(1000);
alter table item alter column author type varchar(500);