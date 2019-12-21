CREATE DATABASE mylibrary;

USE mylibrary;

CREATE TABLE user(
	user_id		varchar(6)		primary key,
	user_name	nvarchar(100),
	email		varchar(100),
	password	varchar(100),
	isAdmin		tinyint	default 1, 
	status		char(2) default 'DA',
	CONSTRAINT 	UC_email 	unique(email),
    CONSTRAINT 	CHK_email 	check(email like '%@%.%'),
    CONSTRAINT  CHK_admin	check (isAdmin >=1 and isAdmin <=2),
    CONSTRAINT  CHK_status	check (status ='LA' or status ='DA')
);

CREATE TABLE book(
	book_id			varchar(6) 		primary key,
	book_name		nvarchar(100),
	book_author 	nvarchar(100),
	publish_year	varchar(4),
	book_kind		nvarchar(100)
);

CREATE TABLE user_book(
    id			int primary key auto_increment,
    user_id		varchar(6) 	references user(user_id)	on delete cascade,
    book_id		varchar(6) 	references book(book_id) on delete cascade,
    borrow_date date,
    return_date_expected 	date,
    return_date_real 		date,
    register_date			date,
    emp_id		varchar(6) 	references Users(user_id),
    status		tinyint	default 0,
    CONSTRAINT 	CHK_date check((borrow_date <= return_date_expected) and (return_date_real <= return_date_expected)),
    CONSTRAINT UC_UB unique (user_id, book_id),
    CONSTRAINT CHK_stt	check (status = 1 or status = 0)
); 

INSERT INTO book values('JV01', N'Effective Java', N'Joshua Bloch', '2015', N'Sách tài liệu');
INSERT INTO book values('THJV', N'Java Concurrency in Practice', N'Brian Goetz', '2016', N'Sách hướng dẫn');
INSERT INTO book values('CPL', N'The C Programming Language', N'Brian W', '2017', N'Sách tài liệu');
INSERT INTO book values('THCPL', N'Learn C the Hard Way', N'Zed A', '2018', N'Sách hướng dẫn');
INSERT INTO book values('JV02', N'Java - The Complete Reference', N'Herbert Schildt', '2019', N'Sách tài liệu');

INSERT INTO user VALUES ('00001', N'Hồ Thụy Thu Thảo', 'hothuythuthao@gmail.com', '123456', 2, 'DA');
INSERT INTO user VALUES('00002', N'Nguyễn Văn Vinh', 'nguyenvanvinh@gmail.com', '123456', 2, 'DA');
INSERT INTO user VALUES('00003', N'Phan Huỳnh Minh Ý', 'phanhuynhminhy@gmail.com', '123456', 1, 'DA');
INSERT INTO user VALUES('00004', N'Nguyễn Hồng Quân', 'nguyenhongquan@gmail.com', '123456', 1, 'DA');
INSERT INTO user VALUES('00005', N'Vũ Thành Gia Minh', 'vuthanhgiaminh@gmail.com', '123456', 1, 'LA');
