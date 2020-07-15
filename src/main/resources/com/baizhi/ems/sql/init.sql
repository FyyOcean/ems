create table t_user(
 id varchar(40) PRIMARY key,
 username VARCHAR(40),
 realname VARCHAR(40),
 password varchar(60),
 sex varchar(4)
);

create table t_emp(
 id varchar(40) PRIMARY key,
 name VARCHAR(40),
 salary DOUBLE(7,2),
 age int(3)
);