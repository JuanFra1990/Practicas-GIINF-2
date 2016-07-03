.data 1000
.double 1,2,3,4,5,6,7,8,9,10
.double 11,12,13,14,15,16,17,18,19,20
.double 21,22,23,24,25,26,27,28,29,30

.text 256


add r1,r0,5

Bucle:

ld f2,0(r6);Cargo un minimo
add r4,r0,0
sub r3,r1,1



Bucleminimo:
	
	ld f4,0(r4)
	sub r3,r3,1
	ged f2,f4
	bfpt min
	retorno:
		add r4,r4,8;Sumamos desplazamiento
		bnez r3,Bucleminimo; condicion de salida


sd 0(r10),f2;almacena el minimo
add r10,r10,8
;FINBUCLEMINIMO
sub r1,r1,1
add r6,r6,8
seq r9,r1,1
beqz r9,Bucle

sd 0(r10),f4

trap #0


min:	addd f2,f4,f0
	j retorno