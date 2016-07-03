.data 1000

.float 1,2,3,4,5,6,7,8,9,10
.float 11,12,13,14,15,16,17,18,19,20
.float 21,22,23,24

.text 256

add r1,r0,6


bucle:
	lf f1,0(r2)
	lf f2,4(r2)
	lf f3,8(r2)
	lf f4,12(r2)
	addf f6,f1,f2
	addf f7,f3,f4
	add r2,r2,16; suma desplazamiento
	addf f8,f6,f7
	sub r1,r1,1;restas contador
	addf f9,f8,f9
bnez r1,bucle

trap #0