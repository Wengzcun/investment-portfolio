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