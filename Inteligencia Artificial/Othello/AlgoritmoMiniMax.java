/*
 */

package othello.algoritmo;

import othello.Utils.Casilla;
import othello.Utils.Heuristica;
import othello.Utils.Tablero;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author gusamasan
 */
public class AlgoritmoMiniMax extends Algoritmo{
// ----------------------------------------------------------------------

// ----------------------------------------------------------------------

    /** Constructores **************************************************/
    private int playerColor;
    public AlgoritmoMiniMax(){

    }
    /*******************************************************************/
    

    @Override
    public Tablero obtenerNuevaConfiguracionTablero( Tablero tablero, short turno ){

        System.out.println( "analizando siguiente jugada con MINIMAX" );
        this.playerColor=turno;
        Tablero tableroJugada=tablero.copiarTablero();
         try{
             miniMax(tableroJugada, this.getProfundidad(), playerColor);
            Thread.sleep( 1000 );
        }
        catch( Exception e ){
            e.printStackTrace();
        }

        return( tableroJugada );
    }

     /**
     *
     * Éste es el método que tenemos que implementar.
     * 
     * Algoritmo AlfaBeta para determinar cuál es el siguiente mejor movimiento
     * 
     * @param tablero
     * Configuración actual del tablero
     * @param prof
     * Profundidad de búsqueda
     * @param jugadorActual
     * Nos indica a qué jugador (FICHA_BLANCA ó FICHA_NEGRA) le toca
     * @return
     */
    public int miniMax(Tablero tablero, int prof, int jugadorActual)
    {        
        int valor;
        int contrario=-jugadorActual;
       //Si no puede jugar pasa el turno
        if (!tablero.PuedeJugar(jugadorActual)){
             valor = miniMax(tablero, prof, contrario);
             return valor;
        } 
        
        if (tablero.EsFinalDeJuego() || prof==0){
            valor = Heuristica.h1(tablero, playerColor);
            return valor;
        } 
        //Genera las posibles posiciones para el jugador
            ArrayList<Casilla> posicionPosible = tablero.generarMovimiento(jugadorActual);
            
        
        //Recorre todas las posiciones en busca de la mejor posicion posible
            Casilla mejorPosicion = null;
            int puntuacionmin = 99999;
            int puntuacionmax = 0;
            
            Casilla celda = new Casilla();
           for (int i=0; i<posicionPosible.size(); i++){
                //Creamos un nuevo tablero en el que copiamos el actual 
                // para realizar las posibles jugadas que podemos hacer
                Tablero nuevoTablero = tablero.copiarTablero();
                celda=posicionPosible.get(i);
                //Asignamos valor dependiendo del jugador y la introducimos en el tablero
                //Obtenemos el valor del nuevo tablero, con la segunda heuristica y calculamos su puntuacion
                //para asegurarnos de si estamos escogiendo el valor MIN y MAX
                if (jugadorActual == 1) {
                    celda.asignarFichaBlanca();
                    int puntuacionh=Heuristica.h2(tablero, playerColor);
                    if (puntuacionh>puntuacionmax){
                        puntuacionmax=puntuacionh;
                        mejorPosicion=celda;
                    }
                } else {
                    celda.asignarFichaNegra();
                    int puntuacionh=Heuristica.h2(tablero, playerColor);
                    if (puntuacionh<puntuacionmin){
                        puntuacionmin=puntuacionh;
                        mejorPosicion=celda;
                    }
                }
                nuevoTablero.ponerFicha(celda);
           }
               
           Random random = new Random();
            //Si hemos obtenido un valor mejorado, añadimos dicha ficha
            if (mejorPosicion != null) tablero.ponerFicha(mejorPosicion);
            else tablero.ponerFicha(posicionPosible.get(random.nextInt(posicionPosible.size())));
            // Devolver el valor asignado al movimiento
            return 0;
    }
        

}

