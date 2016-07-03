CREATE TABLE nadador (
  cn       NUMBER(3)   CONSTRAINT  pk_nadador  PRIMARY KEY,
  nombre   VARCHAR(10) CONSTRAINT nn_nombre_nadador NOT NULL,
  f_nac    DATE        CONSTRAINT nn_f_nac_nadador NOT NULL,
  sexo     VARCHAR(1)  CONSTRAINT ck_sexo_nadador CHECK (sexo='F' OR sexo='M'),
  esp      VARCHAR(3)  CONSTRAINT ck_esp_nadador CHECK(esp='BRA' OR esp='LIB' OR esp='MAR' OR esp='ESP')
  );
  
CREATE TABLE entreno (
  ce      VARCHAR(3)   CONSTRAINT pk_entreno PRIMARY KEY,
  estilo  VARCHAR(3)   CONSTRAINT ck_estilo_nadador CHECK(estilo='BRA' OR estilo='LIB' OR estilo='MAR' OR estilo='ESP') CONSTRAINT nn_estilo_entreno NOT NULL,
  metros  NUMBER(3)    CONSTRAINT ck_metros_entreno CHECK(metros>49 AND metros<401) CONSTRAINT nn_metros_entreno NOT NULL,
  t_max   NUMBER(3)
);

CREATE TABLE sesion (
  cn      NUMBER(3),
  ce      VARCHAR(3) CONSTRAINT fk_ce_entreno_sesion REFERENCES entreno,
  tiempo  NUMBER(3)
);


ALTER TABLE sesion ADD (fecha DATE);

ALTER TABLE sesion MODIFY (fecha DATE CONSTRAINT nn_fecha_sesion NOT NULL); 

ALTER TABLE sesion ADD (CONSTRAINT fk_cn_sesion_nadador FOREIGN KEY(cn) REFERENCES nadador);

ALTER TABLE sesion ADD (CONSTRAINT pk_sesion PRIMARY KEY(cn,ce,fecha));

INSERT INTO nadador VALUES (111,'MARIA','10/01/1987','F','BRA');

INSERT INTO nadador(cn,nombre,f_nac,SEXO) VALUES (222,'JUAN','4/03/1990','M');

INSERT INTO nadador(cn,nombre,f_nac,SEXO) VALUES (333,'ANA','25/01/1990','F');

INSERT INTO nadador VALUES (444,'ANDRES','2/6/1989','M','MAR');

INSERT INTO entreno (ce,estilo,metros,t_max) VALUES ('L05','LIB',50,90);

INSERT INTO entreno (ce,estilo,metros,t_max) VALUES ('L10','LIB',100,200);

INSERT INTO entreno (ce,estilo,metros,t_max) VALUES ('B10','BRA',100,240);

INSERT INTO entreno (ce,estilo,metros,t_max) VALUES ('M10','MAR',100,220);

INSERT INTO sesion (cn,ce,tiempo,fecha) VALUES(111,'L10',85,'17/02/2011');

INSERT INTO sesion (cn,ce,tiempo,fecha) VALUES(222,'B10',102, '17/02/2011');

INSERT INTO sesion (cn,ce,tiempo,fecha) VALUES(333,'L05',42, '17/02/2011');

INSERT INTO sesion (cn,ce,tiempo,fecha) VALUES(444,'M10',81, '17/02/2011');

INSERT INTO sesion  VALUES(333,'L05',45,'10-MAR-2011');

INSERT INTO sesion  VALUES(444,'M10',75,'10-MAR-2011');

INSERT INTO sesion  VALUES(333,'L05',39, '17-MAR-2011');

INSERT INTO sesion  VALUES(444,'M10',75, '17-MAR-2011');

/**/
UPDATE sesion SET fecha='11-MAR-2011' WHERE fecha='10-MAR-2011';

/*El error que nos aparece es porque al haber una condicion o restriccion de clave foranea entre esta tabla y la de sesion, donde al menos existe
  una tupla con el valor de cn que queremos borrar, lo que hacemos es violar la restriccion al querer borrarla*/
DELETE FROM nadador WHERE cn=111;

/**/
UPDATE entreno SET t_max=t_max-5 WHERE metros=100;

/*El error que nos aparece es que dado que hay una restriccion de clave foranea, al estar introduciendo B20 que no esta aun insertado en ninguna tupla de la tabla sesion */
INSERT INTO sesion (cn,ce,tiempo,fecha) VALUES (111, 'B20', 159, '10-FEB-2011');

/*Dado que la clave primaria esta formada por cn, ce y fecha no nos permite realizar la insercion, ya que estamos intentando insertar una tupla con esas columnas al mismo valor
  que una tupla ya existente*/
INSERT INTO sesion (cn,ce,tiempo,fecha) VALUES (111, 'L10', 82, '17-FEB-2011');


SELECT CN,NOMBRE,TO_CHAR(F_NAC,'dd-MON-yyyy') "F_NAC",ESP FROM nadador;

SELECT * FROM entreno;

SELECT CN,CE,TIEMPO,TO_CHAR(FECHA,'dd-MON-yyyy') "FECHA" FROM sesion;

