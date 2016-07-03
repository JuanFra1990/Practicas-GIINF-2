#!/bin/bash
#Autor:Juan Francisco Aban Fontecha
#Descripcion: Se le pasan como argumentos nombres de componentes y nos dice que memoria ocupan en MB

if [ ${#} -gt 0 ]
then
	componentes=${*}
	for c in ${componentes}
	do
		echo ${c} >> /tmp/componentes
	done

	while read componente
	do
		comp=$(cat /proc/meminfo | grep ${componente})
		if [ -z ${comp} ]
		then
			echo "La memoria que ocupa ${componente} es:"
			echo $comp
			tamanio=$(echo ${comp} | cut -f 2 -d":" | sed s/KB//g | sed s/ //g )
			tamtotal=$((${tamtotal}+${tamanio}))
		fi
	done < /tmp/componentes
	tam=$(${tamtotal}/1024)
	echo "El tamaño total es ${tam} MB"
	rm /tmp/componentes
else
	echo "La sintaxis del programa es ${0} componente1 componente2 ..."
fi
