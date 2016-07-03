/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

/**
 *
 * @author Juan Francisco Aban Fontecha
 */
public class CuentaAhorros extends CuentaBancaria {
     
    //Constructor CuentaAhorros con saldo 0
    public CuentaAhorros (String nombre, String apellido){
        super(nombre,apellido);
    }
    
    //Constructor CuentaAhorros con saldo
    public CuentaAhorros (String nombre, String apellido, int Saldo) {
        super(nombre, apellido, Saldo);
    }
    
    //Metodos Propios
    public void ConsultaSaldo (){
        System.out.println("Su Saldo es: " + this.Saldo);
    }
    
    public void IngresarDinero (int Saldo) {
        this.Saldo+=Saldo;
        System.out.println("Se ha ingresado en su cuenta el dinero");
    }
    
    
}
