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