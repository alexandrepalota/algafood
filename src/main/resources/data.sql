insert into tb_cozinha (nm_cozinha) values ('Tailandesa');
insert into tb_cozinha (nm_cozinha) values ('Indiana');

insert into tb_estado (nm_estado) values ('Rio Grande do Sul');
insert into tb_estado (nm_estado) values ('Santa Catarina');
insert into tb_estado (nm_estado) values ('Paraná');

insert into tb_cidade (nm_cidade, estado_id) values ('Rio Grande', (select id from tb_estado where nm_estado = 'Rio Grande do Sul'));
insert into tb_cidade (nm_cidade, estado_id) values ('Pelotas', (select id from tb_estado where nm_estado = 'Rio Grande do Sul'));
insert into tb_cidade (nm_cidade, estado_id) values ('Erechim', (select id from tb_estado where nm_estado = 'Rio Grande do Sul'));
insert into tb_cidade (nm_cidade, estado_id) values ('Florianópolis', (select id from tb_estado where nm_estado = 'Santa Catarina'));
insert into tb_cidade (nm_cidade, estado_id) values ('Concórdia', (select id from tb_estado where nm_estado = 'Santa Catarina'));
insert into tb_cidade (nm_cidade, estado_id) values ('Curitiba', (select id from tb_estado where nm_estado = 'Paraná'));
insert into tb_cidade (nm_cidade, estado_id) values ('Ponta Grossa', (select id from tb_estado where nm_estado = 'Paraná'));
insert into tb_cidade (nm_cidade, estado_id) values ('Londrina', (select id from tb_estado where nm_estado = 'Paraná'));

insert into tb_restaurante (nm_restaurante, vl_frete, cozinha_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro, endereco_cidade_id, data_cadastro, data_atualizacao) values ('India Food', '12.00', (select id from tb_cozinha where nm_cozinha = 'Indiana'), '96215570', 'Rua do Mirante', '251', 'Fundos', 'Parque Marinha', 1, current_timestamp(0) at time zone 'utc', current_timestamp(0) at time zone 'utc');
insert into tb_restaurante (nm_restaurante, vl_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Palácio Tailandês', '8.00', (select id from tb_cozinha where nm_cozinha = 'Tailandesa'), now(), now());
insert into tb_restaurante (nm_restaurante, vl_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Prato Exótico', '9.00', (select id from tb_cozinha where nm_cozinha = 'Tailandesa'), now(), now());
insert into tb_restaurante (nm_restaurante, vl_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Namastê', '0', (select id from tb_cozinha where nm_cozinha = 'Indiana'), now(), now());

insert into tb_forma_pagamento (nm_forma_pagamento) values ('Cartão de crédito');
insert into tb_forma_pagamento (nm_forma_pagamento) values ('Cartão de débito');
insert into tb_forma_pagamento (nm_forma_pagamento) values ('Dinheiro');

insert into tb_permissao (nm_permissao, ds_permissao) values ('CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into tb_permissao (nm_permissao, ds_permissao) values ('EDITAR_COZINHAS', 'Permite editar cozinhas');

insert into rl_restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1), (1, 2), (1, 3), (2, 1), (2, 2), (3, 3), (4, 1), (4, 3);