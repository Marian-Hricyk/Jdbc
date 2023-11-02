
CREATE TABLE worker (
    ID int primary key not null unique,
    "NAME" varchar(1000) NOT NULL CHECK (LENGTH("NAME") >= 2 AND LENGTH("NAME") <= 1000),
    BIRTHDAY date CHECK (EXTRACT(YEAR FROM BIRTHDAY) > 1900),
    "LEVEL" varchar(20) NOT NULL CHECK ("LEVEL" IN ('Trainee', 'Junior', 'Middle', 'Senior')),
    SALARY integer CHECK (SALARY >= 100 AND SALARY <= 100000)
);


CREATE TABLE client (
    ID int primary key not null unique,
    "NAME" varchar(1000) NOT NULL CHECK (LENGTH("NAME") >= 2 AND LENGTH("NAME") <= 1000)
);


CREATE TABLE project (
    ID int primary key not null unique,
    CLIENT_ID integer,
    START_DATE date,
    FINISH_DATE date,
    FOREIGN KEY (CLIENT_ID) REFERENCES client (ID)
);


CREATE TABLE project_worker (
    PROJECT_ID integer,
    WORKER_ID integer,
    PRIMARY KEY (PROJECT_ID, WORKER_ID),
    FOREIGN KEY (PROJECT_ID) REFERENCES project (ID),
    FOREIGN KEY (WORKER_ID) REFERENCES worker (ID)
);
