/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

/**
 *
 * @author Juan Francisco Abán Fontecha
 */
public class CuentaBancaria {
    String nombre;
    String apellidos;
    int Saldo;
    
    //Constructor cuenta Saldo 0
    public CuentaBancaria( String nombre, String apellidos){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.Saldo=0;
    }
    
    //Constructor cuenta con Saldo inicial
    public CuentaBancaria( String nombre, String apellidos, int Saldo){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.Saldo=Saldo;
    }
    
    
    
    
}
