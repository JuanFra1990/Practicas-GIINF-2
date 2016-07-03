/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2.implementacion;

/**
 *
 * @author Juan Francisco Aban Fontecha
 * @description Clase para el consumidor que solo consume
 * Data tipo B
 */
public class ConsumidorB extends Consumidor implements Runnable {
    ConsumidorB(Buffer buffer){
        super(buffer);
    }
    
     public void consume(Data list[], int num){
        //Reordenamos el vector de forma que desaparece el dato consumido
        for (int i=0; i<num; i++){
            if (list[i].GetTipo()=="B"){
                for (int j=1; j<num; j++){
                    System.out.printf("Consumiendo el dato\n");
                    list[i]=list[j];
                }
            } else {
                System.out.printf("Dato no es de tipo B\n");
            }
        }
    }
     
       @Override
    public void run(){
        String nombre = Thread.currentThread().getName();
        int tamano=buffer.getTamano(new Data("Tipo B","B"));
        Data list[] = new Data[100];
        for (int i=0; i<tamano; i++){
            System.out.printf("Consumiendo datos B del buffer\n");
            consume(list,i);
        }
    }
}