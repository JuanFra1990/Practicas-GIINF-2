#!/bin/bash
#Autor: Juan Francisco Aban Fontecha
#Descripcion: Comprobar ficheros.sh en ~/bin si no tienen permiso de 
#ejecucion darselo, y comprobar que el resto no lo tienen y mostrar 
# numero de archivos a los que le ha puesto ejecucion y a cuantos se lo 
#ha quitado

perot=0
perquit=0

for f in `ls ~/bin`
do
	if [ -d ${f} ]
	then
		echo "${f} es un directorio"
	else
		ext=$(echo ${f} | cut -d"." -f 2)
		if [ ${ext} == sh ]
		then
			echo "El archivo ${f} es ejecutable"
			if [ ! -x ~/bin/${f} ]
			then
				chmod u+x ~/bin/${f}
				perot=$((perot+1))
			fi
		else
			echo "El archivo ${f} no es ejecutable"
			if [ -x ~/bin/${f} ]
			then
				chmod ugo-x ~/bin/${f}
				perquit=$((perquit+1))
			fi
		fi
	
	fi
done

echo "El numero de ficheros a los que le ha otorgado permisos es: 
${perot}"

echo "El numero de ficheros a los que les ha quitado permisos es: 
${perquit}"
