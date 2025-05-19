-- GRUPO: Challenge Banco de Dados - Sprint 4
-- INTEGRANTES:
-- RM561089 - Sulamita Viegas Dos Santos
-- RM - Pedro Henrique Sena
-- RM561090 - Matteus Viegas Dos Santos

-- ===========================================
-- SEQUENCE GERADOR DE IDs
-- ===========================================
CREATE SEQUENCE gerador_id_chall;

-- ===========================================
-- TABELA LINHAMETRO
-- ===========================================
CREATE TABLE LinhaMetro (
    id_linhaMetro NUMBER PRIMARY KEY,
    nome VARCHAR2(50) NOT NULL,
    extensao NUMBER NOT NULL,
    numero NUMBER,
    descricao VARCHAR2(200),
    tipo VARCHAR2(30),
    responsavel VARCHAR2(100)
);

-- Inserção na Tabela LinhaMetro
INSERT INTO LinhaMetro (id_linhaMetro, nome, extensao, numero, descricao, tipo, responsavel)
VALUES (gerador_id_chall.NEXTVAL, 'Linha 9', 23.9, 9, 'Linha mais ou menos', 'Trem', 'CCR');

INSERT INTO LinhaMetro (id_linhaMetro, nome, extensao, numero, descricao, tipo, responsavel)
VALUES (gerador_id_chall.NEXTVAL, 'Linha 8', 41.6, 8, 'Linha intermunicipal', 'Trem', 'ViaMobilidade');

INSERT INTO LinhaMetro (id_linhaMetro, nome, extensao, numero, descricao, tipo, responsavel)
VALUES (gerador_id_chall.NEXTVAL, 'Linha 4', 12.3, 4, 'Linha subterrânea moderna', 'Metrô', 'ViaQuatro');

INSERT INTO LinhaMetro (id_linhaMetro, nome, extensao, numero, descricao, tipo, responsavel)
VALUES (gerador_id_chall.NEXTVAL, 'Linha 3', 22.0, 3, 'Linha com alta demanda', 'Metrô', 'Governo');

INSERT INTO LinhaMetro (id_linhaMetro, nome, extensao, numero, descricao, tipo, responsavel)
VALUES (gerador_id_chall.NEXTVAL, 'Linha 1', 23.5, 1, 'Linha mais antiga', 'Metrô', 'Governo');
COMMIT;  

SELECT * FROM LINHAMETRO; -- 101

-- ===========================================
-- TABELA ESTACAO
-- ===========================================
CREATE TABLE Estacao (
    id_estacao NUMBER PRIMARY KEY,
    nome VARCHAR2(30) NOT NULL,
    localizacao VARCHAR2(50) NOT NULL,
    passageirosSimulados NUMBER NOT NULL,
    id_linhaMetro NUMBER NOT NULL,
    CONSTRAINT fk_estacao FOREIGN KEY (id_linhaMetro) REFERENCES LinhaMetro (id_linhaMetro),
    CONSTRAINT chk_pax_simulados CHECK (passageirosSimulados >= 0),
    CONSTRAINT uq_nome_estacao UNIQUE (nome)
);

-- Inserção na tabela de Estação

-- Linha 9 esmeralda
INSERT INTO estacao (
    id_estacao,
    nome,
    localizacao,
    passageirossimulados,
    id_linhametro
) VALUES ( gerador_id_chall.NEXTVAL,
           'Osasco',
           'Centro, Osasco - SP',
           1300,
           101 );

COMMIT;

INSERT INTO estacao (
    id_estacao,
    nome,
    localizacao,
    passageirossimulados,
    id_linhametro
) VALUES ( gerador_id_chall.NEXTVAL,
           'Pinheiros',
           'Rua Capri, 145',
           1100,
           101 );

COMMIT;

INSERT INTO estacao (
    id_estacao,
    nome,
    localizacao,
    passageirossimulados,
    id_linhametro
) VALUES ( gerador_id_chall.NEXTVAL,
           'Presidente Altino',
           'Av. dos Autonomistas, Osasco - SP',
           900,
           101 );

COMMIT;

