-- begin PLATFORM_CHAPTER
create table PLATFORM_CHAPTER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NUMBER integer,
    NAME varchar(255),
    COURSE_ID varchar(36),
    --
    primary key (ID)
)^
-- end PLATFORM_CHAPTER
-- begin PLATFORM_POSITION
create table PLATFORM_POSITION (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CODE integer,
    NAME varchar(255),
    --
    primary key (ID)
)^
-- end PLATFORM_POSITION
-- begin PLATFORM_QUESTION
create table PLATFORM_QUESTION (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CHAPTER_ID varchar(36),
    TEXT longvarchar,
    VARIANT1 longvarchar,
    VARIANT2 longvarchar,
    VARIANT3 longvarchar,
    VARIANT4 longvarchar,
    ANSWER integer,
    --
    primary key (ID)
)^
-- end PLATFORM_QUESTION
-- begin PLATFORM_EMPLOYEE_COURSE
create table PLATFORM_EMPLOYEE_COURSE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    EMPLOYEE_ID varchar(36),
    COURSE_ID varchar(36),
    START_DATETIME timestamp,
    END_DATETIME timestamp,
    COURSE_STATUS integer,
    PROGRESS integer,
    EXAM_STATUS integer,
    EXAM_SCORE double precision,
    --
    primary key (ID)
)^
-- end PLATFORM_EMPLOYEE_COURSE
-- begin PLATFORM_COURSE
create table PLATFORM_COURSE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    EMPLOYEE_ID varchar(36),
    SOURCE varchar(255),
    SIZE integer,
    --
    primary key (ID)
)^
-- end PLATFORM_COURSE
-- begin PLATFORM_EMPLOYEE
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
    FATHER_NAME varchar(255),
    BIRTHDAY date,
    POSITION_ID varchar(36),
    EMPLOYMENT_DATE date,
    DISMISSAL_DATE date,
    LOGIN varchar(255),
    PASS varchar(255),
    ROLE varchar(255),
    --
    primary key (ID)
)^
-- end PLATFORM_EMPLOYEE
-- begin PLATFORM_EMPLOYEE_CHAPTER
create table PLATFORM_EMPLOYEE_CHAPTER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    EMPLOYEE_ID varchar(36),
    CHAPTER_ID varchar(36),
    SCORE double precision,
    --
    primary key (ID)
)^
-- end PLATFORM_EMPLOYEE_CHAPTER
