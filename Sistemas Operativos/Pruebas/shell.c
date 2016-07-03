#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#define MAXLINE 100
 
int main(void)
{
        char buf[MAXLINE];
        id_t pid;
        int status;
 
        printf("%% "); /* escribe el indicador % (printf requiere %% para escribir %) */
 
        while (fgets(buf, MAXLINE, stdin) != NULL) {
 
                buf[strlen(buf) - 1] = '\0'; /* cambia newline por nulo */
 
                pid = fork();
 
                if (pid < 0) { /* no se pudo crear el hijo */
 
                        puts("Error en fork");
                        exit(127);
 
                } else if (pid == 0) { /* hijo */
 
                        execlp(buf, buf, (char *) 0);
                        printf("No se pudo ejecutar %s\n", buf);
                        exit(126);
 
                } else { /* padre */
 
                        if ((pid = waitpid(pid, &status, 0)) < 0) {
                                puts("Error en waitpid");
                                exit(125);
                        }
                        printf("%% ");
                }
        }
        exit(0);
}
