/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2.implementacion;

/**
 *
 * @author Juan Francisco Aban Fontecha
 * @description Esta clase es la clase monitor
 */
public class Buffer {
    //Atributos
    private int tamA;
    private int tamB;
    private Data listA[];
    private Data listB[];
    private int referenciaA;
    private int referenciaB;
    
    //Metodos
    public Buffer(){
        tamA = 100;
        tamB = 100;
        listA = new Data[100];
        listB = new Data[100];
        referenciaA = 100;
        referenciaB = 100;
    }
    
    //Metodos de insercion de cada tipo Data
    public void inserta(String tipo, Data datos[]){
        int tamano = datos.length;
        int referencia = 0;
        for (int i=0; i<tamano; i++){
            if(datos[i].GetTipo()=="A"){
                listA[listA.length]=datos[i];
            } else if(datos[i].GetTipo()=="B"){
                listB[listB.length]=datos[i];
            }
        }
    }
    
    public void insertaA(Data listA[], Data datos[]){
    int tamano = datos.length;
    int referencia = 0;
    while (referencia+tamano>this.tamA){
     //Espera   wait();
    }
    
    //Insertamos datos en listA
    for (int i=0; i<tamA;i++){
        listA[i]=datos[i];
        datos[i]=null;
    }
    
    //Reordenamos el vector de Data, eliminando los que ya estan
    //para consumir
    for (int i=0; i<datos.length;i++){
        for (int j=0; j<datos.length;j++){
            if (datos[i]==null){
                datos[j]=datos[i];
            }
        }
    }
    
    referencia=tamano;
    //notify();
    
    }
    
    
    public void insertaB(Data listB[], Data datos[]){
    int tamano = datos.length;
    int referencia = 0;
    while (referencia+tamano>this.tamB){
     //Espera   wait();
    }
    
    //Insertamos datos en listB
    for (int i=0; i<tamB;i++){
        listB[i]=datos[i];
        datos[i]=null;
    }
    
    //Reordenamos el vector de Data, eliminando los que ya estan
    //para consumir
    for (int i=0; i<datos.length;i++){
        for (int j=0; j<datos.length;j++){
            if (datos[i]==null){
                datos[j]=datos[i];
            }
        }
    }
    
    referencia=tamano;
    //notify();
    
    }
    
    //Metodos para borrar la lista de Data A cuando los datos son consumidos
    
    public Data[] borrarA() {
        while (listA.length==0) {
            //Espera wait();
        }
        
        for (int i=tamA; i>0;i--){
            listA[i]=null;
        }
        
        referenciaA=listA.length;
        //notify()
        return listA;
    }
    
     public Data[] borrarB() {
        while (listB.length==0) {
            //Espera wait();
        }
        
        for (int i=tamB; i>0;i--){
            listB[i]=null;
        }
        
        referenciaB=listB.length;
        //notify()
        return listB;
    }
    
     
     //Metodo para dar el tamano
     public int getTamano( Data list){
         if(list.GetTipo()=="A"){
             return this.tamA;
         }else {
             return this.tamB;
         }
     }
    
}

