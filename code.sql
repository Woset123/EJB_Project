
-- Init
CREATE TABLE Department (
id_department DECIMAL ( 3 , 0 ) PRIMARY KEY ,
name VARCHAR ( 25 ),
floor DECIMAL ( 2 , 0 ),
bat_number DECIMAL ( 2 , 0 ),
nbemployee DECIMAL (3 , 0 )
);


CREATE TABLE Employee (
	id_employee DECIMAL ( 3 , 0 ) PRIMARY KEY ,
	id_department DECIMAL ( 3 , 0 ),
	first_name VARCHAR ( 25 ),
	last_name VARCHAR ( 25 ),
	age DECIMAL ( 2 , 0 ) CHECK ( age > 0 and age < 120 ),
	FOREIGN KEY ( id_department ) REFERENCES Department
);

INSERT INTO department VALUES (0, 'Not Affected', 0 , 0, 0);
INSERT INTO department VALUES (1,'Sales', 2 , 1, 1);
INSERT INTO department VALUES (2,'Customer Support', 3 , 1, 2);
INSERT INTO department VALUES (3,'Prosthesis', 1 , 2, 1);
INSERT INTO department VALUES (4, 'TestAssign', 2, 3, 3);

INSERT INTO employee VALUES (222, 1 , 'Michel', 'Jean', 54);
INSERT INTO employee VALUES (333, 2 , 'Philippe', 'Chandonnet', 34);
INSERT INTO employee VALUES (444, 2 , 'Etienne', 'Bellemare', 39);
INSERT INTO employee VALUES (555, 3 , 'Patricia', 'Authier', 42);
INSERT INTO employee VALUES (777, 0 , 'Too', 'Young' , 12);
INSERT INTO employee VALUES (888, 0 , 'Too', 'Old', 90);
INSERT INTO employee VALUES (445, 4 , 'Bernard', 'Toto', 50);
INSERT INTO employee VALUES (446, 4 , 'Marie', 'Toto', 45);
INSERT INTO employee VALUES (447, 4 , 'Marion', 'Toto', 48);
INSERT INTO employee VALUES (448, 0 , 'Toto', 'Toto', 47);


-- Reinit

DELETE FROM employee;
DELETE FROM department;

INSERT INTO department VALUES (0, 'Not Affected', 0 , 0, 0);
INSERT INTO department VALUES (1,'Sales', 2 , 1, 1);
INSERT INTO department VALUES (2,'Customer Support', 3 , 1, 2);
INSERT INTO department VALUES (3,'Prosthesis', 1 , 2, 1);
INSERT INTO department VALUES (4, 'TestAssign', 2, 3, 3);

INSERT INTO employee VALUES (222, 1 , 'Michel', 'Jean', 54);
INSERT INTO employee VALUES (333, 2 , 'Philippe', 'Chandonnet', 34);
INSERT INTO employee VALUES (444, 2 , 'Etienne', 'Bellemare', 39);
INSERT INTO employee VALUES (555, 3 , 'Patricia', 'Authier', 42);
INSERT INTO employee VALUES (777, 0 , 'Too', 'Young' , 12);
INSERT INTO employee VALUES (888, 0 , 'Too', 'Old', 90);
INSERT INTO employee VALUES (445, 4 , 'Bernard', 'Toto', 50);
INSERT INTO employee VALUES (446, 4 , 'Marie', 'Toto', 45);
INSERT INTO employee VALUES (447, 4 , 'Marion', 'Toto', 48);
INSERT INTO employee VALUES (448, 0 , 'Toto', 'Toto', 47);




