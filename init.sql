CREATE
DATABASE IF NOT EXISTS alunos_db;

USE
alunos_db;

CREATE TABLE IF NOT EXISTS alunos
(
    id
    INT
    AUTO_INCREMENT
    PRIMARY
    KEY,
    nome
    VARCHAR
(
    100
) NOT NULL,
    ra VARCHAR
(
    20
) NOT NULL,
    curso VARCHAR
(
    100
) NOT NULL,
    turma VARCHAR
(
    50
) NOT NULL,
    status_matricula BOOLEAN NOT NULL,
    );

INSERT INTO alunos (nome, ra, curso, turma, status_matricula, idade)
VALUES ('Maria Silva', 'RA1001', 'Engenharia', 'A1', TRUE),
       ('João Souza', 'RA1002', 'Direito', 'B2', TRUE),
       ('Ana Costa', 'RA1003', 'Medicina', 'C1', FALSE);