INSERT INTO estacao (
    id_estacao,
    nome,
    localizacao,
    passageirossimulados,
    id_linhametro
) VALUES ( gerador_id_chall.NEXTVAL,
           'Ceasa',
           'Av. Eng. Billings, São Paulo - SP',
           700,
           101 );

COMMIT;

INSERT INTO estacao (
    id_estacao,
    nome,
    localizacao,
    passageirossimulados,
    id_linhametro
) VALUES ( gerador_id_chall.NEXTVAL,
           'Vila Lobos',
           'Próximo ao Parque Villa-Lobos, São Paulo - SP',
           600,
           101 );

COMMIT;

INSERT INTO estacao (
    id_estacao,
    nome,
    localizacao,
    passageirossimulados,
    id_linhametro
) VALUES ( gerador_id_chall.NEXTVAL,
           'Cidade Jardim',
           'Av. das Nações Unidas, São Paulo - SP',
           800,
           101 );

COMMIT;

INSERT INTO estacao (
    id_estacao,
    nome,
    localizacao,
    passageirossimulados,
    id_linhametro
) VALUES ( gerador_id_chall.NEXTVAL,
           'Vila Olimpia',
           'Av. Dr. Cardoso de Melo, São Paulo - SP',
           1200,
           101 );

COMMIT;

INSERT INTO estacao (
    id_estacao,
    nome,
    localizacao,
    passageirossimulados,
    id_linhametro
) VALUES ( gerador_id_chall.NEXTVAL,
           'Berrini',
           'Próximo à Av. Eng. Luís Carlos Berrini, SP',
           1400,
           101 );

COMMIT;

INSERT INTO estacao (
    id_estacao,
    nome,
    localizacao,
    passageirossimulados,
    id_linhametro
) VALUES ( gerador_id_chall.NEXTVAL,
           'Morumbi',
           'Av. Roque Petroni Jr., São Paulo - SP',
           1500,
           101 );

COMMIT;

INSERT INTO estacao (
    id_estacao,
    nome,
    localizacao,
    passageirossimulados,
    id_linhametro
) VALUES ( gerador_id_chall.NEXTVAL,
           'Granja Julieta',
           'Rua Laguna, São Paulo - SP',
           1000,
           101 );

COMMIT;

INSERT INTO estacao (
    id_estacao,
    nome,
    localizacao,
    passageirossimulados,
    id_linhametro
) VALUES ( gerador_id_chall.NEXTVAL,
           'João Dias',
           'Av. João Dias, São Paulo - SP',
           800,
           101 );

COMMIT;

INSERT INTO estacao (
    id_estacao,
    nome,
    localizacao,
    passageirossimulados,
    id_linhametro
) VALUES ( gerador_id_chall.NEXTVAL,
           'Santo Amaro',
           'Terminal Santo Amaro, São Paulo - SP',
           1800,
           101 );

COMMIT;

INSERT INTO estacao (
    id_estacao,
    nome,
    localizacao,
    passageirossimulados,
    id_linhametro
) VALUES ( gerador_id_chall.NEXTVAL,
           'Socorro',
           'Av. Guido Caloi, São Paulo - SP',
           700,
           101 );

COMMIT;

INSERT INTO estacao (
    id_estacao,
    nome,
    localizacao,
    passageirossimulados,
    id_linhametro
) VALUES ( gerador_id_chall.NEXTVAL,
           'Jurubatuba',
           'Av. das Nações Unidas, São Paulo - SP',
           900,
           101 );

COMMIT;

INSERT INTO estacao (
    id_estacao,
    nome,
    localizacao,
    passageirossimulados,
    id_linhametro
) VALUES ( gerador_id_chall.NEXTVAL,
           'Autódromo',
           'Próximo ao Autódromo de Interlagos, SP',
           750,
           101 );

COMMIT;

INSERT INTO estacao (
    id_estacao,
    nome,
    localizacao,
    passageirossimulados,
    id_linhametro
) VALUES ( gerador_id_chall.NEXTVAL,
           'Interlagos',
           'Av. Interlagos, São Paulo - SP',
           850,
           101 );

