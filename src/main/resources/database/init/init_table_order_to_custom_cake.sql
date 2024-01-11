create table if not exists table_order_to_custom_cake
(
    order_id varchar not null,
    custom_cake_id bigint not null,
    foreign key (order_id) references table_order (order_id),
    foreign key (custom_cake_id) references table_custom_cake (custom_cake_id)
);