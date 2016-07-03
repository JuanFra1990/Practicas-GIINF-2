.data 0
 .global x
x: .word 4
 .global y
y: .word 8
 .global out
out: .word 8


.text 256
lw r1,x
lw r2,y
add r3,r1,r2
sw out,r3
lw r4,out
trap #0