COMMIT;

INSERT INTO estacao (
    id_estacao,
    nome,
    localizacao,
    passageirossimulados,
    id_linhametro
) VALUES ( gerador_id_chall.NEXTVAL,
           'Grajaú',
           'Terminal Grajaú, São Paulo - SP',
           1600,
           101 );

COMMIT;

SELECT * FROM ESTACAO; -- 102 A 118

-- ===========================================
-- TABELA ALERTA
-- ===========================================
CREATE TABLE Alerta (
    id_alerta NUMBER PRIMARY KEY,
    mensagem VARCHAR(255) NOT NULL,
    tipo VARCHAR(30) NOT NULL,
    id_estacao NUMBER NOT NULL,
    CONSTRAINT fk_alerta FOREIGN KEY (id_estacao) REFERENCES Estacao (id_estacao)
);

-- Inserção na Tabela Alerta
INSERT INTO alerta (
    id_alerta,
    mensagem,
    tipo,
    id_estacao
) VALUES ( gerador_id_chall.NEXTVAL,
           'Tudo funcionando normalmente',
           'verde',
           102 );

COMMIT;

INSERT INTO alerta (
    id_alerta,
    mensagem,
    tipo,
    id_estacao
) VALUES ( gerador_id_chall.NEXTVAL,
           'Obstrução na linha, por favor, aguarde.',
           'vermelho',
           103 );

COMMIT;

INSERT INTO alerta (
    id_alerta,
    mensagem,
    tipo,
    id_estacao
) VALUES ( gerador_id_chall.NEXTVAL,
           'Problema técnico, linha está suspensa temporariamente.',
           'amarelo',
           104 );

COMMIT;

INSERT INTO alerta (
    id_alerta,
    mensagem,
    tipo,
    id_estacao
) VALUES ( gerador_id_chall.NEXTVAL,
           'Trânsito normal, sem ocorrências.',
           'verde',
           105 );

COMMIT;

INSERT INTO alerta (
    id_alerta,
    mensagem,
    tipo,
    id_estacao
) VALUES ( gerador_id_chall.NEXTVAL,
           'Atenção, possível falha no sistema de bilhetagem.',
           'laranja',
           106 );

COMMIT;

SELECT * FROM ALERTA;

-- ===========================================
-- TABELA DADOSHISTORICO
-- ===========================================
CREATE TABLE DadosHistorico (
    id_dadoshistorico NUMBER PRIMARY KEY,
    datahora TIMESTAMP,
    id_estacao NUMBER NOT NULL,
    CONSTRAINT fk_dadoshistorico FOREIGN KEY (id_estacao) REFERENCES Estacao (id_estacao)
);

-- Inserção na Tabela DadosHistorico
INSERT INTO DadosHistorico (
    id_dadoshistorico,
    datahora,
    id_estacao
) VALUES ( gerador_id_chall.NEXTVAL,
           TO_TIMESTAMP('2025-03-11 10:30:00', 'YYYY-MM-DD HH24:MI:SS'),
           102 );

COMMIT;

INSERT INTO DadosHistorico (
    id_dadoshistorico,
    datahora,
    id_estacao
) VALUES ( gerador_id_chall.NEXTVAL,
           TO_TIMESTAMP('2025-03-12 08:00:00', 'YYYY-MM-DD HH24:MI:SS'),
           103 );

COMMIT;

INSERT INTO DadosHistorico (
    id_dadoshistorico,
    datahora,
    id_estacao
) VALUES ( gerador_id_chall.NEXTVAL,
           TO_TIMESTAMP('2025-03-12 09:00:00', 'YYYY-MM-DD HH24:MI:SS'),
           104 );

COMMIT;

INSERT INTO DadosHistorico (
    id_dadoshistorico,
    datahora,
    id_estacao
) VALUES ( gerador_id_chall.NEXTVAL,
           TO_TIMESTAMP('2025-03-12 10:00:00', 'YYYY-MM-DD HH24:MI:SS'),
           105 );

COMMIT;

