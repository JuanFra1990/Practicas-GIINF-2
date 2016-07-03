/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package othello.Utils;

/**
 *
 * @author user
 */
public class Heuristica {


   public static int h1(Tablero tablero,int playerColor)
    {
        int contrario = -playerColor;
        int puntuacion = Puntos(playerColor, tablero) - Puntos(contrario, tablero);
        
        //Sino funcion getCantidadColumnas, cambiarlo por getCanidadColumnas que es
        //un fallo sintactico que he encontrado en el Source de Othello
        int columnas = tablero.getCantidadColumnas();
        int filas = tablero.getCantidadFilas();
        
        // If the game is over
        if (tablero.EsFinalDeJuego())
        {
            // if player has won
            if (puntuacion > 0)
                return 100;
            // if player has lost (or tied)
            else
                return -100;
        }
        else{
            Casilla[][] valorActual = tablero.getMatrizTablero();
            int puntuacionEsquina =0;
            
            //Vamos a ver si tienen esquinas cogidas, su Heuristica aumenta
            //Si el jugador tiene las fichas blancas (1)
            if(playerColor == 1){
                if (valorActual[0][0].esBlanca()){
                    puntuacionEsquina = puntuacionEsquina+15;
                }
                if (valorActual[0][columnas-1].esBlanca()){
                    puntuacionEsquina = puntuacionEsquina+15;
                }
                if (valorActual[filas-1][0].esBlanca()){
                    puntuacionEsquina = puntuacionEsquina+15;
                }
                if (valorActual[filas-1][columnas-1].esBlanca()){
                    puntuacionEsquina = puntuacionEsquina+15;
                }
            }
            
            //Si el jugador tiene las fichas negras(-1)
            if(playerColor == -1){
                if (valorActual[0][0].esNegra()){
                    puntuacionEsquina = puntuacionEsquina+15;
                }
                if (valorActual[0][columnas-1].esNegra()){
                    puntuacionEsquina = puntuacionEsquina+15;
                }
                if (valorActual[filas-1][0].esNegra()){
                    puntuacionEsquina = puntuacionEsquina+15;
                }
                if (valorActual[filas-1][columnas-1].esNegra()){
                    puntuacionEsquina = puntuacionEsquina+15;
                }
            }
            
            //Devolvemos la suma de su puntuacion mas los puntos por haber seleccionado
            // las esquinas.
            
            int valor=puntuacion+puntuacionEsquina;
            return valor;
        }
    }


    //Una heuristica posible a usar
    public static int h2(Tablero tablero,int playerColor)
    {
        int adversario=-playerColor;
        int score = Puntos(playerColor, tablero) - Puntos(adversario, tablero);

        // If the game is over
        if (tablero.EsFinalDeJuego())
        {
            // if player has won
            if (score > 0)
                return 100;
            // if player has lost (or tied)
            else
                return -100;
        }

        // if game isn't over, return relative advatage
        return score;
    }

    public static int Puntos(int playerColor, Tablero tablero)
    {
        int points = 0;

        for (int x = 0; x < Tablero.CANTIDAD_FILAS_DEFECTO; x++)
            for (int y = 0; y < Tablero.CANTIDAD_COLUMNAS_DEFECTO; y++)
                if (tablero.getMatrizTablero()[x][y].obtenerColorFicha() == playerColor)
                    points++;

        return points;
    }



}
