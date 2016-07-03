/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2.implementacion;

/**
 *
 * @author lola
 */
public class Practica2Implementacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Buffer buffer = new Buffer();
        
        Thread hilos[] = new Thread[100];
        
        System.out.printf("Main: Comenzando el programa \n");
        
        for (int i=0; i<12; i=i+4){
            ProductorA productora = new ProductorA(buffer);
            ProductorB productorb = new ProductorB(buffer);
            ConsumidorA consumidora = new ConsumidorA(buffer);
            ConsumidorB consumidorb = new ConsumidorB(buffer);
            ConsumidorAB consumidorab = new ConsumidorAB(buffer);
            
            hilos[i] = new Thread(productora);
            hilos[i+1] = new Thread(productorb);
            hilos[i+2] = new Thread(consumidora);
            hilos[i+3] = new Thread(consumidorb);
            hilos[i+4] = new Thread(consumidorab);
            
            hilos[i].start();
            hilos[i+1].start();
            hilos[i+2].start();
            hilos[i+3].start();
            hilos[i+4].start();
        }
        
        for (int i=0; i<12; i++){
            try {
            hilos[i].join();
            } catch( InterruptedException e){
                e.printStackTrace();
            }
        }
        
        System.out.printf("Main: Terminando el Programa\n");
        
        
    }
    
}
