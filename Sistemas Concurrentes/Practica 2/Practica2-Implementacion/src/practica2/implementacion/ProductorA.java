/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2.implementacion;

/**
 *
 * @author Juan Francisco Abán Fontecha
 * @description Esta clase es la productora de Data A
 */
public class ProductorA extends Productor implements Runnable {
    
    public ProductorA(Buffer buffer){
        super(buffer);
    }
    
    //Metodo especifico de generar datos tipo A
    public void generate(String tipo, Data list[]){
        Data listA[] = new Data[100];
        
        buffer.insertaA(listA,list);
    }
    
      @Override
    public void run(){
        String nombre = Thread.currentThread().getName();
        int tamano=buffer.getTamano(new Data("Tipo A","A"));
        Data list[] = new Data[100];
        for (int i=0; i<tamano; i++){
            System.out.printf("Produciendo datos A en el buffer\n");
            generate("A",list);
        }
    }
    
}
