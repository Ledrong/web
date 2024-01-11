create table if not exists table_product_to_bonus
(
    product_id bigint not null,
    bonus_id bigint not null,
    foreign key (product_id) references table_product (product_id),
    foreign key (bonus_id) references table_bonus (bonus_id)
);