#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
void mayus(FILE *fp);
int main(int argc, char *argv[]) /* mayus2: convierte la entrada de minúsculas a mayúsculas */
 
{
        FILE *fp;
        if (argc == 1) /* ningún argumento, a mayúsculas la entrada estándar */
        mayus(stdin);
        else
        if ((fp = fopen(argv[1], "r")) == NULL) {
                fprintf(stderr, "%s: no puedo abrir %s\n", argv[0], argv[1]);
                exit(1);
        } else {
                mayus(fp);
                fclose(fp);
        }
}
 
void mayus(FILE *fp) /* pasa a mayúsculas el fichero fp a la salida estándar */
{
        int c;
        while ((c = getc(fp)) != EOF)
        putc(islower(c) ? toupper(c) : c, stdout);
}
