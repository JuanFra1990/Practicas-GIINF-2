int u,v,w;

inline void algoritmomejorado2( int l, int m, int n, int  **c,  int  **a, int  **b){
    for (u=0;u<l;u++){
        for (v=0;v<l;v=v+5){
                c[u][v]=0;
                c[u][v+1]=0;
                c[u][v+2]=0;
                c[u][v+3]=0;
                c[u][v+4]=0;
            for (w=0;w<l;w=w+5){
                c[u][v]+= a[u][w]*b[w][v];
                c[u][v]+= a[u][w+1]*b[w+1][v];
                c[u][v]+= a[u][w+2]*b[w+2][v];
                c[u][v]+= a[u][w+3]*b[w+3][v];
                c[u][v]+= a[u][w+4]*b[w+4][v];


            }
        }
    }
}


