create table tb_estado (
	id serial not null,
	nome varchar(80) not null,
	primary key (id)
);

insert into tb_estado (nome) select distinct nome_estado from tb_cidade;
alter table tb_cidade add column estado_id integer not null default 0;
update tb_cidade set estado_id = (select e.id from tb_estado e where e.nome = tb_cidade.nome_estado);
alter table tb_cidade add constraint fk_cidade_estado foreign key (estado_id) references tb_estado(id);
alter table tb_cidade drop column nome_estado;
alter table tb_cidade rename column nome_cidade to nome;