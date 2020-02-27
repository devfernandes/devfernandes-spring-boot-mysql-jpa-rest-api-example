CREATE TABLE PERSON(
	Id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	person_name VARCHAR(50) NOT NULL,
    status BOOLEAN
) ENGINE = InnoDB DEFAULT CHARSET=UTF8;

INSERT INTO PERSON (person_name, status) VALUES
('Rafael Fernandes de Carvalho', true),
('Cauã Edson Assis', true),
('Marlene Lúcia Castro', true),
('Manoel Marcos Vinicius Gustavo Aragão', true),
('Giovana Lívia Rayssa da Conceição', true),
('Márcia Carolina Martins', true),
('Regina Emanuelly Josefa Oliveira', true),
('Roberto Mateus Oliveira', false),
('Oliver Marcos Vinicius Elias Gonçalves', true),
('Lívia Milena Vitória Viana', true);