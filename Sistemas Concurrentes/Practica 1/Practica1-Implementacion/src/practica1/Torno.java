/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;
import java.util.concurrent.Semaphore;
import java.util.Date;

/**
 *
 * @author Juan Francisco Aban Fontecha
 * @description Esta es la clase "Productora", tiene 3 semaforos, uno para garantizar
 * la exclusion mutua y los otros dos para la sincronizacion entre clases Torno y
 * Coche
 */
public class Torno implements Runnable {
    
    private static int tamanototal=6;
    
    private Task pasajeros[];
    public Semaphore vacios;
    public Semaphore mutex;
    public Semaphore llenos;
    
    private int frente;
    
    public Torno(Task pasajeros[], Semaphore vacios, Semaphore llenos, Semaphore mutex){
        this.pasajeros = new Task[tamanototal];
        this.vacios=vacios;
        this.llenos=llenos;
        this.mutex=mutex;
        this.frente=0;
    }
    
    public Task[] getPasajeros(){
        return this.pasajeros;
    }
    
    public void setPasajeros(Task pasajero, int posicion){
        this.pasajeros[posicion]=pasajero;
    }
    
    private void addPasajero(Task pasajero){
        pasajeros[frente]=pasajero;
        frente++;
    }
    
    
    
    @Override
    public void run(){
        while(true){
            try{
            vacios.acquire();
            Date date=new Date();
            System.out.printf("Comenzando el dia: %s", date);
            if (frente<tamanototal){
                //Realizamos la operacion de añadir pasajeros y crear tareas de 
                //pasajeros en Exclusion Mutua
                mutex.acquire();
                for(int i=frente;i<tamanototal;i++){
                    Task pasajero=new Task("pasajero"+i);
                    addPasajero(pasajero);
                }
                mutex.release();
            }    
            //Desbloqueamos si hay algun "coche lleno" en espera
            llenos.release();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    
}
