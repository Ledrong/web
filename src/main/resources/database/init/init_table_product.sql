create table if not exists table_product
(
    product_id serial primary key,
    product_add_descr_id bigint not null,
    product_name varchar(100) not null,
    product_cost double precision,
    product_img_name varchar
);