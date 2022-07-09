create table tb_pedido (
    id serial not null,
    subtotal decimal(10,2) not null,
    taxa_frete decimal(10,2) not null,
    valor_total decimal(10,2) not null,
    restaurante_id integer not null,
    usuario_cliente_id integer not null,
    forma_pagamento_id integer not null,
    endereco_cidade_id integer not null,
    endereco_cep varchar(10) not null,
    endereco_logradouro varchar(100) not null,
    endereco_numero varchar(20) not null,
    endereco_complemento varchar(60),
    endereco_bairro varchar(60) not null,
    status varchar(10) not null,
    data_criacao timestamp not null,
    data_confirmacao timestamp null,
    data_cancelamento timestamp null,
    data_entrega timestamp null,
    primary key (id),
    constraint fk_pedido_endereco_cidade foreign key (endereco_cidade_id) references tb_cidade (id),
    constraint fk_pedido_restaurante foreign key (restaurante_id) references tb_restaurante (id),
    constraint fk_pedido_usuario_cliente foreign key (usuario_cliente_id) references tb_usuario (id),
    constraint fk_pedido_forma_pagamento foreign key (forma_pagamento_id) references tb_forma_pagamento (id)
);

create table tb_item_pedido (
    id serial not null,
    quantidade integer not null,
    preco_unitario decimal(10,2) not null,
    preco_total decimal(10,2) not null,
    observacao varchar(255) null,
    pedido_id integer not null,
    produto_id integer not null,
    primary key (id),
    constraint uk_pedido_produto unique (pedido_id, produto_id),
    constraint fk_item_pedido_pedido foreign key (pedido_id) references tb_pedido (id),
    constraint fk_item_pedido_produto foreign key (produto_id) references tb_produto (id)
);