CREATE TABLE  IF NOT EXISTS pessoa (
   id BIGINT NOT NULL AUTO_INCREMENT,
   nome VARCHAR (50) NOT NULL,
   ativo TINYINT(1)  NOT NULL,
   logradouro VARCHAR (30)  NULL,
   numero VARCHAR (5)  NULL,
   complemento VARCHAR (50)  NULL,
   bairro VARCHAR (20)  NULL,
   cep VARCHAR (8)  NULL,
   cidade VARCHAR (20)  NULL,
   estado VARCHAR (3) NULL,
   PRIMARY KEY (id)
)ENGINE= INNODB DEFAULT CHARSET= utf8;

INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado)
 VALUES('savio',1,'Rua abaíra','15','usf Salvlador','arraial','41204105','salvador','BA');
 
 INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado)
 VALUES('joao',1,'Rua abaíra','15','usf Salvlador','arraial','41204105','salvador','BA');
 
 INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado)
 VALUES('maria',1,'Rua abaíra','15','usf Salvlador','arraial','41204105','salvador','BA');