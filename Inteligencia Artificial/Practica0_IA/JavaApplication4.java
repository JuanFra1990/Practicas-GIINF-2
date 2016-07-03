/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author Juan Francisco Aban Fontecha
 */
public class JavaApplication4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        

        // 1. Ejercicio de numeros  
        
        Scanner in = new Scanner (System.in);
        int a;
        int b;
     
        
         
       System.out.println("Introduce un numero");
       a = in.nextInt();
       
       System.out.println("Introduce otro numero");
       b = in.nextInt();     
   
      
       Calculadora calculo = new Calculadora (a,b);
       
       
       System.out.println("La suma es: " + calculo.suma() );
       System.out.println("La resta es: " + calculo.resta() );
       System.out.println("La multiplicacion es: " + calculo.multiplicacion() );
       System.out.println("La division es: " + calculo.division() );
       //1. Ejercicio de numeros, elegir operacion.
	   int c;
	   System.out.println("***************MENU**************");
	   System.out.println("****1. Operacion Suma************");
	   System.out.println("****2. Operacion Resta***********");
	   System.out.println("****3. Operacion Multiplicacion**");
	   System.out.println("****4. Operacion Division********");
	   System.out.println("*********************************");
	   System.out.println("¿Que operacion desea realizar?");
       c = in.nextInt();
	  
	   switch (c) {
		case 1:
			System.out.println("La suma es: " + calculo.suma() );
			break;
		case 2:
			System.out.println("La resta es: " + calculo.resta() );
			break;
		case 3:
			System.out.println("La multiplicacion es: " + calculo.multiplicacion() );
			break;
		case 4:
			System.out.println("La division es: " + calculo.division() );
			break;
		default:
			System.out.println("Error:  No ha seleccionado una operacion valida");
	   }
	  
       // 2. Ejercicio de Cadenas      
       
       BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
       String cadena;
       System.out.println("Introduce una cadena");
       cadena = lectura.readLine();
              
    
       System.out.println("La longitud de la cadena " + " es: "  + cadena.length());
    
       //3. Ejercicio de ficheros y arrays
       
       System.out.println("El fichero sobre el que vamos a trabajar es: dato.txt"); 
       
       ficheros fichero = new ficheros (".\\dato.txt");
       
       fichero.muestraContenido();
       
       
    }
    
    
    
}
