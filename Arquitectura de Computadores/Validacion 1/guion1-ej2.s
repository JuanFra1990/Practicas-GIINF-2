.data 0
 .global x
x: .double 4
 .global y
y: .double 8
 .global out
out: .double 8


.text 256
ld f2,x
ld f4,y
multd f2,f2,f2
multd f4,f4,f4

trap #0