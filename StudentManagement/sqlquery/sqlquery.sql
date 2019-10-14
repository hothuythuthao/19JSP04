CREATE DATABASE StudentManagement;
/*-------------------------------------------------------*/
USE StudentManagement;
/*-------------------------------------------------------*/
CREATE TABLE student	(
	student_id		int				primary key auto_increment,
    student_name	varchar(100)	not null,
    student_age		int
);

CREATE TABLE class		(
	class_id		int				primary key auto_increment,
    class_name		varchar(100)	not null,
    amount			int				not null default(0)
);

CREATE TABLE dayoff		(
	dayoff_id		int				primary key auto_increment,
    day_off			date			not null,
    student_id		int,
    constraint FK_StudentDayOff foreign key (student_id) references student(student_id)
);

CREATE TABLE student_class	(
	id				int				primary key auto_increment,
    student_id		int,
    class_id		int,
    constraint FK_Student foreign key (student_id) references student(student_id),
    constraint FK_Class foreign key (class_id) references class(class_id)
);
/*-------------------------------------------------------*/
INSERT INTO student(student_name, student_age)
VALUES	('Tee', 22),
		('Qii', 22),
        ('Mini', 22),
        ('Hui', 22),
        ('Min', 22);

INSERT INTO class(class_name)
VALUES	('JAVA101'),
		('JAVA102'),
        ('CSHARP101'),
        ('CSHARP102'),
        ('HTML101'),
        ('HTML102');
        
INSERT INTO dayoff(day_off, student_id)
VALUES	('2019/10/10', 1),
		('2019/10/12', 1),
        ('2019/10/15', 2),
        ('2019/10/17', 2),
        ('2019/10/10', 3),
        ('2019/10/15', 3),
        ('2019/10/12', 4),
        ('2019/10/17', 4),
        ('2019/10/15', 5),
        ('2019/10/20', 5);
        
INSERT INTO student_class(student_id, class_id)
VALUES	(1,1),
		(1,3),
        (2,2),
        (2,4),
        (3,5),
        (3,6),
        (4,2),
        (4,6),
        (5,3),
        (5,4);
/*-------------------------------------------------------*/
CREATE TRIGGER tg_CountStudent AFTER INSERT ON student_class
FOR EACH ROW
	UPDATE CLASS
	SET amount = (	SELECT COUNT(student_id)
					FROM student_class
                    WHERE student_class.class_id = new.class_id
				 )
					WHERE class.class_id = new.class_id;
/*-------------------------------------------------------*/
CREATE TRIGGER tg_DeleteStudentInDayOff BEFORE DELETE ON student
FOR EACH ROW
    DELETE FROM dayoff WHERE dayoff.student_id = old.student_id;
/*-------------------------------------------------------*/
CREATE TRIGGER tg_DeleteStudentInStudentClass BEFORE DELETE ON student
FOR EACH ROW
    DELETE FROM student_class WHERE student_class.student_id = old.student_id;
/*-------------------------------------------------------*/
CREATE TRIGGER tg_DeleteClass BEFORE DELETE ON class
FOR EACH ROW
	DELETE FROM student_class WHERE student_class.class_id = old.class_id;
/*-------------------------------------------------------*/    
CREATE TRIGGER tg_CountStudents AFTER DELETE ON student_class
FOR EACH ROW
	UPDATE class
	SET amount = (	SELECT COUNT(student_id)
					FROM student_class
                    WHERE student_class.class_id = old.class_id
				 )
					WHERE class.class_id = old.class_id;
/*-------------------------------------------------------*/

