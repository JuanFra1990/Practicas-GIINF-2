#!/bin/bash
#Autor:Juan Francisco Aban Fontecha
#Descripcion:Recibe una o mas rutas de directorios y comprueba si es directorio
# y si tiene permisos de ejecucion y de lectura y mostrar su contenido

if [ ${#} -gt 0 ]
then
	lista=${*}
	for d in ${lista}
	do
		if [ -d ${d} ] && [ -x ${d} ] && [ -r ${d} ]
		then
			echo "El listado del directorio ${d} es:"
			ls ${d}
		else
			echo "${d} no es directorio y no tiene permiso de lectura ni ejecucion"
		fi
	done
else
	echo "La sintaxis correcta es: ${0} directorio1 directorio2 ..."
fi
