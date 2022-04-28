create database ecom_system_db;
use ecom_system_db;

SELECT database();

CREATE table product_data(id bigint primary key auto_increment , product_name varchar(50),
product_price decimal(10,2), product_description varchar(50), product_brand varchar(50), create_date timestamp default now(),
expired_date timestamp default now());


desc product_data;

INSERT into product_data(product_name,product_price,product_description,product_brand)
values('Apple Mac Book SHFGF Model', 5435.56, 'It is a laptop', 'Apple');

INSERT into product_data(product_name,product_price,product_description,product_brand)
values('HP Slim Book QSEF Model Laptop', 2235.56, 'It is a laptop', 'HP');

INSERT into product_data(product_name,product_price,product_description,product_brand)
values('Lenovoideapad ISSDE Model Laptop', 4435.56, 'It is a laptop', 'Lenovo');

INSERT into product_data(product_name,product_price,product_description,product_brand)
values('DELL inspiron RF34DM Model Laptop', 5135.56, 'It is a laptop', 'Dell');