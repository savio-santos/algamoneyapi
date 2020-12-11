CREATE TABLE categoria(
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
 
   	PRIMARY KEY(id)
 )ENGINE=InnoDB default CHARSET=utf8;
 
 INSERT INTO categoria (nome) VALUES('lazer');
 INSERT INTO categoria (nome) VALUES('Alimentação');
 INSERT INTO categoria (nome) VALUES('Supermercado');
 INSERT INTO categoria (nome) VALUES('Farmacia');
 INSERT INTO categoria (nome) VALUES('Outros');

 