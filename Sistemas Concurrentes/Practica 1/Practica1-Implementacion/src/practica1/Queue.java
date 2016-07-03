/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Juan Francisco Aban Fontecha
 */
public class Queue {
    /*Semaforo de control*/
    private final Semaphore semaphore;
    
    public Queue(){
        semaphore= new Semaphore(1);
    }
    
     public void executeTask(Object document) {
        try{
            semaphore.acquire();
            
            Long duration=(long)(Math.random()*10);
            System.out.printf("%s: Queue: Execute a Task during %d seconds\n", 
                    Thread.currentThread().getName(), duration);
            
            Thread.sleep(duration);
            TimeUnit.SECONDS.sleep(duration);
        }catch(InterruptedException e){
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
     
    
}
