USE db_mvclogin;

DROP TABLE IF EXISTS user;
CREATE TABLE IF NOT EXISTS user (
	iduser int primary key auto_increment,
    name varchar(255),
    password varchar(255),
    role varchar(8),
    username varchar(255)
);