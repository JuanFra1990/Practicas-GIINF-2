#!/bin/bash
#Autor:Juan Francisco Aban Fontecha
#Descripcion: recibe un UID de un usuario y comprueba si existe

if [ ${#} -le 0 ]
then
	echo "Error sintaxis del programa: ${0} UID1 UID2 ..."
else
	uids=${*}
	for u in ${uids}
	do
		echo ${u} >> usuarios
	done
	
	listausuarios=$(cat /etc/passwd)
	while read linea
	do
		us=$(echo $listausuarios | grep ${linea})
		if [ ${us} ]
		then
			ue={echo ${us} | cut -d":" -f1}
			echo "El usuario existe y su login es: ${ue}"
			existen=$((existen++))
		else
			echo "El UID ${us} no esta en uso"
			noexisten=$((noexisten++))
		fi
	done < ./usuarios
	echo "Numero de usuarios comprobados que existen: ${existen}"
	echo "Numero de usuarios comprobados que no existen: 
${noexisten}"
fi
