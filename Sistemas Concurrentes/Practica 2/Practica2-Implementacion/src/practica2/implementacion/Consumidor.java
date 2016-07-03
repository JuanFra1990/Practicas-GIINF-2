/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2.implementacion;

/**
 *
 * @author Juan Francisco Aban Fontecha
 * @description Esta clase es la generica del consumidor
 */
public class Consumidor{
    //Atributos
    
    Buffer buffer;
    
    //Metodos
    
    Consumidor(Buffer buffer){
        this.buffer=buffer;
    }
    
    //Metodo Consumir
    public void consume(Data list[], int num){
        //Reordenamos el vector de forma que desaparece el dato consumido
        for (int i=0; i<num; i++){
            for (int j=1; j<num; j++){
                System.out.printf("Consumiendo el dato\n");
                list[i]=list[j];
            }
        }
    }
    
    
    
}
