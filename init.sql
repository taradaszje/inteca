create sequence hibernate_sequence;

create table credits
(
    id            bigint not null
        constraint credits_pkey
            primary key,
    name          varchar(100),
    credit_id uuid
);


create table products
(
    id            bigint not null
        constraint products_pkey
            primary key,
    name          varchar(100),
    value         integer,
    credit_id uuid
);

create table customers
(
    id              bigint not null
        constraint customers_pkey
            primary key,
    first_name      varchar(50),
    surname         varchar(50),
    identity_number bigint,
    credit_id   uuid
);

insert into credits values (nextval('hibernate_sequence'),'Kredyt dla typa', '9d783bf4-c64e-11e9-88b6-0c54a52d7951');
insert into customers values (nextval('hibernate_sequence'),'Jan','Nowak',95091800000,'9d783bf4-c64e-11e9-88b6-0c54a52d7951');
insert into products values (nextval('hibernate_sequence'),'Kredyt studencki',10000,'9d783bf4-c64e-11e9-88b6-0c54a52d7951')