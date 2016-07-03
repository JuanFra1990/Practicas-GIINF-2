#!/bin/bash
#Autor: Juan Francisco Abán Fontecha
#Descripcion: Renombra ficheros del directorio ~/bin
# añadiendo .sh a ejecutables, sino existe nombre

for a in `ls ~/bin`
do
	exten=$(echo $a.sh | cut -d"." -f 2)
	echo exten
	if [ -x ~/bin/${a} ] && [ exten != "sh"  ]
	then
		mv ~/bin/${a} ~/bin/${a}.sh
	fi
	
done 
