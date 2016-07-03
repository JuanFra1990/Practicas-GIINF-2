/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Juan Francisco Abán Fontecha
 * @description Clase del primer ejercicio, nos permite crear tareas que sean 
 * del mismo tipo y luego las alternamos con los semaforos, para cumplir las
 * necesidades del ejercicio
 */
public class Task implements Runnable {
    
    private Date fec_creacion;
    private String nombre;
    
    public Task(String nombre){
        Date fechaactual=new Date();
        this.fec_creacion=fechaactual;
        this.nombre=nombre;
    }
    
    @Override
    public void run(){
        System.out.printf("%s: Task %s: Creada en: %s\n", Thread.currentThread().getName(),nombre,fec_creacion);
        System.out.printf("%s: Task %s: Iniciada en: %s\n", Thread.currentThread().getName(),nombre, new Date());
       
        try {
            Long duracion=(long)(Math.random()*10);
            System.out.printf("%s: Task %s: Ha durado %d seconds\n", Thread.currentThread().getName(),nombre, duracion);
            TimeUnit.SECONDS.sleep(duracion);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        
        System.out.printf("%s: Task %s: Finalizada en: %s\n", Thread.currentThread().getName(),nombre, new Date());
    }
    
}
