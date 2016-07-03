/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.io.Serializable;

/**
 *
 * @author Juan Francisco Aban Fontecha
 */
public class Peliculas implements Serializable {
    String nombre;
    int duracion;
    String tipo;
    
    public Peliculas(String nombre, int duracion, String tipo){
        this.nombre=nombre;
        this.duracion=duracion;
        this.tipo=tipo;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int getDuracion() {
        return this.duracion;
    }
    
    public String getTipo() {
        return this.tipo;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public void setDuracion( int duracion) {
        this.duracion=duracion;
    }
    
    public void setTipo( String tipo) {
        this.tipo=tipo;
    }
}
