#!/bin/bash
#Autor: Juan Francisco Aban Fontecha
#Descripcion: Analiza archivos de ~/bin e informa si hay archivos de 
#lectura o escritura para grupo u otros activo

ls -l ~/bin > /tmp/archivos
while read linea
do
	permisos=$(echo ${linea} | cut -d" " -f1)
	numper=$(echo ${permisos} | grep -o "w" | wc -c)
	numper1=$(echo ${permisos} | grep -o "r" | wc -c)
	nombre=$(echo ${linea} | cut -d" " -f 9)
	if [ ${numper} -gt 2 ] || [ ${numper1} -gt 2 ]
	then
		echo ${nombre}
		echo "Tiene ${numper} w"
		echo "Tiene ${numper1} r"
		echo "Este archivo tiene permisos de lectura o  escritura para 
grupo u otros"
		
	fi	
done < /tmp/archivos
