/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.concurrent.Semaphore;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Juan Francisco Aban Fontecha
 * @description Esta es la clase consumidora, esta solo consta de un elemento 
 * Torno y un semafoto para garantizar la exclusion mutua
 */
public class Coche implements Runnable {
    private static int tamanomaximo=6;
    private Torno pasajeros;
    
   
    public Semaphore mutex;
    
     private int cola;
     
     public Coche(Torno pasajeros, Semaphore mutex){
        this.pasajeros = pasajeros;
        this.mutex=mutex;
        this.cola=tamanomaximo;
    }
     
    private void eliminandoPasajeros(int posicion){
      pasajeros.setPasajeros(null, posicion);
      cola--;
    }
    
    private void dandoViaje(){
        System.out.printf("Comienza el viaje");
        try{
        TimeUnit.MINUTES.sleep(5);
        } catch( InterruptedException e){
            e.printStackTrace();
        }
        System.out.printf("Terminando el viaje");
    }
    
     @Override
    public void run(){
        while(true){
            try{
            pasajeros.llenos.acquire();
            Date date=new Date();
            System.out.printf("Llenando el coche de la atraccion: %s", date);
            if (cola==0){
                //Simular el viaje e ir eliminando a los pasajeros, es decir
                //dejar el elemento Torno vacio de nuevo, para comenzar
                //lo hacemos en exclusion mutua
                mutex.acquire();
                dandoViaje();
                for(int i=tamanomaximo;i>0;i--){
                   eliminandoPasajeros(i);
                }
                mutex.release();
            }    
            //Aqui volvemos a desbloquear el elemento Torno que este bloqueado
            pasajeros.vacios.release(); 
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    
}
