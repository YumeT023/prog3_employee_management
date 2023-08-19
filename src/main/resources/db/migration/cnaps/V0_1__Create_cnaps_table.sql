create extension if not exists "uuid-ossp";

create table if not exists "cnaps"
(
    id                  varchar
        constraint cnaps_pk primary key default uuid_generate_v4(),
    number          varchar
);