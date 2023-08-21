create extension if not exists "uuid-ossp";

create table if not exists "dummy"
(
    id                  varchar
        constraint cnaps_thing_pk primary key default uuid_generate_v4(),
    label               varchar not null
);
