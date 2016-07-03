.data 0
 .global x
x: .word 1,2,3,4,5,6,7,8,9,10
out: .word 10

.text 256

add r4,r0,r0
add r1,r0,5
add r5,r0,4
add r22,r0,5

Bucle:

	lw r3,0(r4);carga impares
	lw r6,0(r5);carga pares
	add r20,r20,r6; suma pares
	add r21,r21,r3; Suma impares
	

	add r4,r4,8;Sumamos desplazamiento
	add r5,r5,8;Sumamos desplazamiento
	addi r1,r1,-1;descendemos contador
	bnez r1,Bucle; condicion de salida

div r21,r21,r22; hacemos la media



trap #0