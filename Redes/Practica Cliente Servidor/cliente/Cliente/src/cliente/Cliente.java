package cliente;

import java.io.*;
import java.net.*;
import java.util.concurrent.TimeUnit;

class Cliente {
    
 public static void main(String argv[]) throws Exception
 {
    String paquetes="holaaaaaaaaaaaaaaaaaaa";
    String resultado;
    BufferedReader entradaDesdeUsuario =  new BufferedReader(new InputStreamReader(System.in));
    Socket socketCliente = new Socket("localhost", 6789);
    DataOutputStream salidaAServidor = new DataOutputStream(socketCliente.getOutputStream());
    BufferedReader entradaDesdeServidor = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
    
    
    System.out.println("Enviando Paquetes....");
    paquetes = entradaDesdeUsuario.readLine(); 
    TimeUnit.MILLISECONDS.sleep(10);
    salidaAServidor.writeBytes(paquetes+ '\n');
    resultado= entradaDesdeServidor.readLine();
    System.out.println(resultado);
    socketCliente.close(); 
 }
 
}