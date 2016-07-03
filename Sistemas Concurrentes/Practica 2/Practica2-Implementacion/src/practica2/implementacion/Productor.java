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
 * @description esta es una clase generica, de la cual
 * van a heredar los dos tipos de productores
 */
public abstract class Productor {
    //Atributos
    Random random;
    Buffer buffer;
    
    //Metodos
    Productor(Buffer buffer){
        this.buffer=buffer;
        random = new Random();
    }
    
    

    /**
     * @description generate es un metodo con el cual vemos de que manera se generan Data
     * @param tipo de dato a producir
     * @param list vector de Data, depende del productor
     */
    protected abstract void generate(String tipo, Data list[]);
    
    
    //Metodo generico de Producir Data
    void produce() {
     String tipo="x";
     Data list[];
     list = new Data[random.nextInt((3)+1)];
     generate(tipo,list);
     buffer.inserta(tipo,list);
    }
}
