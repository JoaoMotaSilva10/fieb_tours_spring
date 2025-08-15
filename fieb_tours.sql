-- Criar o banco de dados
CREATE DATABASE fieb_tours;
GO

-- Usar o banco
USE fieb_tours;
GO

-- Tabela de usuários (alunos)
CREATE TABLE alunos (
                        id INT IDENTITY(1,1) PRIMARY KEY,
                        rm NVARCHAR(20) NOT NULL UNIQUE,
                        nome NVARCHAR(100) NOT NULL,
                        turma NVARCHAR(50) NOT NULL,
                        numero_chamada INT NOT NULL,
                        senha NVARCHAR(255) NOT NULL -- pode guardar Base64 ou hash
);
GO

-- Tabela de passeios
CREATE TABLE passeios (
                          id INT IDENTITY(1,1) PRIMARY KEY,
                          titulo NVARCHAR(100) NOT NULL,
                          descricao NVARCHAR(MAX) NULL,
                          data DATE NOT NULL,
                          preco DECIMAL(10,2) NOT NULL
);
GO

-- Tabela de reservas
CREATE TABLE reservas (
                          id INT IDENTITY(1,1) PRIMARY KEY,
                          aluno_id INT NOT NULL,
                          passeio_id INT NOT NULL,
                          data_reserva DATETIME DEFAULT GETDATE(),
                          FOREIGN KEY (aluno_id) REFERENCES alunos(id) ON DELETE CASCADE,
                          FOREIGN KEY (passeio_id) REFERENCES passeios(id) ON DELETE CASCADE
);
GO

-- Inserir alguns passeios iniciais
INSERT INTO passeios (titulo, descricao, data, preco) VALUES
('Visita ao Museu do Ipiranga', 'Passeio cultural ao Museu do Ipiranga, com guia incluso.', '2025-09-10', 50.00),
('Parque Ibirapuera', 'Passeio de lazer no Parque Ibirapuera, com atividades recreativas.', '2025-09-15', 0.00),
('Planetário do Carmo', 'Exploração astronômica no planetário, com oficinas práticas.', '2025-09-20', 30.00);
GO
