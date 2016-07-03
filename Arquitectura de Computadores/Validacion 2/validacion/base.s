.data 0

.double 14
.double 16,13,18,10,12,15
.double 17,18,15,12,11,18

.text 256

add r1,r0,8;sumamos 8 al desplazamiento para empezar en el segundo numero, primero del vector
ld f2,0(r0); cargamos el numero 14 para comparar
add r2,r0,12


bucle:
	ld f4,0(r1); comenzamos a cargar el vector
	add r1,r1,8; aumentamos el desplazamiento
	sub r2,r2,1; reducimos el contador
	
	gtd f4,f2; comparamos si f4 es mayor que f2
	bfpt esmayor

continua:
	bnez r2, bucle

trap #0

esmayor: add r3,r3,1 ; si es mayor sumamos uno al acumulador
	j continua