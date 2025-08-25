-- Criar o banco de dados
CREATE DATABASE fieb_tours;
GO

-- Usar o banco
USE fieb_tours;
GO

-- Tabela de alunos
CREATE TABLE dbo.alunos (
                            id BIGINT IDENTITY(1,1) PRIMARY KEY,
                            rm VARCHAR(255) NOT NULL UNIQUE,
                            nome VARCHAR(255) NOT NULL,
                            turma VARCHAR(255) NOT NULL,
                            numeroChamada INT NOT NULL,
                            senhaBase64 VARCHAR(MAX) NOT NULL
);
GO

-- Tabela de passeios
CREATE TABLE dbo.passeios (
                              id BIGINT IDENTITY(1,1) PRIMARY KEY,
                              titulo VARCHAR(255) NOT NULL,
                              descricao VARCHAR(MAX) NULL,
    data DATE NOT NULL,
    preco DECIMAL(18, 2) NOT NULL
);
GO

-- Tabela de reservas
CREATE TABLE dbo.reservas (
                              id BIGINT IDENTITY(1,1) PRIMARY KEY,
                              aluno_id BIGINT NOT NULL,
                              passeio_id BIGINT NOT NULL,
                              status VARCHAR(50) NOT NULL DEFAULT 'CONFIRMADA',
                              CONSTRAINT FK_reserva_aluno FOREIGN KEY (aluno_id) REFERENCES dbo.alunos(id),
                              CONSTRAINT FK_reserva_passeio FOREIGN KEY (passeio_id) REFERENCES dbo.passeios(id)
);
GO

-- Tabela de avaliações
CREATE TABLE dbo.avaliacoes (
                                id BIGINT IDENTITY(1,1) PRIMARY KEY,
                                passeio_id BIGINT NOT NULL,
                                aluno_id BIGINT NOT NULL,
                                nota INT NOT NULL CHECK (nota >= 1 AND nota <= 5),
                                comentario VARCHAR(MAX) NULL,
    CONSTRAINT FK_avaliacao_passeio FOREIGN KEY (passeio_id) REFERENCES dbo.passeios(id),
    CONSTRAINT FK_avaliacao_aluno FOREIGN KEY (aluno_id) REFERENCES dbo.alunos(id)
);
GO

-- Inserir passeios
INSERT INTO dbo.passeios (titulo, descricao, data, preco) VALUES
('Visita ao Museu do Ipiranga', 'Passeio cultural ao Museu do Ipiranga, com guia incluso.', '2025-09-10', 50.00),
('Parque Ibirapuera', 'Passeio de lazer no Parque Ibirapuera, com atividades recreativas.', '2025-09-15', 20.00),
('Planetário do Carmo', 'Exploração astronômica no planetário, com oficinas práticas.', '2025-09-20', 30.00),
('Hopi Hari', 'Hopi Hari é o maior parque temático de São Paulo.', '2027-09-20', 80.00),
('Parque Aquático', 'Parque aquático amplo e colorido com toboáguas, piscina de ondas e eventos e DJs esporádicos..', '2025-09-20', 30.00);
GO

-- Inserir alunos
INSERT INTO dbo.alunos (rm, nome, turma, numeroChamada, senhaBase64) VALUES
('RM001', 'Ana Silva', 'Turma A', 1, 'c2VuaGExMjM='),
('RM002', 'Bruno Souza', 'Turma A', 2, 'c2VuaGE0NTY='),
('RM003', 'Carla Pereira', 'Turma B', 3, 'c2VuaGE3ODk='),
('RM004', 'Diego Martins', 'Turma B', 4, 'c2VuaGEwMTI='),
('RM005', 'Elisa Fernandes', 'Turma C', 5, 'c2VuaGEzNDU=');
GO

-- Inserir reservas
INSERT INTO dbo.reservas (aluno_id, passeio_id, status) VALUES
(1, 1, 'CONFIRMADA'),
(2, 2, 'CONFIRMADA'),
(3, 3, 'CONFIRMADA'),
(4, 1, 'CONFIRMADA'),
(5, 2, 'CONFIRMADA');
GO

-- Inserir avaliações
INSERT INTO dbo.avaliacoes (passeio_id, aluno_id, nota, comentario) VALUES
(1, 1, 5, 'Experiência incrível no Museu!'),
(2, 2, 4, 'Passeio divertido, mas poderia ter mais atividades.'),
(3, 3, 5, 'Planetário foi sensacional, aprendi muito!'),
(1, 4, 3, 'Achei o passeio legal, mas um pouco cansativo.'),
(2, 5, 4, 'Parque é lindo, adorei o piquenique.');
GO

-- Consultas de teste
SELECT * FROM dbo.alunos;
SELECT * FROM dbo.passeios;
SELECT * FROM dbo.reservas;
SELECT * FROM dbo.avaliacoes;