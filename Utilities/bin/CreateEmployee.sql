DROP SEQUENCE serial;
drop table EMPLOYEE;
CREATE SEQUENCE serial START 101;

create table EMPLOYEE (
   id integer default nextval('serial'),
   first_name VARCHAR(20) default NULL,
   last_name  VARCHAR(20) default NULL,
   salary     INT  default NULL,
   PRIMARY KEY (id)
);
