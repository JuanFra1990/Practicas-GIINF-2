package mouserun.mouse;

import java.util.ArrayList;
import mouserun.game.Cheese;
import mouserun.game.Grid;
import mouserun.game.Mouse;
import java.util.Random;

/**
 *
 * @author Maria Martinez Baeza
 * @author Juan Francisco Aban Fontecha
 */

public class M16B01B extends Mouse {

        private int lastMove;
        private ArrayList<Grid> GridVisited;
        private ArrayList<Integer> PossibleMoves;
        private ArrayList<Integer> ReturnMoves;
        private Grid explorado;
        
	public M16B01B()
	{
        super("SuperGoku");		
        GridVisited=new ArrayList<Grid>();
        PossibleMoves = new ArrayList<Integer>();
        ReturnMoves = new ArrayList<Integer>();
	}
        
        //Funcion que nos devuelve si el Grid es visitado o no
        private boolean VisitadoBool(Grid currentGrid){
        for (int i=0;i<GridVisited.size();i++){
            if (GridVisited.get(i)==currentGrid) {
                return true;
            }
        }
        GridVisited.add(currentGrid);
        return false;
    }
        
        //Funcion que explora las posibilidades del Grid que pasamos como parametro
        private void Exploracion(Grid current){
            //Exploracion de las posibilidades
            if (current.canGoUp()) PossibleMoves.add(Mouse.UP);
            if (current.canGoDown()) PossibleMoves.add(Mouse.DOWN);
            if (current.canGoRight()) PossibleMoves.add(Mouse.RIGHT);
            if (current.canGoLeft()) PossibleMoves.add(Mouse.LEFT);
        }
        
        /*
         * Funciones que permiten la vuelta atras
         *
         * volver: le pasamos el grid inicial y una variable entera que nos
         * permite saber desde que posicion del vector Return debemos coger para 
         * volver a la casilla padre
         *
         * returnmoveadd: nos permite que cada vez que hagamos un movimiento hacia
         * un nodo hijo, añadamos un movimiento de marcha atras dependiendo del movimiento
         * ultimo realizado
         *
         */
        private int volver(Grid inicial, int i){
            lastMove=ReturnMoves.get(i);
            ReturnMoves.remove(i);
            return lastMove;
        }
        
        private void returnmoveadd (int lastMove) {
            if (lastMove==Mouse.UP) ReturnMoves.add(Mouse.DOWN);
            if (lastMove==Mouse.DOWN) ReturnMoves.add(Mouse.UP);
            if (lastMove==Mouse.LEFT) ReturnMoves.add(Mouse.RIGHT);
            if (lastMove==Mouse.RIGHT) ReturnMoves.add(Mouse.LEFT);
        }
        
                
    @Override
    public int move(Grid currentGrid, Cheese cheese) {
        //Contabilizando Grid Visitados
        boolean visitado;
        visitado=VisitadoBool(currentGrid);
        if (!visitado) {
            this.incExploredGrids();
        }
      
        /*Si estamos en en Grid en exploracion y tiene movimientos posibles, 
         * devuelve el primer movimiento disponible, si en cambio estamos en un
         * Grid que no es el que tenemos en exploracion (padre) y los movimientos
         * posibles son 0, tomamos este como nuevo Grid a explorar, y devolvemos
         * el primer movimiento
         */
        if (currentGrid == explorado && !PossibleMoves.isEmpty()){
            lastMove = PossibleMoves.get(0);
            returnmoveadd(PossibleMoves.get(0));
            PossibleMoves.remove(0);
            return lastMove;
        } else if (currentGrid != explorado && PossibleMoves.isEmpty()){
            explorado=currentGrid;
            Exploracion(currentGrid);
            lastMove = PossibleMoves.get(0);
            returnmoveadd(PossibleMoves.get(0));
            PossibleMoves.remove(0);
            return lastMove;
        } else {
            if (currentGrid != explorado && !PossibleMoves.isEmpty()) {
                lastMove=volver(explorado,ReturnMoves.size()-1);
                return lastMove;
            }else {
                Random random = new Random();
                Exploracion(currentGrid);
                lastMove = PossibleMoves.get(random.nextInt(PossibleMoves.size()));
                PossibleMoves.clear();
                return lastMove;
            }   
        }
    }
    
    @Override
    public void newCheese() {
    }

    @Override
    public void respawned() {
        explorado=null;
        
    }
    
}