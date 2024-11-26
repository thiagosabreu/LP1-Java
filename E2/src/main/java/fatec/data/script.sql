create database e2;

use e2;

create table moto (
    id int auto_increment primary key,
    marca varchar(50) not null,
    modelo varchar(50) not null,
    ano int not null,
    peso double not null,
    tem_carenagem boolean not null
);

create table carro (
    id int auto_increment primary key,
    marca varchar(50) not null,
    modelo varchar(50) not null,
    ano int not null,
    peso double not null,
    quantidade_portas int not null
);

create table caminhao (
    id int auto_increment primary key,
    marca varchar(50) not null,
    modelo varchar(50) not null,
    ano int not null,
    peso double not null,
    capacidade_carga double not null
);

create table felino (
    id int auto_increment primary key,
    nome varchar(50) not null,
    idade int not null,
    peso double not null,
    gosta_de_dormir boolean not null
);

create table aquatico (
    id int auto_increment primary key,
    nome varchar(50) not null,
    idade int not null,
    peso double not null,
    vive_em_aguas_salgadas boolean not null
);

