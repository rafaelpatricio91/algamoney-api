CREATE TABLE categoria
(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO categoria(nome) VALUES('Farmácia');
INSERT INTO categoria(nome) VALUES('Supermercado');
INSERT INTO categoria(nome) VALUES('Hortifruti');
INSERT INTO categoria(nome) VALUES('Shows');
INSERT INTO categoria(nome) VALUES('Livros');
