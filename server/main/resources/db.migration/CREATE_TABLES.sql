DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS confimation_token;
DROP TABLE IF EXISTS hibernate_sequence;
DROP TABLE IF EXISTS discount;

CREATE TABLE discount (
    id          int auto_increment PRIMARY KEY NOT NULL,
    name        VARCHAR(50) NOT NULL UNIQUE,
    discount    int NOT NULL
);

CREATE TABLE users(
    iduser   int auto_increment PRIMARY KEY NOT NULL,
    email    VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(64) NOT NULL,
    role     varchar(20) NOT NULL,
    active   int         not null
);

CREATE TABLE confimation_token (
    id int auto_increment primary key not null,
    token VARCHAR(255) NOT NULL,
    created TIMESTAMP NOT NULL,
    expired TIMESTAMP NOT NULL,
    CONFIRMED TIMESTAMP,
    user_iduser int REFERENCES user(iduser)
);

CREATE SEQUENCE public.hibernate_sequence INCREMENT 1 START 1 MINVALUE 1;