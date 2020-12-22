CREATE TABLE if not exists lancamento (
	id				BIGINT(20) 		PRIMARY KEY AUTO_INCREMENT,
	descricao 			VARCHAR(50) 	NOT NULL,
	data_vencimento 	DATE	 		NOT NULL,
	data_pagamento  	DATE			NOT NULL,
	valor				DECIMAL(10,2)	NOT NULL,
	observacao			VARCHAR(100),
	tipo				VARCHAR(20)		NOT NULL,
	categoria_id	BIGINT(20)		NOT NULL,
	pessoa_id		BIGINT(20)		NOT NULL,
	FOREIGN KEY (categoria_id)  REFERENCES	categoria(id),
	FOREIGN KEY (pessoa_id)  	REFERENCES	pessoa(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO lancamento (descricao,data_vencimento,data_pagamento,valor, observacao, tipo,categoria_id,pessoa_id) 
	   VALUES ('Salário Mensal', '2017-02-10', '2017-02-10', 100.32,  null, 'DESPESA',1,1);
INSERT INTO lancamento (descricao,data_vencimento,data_pagamento,valor, observacao, tipo,categoria_id,pessoa_id) 
	   VALUES ('Salão beleza', '2017-03-10', '2017-03-12', 50.00,  null, 'RECEITA',2,2);
INSERT INTO lancamento (descricao,data_vencimento,data_pagamento,valor, observacao, tipo,categoria_id,pessoa_id) 
	   VALUES ('Manutenção carro', '2017-05-01', '2017-05-01', 349.99,  null, 'DESPESA',1,2);
INSERT INTO lancamento (descricao,data_vencimento,data_pagamento,valor, observacao, tipo,categoria_id,pessoa_id) 
	   VALUES ('Estorno compra', '2017-05-10', '2017-05-11', 599.90,  null, 'RECEITA',3,3);