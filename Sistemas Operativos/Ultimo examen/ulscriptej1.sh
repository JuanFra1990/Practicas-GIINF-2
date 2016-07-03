#!/bin/bash
#Autor: Juan Francisco Abán Fontecha
#Descripcion: Analiza /etc/passwd y muestra usuarios que no son del 
#sistema y que su directorio no cuelga de /home

usuarios=$(cat /etc/passwd | wc -l)

for us in `cat /etc/passwd`
do
		
		uidus=$(echo ${us} | cut -f 3 -d":")
		echo $uidus
			if [ ${uidus} -ge 1000 ] 2> /dev/null
			then
				dirhome=$(echo ${us} | cut -f 6 -d":")
				homed=$(echo ${dirhome:0:5} )
				if [ ${homed} != "/home" ] 2> /dev/null
				then
					echo ${us} | cut -f 1 -d":"
				fi		
			fi
done
