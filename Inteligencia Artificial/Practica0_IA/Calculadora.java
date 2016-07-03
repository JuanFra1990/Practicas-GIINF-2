/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

/**
 *
 * @author Juan Francisco Aban Fontecha
 * @param a integer
 * @param b integer
 * @version 1.0
 * @since 03/02/2016
 */
public class Calculadora {
    //Params
    private int a;
    private int b;
    //Methods
    
    public Calculadora(int a, int b){
        this.a=a;
        this.b=b;
    };
    
    public int suma() {
        return this.a+this.b;
    }
    
    public int resta() {
        return this.a-this.b;
    }
    
    public int multiplicacion() {
        return this.a*this.b;
    }
    
    public int division() {
        return this.a/this.b;
    }
}
