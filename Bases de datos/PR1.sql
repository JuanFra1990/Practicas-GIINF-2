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

/*PRACTICA 2*/

SELECT * FROM entreno;

/**/
SELECT sexo S, nombre FROM nadador
ORDER BY sexo DESC, nombre ASC;

/**/
SELECT DISTINCT fecha FROM sesion;

/**/
SELECT TO_CHAR(fecha,'dd-mon-yyyy') "Fecha", tiempo FROM sesion
ORDER BY fecha DESC;

/**/

SELECT CE, T_MAX, T_MAX*1.1 "Aumento de t_max" FROM entreno;

/**/
SELECT * FROM nadador WHERE nombre like 'A%'  OR sexo='F';

/**/
SELECT * FROM nadador where ESP IS NULL;

/**/
SELECT s.cn,ce,tiempo,fecha,nombre,esp FROM sesion s,nadador n
WHERE s.cn=n.cn
ORDER BY fecha;

/**/
SELECT nombre, e.metros, t_max, tiempo FROM entreno e, nadador n, sesion s
WHERE e.ce=s.ce AND n.cn=s.cn AND sexo='F'
ORDER BY tiempo ASC;

/**/
SELECT en.estilo, e.estilo, en.metros
FROM entreno e,entreno en
WHERE e.metros=en.metros AND en.estilo > e.estilo;

/*PRACTICA 3*/
/**/
SELECT AVG(tiempo) "Tiempo Medio", SUM(tiempo) "Tiempo total" FROM sesion
where fecha='17/02/2011';

/**/
SELECT estilo, COUNT(*) "Num. Entrenamientos"  FROM entreno 
GROUP BY estilo
ORDER BY estilo;

/**/
SELECT estilo, SUM(metros) FROM entreno e, sesion s
WHERE e.ce=s.ce
GROUP BY estilo
ORDER BY estilo;

/**/
SELECT nombre, SUM(metros) "Total Metros" FROM nadador n, entreno e, sesion s
WHERE e.ce=s.ce AND n.cn=s.cn 
HAVING SUM(metros)>100
GROUP BY nombre
ORDER BY nombre;

/**/
SELECT DISTINCT cn "Nadador", fecha "FECHA" FROM sesion
WHERE fecha IN
(SELECT fecha FROM sesion
WHERE cn='333') AND cn!='333';


/**/
SELECT nombre, SUM(metros) "Total Metros" 
FROM nadador n, entreno e, sesion s
WHERE e.ce=s.ce AND n.cn=s.cn
GROUP BY nombre
HAVING SUM(metros)=
(SELECT MAX(SUM(metros))
FROM nadador n, entreno e, sesion s
WHERE e.ce=s.ce AND n.cn=s.cn
GROUP BY nombre);


/**/
SELECT nombre 
FROM nadador n
WHERE 100<(
SELECT sum(metros)
FROM sesion s, entreno e
WHERE s.ce=e.ce AND s.cn=n.cn);

/**/
INSERT INTO sesion VALUES ('111','L05',40,'18-3-2011');
INSERT INTO sesion VALUES ('222','L05',42,'18-3-2011');

/*SIN ACABAR*/
SELECT n1.nombre, n2.nombre
FROM nadador n1, nadador n2
WHERE (SELECT SUM(metros) 
FROM nadador 
GROUP BY nombre)=(SELECT SUM(metros) 
FROM nadador 
GROUP BY nombre);



/**/
INSERT INTO entreno VALUES('L20','LIB',200,420);

SELECT e.ce, en.ce
FROM entreno e, entreno en
WHERE e.estilo=en.estilo
AND e.ce<en.ce;


/**/
 INSERT INTO sesion VALUES('222', 'M10',81,'18-3-2011');
 
SELECT DISTINCT cn 
 FROM nadador n
 WHERE   NOT EXISTS ((SELECT DISTINCT estilo 
                      FROM entreno)
                    MINUS
                    (SELECT DISTINCT estilo 
                    FROM entreno e, sesion s
                    WHERE e.ce=s.ce AND n.cn=s.cn));

 
 /**/
 
 SELECT DISTINCT nombre
 FROM nadador n
 WHERE   NOT EXISTS (
                    (SELECT DISTINCT estilo 
                    FROM entreno e, sesion s
                    WHERE e.ce=s.ce AND n.cn=s.cn)
                    MINUS
                    (SELECT DISTINCT estilo 
                      FROM entreno WHERE estilo='LIB'))
ORDER BY nombre;
 

 
 /**/
 SELECT * FROM entreno;
 
 
 /**/
 SELECT * FROM nadador;
 SELECT * FROM sesion
 ORDER BY fecha, cn;
 
 /*ACLARACIONES*/
 UPDATE sesion
 SET tiempo=42
 WHERE cn=333 AND ce='L05' AND fecha='17-FEB-2011';
 
 /*ACLARACIONES*/
 UPDATE entreno
 SET t_max=195
 WHERE ce='L10';
 
COMMIT; 

ROLLBACK;


/*PRACTICA 5*/

/**/
CREATE OR REPLACE VIEW entreno_largo
AS SELECT *
FROM entreno
WHERE t_max>200;

SELECT * FROM entreno_largo;

/**/
/*Error: restriccion pk_entreno violada */
INSERT INTO entreno_largo
VALUES('M10','MAR',100,220 );

/*Error: restriccion ck_estilo_nadador violada*/
INSERT INTO entreno_largo
VALUES('R10','RLV',200,310);

INSERT INTO entreno_largo
VALUES('M05','MAR',50,100);

INSERT INTO entreno_largo
VALUES('M20','MAR',200,430);

/**/
CREATE OR REPLACE VIEW metros_por_nadador(nadador,nombre,metros)
AS SELECT n.cn, nombre, SUM(metros)
  FROM nadador n, entreno e, sesion s
  WHERE n.cn=s.cn AND e.ce=s.ce
  GROUP BY n.cn, nombre;
  
  SELECT * FROM metros_por_nadador
  ORDER BY nadador;


/**/
SELECT nadador,nombre, metros
FROM metros_por_nadador
WHERE metros=( SELECT MAX(metros)
              FROM metros_por_nadador 
              );

/**/
SELECT * 
FROM nadador
ORDER BY 1;

SELECT * 
FROM entreno
ORDER BY 1;

UPDATE entreno
SET t_max=81
WHERE ce='L05' AND estilo='LIB';

DELETE entreno
WHERE ce='M05' AND estilo='MAR';

UPDATE entreno
SET t_max=194
WHERE ce='M10' AND estilo='MAR';


SELECT * 
FROM sesion
ORDER BY 1,2,3,4;

UPDATE sesion
SET tiempo=135
WHERE cn=111 AND fecha='17/02/11';

DELETE sesion
WHERE cn=222 AND ce='L05';

DELETE sesion
WHERE cn=333 AND fecha!='17/02/11';

UPDATE sesion
SET tiempo=135
WHERE cn=333;

DELETE sesion
WHERE cn=444 AND tiempo=75;

INSERT INTO sesion
VALUES(444,'M10',75,'11/03/11');

INSERT INTO sesion
VALUES(444,'M10',75,'17/03/11');
