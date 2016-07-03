.data 0

.double 14
.double 16,13,18,10,12,15
.double 17,18,15,12,11,18

.text 256

add r1,r0,8;sumamos 8 al desplazamiento para empezar en el segundo numero, primero del vector
ld f2,0(r0); cargamos el numero 14 para comparar
add r2,r0,3; sumamos 3 al contador para que haga 3 iteraciones el bucle


bucle:
	ld f4,0(r1)
	ld f6,8(r1)
	ld f8,16(r1)
	ld f10,24(r1)

	add r1,r1,32; aumentamos el desplazamiento
	sub r2,r2,1; reducimos el contador
	
	gtd f4,f2; Comparamos uno a uno los 4 elementos del vector cargado
	bfpt esmayor1
	
	comprueba1:

	gtd f6,f2
	bfpt esmayor2

	comprueba2:
	gtd f8,f2
	bfpt esmayor3
	
	comprueba3:
	gtd f10,f2
	bfpt esmayor4

continua:
	bnez r2, bucle

trap #0

esmayor1: add r3,r3,1 ; si es mayor sumamos uno al acumulador
	j comprueba1

esmayor2: add r3,r3,1 ; si es mayor sumamos uno al acumulador
	j comprueba2

esmayor3: add r3,r3,1 ; si es mayor sumamos uno al acumulador
	j comprueba3

esmayor4: add r3,r3,1 ; si es mayor sumamos uno al acumulador
	j continua