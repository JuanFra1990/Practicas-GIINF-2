#!/bin/bash
#Autor: Juan Francisco Aban Fontecha
#Descripcion: Recibe nombres de usuario y comprueba si existe y si existe su directorio base

if [ ${#} -gt 0 ]
then
	usuarios=${*}
	touch /tmp/usuario
	for u in ${usuarios}
	do
		echo ${u} >> /tmp/usuario
	done
		cat /tmp/usuario
	while read usuario
	do
		compus=$(cat /etc/passwd | grep ${usuario} | cut -d":" -f1 )
		if [ -n ${compus} ]
		then
			echo "El usuario ${usuario} existe"
			compdir=$(cat /etc/passwd | grep ${usuario} | cut -d":" -f6)
			if [ ${compdir} == /home/$usuario ]
			then
				echo "Su directorio base es: $compdir "
			else
				echo "No tiene directorio base"
			fi
		else
			echo $compus
			echo "El usuario ${usuario} no existe"
		fi
	done < /tmp/usuario
	rm /tmp/usuario
else
	echo "Error: La sintaxis del programa es ${0} User1 User2 ..."
fi
