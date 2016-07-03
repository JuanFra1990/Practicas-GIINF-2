/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2.implementacion;

/**
 *
 * @author Juan Francisco Abán Fontecha
 * @description Esta clase incluye un tipo de dato nuevo que sera utilizado por 
 * consumidores y productores para esta practica
 */
public class Data {
    //Atributos
    private String nombre;
    private String tipo;
    
    //Metodos
    public Data(String nom, String tipo){
        this.nombre=nom;
        this.tipo=tipo;
    }
    
    String GetNombre(){
        return this.nombre;
    }
    
    String GetTipo(){
        return this.tipo;
    }
    
}
