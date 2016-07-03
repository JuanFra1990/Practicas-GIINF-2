package servidor;

import java.io.*;
import java.net.*;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

class Servidor {
    public static void main(String argv[]) throws Exception, IOException
    {
        String paquetes;
        String resultado;
        ServerSocket socketAcogida = new ServerSocket(6789);
        Calendar calendar = Calendar.getInstance();
        int start, end, duration;
        while(true) {
            start =calendar.get(Calendar.MILLISECOND);
            System.out.println("Servidor iniciando la conexion...");
            System.out.println("Servidor puertos abiertos...");
            System.out.println("Servidor escuchando...");
            Socket socketConexion = socketAcogida.accept();
            BufferedReader entradaDesdeCliente = new BufferedReader(new  InputStreamReader(socketConexion.getInputStream())); 
            DataOutputStream salidaACliente= new DataOutputStream(socketConexion.getOutputStream());
            paquetes = entradaDesdeCliente.readLine();
            TimeUnit.MILLISECONDS.sleep(1000);
            end=calendar.get(Calendar.MILLISECOND);
            duration=end-start;
            resultado="Hora de comienzo: " + start + "  Hora de fin: " + end + "   " ;
            resultado+="Ha tardado: "+duration+"\n";
            salidaACliente.writeBytes(resultado);
        }
    }
}


