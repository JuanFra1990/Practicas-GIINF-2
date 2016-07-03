#!/bin/bash
#Autor:Juan Francisco Aban Fontecha
#Descripcion:Recibe varios logins y comprueba si existen

if [ ${#} -gt 1 ]
then
	usuarios=${*}
	for u in $usuarios
	do
		usu=$(cut -f 1 -d":" /etc/passwd | grep ${u} )
		login=$(cut -f1 -d":" /etc/passwd | grep -ic ${u})
echo valor de usu $usu
		if [ ${login} -ge 1 ]
		then
			echo "El usuario ${u} existe"
			echo "Hay ${login} usuario con el nombre ${u}"
		else
			echo "El usuario ${u} esta libre"
		fi
	done
else
	echo "La sintaxis es  ${0} usuario1 usuario2 ...."
fi
