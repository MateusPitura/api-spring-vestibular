CREATE SEQUENCE universidades_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER universidades_trigger
BEFORE INSERT ON universidades
FOR EACH ROW
BEGIN
    SELECT universidades_seq.NEXTVAL INTO :new.id FROM dual;
END;
/

CREATE TABLE universidades(
    id NUMBER(19) NOT NULL,
    nome VARCHAR2(128) NOT NULL,
    sigla VARCHAR2(16) NOT NULL,
    url_image VARCHAR2(256) NOT NULL,
    CONSTRAINT universidades_pk PRIMARY KEY(id)
);

CREATE SEQUENCE eventos_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER eventos_trigger
BEFORE INSERT ON eventos
FOR EACH ROW
BEGIN
    SELECT eventos_seq.NEXTVAL INTO :new.id FROM dual;
END;
/

CREATE TABLE eventos(
    id NUMBER(19) NOT NULL,
    data DATE NOT NULL,
    descricao VARCHAR2(255) NOT NULL,
    universidade_id NUMBER(19) NOT NULL,
    CONSTRAINT eventos_pk PRIMARY KEY(id),
    CONSTRAINT eventos_fk FOREIGN KEY(universidade_id) REFERENCES universidades(id)
);

CREATE SEQUENCE avisos_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER avisos_trigger
BEFORE INSERT ON avisos
FOR EACH ROW
BEGIN
    SELECT avisos_seq.NEXTVAL INTO :new.id FROM dual;
END;
/

CREATE TABLE avisos(
    id NUMBER(19) NOT NULL,
    data TIMESTAMP NOT NULL,
    title VARCHAR2(128) NOT NULL,
    descricao VARCHAR2(256) NOT NULL,
    url VARCHAR2(256) NOT NULL,
    universidade_id NUMBER(19) NOT NULL,
    CONSTRAINT avisos_pk PRIMARY KEY(id),
    CONSTRAINT avisos_fk FOREIGN KEY(universidade_id) REFERENCES universidades(id)
);

CREATE SEQUENCE users_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER users_trigger
BEFORE INSERT ON users
FOR EACH ROW
BEGIN
    SELECT users_seq.NEXTVAL INTO :new.id FROM dual;
END;
/

CREATE TABLE users(
    id NUMBER(19) NOT NULL,
    username VARCHAR2(256) NOT NULL,
    password VARCHAR2(256) NOT NULL,
    CONSTRAINT users_pk PRIMARY KEY(id)
);
