create table if not exists table_order_to_product
(
    order_id varchar not null,
    product_id bigint not null,
    foreign key (order_id) references table_order (order_id),
    foreign key (product_id) references table_product (product_id)
);