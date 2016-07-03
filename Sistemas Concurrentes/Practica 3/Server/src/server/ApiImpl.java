/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import api.Api;
import api.Peliculas;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Juan Francisco Aban Fontecha
 */
public class ApiImpl extends UnicastRemoteObject implements Api{
    private static final long serialVersionUID= 1L;
    ArrayList<Peliculas> lista= new ArrayList<Peliculas>();
    
    public ApiImpl() throws RemoteException {
        super();
        Peliculas pelicula=new Peliculas("La bala que doblo la esquina",100, "oeste");
        lista.add(pelicula);
        pelicula=new Peliculas("El misterio del donut",200, "misterio");
        lista.add(pelicula);
        pelicula=new Peliculas("El mago de la vara",150, "magia");
        lista.add(pelicula);
        pelicula=new Peliculas("La niña del espejo",300, "miedo");
        lista.add(pelicula);
        pelicula=new Peliculas("El deporte nos salvo",190, "deporte");
        lista.add(pelicula);
        pelicula=new Peliculas("La sonrisa de una borrica",100, "amor");
        lista.add(pelicula);
        pelicula=new Peliculas("Por Ti, Nada",140, "amor");
        lista.add(pelicula);
    }
    
     @Override
    public synchronized ArrayList<Peliculas> mostrarPeliculas(int tipo) throws RemoteException{
        System.out.println("...Cliente nos esta pidiendo ver el listado de peliculas...");
        ArrayList<Peliculas> pelistipo=new ArrayList<Peliculas>();
        int counter=0;
        String tipos;
        switch (tipo){
            case 1: tipos="oeste";
                break;
            case 2: tipos="misterio";
                break;
            case 3: tipos="magia";
                break;
            case 4: tipos="miedo";
                break;
            case 5: tipos="deporte";
                break;
            default: tipos="amor";
                break;
        }
        
        for (int i=0;i<lista.size();i++){
            if(lista.get(i).getTipo()==tipos){
               pelistipo.add(lista.get(i));
            }
        }
        return pelistipo;
    };
    
    @Override
    public synchronized Peliculas alquilarPelicula(String nombre) throws RemoteException{
        Peliculas peliculaalquilada = new Peliculas("0",0,"0");
         System.out.println("...Cliente nos esta pidiendo alquilar la pelicula " + nombre + "...");
        for(int i=0; i<lista.size();i++){
            if (lista.get(i).getNombre()==nombre){
                peliculaalquilada=lista.get(i);
                lista.get(i).setNombre(nombre+"alquilada");
            }
        }
        if (peliculaalquilada.getDuracion()==0){
            System.out.println("...No disponemos de la pelicula que nos pide ...");
        } else {
             System.out.println("...Pelicula alquilada con exito ...");
        }
        
        return peliculaalquilada;
    };
    
    public synchronized void devolverPelicula(String nombre) throws RemoteException{
        String nombrealquilado=nombre+"alquilada";
        int id=-1;
        for (int i=0; i<lista.size();i++){
            if(nombrealquilado==lista.get(i).getNombre()){
                id=i;
                break;
            }
        }
        lista.get(id).setNombre(nombre);
    }
    
    @Override
    public synchronized Peliculas verPelicula(String nombre) throws RemoteException{
         Peliculas peliculaaver = new Peliculas("0",0,"0");
         System.out.println("...Cliente nos esta pidiendo ver la pelicula " + nombre + "...");
        for(int i=0; i<lista.size();i++){
            if (lista.get(i).getNombre()==nombre){
                peliculaaver=lista.get(i);
            }
        }
        return peliculaaver;
    };
    
    @Override
    public synchronized void anadirPelicula(Peliculas pelicula) throws RemoteException{
        System.out.println("...Añadiendo una nueva pelicula en el sistema...");
        Peliculas peliculanueva=new Peliculas(pelicula.getNombre(),pelicula.getDuracion(),pelicula.getTipo());
        lista.add(peliculanueva);
        System.out.println("...La nueva pelicula añadida en el sistema es..."+pelicula.getNombre());
    }
}
