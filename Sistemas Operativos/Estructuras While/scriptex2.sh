#!/bin/bash
#Autor:Juan Francisco Aban Fontecha
#Descripcion: Recibe componentes del pc e indica cuanta memoria consumen 
en un instante determinado

if [ ${#} -le 0 ]
then
	echo "ERROR: La sintaxis es ${0} comp1 comp2 ..."
else 
	componentes=${*}
	for c in ${componentes}
	do
		echo ${c} >> component
	done
	
	while read linea
	do
		comp=$(cat /proc/meminfo | grep -w ${linea})
		if [ $comp ]
		then
			echo "El componente existe:"
			echo $comp
			tamanio=$(echo ${linea} | cut -f2 -d":" | sed 
s/kB//g | sed s/ //g)
			tamanioMB=$((${tamanio}/1024))
			echo "su tamaño en MB es: ${tamanioMB}"
			tamaniototal+=$((tamanio)) 
		else
			echo "El componente ${linea} no existe"
		fi
	done < ./component
	tamaniototalMB=$((${tamaniototal}/1024))
	echo "Los componentes ${*} ocupan en memoria: ${tamaniototalMB} 
MB"
fi
