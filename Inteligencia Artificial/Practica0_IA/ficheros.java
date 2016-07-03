/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.io.*;
import java.util.*;

/**
 *
 * @author Juan Francisco Aban Fontecha
 */
public class ficheros {
    
    //Params
    
    private String archivo;
    
    //Method
    public ficheros(String archivo) {
        this.archivo=archivo;
    }
    
    public void muestraContenido() throws FileNotFoundException, IOException {
      String cadena;
      //Fichero del que leemos
      FileReader f = new FileReader(this.archivo);
      BufferedReader b = new BufferedReader(f);
      //Fichero en el que escribimos
      FileWriter ficheroescritura = new FileWriter(".//nuevo.txt", true);
      PrintWriter pw = new PrintWriter(ficheroescritura);
      
      while((cadena = b.readLine())!=null) {
          
          int numTokens = 0;
          StringTokenizer st = new StringTokenizer (cadena);
          int nDatos=st.countTokens();
          String[] datos=new String[nDatos];
          int i=0;
          while(st.hasMoreTokens()){
            String str=st.nextToken();
            datos[i]=String.valueOf(str);
            if (i%3==0){
                int identificador =  Integer.parseInt(datos[i]);
                if (identificador%2==0){
                    pw.println(cadena);
                }
            }
            i++;
          }
          
      }
      b.close();
      ficheroescritura.close();
}
    
}
