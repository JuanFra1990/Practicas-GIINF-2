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
