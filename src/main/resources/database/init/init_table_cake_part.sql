create table if not exists table_cake_part
(
    cake_part_id serial primary key,
    cake_part_add_descr_id bigint,
    cake_part_name varchar(100) not null,
    cake_part_cost double precision,
    cake_part_type int,
    foreign key (cake_part_add_descr_id) references table_add_descr (add_descr_id)
);