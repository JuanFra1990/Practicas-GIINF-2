.data 0

.double 1,2,3,5,4
;.double 6,7,8,9,10
;.double 11,12,13,14,15,16,17,18,19,20
;.double 21,22,23,24,25,26,27,28,29,9

.text 256

add r1,r0,5;inicializamos r1 a 10
add r3,r0,8; aumentamos desplazamiento

bucle:
ld f2,0(r2); cargar numero principal 

	bucle2:
		
		ld f4,0(r3); cargar numero secundario
		add r3,r3,8; Desplazamiento bucle2
		gtd f4,f2;comparar numeros
		sub r4,r4,1;descendemos en uno el contador
		bfpt mayor
	vuelve:
		bnez r4,bucle2


sub r1,r1,1;descendemos Contador bucle1
add r2,r2,8;desplazamiento bucle1
add r3,r2,8;Igualamos el desplazamiento del bucle2 al de bucle1+8

bnez r1,bucle


trap #0

mayor:add r10,r10,1
j vuelve
