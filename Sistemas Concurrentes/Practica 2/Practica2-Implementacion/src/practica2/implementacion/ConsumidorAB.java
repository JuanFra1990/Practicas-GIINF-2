/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2.implementacion;

import java.util.Random;

/**
 *
 * @author Juan Francisco Aban Fontecha
 * @description Clase para el consumidor que solo consume
 * Data tipo A y B
 */
public class ConsumidorAB extends Consumidor implements Runnable {
    Random random;
    
    ConsumidorAB(Buffer buffer){
        super(buffer);
        random = new Random();
    }
    
     public void consume(Data listA[], Data listB[], int num){
        //Reordenamos el vector de forma que desaparece el dato consumido
        int aleatorio=random.nextInt((10)+1);
        if (aleatorio%2==0){
                for (int i=0; i<num; i++){
                    if (listA[i].GetTipo()=="A"){
                        for (int j=1; j<num; j++){
                            System.out.printf("Consumiendo el dato\n");
                            listA[i]=listA[j];
                        }
                    } else {
                        System.out.printf("Dato no es de tipo A\n");
                    }
                }   
        } else {
                for (int i=0; i<num; i++){
                    if (listB[i].GetTipo()=="B"){
                        for (int j=1; j<num; j++){
                            System.out.printf("Consumiendo el dato\n");
                            listB[i]=listB[j];
                        }
                    } else {
                        System.out.printf("Dato no es de tipo B\n");
                    }
                }   
        }
        
    }
     
       @Override
    public void run(){
        String nombre = Thread.currentThread().getName();
        System.out.printf("Consumiendo datos B del buffer\n");
        int tamanoB=buffer.getTamano(new Data("Tipo B","B"));
        int tamanoA=buffer.getTamano(new Data("Tipo A","A"));
        int tamano;
        if (tamanoB>tamanoA){
             tamano=tamanoB;
         } else {
             tamano=tamanoA;
         }
         Data listA[] = new Data[100];
         Data listB[] = new Data[100];
         for (int i=0; i<tamano; i++){
            consume(listA,listB,i);
         }
    }
    
}
