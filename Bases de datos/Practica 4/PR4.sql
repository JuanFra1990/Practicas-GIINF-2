 /*PRACTICA 4*/
 
 /**/
INSERT INTO sesion
SELECT cn,ce,0,'10-04-2011'
FROM sesion 
WHERE fecha='17-FEB-11';
 
 

 /**/
UPDATE sesion
SET tiempo=(SELECT AVG(t_max)-100 FROM entreno e
WHERE estilo='LIB')
WHERE ce LIKE 'L%';

/**/
UPDATE sesion s
SET tiempo=(SELECT t_max/2
            FROM entreno e
            WHERE e.ce=s.ce)
WHERE tiempo=0  ;


COMMIT;

/**/
UPDATE entreno
SET t_max=t_max*0.9
WHERE ce IN ( SELECT e.ce
                FROM sesion s , entreno e
                WHERE s.ce=e.ce 
                GROUP BY e.ce,metros
                HAVING COUNT(*)*metros>200
                );


/**/
SELECT cn 
FROM nadador
WHERE esp IS NULL ;

SELECT cn, SUM(tiempo) 
FROM sesion
GROUP BY cn;

DELETE FROM sesion s
WHERE fecha>'01-MAR-2011' AND cn IN (SELECT cn 
                                      FROM nadador
                                    WHERE esp IS NULL)
AND tiempo>(SELECT t_max/2 
            FROM entreno e
            WHERE s.ce=e.ce);                                    

