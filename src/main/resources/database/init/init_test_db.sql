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

insert into table_user(user_login, user_password, user_name, user_surname, user_lastname, user_address_street,
                       user_address_city, user_address_zip, user_regdate, user_email, user_tariff_plan, user_role)
values ('zenya', '$2a$12$ShWWiQQvSWPOAnPudUVPSO7nZPv5yXmqa10T/Wz3Hd3guEWiBPBgy',
                               'Евгений', 'Коняев', 'Андреевич', 'Мячковский', 'Москва', '012654', '2012-12-12', 'test_value', 1, 'ROLE_ADMIN');

-----------------------------

create table if not exists  table_add_descr
(
    add_descr_id serial primary key,
    add_descr_title varchar not null,
    add_descr_descr varchar not null,
    add_descr_img_name varchar not null,
    add_descr_amount_carb float not null,
    add_descr_amount_prot float not null,
    add_descr_amount_fat float not null,
    add_descr_expiry_time_days int not null
);

create table if not exists table_product
(
    product_id serial primary key,
    product_add_descr_id bigint not null,
    product_name varchar(100) not null,
    product_cost double precision,
    product_img_name varchar
);

insert into table_add_descr(add_descr_title, add_descr_descr, add_descr_img_name, add_descr_amount_carb,
                            add_descr_amount_prot, add_descr_amount_fat, add_descr_expiry_time_days)
values ('Awesome Bread', 'some_descr', 'some_url', 5, 10, 15, 10);
insert into table_add_descr(add_descr_title, add_descr_descr, add_descr_img_name, add_descr_amount_carb,
                            add_descr_amount_prot, add_descr_amount_fat, add_descr_expiry_time_days)
values ('Awesome Baget', 'some_descr', 'some_url', 5, 10, 15, 10);

insert into table_add_descr(add_descr_title, add_descr_descr, add_descr_img_name, add_descr_amount_carb,
                            add_descr_amount_prot, add_descr_amount_fat, add_descr_expiry_time_days)
values ('AwesomeBasePart1', 'some_descr1', 'some_url1', 1, 2, 3, 4);

insert into table_add_descr(add_descr_title, add_descr_descr, add_descr_img_name, add_descr_amount_carb,
                            add_descr_amount_prot, add_descr_amount_fat, add_descr_expiry_time_days)
values ('AwesomeBasePart2', 'some_descr2', 'some_url2', 3, 2, 1, 5);

insert into table_add_descr(add_descr_title, add_descr_descr, add_descr_img_name, add_descr_amount_carb,
                            add_descr_amount_prot, add_descr_amount_fat, add_descr_expiry_time_days)
values ('AwesomeFillingPart1', 'some_descr3', 'some_url2', 3, 3, 3, 5);

insert into table_add_descr(add_descr_title, add_descr_descr, add_descr_img_name, add_descr_amount_carb,
                            add_descr_amount_prot, add_descr_amount_fat, add_descr_expiry_time_days)
values ('AwesomeFillingPart2', 'some_descr4', 'some_url2', 1, 1, 1, 5);

insert into table_add_descr(add_descr_title, add_descr_descr, add_descr_img_name, add_descr_amount_carb,
                            add_descr_amount_prot, add_descr_amount_fat, add_descr_expiry_time_days)
values ('AwesomeCreamPart1', 'some_descr5', 'some_url3', 3, 3, 3, 5);

insert into table_add_descr(add_descr_title, add_descr_descr, add_descr_img_name, add_descr_amount_carb,
                            add_descr_amount_prot, add_descr_amount_fat, add_descr_expiry_time_days)
values ('AwesomeCreamPart2', 'some_descr5', 'some_url3', 3, 0, 0, 5);

insert into table_product(product_add_descr_id, product_name, product_cost, product_img_name)
values (1, 'Bread', 15.99, 'some_url');
insert into table_product(product_add_descr_id, product_name, product_cost, product_img_name)
values (2, 'Baget', 19.99, 'some_url_2');

----------------------------------

