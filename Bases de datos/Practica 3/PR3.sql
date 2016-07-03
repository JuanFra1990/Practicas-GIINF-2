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


/*SIN ACABAR*/
 INSERT INTO sesion VALUES('222', 'M10',81,'18-3-2011');
 
 SELECT DISTINCT cn 
 FROM sesion s, entreno e
 WHERE s.ce=e.ce AND
 s.cn = (
 SELECT cn FROM nadador n
 WHERE estilo
 );
 
 
 
 /**/
 
 SELECT DISTINCT nombre 
 FROM nadador n, sesion s, entreno e
 WHERE n.cn=s.cn AND e.ce=s.ce
 AND estilo<>'LIB';
 
 
 /**/
 SELECT * FROM entreno;
 SELECT * FROM nadador;
 SELECT * FROM sesion
 ORDER BY fecha, cn;