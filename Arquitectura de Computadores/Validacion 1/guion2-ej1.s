.data 0
 .global x
x: .word 1,2,3,4,5,6,7,8,9,10
out: .word 10

.text 256

add r25,r0,x 

lw r1,0(r25)
lw r2,4(r25) ; me muevo con el desplazamiento
lw r3,8(r25)
lw r4,12(r25)
lw r5,16(r25)
lw r6,20(r25) ; me muevo con el desplazamiento
lw r7,24(r25)
lw r8,28(r25)
lw r9,32(r25)
lw r10,36(r25)


add r12,r2,r4
add r12,r12,r6
add r12,r12,r8; suma de los numeros en posiciones pares
add r12,r12,r10

sw out,r12
lw r12,out

add r11,r1,r3
add r11,r11,r5
add r11,r11,r7; media de los numeros en posiciones impares
add r11,r11,r9
div r11,r11,r5

sw out,r11
lw r11,out

trap #0