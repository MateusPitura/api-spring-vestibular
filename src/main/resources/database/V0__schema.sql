create database if not exists vestibulares;

use vestibulares;

create table if not exists universidades(
    id bigint auto_increment not null,
    nome varchar(128),
    sigla varchar(16),
    primary key(id)
);

create table if not exists eventos(
    id bigint auto_increment not null,
    data timestamp,
    descricao varchar(255),
    id_universidade bigint not null,
    primary key(id),
    foreign key(id_universidade) references universidades(id)
);

create table if not exists avisos(
    id bigint auto_increment not null,
    data timestamp,
    descricao varchar(255),
    url varchar(255),
    id_universidade bigint not null,
    primary key(id),
    foreign key(id_universidade) references universidades(id)
);