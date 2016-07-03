			.data 1000
			.global numbers
numbers: 	.word 11
			.word 8,10,13,2,5,3,4,1,6,10
			.word 11,20,3,8,19,12,8,10,19,20
			.word 21,1,3,45,67,5,65,67,65,32
			.global tam
tam:		.word 40
			.text 256

			add r15,r0,tam					; r15=[tam]
			lw r15,(r15)						; r15=tam;
			addi r2,r0,#4 					; r2=i=4
			addi r1,r0,numbers 				; r1=[numbers]

BUCLE1:		add r6,r1,r2 					; r6=[numbers[i]]
			lw r4,(r6) 						; r4=numbers[i]
			subi r3,r2,4 					; r3=a=i-1

BUCLE2:		sge r12,r3,0 					; a>=0
			;BEQZ r12,BUCLE1CONT 			
			;ADD r6,r1,r3 					; [r6=numbers[a]]
			;LW r10,(r6) 					; r10=numbers[a]
			;SGT r12,r10,r4 					; numbers[a]>numbers[i]
			;beqz r12,BUCLE1CONT 			
			;ADDI r7,r3,#4 					; r7=a+1
			;ADD r5,r1,r3 					; r5=[numbers[a]]
			;ADD r7,r1,r7 					; r7=[numbers[a+1]]
			;LW r6,(r5) 						; r6=[numbers[a]]
			;SW (r7),r6 						; r7=[numbers[a]]
			;SUBI r3,r3,#4 					; a=a-1
			;SGE r12,r3,r0 					; comprobamos si a =0
			;bnez r12,BUCLE2 				 
BUCLE1CONT:	addi r7,r3,#4 					; a=a+1
			add r7,r1,r7 					; r7=[numbers[a+1]]
			sw (r7),r4 						; numbers[a+1]=index(numbers[i])
			addi r2,r2,#4 					; i++				
			slt r12,r2,r15 				; si i es menor que 40 salta a bucle, sino fin
			bnez r12,BUCLE1 ;
FIN: 		trap #0 ;