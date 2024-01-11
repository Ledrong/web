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