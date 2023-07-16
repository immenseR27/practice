create table PLATFORM_EMPLOYEE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    LAST_NAME varchar(255),
    FIRST_NAME varchar(255),
    FATHER_NAME varchar(255) not null,
    BIRTHDAY date,
    POSITION_ID varchar(36),
    EMPLOYMENT_DATE date,
    DISMISSAL_DATE date,
    LOGIN varchar(255),
    PASS varchar(255),
    ROLE varchar(255),
    --
    primary key (ID)
);