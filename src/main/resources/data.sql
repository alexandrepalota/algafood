insert into tb_cozinha (nm_cozinha) values ('Tailandesa');
insert into tb_cozinha (nm_cozinha) values ('Indiana');

insert into tb_restaurante (nm_restaurante, vl_frete, cozinha_id) values ('India Food', '12.00', (select id from tb_cozinha where nm_cozinha = 'Indiana'));
insert into tb_restaurante (nm_restaurante, vl_frete, cozinha_id) values ('Palácio Tailandês', '8.00', (select id from tb_cozinha where nm_cozinha = 'Tailandesa'));
insert into tb_restaurante (nm_restaurante, vl_frete, cozinha_id) values ('Prato Exótico', '9.00', (select id from tb_cozinha where nm_cozinha = 'Tailandesa'));
insert into tb_restaurante (nm_restaurante, vl_frete, cozinha_id) values ('Namastê', '0.00', (select id from tb_cozinha where nm_cozinha = 'Indiana'));

insert into tb_estado (nm_estado) values ('Rio Grande do Sul');
insert into tb_estado (nm_estado) values ('Santa Catarina');
insert into tb_estado (nm_estado) values ('Paraná');

insert into tb_cidade (id, nm_cidade, estado_id) values (1, 'Rio Grande', (select id from tb_estado where nm_estado = 'Rio Grande do Sul'));
insert into tb_cidade (id, nm_cidade, estado_id) values (2, 'Pelotas', (select id from tb_estado where nm_estado = 'Rio Grande do Sul'));
insert into tb_cidade (id, nm_cidade, estado_id) values (3, 'Erechim', (select id from tb_estado where nm_estado = 'Rio Grande do Sul'));
insert into tb_cidade (id, nm_cidade, estado_id) values (4, 'Florianópolis', (select id from tb_estado where nm_estado = 'Santa Catarina'));
insert into tb_cidade (id, nm_cidade, estado_id) values (5, 'Concórdia', (select id from tb_estado where nm_estado = 'Santa Catarina'));
insert into tb_cidade (id, nm_cidade, estado_id) values (6, 'Curitiba', (select id from tb_estado where nm_estado = 'Paraná'));
insert into tb_cidade (id, nm_cidade, estado_id) values (7, 'Ponta Grossa', (select id from tb_estado where nm_estado = 'Paraná'));
insert into tb_cidade (id, nm_cidade, estado_id) values (8, 'Londrina', (select id from tb_estado where nm_estado = 'Paraná'));

insert into tb_forma_pagamento (id, nm_forma_pagamento) values (1, 'Cartão de crédito');
insert into tb_forma_pagamento (id, nm_forma_pagamento) values (2, 'Cartão de débito');
insert into tb_forma_pagamento (id, nm_forma_pagamento) values (3, 'Dinheiro');

insert into tb_permissao (id, nm_permissao, ds_permissao) values (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into tb_permissao (id, nm_permissao, ds_permissao) values (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');