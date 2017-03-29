Use WinePax
CREATE TABLE [vinho].[Tipo_Vinho](
id int primary key,
descricao varchar(50)
)ON Vinho;

create table vinho.Vinho (
id int primary key,
marca varchar(50),
teor_alcoolico int,
media_repouso int,
preco float(50),
nr_garrafas int,
tipo_vinho int REFERENCES vinho.Tipo_Vinho(id) on update cascade on delete set null
)on Vinho;

CREATE TABLE propriedades.Propriedades (
id int primary key,
nome varchar(50),
regiao varchar(50),
area_total float(50),
endereco varchar(50),
nr_telefone varchar(9),
email varchar(50),
)on Propriedade;

CREATE TABLE vinha.Vinha(
id int primary key,
designacao varchar(50),
area_util float(4),
tipo_solo varchar(50),
exposicao_predominante varchar(50),
situacao_predominante varchar (50),
altitude int,
ano_plantacao int,
quantidade_esperada int,
propriedade int REFERENCES propriedades.Propriedades(id) on update cascade on delete set null
)on Vinha;

CREATE TABLE vinha.Castas (
id int primary key,
designacao varchar(50),
descricao varchar(50),
cor varchar(50),
indicador_prod int
)on Vinha;

CREATE TABLE armazem.Equipamento(
id int primary key,
designacao varchar(50),
data_aquisicao date,
ano_fabrico int,
numero_serie varchar(50),
descricao varchar(50),
anos_restantes int,
propriedade int REFERENCES propriedades.Propriedades(id) on update cascade on delete set null
)on Armazem;

CREATE TABLE propriedades.Dist_Prop(
id int primary key,
prop_1 int REFERENCES propriedades.Propriedades(id),
prop_2 int REFERENCES propriedades.Propriedades(id),
distancia float(50),
tempo_medio time
)on Propriedade;

CREATE TABLE vinha.Vinha_Casta(
id int primary key,
id_vinha int REFERENCES vinha.Vinha(id) on update cascade on delete set null,
id_casta int REFERENCES vinha.Castas(id) on update cascade on delete set null,
nr_pes_plantados int
)on Vinha;

CREATE TABLE vinho.Vinho_Casta(
id int primary key,
id_vinho int REFERENCES vinho.Vinho(id) on update cascade on delete set null,
id_casta int REFERENCES vinha.Castas(id) on update cascade on delete set null
)on Vinho;
