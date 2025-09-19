INSERT INTO usuarios (nome, login, senha)
VALUES (
        'João Silva',
        'joao.silva@example.com',
        '$2a$10$iqgT9I8BdrQTE4InATWGyuYmnZmtEflyIJbh4REw9RvsrTg015Jxm'
    ),
    (
        'Maria Oliveira',
        'maria.oliveira@example.com',
        '$2a$10$iqgT9I8BdrQTE4InATWGyuYmnZmtEflyIJbh4REw9RvsrTg015Jxm'
    ),
    (
        'Carlos Souza',
        'carlos.souza@example.com',
        '$2a$10$iqgT9I8BdrQTE4InATWGyuYmnZmtEflyIJbh4REw9RvsrTg015Jxm'
    );
insert into clientes (
        cpf,
        nome,
        email,
        telefone,
        logradouro,
        bairro,
        cidade,
        uf,
        cep,
        usuario_id
    )
values (
        '123.456.789-00',
        'João Silva',
        'joao.silva@example.com',
        '(11) 98765-4321',
        'Rua A',
        'Bairro B',
        'Cidade C',
        'SP',
        '12345-678',
        1
    ),
    (
        '987.654.321-00',
        'Maria Oliveira',
        'maria.oliveira@example.com',
        '(21) 87654-3210',
        'Avenida X',
        'Bairro Y',
        'Cidade Z',
        'RJ',
        '87654-321',
        2
    ),
    (
        '456.789.123-00',
        'Carlos Souza',
        'carlos.souza@example.com',
        '(31) 76543-2109',
        'Travessa Q',
        'Bairro W',
        'Cidade V',
        'MG',
        '65432-109',
        3
    );
insert into categorias (nome, status)
values ('Eletrônicos', true),
    ('Móveis', true),
    ('Eletrodomésticos', true),
    ('Casa', true),
    ('Informática', true),
    ('Esportes', true);
insert into produtos (nome, preco, descricao, quantidade)
values (
        'Smartphone',
        1500.00,
        'Smartphone com 4GB de RAM e 128GB de armazenamento',
        10
    ),
    (
        'Sofá',
        1200.00,
        'Sofá de 3 lugares com tecido impermeável',
        5
    ),
    (
        'Geladeira',
        2500.00,
        'Geladeira frost-free com 380 litros de capacidade',
        8
    );
insert into categoria_produto (categoria_id, produto_id)
values (1, 1),
    (2, 2),
    (3, 3),
    (4, 2),
    (4, 3);