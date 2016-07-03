#include <chrono>
#include <cstdlib>
#include <fstream>
#include <iostream>

#define TAM 50000
#define CICLOS 4000

struct {
 double a;
 double b;
}
s [TAM];
long ii,i;

void algoritmo(){
for (ii=1;ii<=CICLOS;ii++) {
for (i=0;i<TAM;i++){
 		s[i].a=i+1;
      		s[i].a=2*s[i].a;
       		s[i].b=i+1;
       		s[i].b=3*s[i].b;
        	}
    	}
}


using namespace std;

int main() {
clock_t start = clock();
    algoritmo();

    cout<< s[15].a <<" y "<< s[15].b << endl;

clock_t end = clock();
float time = (float)((end - start) * 1000.0 / CLOCKS_PER_SEC);

//ofstream fs("valores.csv");
//fs << time;
//fs.close();


ofstream fs("valores1.csv");
for (int i=0;i<5;i++){

    clock_t start = clock();
    algoritmo();

clock_t end = clock();
float time = (float)((end - start) * 1000.0 / CLOCKS_PER_SEC);
fs << time <<",";
}


fs.close();
    return 0;
}
