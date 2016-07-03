#define TAM 50000
#define CICLOS 4000

struct {
 double a;
 double b;
} st[TAM];

long jj,j;

void algoritmo1(){
 for (jj=1;jj<=CICLOS;jj++) {
 for (j=0;j<TAM;j++){
 st[j].a=j+1;
 st[j].b=j+1;
 st[j].a=2*st[j].a;
 st[j].b=3*st[j].b;
 }
 }
}

