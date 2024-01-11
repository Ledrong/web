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