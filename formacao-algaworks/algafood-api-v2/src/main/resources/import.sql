insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');

insert into restaurante (nome, taxa_frete, cozinha_id) values ('Lukas', 3, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Caios', 10, 2);

insert into estado (id, nome) values (1, 'Rio de Janeiro');
insert into estado (id, nome) values (2, 'São Paulo');

insert into cidade (nome, estado_id) values ('Petrópolis', 1);
insert into cidade (nome, estado_id) values ('Campinas', 2);

insert into forma_pagamento (id, descricao) values (1, 'MasterCard Crédito');
insert into forma_pagamento (id, descricao) values (2, 'Visa Débito');

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1), (1, 2), (2, 1), (2, 2);

select setval('cozinha_id_seq', (select max(id) from cozinha));
select setval('restaurante_id_seq', (select max(id) from restaurante));
select setval('estado_id_seq', (select max(id) from estado));
select setval('cidade_id_seq', (select max(id) from cidade));
select setval('forma_pagamento_id_seq', (select max(id) from forma_pagamento));