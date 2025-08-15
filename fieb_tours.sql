-- Criar o banco de dados
CREATE DATABASE fieb_tours;
GO

-- Usar o banco
USE fieb_tours;
GO

CREATE TABLE alunos (
                        id BIGINT IDENTITY(1,1) PRIMARY KEY,
                        rm VARCHAR(255) NOT NULL UNIQUE,
                        nome VARCHAR(255) NOT NULL,
                        turma VARCHAR(255) NOT NULL,
                        numeroChamada INT NOT NULL,
                        senhaBase64 VARCHAR(MAX) NOT NULL
);

CREATE TABLE passeios (
                          id BIGINT IDENTITY(1,1) PRIMARY KEY,
                          titulo VARCHAR(255) NOT NULL,
                          descricao VARCHAR(MAX) NULL,
    data DATE NOT NULL,
    preco DECIMAL(18, 2) NOT NULL
);

CREATE TABLE reservas (
                          id BIGINT IDENTITY(1,1) PRIMARY KEY,
                          aluno_id BIGINT NOT NULL,
                          passeio_id BIGINT NOT NULL,
                          CONSTRAINT FK_reserva_aluno FOREIGN KEY (aluno_id) REFERENCES alunos(id),
                          CONSTRAINT FK_reserva_passeio FOREIGN KEY (passeio_id) REFERENCES passeios(id)
);

INSERT INTO passeios (titulo, descricao, data, preco) VALUES
                                                          ('Visita ao Museu do Ipiranga', 'Passeio cultural ao Museu do Ipiranga, com guia incluso.', '2025-09-10', 50.00),
                                                          ('Parque Ibirapuera', 'Passeio de lazer no Parque Ibirapuera, com atividades recreativas.', '2025-09-15', 20.00),
                                                          ('Planetário do Carmo', 'Exploração astronômica no planetário, com oficinas práticas.', '2025-09-20', 30.00);

INSERT INTO alunos (rm, nome, turma, numeroChamada, senhaBase64) VALUES
                                                                     ('RM001', 'Ana Silva', 'Turma A', 1, 'c2VuaGExMjM='),
                                                                     ('RM002', 'Bruno Souza', 'Turma A', 2, 'c2VuaGE0NTY='),
                                                                     ('RM003', 'Carla Pereira', 'Turma B', 3, 'c2VuaGE3ODk='),
                                                                     ('RM004', 'Diego Martins', 'Turma B', 4, 'c2VuaGEwMTI='),
                                                                     ('RM005', 'Elisa Fernandes', 'Turma C', 5, 'c2VuaGEzNDU=');
