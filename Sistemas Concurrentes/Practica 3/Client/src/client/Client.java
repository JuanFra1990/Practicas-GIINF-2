/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import api.Api;
import api.Peliculas;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Random;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Juan Francisco Aban Fontecha
 */
public class Client {
    static String HOST="localhost";
    static int PORT=1099;
     static Registry regobject;
    
    
     
     public static void main(String[] args) throws Exception {
         regobject = LocateRegistry.getRegistry(HOST,PORT);
         Api remoteApi = (Api) regobject.lookup(Api.class.getSimpleName());
         Random random= new Random();
         int opcion=0;
         while(opcion!=5) {          
         System.out.println("*****************************************");
         System.out.println("************MENU*************************");
         System.out.println("***1.-Mostrar listado de peliculas*******");
         System.out.println("***2.-Añadir Peliculas al listado********");
         System.out.println("***3.-Alquilar una pelicula**************");
         System.out.println("***4.- Ver una pelicula******************");
         System.out.println("***5.- Salir de la aplicacion************");
         System.out.println("*****************************************");
         System.out.println("¿Que desea hacer?");
         opcion = random.nextInt(5);
         
            switch (opcion){
                case 1: System.out.println("Ha elegido mostrar listado");
                        System.out.println("¿Que tipo de peliculas desea ver?");
                        int tipo=random.nextInt(6);
                        
                        ArrayList<Peliculas> lista=remoteApi.mostrarPeliculas(tipo);
                        
                        if( lista.size()!=0){
                            for (int i=0; i<lista.size();i++){
                                System.out.println("Pelicula Nº" + i);
                                System.out.println("Nombre: " + lista.get(i).getNombre());
                                System.out.println("Duracion: " + lista.get(i).getDuracion());
                            }   
                        }else {
                            System.out.println("No disponemos de peliculas en stock");
                        }
                        
                    break;
                case 2: System.out.println("Ha elegido anadir pelicula al listado");
                        System.out.println("¿Que peliculas desea añadir?");
                        String nombre="El patito fue a pescar";
                        System.out.println("¿Que duracion tiene?");
                        int duracion=100;
                        System.out.println("¿Que tipo de pelicula es?");
                        String tipo1="amor";
                        Peliculas pelicula=new Peliculas(nombre,duracion,tipo1);
                        remoteApi.anadirPelicula(pelicula);
                    break;
                case 3: System.out.println("Ha elegido alquilar pelicula");
                         System.out.println("¿Que peliculas desea aqluilar?");
                        String nombrealquiler="El misterio del donut";
                        System.out.println("Desea ver " + nombrealquiler);
                        Peliculas peliculaalquiler=remoteApi.alquilarPelicula(nombrealquiler);
                        if (peliculaalquiler.getDuracion()==0){
                            System.out.println("La pelicula que ha pedido no esta en nuestro listado o esta alquilada");
                        } else {
                            System.out.println("Ya dispone de la pelicula durante 1 dia");
                            TimeUnit.SECONDS.sleep(30);
                            remoteApi.devolverPelicula(nombrealquiler);
                        }
                        
                        
                    break;
                case 4: System.out.println("Ha elegido ver pelicula");
                         System.out.println("¿Que peliculas desea ver?");
                        String nombrever="La niña del espejo";
                        Peliculas peliculaver=remoteApi.verPelicula(nombrever);
                        if (peliculaver.getNombre()=="0"){
                            System.out.println("La pelicula que ha pedido no esta en nuestro listado o esta alquilada");
                        }else {
                             System.out.println("Comienza........"+peliculaver.getNombre());
                             TimeUnit.MINUTES.sleep(peliculaver.getDuracion());
                             System.out.println(".........................FIN");
                        }
                        
                    break;
                case 5: System.out.println("Gracias por usar nuestra aplicacion");
                        System.out.println("Hasta la proxima");
                        break;  
                default: System.out.println("Ha elegido una opcion no valida");
                        System.out.println("Seleccione de nuevo una opcion, Gracias");
                    break;
            }
         }
     }
}
