CREATE TABLE  IF NOT EXISTS pessoa (
   id BIGINT NOT NULL AUTO_INCREMENT,
   nome VARCHAR (50) NOT NULL,
   email VARCHAR (100) NOT NULL,
   senha VARCHAR (255) NOT NULL,
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

INSERT INTO pessoa (nome,email,senha,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado)
 VALUES('savio','savio@gmail.com','$2a$10$sX0l3fSvSCkNNw9lxiz60uN.a5WOZeI7W2IoAk0RJ2O2qth5cofzm',1,'Rua abaíra','15','usf Salvlador','arraial','41204105','salvador','BA');
 
 INSERT INTO pessoa (nome,email,senha,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado)
 VALUES('kauana','kauana@gmail.com','$2a$10$HVZmaD620bUvZqew.q.rLecAGsoW7h1IEyRibo0.uzs8KfXfktGae',1,'Rua abaíra','15','usf Salvlador','arraial','41204105','salvador','BA');
 