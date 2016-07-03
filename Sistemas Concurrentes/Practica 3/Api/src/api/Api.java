/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Juan Francisco Aban Fontecha
 */
public interface Api extends Remote {
    public ArrayList<Peliculas> mostrarPeliculas(int tipo) throws RemoteException;
    public Peliculas alquilarPelicula(String nombre) throws RemoteException;
    public void devolverPelicula(String nombre) throws RemoteException;
    public Peliculas verPelicula(String nombre) throws RemoteException;
    public void anadirPelicula(Peliculas pelicula) throws RemoteException;
}
