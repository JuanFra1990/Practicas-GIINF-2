#include <stdio.h>
#include <ctype.h>
int main(void) /* convertir la entrada de minúsculas a mayúsculas */
{
        int c;
 
        while ((c = getchar()) != EOF)
        putchar(islower(c) ? toupper(c) : c);
}
