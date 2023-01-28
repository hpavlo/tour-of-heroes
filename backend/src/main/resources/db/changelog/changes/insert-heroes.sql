--liquibase formatted sql
--changeset <mysql>:<insert-heroes>

insert into heroes (name)
values ('Bombasto'),
       ('Magneta'),
       ('Dr. IQ'),
       ('Tornado'),
       ('RubberMan'),
       ('Celeritas'),
       ('Magma'),
       ('Dr. Nice');

--rollback DELETE FROM heroes;
