drop table if exists tb_agendamento CASCADE;
drop table if exists tb_cliente CASCADE;
drop table if exists tb_servico CASCADE;

create table tb_agendamento
(
    id_agendamento bigint generated by default as identity,
    data_hora      timestamp    not null,
    observacao     varchar(250) not null,
    id_cliente     bigint,
    id_servico     bigint,
    primary key (id_agendamento)
);


create table tb_cliente
(
    id_cliente bigint generated by default as identity,
    cpf        varchar(14)  not null,
    nome       varchar(100) not null,
    primary key (id_cliente)
);


create table tb_servico
(
    id_servico bigint generated by default as identity,
    codigo     varchar(50)  not null,
    descricao  varchar(250) not null,
    valor      varchar(25)  not null,
    primary key (id_servico)
);

-- Foreign Keys --
alter table tb_agendamento
    add constraint FK_AGENDAMENTO_CLIENTE
        foreign key (id_cliente)
            references tb_cliente;


alter table tb_agendamento
    add constraint FK_AGENDAMENTO_SERVICO
        foreign key (id_servico)
            references tb_servico;

-- Tabela Cliente --
INSERT INTO tb_cliente (id_cliente, nome, cpf) VALUES (1, 'Emanuel Márcio Vicente Pires', '106.527.421-14');
INSERT INTO tb_cliente (id_cliente, nome, cpf) VALUES (2, 'Isadora Giovana da Costa', '808.107.681-60');

-- Tabela Servico --
INSERT INTO tb_servico (id_servico, codigo, descricao, valor) VALUES (1, 'T27', 'Limpeza', '100,00');
INSERT INTO tb_servico (id_servico, codigo, descricao, valor) VALUES (2, 'FT3', 'Informática', '150,00');

-- Tabela Agendamento --
INSERT INTO tb_agendamento (id_agendamento, data_hora, observacao, id_cliente, id_servico) VALUES (1, '2021-09-22T16:00:00.001', 'Limpeza', 1, 1);
INSERT INTO tb_agendamento (id_agendamento, data_hora, observacao, id_cliente, id_servico) VALUES (2, '2021-09-22T16:00:00.002', 'Informática', 2, 2);