INSERT INTO DadosHistorico (
    id_dadoshistorico,
    datahora,
    id_estacao
) VALUES ( gerador_id_chall.NEXTVAL,
           TO_TIMESTAMP('2025-03-12 11:00:00', 'YYYY-MM-DD HH24:MI:SS'),
           106 );

COMMIT;


SELECT * FROM DADOSHISTORICO; 

-- ===========================================
-- TABELA USUARIO
-- ===========================================

CREATE TABLE Usuario_Challenge (
    id_usuario NUMBER PRIMARY KEY,
    nome VARCHAR2(30) NOT NULL,
    email VARCHAR2(50) NOT NULL,
    senha VARCHAR2(255) NOT NULL
);

-- Inserção na Tabela Usuario
INSERT INTO usuario_challenge (
    id_usuario,
    nome,
    email,
    senha
) VALUES (
    gerador_id_chall.NEXTVAL,
    'Pedro',
    'pedro@gmail.com',
    'abobora2020'
);

COMMIT;

INSERT INTO usuario_challenge (
    id_usuario,
    nome,
    email,
    senha
) VALUES (
    gerador_id_chall.NEXTVAL,
    'Ana Clara',
    'ana.clara@gmail.com',
    'senha123'
);

COMMIT;

INSERT INTO usuario_challenge (
    id_usuario,
    nome,
    email,
    senha
) VALUES (
    gerador_id_chall.NEXTVAL,
    'Lucas Silva',
    'lucas.silva@gmail.com',
    'lucas2024'
);

COMMIT;

INSERT INTO usuario_challenge (
    id_usuario,
    nome,
    email,
    senha
) VALUES (
    gerador_id_chall.NEXTVAL,
    'Mariana Costa',
    'mariana.costa@hotmail.com',
    'mari@321'
);

COMMIT;

INSERT INTO usuario_challenge (
    id_usuario,
    nome,
    email,
    senha
) VALUES (
    gerador_id_chall.NEXTVAL,
    'Carlos Henrique',
    'carlos.henrique@gmail.com',
    'senhaCarlos'
);

COMMIT;

--  dados de Usuario
SELECT * FROM Usuario_Challenge;

-- ===========================================
-- TABELA StatusLinha
-- ===========================================
CREATE TABLE StatusLinha (
    id_StatusLinha NUMBER PRIMARY KEY,
    nome VARCHAR2(50),
    status VARCHAR2(30),
    id_estacao NUMBER NOT NULL,
    CONSTRAINT fk_StatusLinha FOREIGN KEY (id_estacao) REFERENCES Estacao (id_estacao)
);

INSERT INTO StatusLinha (
    id_StatusLinha,
    nome,
    status, 
    id_estacao
) VALUES (
    gerador_id_chall.NEXTVAL,
    'Status Operacional',
    'Operando normalmente',
    106
);
COMMIT;

INSERT INTO StatusLinha (
    id_StatusLinha,
    nome,
    status, 
    id_estacao
) VALUES (
    gerador_id_chall.NEXTVAL,
    'Monitoramento',
    'fluxo elevado de passageiros',
    102
);
COMMIT;

INSERT INTO StatusLinha (
    id_StatusLinha,
    nome,
    status, 
    id_estacao
) VALUES (
    gerador_id_chall.NEXTVAL,
    'Parcialmente Operacional',
    'Operando com atrasos',
    103
);
COMMIT;

INSERT INTO StatusLinha (
    id_StatusLinha,
    nome,
    status, 
    id_estacao
) VALUES (
    gerador_id_chall.NEXTVAL,
    'Emergência',
    'Serviço temp. suspenso',
    104
);
COMMIT;

INSERT INTO StatusLinha (
    id_StatusLinha,
    nome,
    status, 
    id_estacao
) VALUES (
    gerador_id_chall.NEXTVAL,
    'Manutenção Programada',
    'Parada prevista entre 22h e 4h',
    105
);
COMMIT;

SELECT * FROM StatusLinha;

-- ===========================================
-- TABELA RELATORIO
-- ===========================================

