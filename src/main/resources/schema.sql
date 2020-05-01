DROP TABLE IF EXISTS estudante;
 
CREATE TABLE IF NOT EXISTS estudante (
  id              INT   NOT NULL AUTO_INCREMENT,
  nome       	  VARCHAR(80) NOT NULL,
  email           VARCHAR(60) NOT NULL,
  telefone        NUMBER,
  matricula		  NUMBER NOT NULL,
  curso			  VARCHAR(80)
);