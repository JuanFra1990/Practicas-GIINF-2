#define TAM 50000
#define CICLOS 4000

struct {
 double a;
 double b;
} stc[TAM];

long kk,k;

void algoritmo2(){
 for (kk=1;kk<=CICLOS;kk++) {
 for (k=0;k<TAM;k+=4){
 stc[k].a=k+1;
 stc[k].b=k+1;
 stc[k+1].a=k+2;
 stc[k+1].b=k+2;
 stc[k+2].a=k+3;
 stc[k+2].b=k+3;
 stc[k+3].a=k+4;
 stc[k+3].b=k+4;
 stc[k].a=2*stc[k].a;
 stc[k+1].a=2*stc[k+1].a;
 stc[k+2].a=2*stc[k+1].a;
 stc[k+3].a=2*stc[k+1].a;
 stc[k].b=3*stc[k].b;
 stc[k+1].b=3*stc[k+1].b;
 stc[k+2].b=3*stc[k+1].b;
 stc[k+3].b=3*stc[k+1].b;
 }
 }
}
