create table inventory (
id BIGSERIAL        PRIMARY KEY NOT NULL,
code                varchar(100) not null,
product             varchar(100) not null,
entrance            int4 not null,
exit                int4 not null,
balance             int4 not null check (balance >= 0),
date_registration   timestamp not null,
version             int4  not null,
unique(code)
);