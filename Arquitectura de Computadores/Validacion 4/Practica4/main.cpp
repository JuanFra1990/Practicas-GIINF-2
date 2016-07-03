#include <iostream>
#include <fstream>
#include <time.h>
#include "base.c"
#include "version1.c"
#include "version2.c"
#include "Ejercicio2base.c"
#include "Ejercicio2mejorado.c"


using namespace std;




int main()
{
    //EJERCICIO 1
    /*clock_t start = clock();
    algoritmo();
    cout << "el doble de 3 es:" << stc[2].a << endl;
    cout << "el triple de 17 es:" << stc[16].b << endl;
    clock_t end = clock();
    float time = (float)((end - start) * 1000.0 / CLOCKS_PER_SEC);
    cout << "Ha tardado: " << time << "ms";
*/
   // Crea un fichero de salida
   //ofstream fs("valores.csv");
   // Enviamos una cadena al fichero de salida:
   //fs << time << ",";
   // Cerrar el fichero,
   // para luego poder abrirlo para lectura:
   //fs.close();

   //EJERCICIO 2
   //int l,m,q;

  const int n=1600;
  const int l=1600;
  const int m=1600;

    int **a,**b,**c;

a=new int *[n];
b=new int *[n];
c=new int *[n];


   for (int f=0; f<l; f++){
    a[f]=new int [m];
    b[f]=new int [m];
    c[f]=new int [m];
   }

    for (int d=0;d<n;d++){
        for (int e=0;e<l;e++){
        a[d][e]=e+1;
        b[d][e]=e+1;
        c[d][e]=e+1;
        }
    }

clock_t start = clock();
  algoritmomejorado2(l,m,n,c,a,b);

  cout << c[2][50] << endl;
  cout << c[60][0] << endl;

clock_t end = clock();
  float time = (float)((end - start) * 1000.0 / CLOCKS_PER_SEC);
  cout << "Ha tardado: " << time << "ms";

for (int f = 0; f < n; f++) {
  delete [] a[f];
  delete [] b[f];
  delete [] c[f];
}
delete [] a;
delete [] b;
delete [] c;


}
