CREATE DATABASE LOGIN;

USE LOGIN;

CREATE TABLE USER
(
user_id			int				primary key	auto_increment,
user_name		varchar(100)	not null,
user_password	varchar(100)	not null
);

-- Insert data: ---------------------------------------------------------------
 
INSERT INTO USER (user_name, user_password)
values 	('Tee', '111111');

INSERT INTO USER (user_name, user_password)
values 	('Qii', '111111');

INSERT INTO USER (user_name, user_password)
values 	('Miny', '111111');

INSERT INTO USER (user_name, user_password)
values 	('Hui', '111111');

INSERT INTO USER (user_name, user_password)
values 	('Min', '111111');