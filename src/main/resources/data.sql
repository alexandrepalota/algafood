insert into tb_cozinha (id, nm_cozinha) values (1, 'Tailandesa');
insert into tb_cozinha (id, nm_cozinha) values (2, 'Indiana');

insert into tb_restaurante (nm_restaurante, vl_frete, cozinha_id) values ('India Food', '12.00', 2);
insert into tb_restaurante (nm_restaurante, vl_frete, cozinha_id) values ('Palácio Tailandês', '8.00', 1);
insert into tb_restaurante (nm_restaurante, vl_frete, cozinha_id) values ('Prato Exótico', '9.00', 1);
insert into tb_restaurante (nm_restaurante, vl_frete, cozinha_id) values ('Namastê', '0.00', 2);

insert into tb_estado (id, nm_estado) values (1, 'Rio Grande do Sul');
insert into tb_estado (id, nm_estado) values (2, 'Santa Catarina');
insert into tb_estado (id, nm_estado) values (3, 'Paraná');

insert into tb_cidade (id, nm_cidade, estado_id) values (1, 'Rio Grande', 1);
insert into tb_cidade (id, nm_cidade, estado_id) values (2, 'Pelotas', 1);
insert into tb_cidade (id, nm_cidade, estado_id) values (3, 'Erechim', 1);
insert into tb_cidade (id, nm_cidade, estado_id) values (4, 'Florianópolis', 2);
insert into tb_cidade (id, nm_cidade, estado_id) values (5, 'Concórdia', 2);
insert into tb_cidade (id, nm_cidade, estado_id) values (6, 'Curitiba', 3);
insert into tb_cidade (id, nm_cidade, estado_id) values (7, 'Ponta Grossa', 3);
insert into tb_cidade (id, nm_cidade, estado_id) values (8, 'Londrina', 3);

insert into tb_forma_pagamento (id, nm_forma_pagamento) values (1, 'Cartão de crédito');
insert into tb_forma_pagamento (id, nm_forma_pagamento) values (2, 'Cartão de débito');
insert into tb_forma_pagamento (id, nm_forma_pagamento) values (3, 'Dinheiro');

insert into tb_permissao (id, nm_permissao, ds_permissao) values (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into tb_permissao (id, nm_permissao, ds_permissao) values (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');