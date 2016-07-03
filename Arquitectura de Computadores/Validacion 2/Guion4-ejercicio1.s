
.data 0
.double 3,2,1,4,8,9,2,7,4,5
.double 3,2,8,4,5,3,2,6,4,5

.text 256

ld f6,0(r1)
add r4,r0,20

bucle:

ld f2,0(r1)
sub r4,r4,1
ltd f2,f6
bfpt min

continua:
addi r1,r1,8

bnez r4,bucle

trap #0

min: ld f6,0(r1)
j continua