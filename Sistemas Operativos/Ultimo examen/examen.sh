#!/bin/bash
#Autor: Juan Francisco Aban Fontecha
#Descripcion: Recibe tres argumentos o mas, nombre, extension y lista de nombres de archivos
#Renombra todos los archivos de la lista con el formato nombre-###.extension

contador=0

if [ ${#} -ge 3 ]
then
	nombre=${1}
	extension=${2}
	listaficheros=${*}
	for f in $listaficheros
	do
		if [ ${f} != ${1} ] 
		then
			if [ ${f} != ${2} ]
			then
				contador=$((${contador}+1))
				renom="${nombre}${contador}.${extension}"
				mv ${f} ${renom} 2> /dev/null
				echo "Ha sido renombrado ${f} a ${renom}"
			fi
		fi
 	done

else
	echo "Error el formato es: ${0} nombre extension archivo1 archivo2..."
fi

