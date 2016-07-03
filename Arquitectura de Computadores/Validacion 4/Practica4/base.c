#define TAM 50000
#define CICLOS 4000

struct {
 double a;
 double b;
} s[TAM];

long ii,i;

void algoritmo(){
 for (ii=1;ii<=CICLOS;ii++) {
 for (i=0;i<TAM;i++){
 s[i].a=i+1;
 s[i].a=2*s[i].a;
 }
 for (i=0;i<TAM;i++){
 s[i].b=i+1;
 s[i].b=3*s[i].b;
 }
 }
}
