CREATE DATABASE javadb;

CREATE TABLE users(
	first_name 	VARCHAR(250),
    last_name 	VARCHAR(250),
    extra_name 	VARCHAR(250),
    address  	VARCHAR(250),
    phone  		VARCHAR(30),
    email  		VARCHAR(150),
	ocupation   VARCHAR(100),
    department  VARCHAR(100)
);

INSERT INTO users
(first_name, last_name, 
address, phone, email, ocupation, department)
VALUES
('Svetlin', 'Nakov', 'Vraca', 
 '08858695147', 'soft@mail', 'CEO', 'IT');

UPDATE users
SET
	last_name = 'Nakov'
WHERE
	first_name = 'Svetlin' AND department = 'IT';
    
SELECT first_name, last_name 
FROM users
WHERE phone = '08865068050'
    