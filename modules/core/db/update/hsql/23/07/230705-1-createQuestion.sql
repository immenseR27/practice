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
    TEXT longvarchar,
    VARIANT1 longvarchar,
    VARIANT2 longvarchar,
    VARIANT3 longvarchar,
    VARIANT4 longvarchar,
    ANSWER varchar(255),
    --
    primary key (ID)
);