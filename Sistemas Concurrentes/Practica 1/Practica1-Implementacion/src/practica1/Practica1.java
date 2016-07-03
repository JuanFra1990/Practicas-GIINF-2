/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;
import java.util.concurrent.Semaphore;


/**
 *
 * @author Juan Francisco Aban Fontecha
 * @description Esta es la clase principal de la practica, donde albergaremos
 * implementaciones de las clases y las ejecuciones de los ejercicios
 */
public class Practica1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       /*Ejercicio1: Debe cumplir ciertas restricciones que son:
        *
        *- P1 debe terminar antes que P2 y P3 empiecen.
        *- P2 debe terminar antes que P4 y P5 empiecen.
        *- P3 debe terminar antes que P5 empiece y
        *- P6 debe empezar después que P3 y P4 terminen.
        *
        */
       //Inicializamos 6 tareas, de la 1 a la 6, y las iniciamos, mediante
       //semaforos hacemos que se cumplan las restricciones anteriores.
       try{ 
        Task task=new Task("task1");
        Thread t= new Thread(task);
        Task task2=new Task("task2");
        Thread t2=new Thread(task2);
        Task task3=new Task("task3");
        Thread t3=new Thread(task3);
        Task task4=new Task("task4");
        Thread t4=new Thread(task4);
        Task task5=new Task("task5");
        Thread t5=new Thread(task5);
        Task task6=new Task("task6");
        Thread t6=new Thread(task6);
        
        t.start();
        t.join();
        t2.start();
        t3.start();
        t2.join();
        t4.start();
        t3.join();
        t5.start();
        t4.join();
        t6.start();
        t5.join();
        t6.join();
        
       }catch (Exception e){
           e.printStackTrace();
       }
       
       /*Ejercicio 2. Se trata de un problema tipico de productor-consumidor
       *    de manera que los pasajeros son los productores, o mas bien los
       *    elementos que se producen, el coche seria el consumidor, solo hay
       *    una condicion extra, que es que para que el consumidor consuma las
       *    personas se deben haber producido n personas, y las consume todas.
       *
       *    Clases Utilizadas:
       *    1. Torno
       *    2. Coche
       *
       *    Se implementa torno con un vector de Task, reciclando la clase del 
       *    ejercicio anterior
       */
       
       Semaphore llenos,mutex,vacios;
       Coche coche;
       Torno torno;
       Task pasajeros[];
       
       //Inicializamos todas las variables necesarias
       //Para poder comenzar la ejecucion
       pasajeros= new Task[6];
       
       llenos = new Semaphore(1);
       vacios = new Semaphore(1);
       mutex = new Semaphore(1);
       
       torno = new Torno(pasajeros,vacios,llenos,mutex);
       coche = new Coche(torno,mutex);
        
       
       //Comenzamos la ejecucion, en esta he tenido algunos problemas,
       //ya que consigo que arranque pero se me queda corriendo siempre en la misma
       //zona
       Server server = new Server();
       
       server.executeTask(torno);
       
        
        
        
        
        
    }
    
}
