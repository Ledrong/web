create table if not exists  table_bonus
(
    bonus_id serial primary key,
    bonus_value float not null,
    bonus_in_percent_flag boolean not null,
    bonus_start_date date not null,
    bonus_end_date date
);