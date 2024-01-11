REASSIGN OWNED BY guest TO postgres;  -- or some other trusted role
DROP OWNED BY guest;
drop role guest;
REASSIGN OWNED BY authorized TO postgres;  -- or some other trusted role
DROP OWNED BY authorized;
drop role authorized;
REASSIGN OWNED BY "admin" TO postgres;  -- or some other trusted role
DROP OWNED BY "admin";
drop role "admin";

create role guest with
    login
    nosuperuser
    nocreatedb
    nocreaterole
    noreplication
    password 'guest'
    connection limit -1;

grant select on
    public.table_user,
    public.table_product,
    public.table_custom_cake,
    public.table_cake_part,
    public.table_add_descr
    to guest;

grant insert on
    public.table_user
    to guest;

grant usage, select on sequence table_user_user_id_seq to guest;

create role authorized with
    login
    nosuperuser
    nocreatedb
    nocreaterole
    noreplication
    password 'authorized'
    connection limit -1;

grant select on all tables in schema public to authorized;

-- grant select on
--     public.table_user,
--     public.table_product,
--     public.table_custom_cake,
--     public.table_cake_part,
--     public.table_add_descr
--     to authorized;
--
-- grant select on
--     public.table_user,
--     public.table_product,
--     public.table_custom_cake,
--     public.table_cake_part,
--     public.table_add_descr,
--     public.table_order,
--     public.table_order_to_product,
--     public.table_order_to_custom_cake
--     to authorized;

create role admin with
    login
    nosuperuser
    nocreatedb
    nocreaterole
    noreplication
    password 'admin'
    connection limit -1;

grant all privileges on all tables in schema public to admin;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO admin;

select * from pg_roles;