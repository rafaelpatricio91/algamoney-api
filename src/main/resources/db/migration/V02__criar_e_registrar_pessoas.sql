CREATE TABLE pessoas
(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
		logradouro VARCHAR(50),
		numero VARCHAR(5) NOT NULL,
		complemento VARCHAR(100),
		bairro VARCHAR(50) NOT NULL,
		cep VARCHAR(10) NOT NULL,
		cidade VARCHAR(30) NOT NULL,
		estado VARCHAR(20) NOT NULL,
	ativo BOOLEAN
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoas(nome,ativo,numero,bairro,cep,cidade,estado) 
VALUES('Rafael',true,'31','São Roque','26312-275','Queimados','RJ');

INSERT INTO pessoas(nome,ativo,numero,bairro,cep,cidade,estado) 
VALUES('Joya',true,'20','Fanchem,','11111-222','Queimados','RJ'); 

INSERT INTO pessoas(nome,ativo,numero,bairro,cep,cidade,estado) 
VALUES('Adomeu',false,'70','Confins','45645-222','Carnaúba','ES');

INSERT INTO pessoas(nome,ativo,numero,bairro,cep,cidade,estado) 
VALUES('Hare Zuia',true,'11','Pandavas','55555-555','Mosteiro','MG');

INSERT INTO pessoas(nome,ativo,numero,bairro,cep,cidade,estado) 
VALUES('Linquel',false,'2236','Alameda Caio','77777-999','Andro Favo','RN');

INSERT INTO pessoas(nome,ativo,numero,bairro,cep,cidade,estado) 
VALUES('Julio',true,'132','Banca Mil','22232-112','Pote de Ouro','RS');
