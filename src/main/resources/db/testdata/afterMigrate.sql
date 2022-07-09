delete from tb_produto;
delete from tb_restaurante_forma_pagamento;
delete from tb_restaurante;
delete from tb_forma_pagamento;
delete from tb_cozinha;
delete from tb_cidade;
delete from tb_estado;
delete from tb_grupo_permissao;
delete from tb_usuario_grupo;
delete from tb_usuario;
delete from tb_grupo;
delete from tb_permissao;


alter sequence tb_restaurante_id_seq restart with 1;
alter sequence tb_forma_pagamento_id_seq restart with 1;
alter sequence tb_cozinha_id_seq restart with 1;
alter sequence tb_cidade_id_seq restart with 1;
alter sequence tb_estado_id_seq restart with 1;
alter sequence tb_usuario_id_seq restart with 1;
alter sequence tb_grupo_id_seq restart with 1;
alter sequence tb_permissao_id_seq restart with 1;
alter sequence tb_produto_id_seq restart with 1;

insert into tb_cozinha (nome) values ('Tailandesa');
insert into tb_cozinha (nome) values ('Indiana');
insert into tb_cozinha (nome) values ('Japonesa');
insert into tb_cozinha (nome) values ('Chinesa');
insert into tb_cozinha (nome) values ('Brasileira');
insert into tb_cozinha (nome) values ('Italiana');
insert into tb_cozinha (nome) values ('Gaúcha');

insert into tb_estado (nome) values ('Rio Grande do Sul');
insert into tb_estado (nome) values ('Santa Catarina');
insert into tb_estado (nome) values ('Paraná');

insert into tb_cidade (nome, estado_id) values ('Rio Grande', 1);
insert into tb_cidade (nome, estado_id) values ('Pelotas', 1);
insert into tb_cidade (nome, estado_id) values ('Erechim', 1);
insert into tb_cidade (nome, estado_id) values ('Florianópolis', 2);
insert into tb_cidade (nome, estado_id) values ('Concórdia', 2);
insert into tb_cidade (nome, estado_id) values ('Curitiba', 3);
insert into tb_cidade (nome, estado_id) values ('Ponta Grossa', 3);
insert into tb_cidade (nome, estado_id) values ('Londrina', 3);

insert into tb_restaurante (nome, taxa_frete, cozinha_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro, endereco_cidade_id, data_cadastro, data_atualizacao) values ('India Food', '12.00', 2, '96215570', 'Rua do Mirante', '251', 'Fundos', 'Parque Marinha', 1, current_timestamp(0) at time zone 'utc', current_timestamp(0) at time zone 'utc');
insert into tb_restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Palácio Tailandês', '8.00', 1, now(), now());
insert into tb_restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Prato Exótico', '9.00', 1, now(), now());
insert into tb_restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Namastê', '0', 2, now(), now());

insert into tb_produto (nome, descricao, preco, restaurante_id, ativo) values ('x-tudao', 'x completaço, o legítimo morte lenta', '36.90', 1, true);
insert into tb_produto (nome, descricao, preco, restaurante_id, ativo) values ('bauru de filé', 'O clássico que tudo mundo ama', '32.90', 1, true);
insert into tb_produto (nome, descricao, preco, restaurante_id, ativo) values ('lasanha', 'lasanha de queijo e presunto', '19.99', 2, true);
insert into tb_produto (nome, descricao, preco, restaurante_id, ativo) values ('pastel de camarão', 'pastel delicioso e bem recheado', '12.00', 2, true);

insert into tb_forma_pagamento (nome) values ('Cartão de crédito');
insert into tb_forma_pagamento (nome) values ('Cartão de débito');
insert into tb_forma_pagamento (nome) values ('Dinheiro');

insert into tb_permissao (nome, descricao) values ('CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into tb_permissao (nome, descricao) values ('EDITAR_COZINHAS', 'Permite editar cozinhas');

insert into tb_restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1), (1, 2), (1, 3), (2, 1), (2, 2), (3, 3), (4, 1), (4, 3);