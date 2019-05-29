use estate4month2019;

create table role(
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	code VARCHAR(255) NOT NULL,
	
	createddate TIMESTAMP NULL,
	modifieddate TIMESTAMP NULL,
	createdby VARCHAR(255) NULL,
	modifiedby VARCHAR(255) NULL
);


create table user (
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	fullname VARCHAR(255) NULL,
	status int NOT NULL,
	
	createddate TIMESTAMP NULL,
	modifieddate TIMESTAMP NULL,
	createdby VARCHAR(255) NULL,
	modifiedby VARCHAR(255) NULL
);

create table user_role(
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	roleid BIGINT NOT NULL,
	userid BIGINT NOT NULL
);

ALTER TABLE user_role ADD CONSTRAINT fk_userrole_role FOREIGN KEY (roleid) REFERENCES role(id);
ALTER TABLE user_role ADD CONSTRAINT fk_userrole_user FOREIGN KEY (userid) REFERENCES user(id);

CREATE TABLE building(
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255) NULL,
	ward VARCHAR(100) NULL ,
	street VARCHAR(100) NULL ,
	structure VARCHAR(100) NULL,
	numberofbasement INT NULL,
	buildingarea INT NULL,
	district VARCHAR(255) NULL,
	costrent INT NULL,
	costdescription TEXT NULL,
	servicecost VARCHAR(255) NULL,
	carcost VARCHAR(255) NULL,
	motorbikecost VARCHAR(255) NULL,
	overtimecost VARCHAR(255) NULL,
	electricitycost VARCHAR(255) NULL,
	deposit VARCHAR(255) NULL,
	payment VARCHAR(255) NULL,
	timerent VARCHAR(255) NULL,
	timedecorator VARCHAR(255) NULL,
	managername VARCHAR(255) NULL,
	managerphone VARCHAR(255) NULL,
	
	type TEXT NULL,
	
	createddate TIMESTAMP NULL,
	modifieddate TIMESTAMP NULL,
	createdby VARCHAR(255) NULL,
	modifiedby VARCHAR(255) NULL

);


create table district(
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	code VARCHAR(255) NOT NULL,
	
	createddate TIMESTAMP NULL,
	modifieddate TIMESTAMP NULL,
	createdby VARCHAR(255) NULL,
	modifiedby VARCHAR(255) NULL
);

create table assignmentbuilding(
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	buildingid BIGINT NOT NULL,
	staffid BIGINT NOT NULL
	
);

ALTER TABLE assignmentbuilding ADD CONSTRAINT fk_assignmentbuilding_user FOREIGN KEY (staffid) REFERENCES user(id);
ALTER TABLE assignmentbuilding ADD CONSTRAINT fk_assignmentbuilding_building FOREIGN KEY (buildingid) REFERENCES building(id);