CREATE TABLE Relatorio (
    id_relatorio NUMBER PRIMARY KEY,
    viagens VARCHAR2(255) NOT NULL,
    id_dadoshistorico NUMBER,
    id_estacao NUMBER NOT NULL,
    id_usuario NUMBER NOT NULL,
    CONSTRAINT fk_relatorio FOREIGN KEY (id_estacao) REFERENCES Estacao (id_estacao),
    CONSTRAINT fk_relatorio_dadoshistorico FOREIGN KEY (id_dadoshistorico) REFERENCES DadosHistorico (id_dadoshistorico),
    CONSTRAINT fk_relatorio_usuario FOREIGN KEY (id_usuario) REFERENCES Usuario_Challenge (id_usuario)
);

-- Inserção na Tabela Relatorio
INSERT INTO Relatorio (
    id_relatorio,
    viagens,
    id_dadoshistorico,
    id_estacao,
    id_usuario
) VALUES ( gerador_id_chall.NEXTVAL,
           'Viagem 01, Viagem 02, Viagem 03',
           120,
           102,
           122);

COMMIT;

INSERT INTO relatorio (
    id_relatorio,
    viagens,
    id_dadoshistorico,
    id_estacao,
    id_usuario
) VALUES ( gerador_id_chall.NEXTVAL,
           'Viagem 04, Viagem 05, Viagem 06',
           210,
           107,
           128 );  

COMMIT;

INSERT INTO relatorio (
    id_relatorio,
    viagens,
    id_dadoshistorico,
    id_estacao,
    id_usuario
) VALUES ( gerador_id_chall.NEXTVAL,
           'Viagem 07, Viagem 08, Viagem 09',
           211,
           116,
           148 ); 

COMMIT;

INSERT INTO relatorio (
    id_relatorio,
    viagens,
    id_dadoshistorico,
    id_estacao,
    id_usuario
) VALUES ( gerador_id_chall.NEXTVAL,
           'Viagem 10, Viagem 11, Viagem 12',
           213,
           113,
           161 );

COMMIT;

INSERT INTO relatorio (
    id_relatorio,
    viagens,
    id_dadoshistorico,
    id_estacao,
    id_usuario
) VALUES ( gerador_id_chall.NEXTVAL,
           'Viagem 13, Viagem 14, Viagem 15',
           211,
           108,
           222 );  

COMMIT;

SELECT * FROM RELATORIO; 

-- ===========================================
-- TABELA VIAGEM 
-- ===========================================
CREATE TABLE Viagem (
    id_viagem NUMBER PRIMARY KEY,
    hpartida TIMESTAMP NOT NULL,
    hchegada TIMESTAMP NOT NULL,
    estacao_origem NUMBER NOT NULL,
    estacao_destino NUMBER NOT NULL,
    id_usuario NUMBER,  
    CONSTRAINT fk_viagem_origem FOREIGN KEY (estacao_origem) REFERENCES Estacao(id_estacao),
    CONSTRAINT fk_viagem_destino FOREIGN KEY (estacao_destino) REFERENCES Estacao(id_estacao),
    CONSTRAINT fk_cliente FOREIGN KEY (id_usuario) REFERENCES Usuario_Challenge(id_usuario), 
    CONSTRAINT chk_horario_viagem CHECK (hchegada > hpartida)
);

DELETE FROM viagem WHERE id_usuario IS NULL;
ALTER TABLE viagem MODIFY id_usuario NOT NULL;

-- Inserção na Tabela Viagem (exemplo com id_cliente)
-- Associa um cliente com a viagem
INSERT INTO viagem (
    id_viagem,
    hpartida,
    hchegada,
    estacao_origem,
    estacao_destino,
    id_usuario
) VALUES ( gerador_id_chall.NEXTVAL,
           TO_TIMESTAMP('2025-03-11 07:30:00', 'YYYY-MM-DD HH24:MI:SS'),
           TO_TIMESTAMP('2025-03-11 08:00:00', 'YYYY-MM-DD HH24:MI:SS'),
           102,
           103,
           122 );  
COMMIT;

select * from viagem;

