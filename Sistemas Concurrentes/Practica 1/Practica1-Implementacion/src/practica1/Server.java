/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author lola
 */
public class Server {
     ThreadPoolExecutor executor;
    
    public Server(){
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
    }
    
    public void executeTask(Torno task){
        System.out.printf("Server: Una nueva tarea esta llegado\n");
        executor.execute(task);
        System.out.printf("Server: Tamaño de ventana %d\n",executor.getPoolSize());
        System.out.printf("Server: Cuenta Activacion: %d\n",executor.getActiveCount());
        System.out.printf("Server: Tareas Completadas: %d\n", executor.getCompletedTaskCount());
        System.out.printf("Server: Task Count: %d\n", executor.getTaskCount());
    }
    
    public void endServer() {
        executor.shutdown();
    }
}
