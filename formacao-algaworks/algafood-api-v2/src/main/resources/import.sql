insert into cozinha (id, nome) values (1, 'Tailandesa')
insert into cozinha (id, nome) values (2, 'Indiana')

insert into restaurante (nome, taxa_frete, cozinha_id) values ('Lukas', 3, 1)
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Caios', 10, 2)

insert into estado (id, nome) values (1, 'Rio de Janeiro')
insert into estado (id, nome) values (2, 'São Paulo')

insert into cidade (nome, estado_id) values ('Petrópolis', 1)
insert into cidade (nome, estado_id) values ('Campinas', 2)