INSERT INTO viagem (
    id_viagem,
    hpartida,
    hchegada,
    estacao_origem,
    estacao_destino,
    id_usuario
) VALUES ( gerador_id_chall.NEXTVAL,
           TO_TIMESTAMP('2025-03-12 07:30:00', 'YYYY-MM-DD HH24:MI:SS'),
           TO_TIMESTAMP('2025-03-12 08:00:00', 'YYYY-MM-DD HH24:MI:SS'),
           103,
           104,
           221 );

COMMIT;

INSERT INTO viagem (
    id_viagem,
    hpartida,
    hchegada,
    estacao_origem,
    estacao_destino,
    id_usuario
) VALUES ( gerador_id_chall.NEXTVAL,
           TO_TIMESTAMP('2025-03-12 09:00:00', 'YYYY-MM-DD HH24:MI:SS'),
           TO_TIMESTAMP('2025-03-12 09:30:00', 'YYYY-MM-DD HH24:MI:SS'),
           104,
           105,
           222 );

COMMIT;

INSERT INTO viagem (
    id_viagem,
    hpartida,
    hchegada,
    estacao_origem,
    estacao_destino,
    id_usuario
) VALUES ( gerador_id_chall.NEXTVAL,
           TO_TIMESTAMP('2025-03-12 10:00:00', 'YYYY-MM-DD HH24:MI:SS'),
           TO_TIMESTAMP('2025-03-12 10:30:00', 'YYYY-MM-DD HH24:MI:SS'),
           105,
           106,
           223 );

COMMIT;

INSERT INTO viagem (
    id_viagem,
    hpartida,
    hchegada,
    estacao_origem,
    estacao_destino,
    id_usuario
) VALUES ( gerador_id_chall.NEXTVAL,
           TO_TIMESTAMP('2025-03-12 11:00:00', 'YYYY-MM-DD HH24:MI:SS'),
           TO_TIMESTAMP('2025-03-12 11:30:00', 'YYYY-MM-DD HH24:MI:SS'),
           106,
           103,
           224 );

COMMIT;


INSERT INTO viagem (
    id_viagem,
    hpartida,
    hchegada,
    estacao_origem,
    estacao_destino,
    id_usuario
) VALUES (
    gerador_id_chall.NEXTVAL,
    TO_TIMESTAMP('2025-03-12 12:00:00', 'YYYY-MM-DD HH24:MI:SS'),
    TO_TIMESTAMP('2025-03-12 12:30:00', 'YYYY-MM-DD HH24:MI:SS'),
    104,
    102,
    222
);

INSERT INTO viagem (
    id_viagem,
    hpartida,
    hchegada,
    estacao_origem,
    estacao_destino,
    id_usuario
) VALUES (
    gerador_id_chall.NEXTVAL,
    TO_TIMESTAMP('2025-03-13 07:00:00', 'YYYY-MM-DD HH24:MI:SS'),
    TO_TIMESTAMP('2025-03-13 07:40:00', 'YYYY-MM-DD HH24:MI:SS'),
    105,
    107,
    221
);

INSERT INTO viagem (
    id_viagem,
    hpartida,
    hchegada,
    estacao_origem,
    estacao_destino,
    id_usuario
) VALUES (
    gerador_id_chall.NEXTVAL,
    TO_TIMESTAMP('2025-03-13 08:15:00', 'YYYY-MM-DD HH24:MI:SS'),
    TO_TIMESTAMP('2025-03-13 08:45:00', 'YYYY-MM-DD HH24:MI:SS'),
    107,
    109,
    223
);

INSERT INTO viagem (
    id_viagem,
    hpartida,
    hchegada,
    estacao_origem,
    estacao_destino,
    id_usuario
) VALUES (
    gerador_id_chall.NEXTVAL,
    TO_TIMESTAMP('2025-03-13 09:00:00', 'YYYY-MM-DD HH24:MI:SS'),
    TO_TIMESTAMP('2025-03-13 09:20:00', 'YYYY-MM-DD HH24:MI:SS'),
    109,
    110,
    161
);

