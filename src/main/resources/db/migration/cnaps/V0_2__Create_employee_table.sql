create extension if not exists "uuid-ossp";

create table if not exists "employee"
(
    id                  varchar
        constraint employee_pk primary key default uuid_generate_v4(),
    cnaps               varchar not null check ( cnaps ~ '^[A-Za-z0-9]+$' ),
    end_to_end_id       varchar not null
);
