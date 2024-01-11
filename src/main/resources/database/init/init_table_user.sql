create table if not exists  table_user
(
    user_id serial primary key,
    user_login      varchar(255) not null,
    user_password   varchar(255) not null,
    user_name       varchar(128) not null,
    user_surname    varchar(128) not null,
    user_lastname   varchar(128) not null,
    user_address_street varchar not null,
    user_address_city varchar not null,
    user_address_zip varchar not null,
    user_regdate    date         not null,
    user_email      varchar,
    user_tariff_plan integer,
    user_role varchar(128) not null
);