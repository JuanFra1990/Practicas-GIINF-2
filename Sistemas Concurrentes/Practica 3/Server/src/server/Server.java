/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import api.Api;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

/**
 *
 * @author Juan Francisco Aban Fontecha
 */
public class Server {

    static int port=1099;
    static Registry regobject;
    
    public Server(int port){
        this.port=port;
    }
    
    public static void startRegistry() throws RemoteException {
        //Create in server registry
        regobject = java.rmi.registry.LocateRegistry.createRegistry(port);
    }
    
    public static void registerObject(String name, Remote remoteObj)
    throws RemoteException, AlreadyBoundException{
        regobject.bind(name, remoteObj);
        System.out.println("Registrando objeto remoto: " + name + " -> " + remoteObj.getClass().getName() + " [" + remoteObj + "]");
    }
    
    public static void main(String[] args) throws Exception {
        startRegistry();
        registerObject(Api.class.getSimpleName(),new ApiImpl());
        Thread.sleep(5*60*100);
        System.out.println("Finalizacion del servidor .....");
    }
}
