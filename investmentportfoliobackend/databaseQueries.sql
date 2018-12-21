

CREATE TABLE customerdetails (
    id IDENTITY,
    customername varchar(255),
    customeremail varchar(255),
    customerphone varchar(255),
    customerpan varchar(255),
    customerpwd varchar(255),
    is_active BOOLEAN,
    
    CONSTRAINT pk_customerdetails_id PRIMARY KEY(id)
);


CREATE TABLE fundcategory (
    id IDENTITY,
    fundname varchar(255),
    
    CONSTRAINT pk_fundcategory_id PRIMARY KEY(id)
);

ALTER TABLE fundcategory
ADD is_active BOOLEAN;

CREATE TABLE fundscheme (
    id IDENTITY,
    fundschemename varchar(255),
	fundcategoryid int ,
	
    CONSTRAINT pk_fundscheme_id PRIMARY KEY(id)
);

ALTER TABLE fundscheme
ADD is_active BOOLEAN;

CREATE TABLE lifeinsurance (
    id IDENTITY,
    policydate varchar(255),
    amount int,
    policyperiod int,
    schemename varchar(255),
    policynumber varchar(255),
    sumassured int,
	policylastdate varchar(255),    
	customername varchar(255),
	is_active BOOLEAN,
	
    CONSTRAINT pk_lifeinsurance_id PRIMARY KEY(id)
);