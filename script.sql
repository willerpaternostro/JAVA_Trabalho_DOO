CREATE TABLE operadores(
email varchar(100) not null PRIMARY KEY,
nome varchar(50),
senha varchar(100) not null,
permissaoADM boolean
)
CREATE TABLE clientes(
nome varchar(50) not null,
cpf varchar(25) not null PRIMARY KEY,
endereco varchar(100),
telefone varchar(25)
)
CREATE TABLE prestadores(
nome varchar(50) not null,
endereco varchar(100),
documento varchar(25) not null PRIMARY KEY,
telefone varchar(25),
servicoOferecido varchar(50),
valorDiaria float,
atendeUrgencia boolean
)
CREATE TABLE servicos(
id INTEGER IDENTITY PRIMARY KEY,
cpfCliente varchar(25) not null ,
documentoPrestador varchar(25) not null ,
tempoGasto double,
valorFinal float not null,
porcentagemADM double not null,
avaliacao double,
dataRealizacao varchar(10),
tipoServico varchar(25),
status boolean
)
ALTER TABLE servicos ADD FOREIGN KEY (cpfCliente) REFERENCES clientes(cpf);
ALTER TABLE servicos ADD FOREIGN KEY (documentoPrestador) REFERENCES prestadores(documento);
INSERT INTO operadores (email,nome,senha,permissaoADM) VALUES ('admin@ihomeservices.br','Admin','123456',true);
