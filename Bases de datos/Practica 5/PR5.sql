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