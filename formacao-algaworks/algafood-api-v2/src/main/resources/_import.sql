insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');
insert into cozinha (id, nome) values (3, 'Argentina');
insert into cozinha (id, nome) values (4, 'Brasileira');

insert into estado (id, nome) values (1, 'Minas Gerais');
insert into estado (id, nome) values (2, 'São Paulo');
insert into estado (id, nome) values (3, 'Ceará');

insert into cidade (id, nome, estado_id) values (1, 'Uberlândia', 1);
insert into cidade (id, nome, estado_id) values (2, 'Belo Horizonte', 1);
insert into cidade (id, nome, estado_id) values (3, 'São Paulo', 2);
insert into cidade (id, nome, estado_id) values (4, 'Campinas', 2);
insert into cidade (id, nome, estado_id) values (5, 'Fortaleza', 3);

insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro) values (1, 'Thai Gourmet', 10, 1, now(), now(), 1, '38400-999', 'Rua João Pinheiro', '1000', 'Centro');
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (2, 'Thai Delivery', 9.50, 1, now(), now());
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (3, 'Tuk Tuk Comida Indiana', 15, 2, now(), now());
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (4, 'Java Steakhouse', 12, 3, now(), now());
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (5, 'Lanchonete do Tio Sam', 11, 4, now(), now());
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (6, 'Bar da Maria', 6, 4, now(), now());

insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (1, 'Porco com molho agridoce', 'Deliciosa carne suína ao molho especial', 78.90, true, 1);
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (2, 'Camarão tailandês', '16 camarões grandes ao molho picante', 110, true, 1);
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (3, 'Salada picante com carne grelhada', 'Salada de folhas com cortes finos de carne bovina grelhada e nosso molho especial de pimenta vermelha', 87.20, true, 2);
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (4, 'Garlic Naan', 'Pão tradicional indiano com cobertura de alho', 21, true, 3);
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (5, 'Murg Curry', 'Cubos de frango preparados com molho curry e especiarias', 43, true, 3);
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (6, 'Bife Ancho', 'Corte macio e suculento, com dois dedos de espessura, retirado da parte dianteira do contrafilé', 79, true, 4);
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (7, 'T-Bone', 'Corte muito saboroso, com um osso em formato de T, sendo de um lado o contrafilé e do outro o filé mignon', 89, true, 4);
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (8, 'Sanduíche X-Tudo', 'Sandubão com muito queijo, hamburger bovino, bacon, ovo, salada e maionese', 19, true, 5);
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (9, 'Espetinho de Cupim', 'Acompanha farinha, mandioca e vinagrete', 8, true, 6);

insert into forma_pagamento (id, descricao) values (1, 'Cartão de crédito');
insert into forma_pagamento (id, descricao) values (2, 'Cartão de débito');
insert into forma_pagamento (id, descricao) values (3, 'Dinheiro');

insert into permissao (id, nome, descricao) values (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into permissao (id, nome, descricao) values (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');

insert into grupo (id, nome) values (1, 'Administrador');
insert into grupo (id, nome) values (2, 'Usuario');

insert into usuario (id, nome, email, senha, data_cadastro) values (1, 'Lucas Guimaraes', 'lucasguiamrasr12321@gmail.com', 'Lucas123', now());
insert into usuario (id, nome, email, senha, data_cadastro) values (2, 'Joao Carlos', 'joaocarlos2010@gmail.com', 'Joao123', now());
insert into usuario (id, nome, email, senha, data_cadastro) values (3, 'Pedro Cleber', 'cleber.pedro@gmail.com', 'Pedro123', now());

insert into grupo_permissao (grupo_id, permissao_id) values (2, 1), (1, 1), (1, 2);

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1), (1, 2), (1, 3), (2, 3), (3, 2), (3, 3), (4, 1), (4, 2), (5, 1), (5, 2), (6, 3);

select setval('cozinha_id_seq', (select max(id) from cozinha));
select setval('restaurante_id_seq', (select max(id) from restaurante));
select setval('estado_id_seq', (select max(id) from estado));
select setval('cidade_id_seq', (select max(id) from cidade));
select setval('forma_pagamento_id_seq', (select max(id) from forma_pagamento));
select setval('permissao_id_seq', (select max(id) from permissao));
select setval('grupo_id_seq', (select max(id) from grupo));
select setval('usuario_id_seq', (select max(id) from usuario));
select setval('produto_id_seq', (select max(id) from produto));