CREATE TABLE USUARIO (
                         ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                         DATA_DE_CRIACAO TIMESTAMP NOT NULL,
                         DATA_DA_ULTIMA_ALTERACAO TIMESTAMP NOT NULL,
                         email VARCHAR(255) NOT NULL,
                         endereco VARCHAR(255),
                         login VARCHAR(100) NOT NULL,
                         nome VARCHAR(100) NOT NULL,
                         senha VARCHAR(255) NOT NULL,
                         ROLE VARCHAR(20) NOT NULL
);