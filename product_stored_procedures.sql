use ecom_system_db;

DELIMITER &&
create procedure get_products_count() 
begin
  SELECT count(id) as total_product FROM ecom_system_db.product_data;
end &&
DELIMITER ;

DELIMITER &&
create procedure get_all_products_and_countget_all_products_and_count() 
begin
  SELECT * FROM ecom_system_db.product_data;
  SELECT count(id) as total_product FROM ecom_system_db.product_data;
end &&
DELIMITER ;


DELIMITER &&
create procedure add_products(IN productName varchar(100) , IN productPrice decimal(10,2))
begin
  INSERT into ecom_system_db.product_data(name,price) values (productName,productPrice);
end &&
DELIMITER ;
