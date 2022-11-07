CREATE TABLE IF NOT EXISTS exame (rowid bigint auto_increment, nm_exame VARCHAR(255), PRIMARY KEY (rowid));
INSERT INTO exame (nm_exame) VALUES ('Acuidade Visual'), ('Urina'), ('Clinico');
CREATE TABLE IF NOT EXISTS funcionario (rowidFunc bigint auto_increment, nm_funcionario VARCHAR(255), PRIMARY KEY (rowidFunc));
INSERT INTO funcionario (nm_funcionario) VALUES ('Erick'), ('Luma');
CREATE TABLE IF NOT EXISTS exameFuncionario
(
    rowidExameFunc bigint auto_increment,
    rowidFunc bigint not null,
    rowid bigint not null,
    data_exame varchar(10) not null,
    CONSTRAINT exameFuncionario_rowidFunc_fk FOREIGN KEY (rowidFunc) REFERENCES funcionario (rowidFunc) ON DELETE CASCADE ON UPDATE RESTRICT,
    CONSTRAINT exameFuncionario_rowid_fk FOREIGN KEY (rowid) REFERENCES exame (rowid) ON DELETE RESTRICT ON UPDATE RESTRICT
);
CREATE UNIQUE INDEX exameFuncionario_un ON exameFuncionario (rowidFunc, rowid, data_exame);

INSERT INTO exameFuncionario (rowid, rowidFunc, data_exame) VALUES (1, 1, '2000-02-02');
