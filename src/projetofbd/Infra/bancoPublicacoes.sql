create database publicacoes
default character set utf8 
default collate utf8_general_ci;

use publicacoes;

create table if not exists universidade(
cod_univer int auto_increment primary key,
nome varchar(30),
sigla varchar(30),
uf varchar(2)
);


create table if not exists pesquisador (
  cod_pesq int auto_increment primary key,
  nome_pesq varchar(30),
  cod_univer int not null,
  foreign Key (cod_univer) references universidade(cod_univer) on delete cascade on update cascade
  
);

create table if not exists revista_cientifica(
cod_revista int auto_increment primary key,
nome varchar(30),
editora varchar(30),
issn varchar(10) 
);

create table if not exists artigo(
cod_artigo int auto_increment primary key,
titulo varchar(30) not null,
pag_inicial int,
pag_final int,
ano date,
volume int ,
numero int ,
cod_revista int,
nome_congresso varchar(30),
cidade_congresso varchar(30), 
data_congresso date,

foreign key (cod_revista) references revista_cientifica(cod_revista) on delete set null on update set null
);


create table if not exists autoria(
cod_artigo int not null,
cod_pesq int not null, 
posicao_autor int,
primary key (cod_artigo, cod_pesq),
foreign Key (cod_pesq) references pesquisador(cod_pesq) on delete cascade on update cascade,
foreign Key (cod_artigo) references artigo(cod_artigo)
on delete cascade on update cascade
);

create table if not exists referencia(
cod_artigo int not null, 
cod_artigo_referenciado int not null,
foreign key(cod_artigo) references artigo(cod_artigo) on delete cascade on update cascade,
foreign key(cod_artigo_referenciado) references artigo(cod_artigo)
on delete cascade on update cascade
);
