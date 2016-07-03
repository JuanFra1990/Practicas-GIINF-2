int p,q,r;

void algoritmobase2(int l,int n, int m, int **c,int **a, int **b){
    for (r=0;r<n;r++){
        for (q=0;q<l;q++){
                c[r][q]=0;
            for (p=0;p<m;p++){
                c[r][q]+= a[r][p]*b[p][q];
            }
        }
    }
}
