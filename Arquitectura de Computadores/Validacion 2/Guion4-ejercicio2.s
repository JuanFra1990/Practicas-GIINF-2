.data 0

.float 1,2,3,1,2,3

.text 256


lf f12,0(r2)
lf f10,4(r2)
add r1,r0,2

buclepar:
add r2,r2,8
sub r1,r1,1
lf f1,0(r2)
multf f12,f12,f1
bnez r1,buclepar

add r1,r0,2
add r2,r0,4

bucleimpar:
add r2,r2,8
sub r1,r1,1
lf f1,0(r2)
multf f10,f10,f1

bnez r1,bucleimpar

trap #0