--liquibase formatted sql
--changeset <mysql>:<create-heroes-table>

create table heroes
(
    id int not null AUTO_INCREMENT,
    name varchar(255),
    primary key (id)
);

--rollback DROP TABLE heroes;