INSERT INTO viagem (
    id_viagem,
    hpartida,
    hchegada,
    estacao_origem,
    estacao_destino,
    id_usuario
) VALUES (
    gerador_id_chall.NEXTVAL,
    TO_TIMESTAMP('2025-03-13 10:00:00', 'YYYY-MM-DD HH24:MI:SS'),
    TO_TIMESTAMP('2025-03-13 10:25:00', 'YYYY-MM-DD HH24:MI:SS'),
    110,
    106,
    151
);

COMMIT;

SELECT * FROM VIAGEM;

-- ===========================================
-- TABELA PREVISAOPICO
-- ===========================================
CREATE TABLE PrevisaoPico (
    id_previsaopico NUMBER PRIMARY KEY,
    horarioPicoPrevisto TIMESTAMP NOT NULL,
    id_estacao NUMBER NOT NULL,
    CONSTRAINT fk_previsao FOREIGN KEY (id_estacao) REFERENCES Estacao (id_estacao)
);

-- Inserção na Tabela PrevisaoPico
INSERT INTO previsaopico (
    id_previsaopico,
    horariopicoprevisto,
    id_estacao
) VALUES ( gerador_id_chall.NEXTVAL,
           TO_TIMESTAMP('2025-03-11 18:00:00', 'YYYY-MM-DD HH24:MI:SS'),
           102 );

COMMIT;

INSERT INTO previsaopico (
    id_previsaopico,
    horariopicoprevisto,
    id_estacao
) VALUES ( gerador_id_chall.NEXTVAL,
           TO_TIMESTAMP('2025-03-12 18:00:00', 'YYYY-MM-DD HH24:MI:SS'),
           106 );

COMMIT;

INSERT INTO previsaopico (
    id_previsaopico,
    horariopicoprevisto,
    id_estacao
) VALUES ( gerador_id_chall.NEXTVAL,
           TO_TIMESTAMP('2025-03-12 19:00:00', 'YYYY-MM-DD HH24:MI:SS'),
           107 );

COMMIT;

INSERT INTO previsaopico (
    id_previsaopico,
    horariopicoprevisto,
    id_estacao
) VALUES ( gerador_id_chall.NEXTVAL,
           TO_TIMESTAMP('2025-03-12 20:00:00', 'YYYY-MM-DD HH24:MI:SS'),
           108 );

COMMIT;

INSERT INTO previsaopico (
    id_previsaopico,
    horariopicoprevisto,
    id_estacao
) VALUES ( gerador_id_chall.NEXTVAL,
           TO_TIMESTAMP('2025-03-12 21:00:00', 'YYYY-MM-DD HH24:MI:SS'),
           109 );

COMMIT;

SELECT * FROM PREVISAOPICO;

-- ===========================================
-- CONSULTAS
-- ===========================================

-- Consulta com Ordenação (ORDER BY)
SELECT * FROM Estacao
ORDER BY nome ASC;

-- Consulta com Função de Grupo (COUNT)
SELECT COUNT(*) AS total_estacoes FROM Estacao;

-- Consulta com Grupo (MAX)
SELECT nome, MAX(passageirosSimulados) AS max_pax 
FROM Estacao
GROUP BY nome;

-- Consulta de Dados (GROUP BY)
SELECT nome, SUM(passageirosSimulados) AS total_pax
FROM Estacao
GROUP BY nome;

-- Consulta com (SUBQUERY)
SELECT e.nome, e.passageirosSimulados
FROM Estacao e
WHERE e.passageirosSimulados > (
    SELECT SUM(passageirosSimulados) / COUNT(*) FROM Estacao
);

-- Consulta com (JOIN)
SELECT e.nome AS Estacao, l.nome AS Linha
FROM Estacao e
JOIN LinhaMetro l ON e.id_linhaMetro = l.id_linhaMetro;

-- Consulta com  (WHERE)
SELECT * FROM Estacao
WHERE passageirosSimulados > 1000;

-- Consulta para verificar viagens de uma estação (com alteração no JOIN)
SELECT e.nome AS Estacao
FROM Estacao e
JOIN LinhaMetro le ON e.id_linhaMetro = le.id_linhaMetro
WHERE le.id_linhaMetro = 2;