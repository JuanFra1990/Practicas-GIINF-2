#!/bin/bash
#Autor:Juan Francisco Aban Fontecha
#Descripcion: recibe un UID de un usuario y comprueba si existe

if [ ${#} -ne 1 ]
then
	echo "Error sintaxis del programa: ${0} UID"
else
	uid=${1}
	lista=$(cat /etc/passwd | grep ${uid})
	if [ lista ]
	then
		user=$(echo ${lista} | cut -d":" -f1)
		echo "El usuario con ese uid es: ${user}"
		gid=$(echo ${lista} | cut -d":" -f4)
		if [ ${uid} == ${gid} ]
		then
			echo "Tiene mismo gid que uid"
		fi
	else
		echo "No existe usuario con ese uid"
	fi
