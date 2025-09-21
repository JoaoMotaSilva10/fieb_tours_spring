USE master;
GO

-- Criar o banco novamente
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
                              nome VARCHAR(255) NOT NULL,
                              descricao VARCHAR(MAX) NULL,
    dataPasseio DATE NOT NULL,
    preco DECIMAL(18,2) NOT NULL,
    horaSaida VARCHAR(10) NOT NULL,
    horaChegada VARCHAR(10) NOT NULL,
    dataInicioRecebimento DATE NOT NULL,
    dataFinalRecebimento DATE NOT NULL,
    dataCadastro DATETIME NOT NULL,
    statusPasseio VARCHAR(50) NOT NULL
);
GO

-- Tabela de reservas com os mesmos campos do frontend
CREATE TABLE dbo.reservas (
                              id BIGINT IDENTITY(1,1) PRIMARY KEY,
                              nome VARCHAR(255) NOT NULL,         -- nome do aluno
                              turma VARCHAR(255) NOT NULL,        -- email do aluno
                              passeio VARCHAR(255) NOT NULL,      -- nome do passeio
                              status VARCHAR(50) NOT NULL DEFAULT 'nao-pago' -- status da reserva
);
GO

-- Tabela de avaliações
CREATE TABLE dbo.avaliacoes (
                                id BIGINT IDENTITY(1,1) PRIMARY KEY,
                                passeio_id BIGINT NOT NULL,
                                aluno_id BIGINT NOT NULL,
                                nota INT NOT NULL CHECK (nota >= 1 AND nota <= 5),
                                comentario VARCHAR(MAX) NULL,
    CONSTRAINT FK_avaliacao_passeio FOREIGN KEY (passeio_id) REFERENCES dbo.passeios(id) ON DELETE CASCADE,
    CONSTRAINT FK_avaliacao_aluno FOREIGN KEY (aluno_id) REFERENCES dbo.alunos(id) ON DELETE CASCADE
);
GO

-- Tabela de gerenciadores com email
CREATE TABLE dbo.gerenciadores (
                                   id BIGINT IDENTITY(1,1) PRIMARY KEY,
                                   nome VARCHAR(255) NOT NULL,
                                   senhaBase64 VARCHAR(MAX) NOT NULL,
    unidade VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);
GO

-- Inserir um aluno
INSERT INTO dbo.alunos (rm, nome, turma, numeroChamada, senhaBase64)
VALUES ('12345', 'João Silva', '3A', 10, 'c2VuaGExMjM=');  -- senha "senha123" em Base64

-- Inserir um gerenciador
INSERT INTO dbo.gerenciadores (nome, senhaBase64, unidade, email)
VALUES ('Maria Souza', 'YWRtaW4xMjM=', 'Unidade Central', 'maria.souza@fieb.com'); -- senha "admin123" em Base64


-- Consultas de teste
SELECT * FROM dbo.alunos;
SELECT * FROM dbo.passeios;
SELECT * FROM dbo.reservas;
SELECT * FROM dbo.avaliacoes;
SELECT * FROM dbo.gerenciadores;
GO
