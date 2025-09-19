drop table if exists usuarios;
create table usuarios (
    id bigint auto_increment primary key,
    nome varchar(255),
    login varchar(255),
    senha varchar(255)
);
drop table if exists clientes;
create table clientes (
    id bigint auto_increment primary key,
    cpf varchar(14),
    nome varchar(255),
    email varchar(255),
    telefone varchar(20),
    logradouro varchar(100),
    bairro varchar(100),
    cidade varchar(50),
    uf char(2),
    cep char(9),
    usuario_id bigint,
    foreign key (usuario_id) references usuarios (id)
);
drop table if exists categoria_produto;
drop table if exists categorias;
create table categorias (
    id bigint auto_increment primary key,
    nome varchar(100),
    status boolean
);
drop table if exists produtos;
create table produtos (
    id bigint auto_increment primary key,
    nome varchar(100),
    preco decimal(10, 2),
    descricao varchar(1000),
    quantidade integer
);
create table categoria_produto (
    categoria_id bigint not null,
    produto_id bigint not null,
    foreign key (categoria_id) references categorias (id),
    foreign key (produto_id) references produtos (id),
    primary key (categoria_id, produto_id)
);