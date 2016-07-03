.data 0
.double 8,2,3,4,1

.text 256

add r3,r0,5

bucle1:
ld f2,0(r4);carga un minimo
sub r3,r3,1
add r1,r0,5
	bucle2:
		ld f4,0(r2)
		sub r1,r1,1
		add r2,r2,8
		ltd f4,f2
		bfpt minimo
	vuelve:
		
		bnez r1,bucle2


add r4,r4,8
bnez r3,bucle1
	

trap #0 


minimo: sd 0(r6),f4
add r6,r6,8
j vuelve