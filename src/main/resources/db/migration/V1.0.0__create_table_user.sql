CREATE SCHEMA IF NOT EXISTS teste;

create table teste.tb_user (cod_user bigserial, cpf varchar(11) not null, email varchar(50), name varchar(80) not null, primary key (cod_user));
alter table if exists teste.tb_user drop constraint if exists UK869sa3rebuf3nm0d4jwxdtouk;
alter table if exists teste.tb_user add constraint UK869sa3rebuf3nm0d4jwxdtouk unique (cpf);
