.data 0
 .global x
x: .double 10,2,3,4,5
.global xt
xt: .double -5


.text 256

add r4,r0,xt
ld f0,0(r4)

Bucle:

	ld f6,-8(r4);carga un numero
	ltd f2,f0
	bfpt min
	
retorno:sub r4,r4,8;Sumamos desplazamiento
	bnez r4,Bucle; condicion de salida

trap #0

min: movd f0,f2
	j retorno