CREATE TABLE category(
id IDENTITY,
name VARCHAR(50),
description VARCHAR(255),
image_url VARCHAR(50),
is_active BOOLEAN,

CONSTRAINT pk_category_id PRIMARY KEY(id)
);


CREATE TABLE category(
id NUMBER GENERATED BY DEFAULT AS IDENTITY,
name VARCHAR(50),
description VARCHAR(255),
image_url VARCHAR(50),
is_active number(1,0),

CONSTRAINT pk_category_id PRIMARY KEY(id)
);


INSERT INTO category(name, description,image_url, is_active) values('Laptop', 'Description for Mobile', 'CAT_3.png',1);
INSERT INTO category(name, description,image_url, is_active) values('Laptop', 'Description for Mobile', 'CAT_3.png',1);

CREATE TABLE user_detail(
id NUMBER GENERATED BY DEFAULT AS IDENTITY,
first_name VARCHAR2(50),
last_name VARCHAR2(50),
role VARCHAR2(50),
enabled NUMBER(1,0),
password VARCHAR2(50),
email VARCHAR2(100),
contact_number VARCHAR2(15),
CONSTRAINT pk_user_id PRIMARY KEY(id));


INSERT INTO USER_DETAIL
(first_name, last_name, role, enabled, password, email, contact_number)
values('Samuel','Sasikiran', 'ADMIN', 1, 'admin', 'samuel.s3k@gmail.com','7506506032');

INSERT INTO USER_DETAIL
(first_name, last_name, role, enabled, password, email, contact_number)
values('Babu','DevaPrasad', 'SUPPLIER', 1, '12345', 'babudevaprasad@gmail.com','7506106032');

INSERT INTO USER_DETAIL
(first_name, last_name, role, enabled, password, email, contact_number)
values('Edward','Williams', 'SUPPLIER', 1, '12345', 'edward@gmail.com','7456506032');


CREATE TABLE product(id NUMBER GENERATED BY DEFAULT AS IDENTITY,
code VARCHAR2(20), name VARCHAR2(50), brand VARCHAR2(50), description VARCHAR2(255), unit_price NUMBER(10,2), quantity number(2),
is_active number(1,0), category_id number(5), supplier_id number(6),purchases NUMBER(6) DEFAULT 0,views NUMBER(6) DEFAULT 0,
CONSTRAINT pk_product_id PRIMARY KEY(id),
CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category(id),
CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id));

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDABC123DEFX', 'iPhone 5s', 'apple', 'This is one of the best phone available in the market right now!', 18000, 5, 1, 3, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDDEF123DEFX', 'Samsung s7', 'samsung', 'A smart phone by samsung!', 32000, 2, 1, 3, 3 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDPQR123WGTX', 'Google Pixel', 'google', 'This is one of the best android smart phone available in the market right now!', 57000, 5, 1, 3, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDMNO123PQRX', ' Macbook Pro', 'apple', 'This is one of the best laptops available in the market right now!', 54000, 3, 1, 1, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDABCXYZDEFX', 'Dell Latitude E6510', 'dell', 'This is one of the best laptop series from dell that can be used!', 48000, 5, 1, 1, 3 );


