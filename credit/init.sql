create database inteca_work;

create sequence hibernate_sequence;


create table credits
(
    id            bigint not null
        constraint credits_pkey
            primary key,
    name          varchar(100),
    credit_number uuid
);


create table products
(
    id            bigint not null
        constraint products_pkey
            primary key,
    name          varchar(100),
    value         integer,
    credit_number uuid
);

create table customers
(
    id              bigint not null
        constraint customers_pkey
            primary key,
    first_name      varchar(50),
    surname         varchar(50),
    identity_number bigint,
    credit_number   uuid
);