create table if not exists table_cake_part
(
    cake_part_id serial primary key,
    cake_part_add_descr_id bigint,
    cake_part_name varchar(100) not null,
    cake_part_cost double precision,
    cake_part_type int,
    foreign key (cake_part_add_descr_id) references table_add_descr (add_descr_id)
);

create table if not exists table_custom_cake
(
    custom_cake_id serial primary key,
    custom_cake_base_part_id bigint not null,
    custom_cake_filling_part_id bigint not null,
    custom_cake_cream_part_id bigint not null,
    foreign key (custom_cake_base_part_id) references table_cake_part (cake_part_id),
    foreign key (custom_cake_filling_part_id) references table_cake_part (cake_part_id),
    foreign key (custom_cake_cream_part_id) references table_cake_part (cake_part_id)
);

insert into table_cake_part(cake_part_add_descr_id, cake_part_name, cake_part_cost, cake_part_type)
values (3, 'Base1', 50, 1);
insert into table_cake_part(cake_part_add_descr_id, cake_part_name, cake_part_cost, cake_part_type)
values (4, 'Base2', 51, 1);

insert into table_cake_part(cake_part_add_descr_id, cake_part_name, cake_part_cost, cake_part_type)
values (5, 'Filling1', 25, 2);
insert into table_cake_part(cake_part_add_descr_id, cake_part_name, cake_part_cost, cake_part_type)
values (6, 'Filling2', 26, 2);

insert into table_cake_part(cake_part_add_descr_id, cake_part_name, cake_part_cost, cake_part_type)
values (7, 'Cream1', 15, 3);
insert into table_cake_part(cake_part_add_descr_id, cake_part_name, cake_part_cost, cake_part_type)
values (8, 'Cream2', 16, 3);

insert into table_custom_cake(custom_cake_base_part_id, custom_cake_filling_part_id, custom_cake_cream_part_id)
values (1, 3, 5);
insert into table_custom_cake(custom_cake_base_part_id, custom_cake_filling_part_id, custom_cake_cream_part_id)
values (1, 4, 5);
insert into table_custom_cake(custom_cake_base_part_id, custom_cake_filling_part_id, custom_cake_cream_part_id)
values (2, 3, 6);

-------------------------------------------------------------------------------------

create table if not exists  table_order
(
    order_id varchar primary key,
    order_user_id bigint not null,
    order_date_create timestamp not null,
    order_date_expiry date,
    order_address_street varchar not null,
    order_address_city varchar not null,
    order_address_zip varchar not null,
    order_description varchar(300),
    order_status_code int,
    foreign key (order_user_id) references table_user (user_id)
);

create table if not exists table_order_to_product
(
    order_id varchar not null,
    product_id bigint not null,
    foreign key (order_id) references table_order (order_id),
    foreign key (product_id) references table_product (product_id)
);

create table if not exists table_order_to_custom_cake
(
    order_id varchar not null,
    custom_cake_id bigint not null,
    foreign key (order_id) references table_order (order_id),
    foreign key (custom_cake_id) references table_custom_cake (custom_cake_id)
);

insert into table_order(order_id, order_user_id, order_date_create, order_date_expiry, order_address_street,
                        order_address_city, order_address_zip, order_description, order_status_code)
VALUES ('abc1', 1, now(), now(), 'first_street', 'some_city_1', '000111', '', 1);
insert into table_order(order_id, order_user_id, order_date_create, order_date_expiry, order_address_street,
                        order_address_city, order_address_zip, order_description, order_status_code)
VALUES ('abc2', 1, now(), now(), 'second_street', 'some_city_1', '111000', '', 2);

insert into table_order_to_product(order_id, product_id) VALUES ('abc1', 1);
insert into table_order_to_product(order_id, product_id) VALUES ('abc1', 1);
insert into table_order_to_product(order_id, product_id) VALUES ('abc1', 2);

insert into table_order_to_product(order_id, product_id) VALUES ('abc2', 1);
insert into table_order_to_custom_cake(order_id, custom_cake_id) VALUES ('abc2', 2);
insert into table_order_to_custom_cake(order_id, custom_cake_id) VALUES ('abc2', 3);
