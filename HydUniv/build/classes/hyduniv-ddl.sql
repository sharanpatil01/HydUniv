
drop table STUDENT;

CREATE TABLE STUDENT (
	id VARCHAR(10),
	firstname VARCHAR(20),
	lastname VARCHAR(20),
	citizenship VARCHAR(10)
);

INSERT INTO STUDENT (id, firstname, lastname, citizenship)values ("1010", "Ajay","Verma", "Indian");
INSERT INTO STUDENT (id, firstname, lastname, citizenship)values ("1020", "Vijay","Sharma", "Indian");
INSERT INTO STUDENT (id, firstname, lastname, citizenship)values ("1030", "Manoj","Sharma", "Indian");
INSERT INTO STUDENT (id, firstname, lastname, citizenship)values ("1040", "Prem","Sharma", "Indian");
INSERT INTO STUDENT (id, firstname, lastname, citizenship)values ("1050", "Suman","Sharma", "Indian");

commit;

select * from STUDENT;

	


