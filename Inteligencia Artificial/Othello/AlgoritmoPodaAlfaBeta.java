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
public class AlgoritmoPodaAlfaBeta extends Algoritmo{
// ----------------------------------------------------------------------

// ----------------------------------------------------------------------

    /** Constructores **************************************************/
    private int playerColor;
    public AlgoritmoPodaAlfaBeta(){

    }
    /*******************************************************************/
    

    @Override
    public Tablero obtenerNuevaConfiguracionTablero( Tablero tablero, short turno ){

        System.out.println( "analizando siguiente jugada con ALFABETA" );
        this.playerColor=turno;
        Tablero tableroJugada=tablero.copiarTablero();
         try{
             int beta = Integer.MAX_VALUE;
             int alfa = Integer.MIN_VALUE;
             alfaBeta(tableroJugada, this.getProfundidad(), playerColor, alfa, beta);
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
     * @author Juan Francisco Abán Fontecha 
     * 
     * Algoritmo AlfaBeta para determinar cuál es el siguiente mejor movimiento
     * 
     * @param tablero
     * Configuración actual del tablero
     * @param prof
     * Profundidad de búsqueda
     * @param jugadorActual
     * Nos indica a qué jugador (FICHA_BLANCA ó FICHA_NEGRA) le toca
     * @param alfa
     * @param beta
     * Parámetros alfa y beta del algoritmo
     * @return
     */
     public int alfaBeta(Tablero tablero, int prof, int jugadorActual, int alfa, int beta)
    {       
        int valor;
        int contrario=-jugadorActual;
       //Si no puede jugar pasa el turno
        if (!tablero.PuedeJugar(jugadorActual)){
             valor = alfaBeta(tablero, prof, contrario, alfa, beta);
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
            
            Casilla celda = new Casilla();
           for (int i=0; i<posicionPosible.size(); i++){
                //Creamos un nuevo tablero en el que copiamos el actual 
                // para realizar las posibles jugadas que podemos hacer
                Tablero nuevoTablero = tablero.copiarTablero();
                celda=posicionPosible.get(i);
                //Asignamos valor dependiendo del jugador y la introducimos en el tablero
                if (jugadorActual == 1) {
                    celda.asignarFichaBlanca();
                } else {
                    celda.asignarFichaNegra();
                }
                nuevoTablero.ponerFicha(celda);
               
                
                //Obtenemos el valor del nuevo tablero
                int valorActual = alfaBeta(nuevoTablero, prof - 1, contrario, alfa, beta);
                
                //Si el jugador Actual es el que juega primero, entonces calcula el
                //valor de alfa, sino calcula el valor de beta
                if (jugadorActual==this.playerColor) {
                    //Si el nuevo valor supera al anterior, lo sustituimos
                    if (valorActual > alfa) {
                            alfa = valorActual;
                            mejorPosicion = celda;
                    } 

                    if (alfa >= beta) {
                            return alfa;
                    }
                } else {
                    //Si el nuevo valor es menor que el anterior, lo sustituimos
                    if (valorActual < beta)
                    {
                        beta = valorActual;
                        mejorPosicion = celda;
                    }

                    if (beta <= alfa)
                    {
                        return beta;
                    }
                }
            }
           Random random = new Random();
            //Si hemos obtenido un valor mejorado, añadimos dicha ficha
            if (mejorPosicion != null) tablero.ponerFicha(mejorPosicion);
            else tablero.ponerFicha(posicionPosible.get(random.nextInt(posicionPosible.size())));
            // Devolver el valor asignado al movimiento
            if (jugadorActual == this.playerColor) return alfa;
            else return beta;
    }
}
