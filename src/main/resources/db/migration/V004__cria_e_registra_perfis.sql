CREATE TABLE perfis(
   `pessoa_id` BIGINT (20) NOT NULL,
   `perfis` INT (11) DEFAULT NULL,
   KEY `fkpessoa_id` (`pessoa_id`),
   FOREIGN KEY (`pessoa_id`) REFERENCES `algamoneyapi`.`pessoa`(`id`)
)ENGINE= INNODB DEFAULT CHARSET= utf8;


INSERT  INTO `perfis`(`pessoa_id`,`perfis`) VALUES 
(1,1),
(1,2),
(2,2);