create table if not exists table_part_cake_to_bonus(
    part_cake_id bigint not null,
    bonus_id bigint not null,
    foreign key (part_cake_id) references table_cake_part (cake_part_id),
    foreign key (bonus_id) references table_bonus (bonus_id)
);