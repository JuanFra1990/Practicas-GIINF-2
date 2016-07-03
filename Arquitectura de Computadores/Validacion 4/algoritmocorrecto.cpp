#include <iostream>

using namespace std;


int i, j,k;
void algoritmo(int l,int n,int m,int **a,int **b,int **c){
for (k=0;k<n;k++)
for (i=0;i<l;i++) {
c[k][i]=0;
for (j=0;j<m;j++)
c[k][i]+=a[k][j]*b[j][i];
}
}


int main()
{

    int l,n,m, **a, **b, **c;
    l=800;
    n=800;
    m=800;

    a=new int *[l];
    b=new int *[l];
    c=new int *[l];
    for (int d=0;d<l;d++){
        a[d]=new int [n];
        b[d]=new int [n];
        c[d]=new int [n];
    }

    a[2][0]=2;
    b[0][50]=2;



    algoritmo(l,n,m,a,b,c);

    cout << c[2][50];

    return 0;
}
