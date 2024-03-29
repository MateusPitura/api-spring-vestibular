create database if not exists vestibulares;

use vestibulares;

create table if not exists universidades(
    id bigint auto_increment not null,
    nome varchar(128) not null,
    sigla varchar(16) not null,
    url_image varchar(256) not null,
    primary key(id)
);

create table if not exists eventos(
    id bigint auto_increment not null,
    data timestamp not null,
    descricao varchar(255) not null,
    id_universidade bigint not null,
    primary key(id),
    foreign key(id_universidade) references universidades(id)
);

create table if not exists avisos(
    id bigint auto_increment not null,
    data date not null,
    title varchar(128) not null,
    descricao varchar(256) not null,
    url varchar(256) not null,
    id_universidade bigint not null,
    primary key(id),
    foreign key(id_universidade) references universidades(id)
);