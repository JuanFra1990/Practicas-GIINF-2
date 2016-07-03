package mouserun.mouse;

import java.util.ArrayList;
import java.util.Random;
import mouserun.game.Cheese;
import mouserun.game.Grid;
import mouserun.game.Mouse;

/**
 *
 * @author Maria Martinez Baeza
 * @author Juan Francisco Aban Fontecha
 */

public class M16B01 extends Mouse {

        private static int counter;
        private int lastMove;
        private ArrayList<Grid> GridVisited;
        
	public M16B01()
	{
        super("Lovecraft");		
        GridVisited=new ArrayList<Grid>();
	}
                
    @Override
    public int move(Grid currentGrid, Cheese cheese) {
    
    Random random = new Random();
		ArrayList<Integer> possibleMoves = new ArrayList<Integer>();
                ArrayList<Integer> possibleDecisions = new ArrayList<Integer>();
		if (currentGrid.canGoUp()) possibleMoves.add(Mouse.UP);
		if (currentGrid.canGoDown()) possibleMoves.add(Mouse.DOWN);
		if (currentGrid.canGoLeft()) possibleMoves.add(Mouse.LEFT);
		if (currentGrid.canGoRight()) possibleMoves.add(Mouse.RIGHT);                               
                
    if (possibleMoves.size()>1){                                           
        
        switch (lastMove) {
            case Mouse.RIGHT:
                possibleMoves.remove((Integer)Mouse.LEFT);
                break;
            case Mouse.UP:
                possibleMoves.remove((Integer)Mouse.DOWN);
                break;
            case Mouse.DOWN:
                possibleMoves.remove((Integer)Mouse.UP);
                break;
            case Mouse.LEFT:
                possibleMoves.remove((Integer)Mouse.RIGHT);
                break;    
            default:
                break;
        }   
        
        if (counter>5){
        if (possibleMoves.size()>1){
        lastMove = lastMove = possibleMoves.get(random.nextInt(possibleMoves.size()));       
        counter=0;
        return lastMove;
        }
        }
        
        boolean visitado=false;
        //Contabilizando Grid Visitados
               for (int i=0;i<GridVisited.size();i++){
                    if (GridVisited.get(i)==currentGrid) {
                        visitado=true; 
                }
               }
       if (!visitado) this.incExploredGrids();
        
        if (possibleMoves.size()>1){ 
                                                                        
            if (cheese.getY() > currentGrid.getY()){
                for (int i=0;i<possibleMoves.size();i++){ 
                if (possibleMoves.get(i)==Mouse.UP) {                
                possibleDecisions.add(Mouse.UP);                  
            }}} else 
            if (cheese.getY() < currentGrid.getY()){    
                for (int i=0;i<possibleMoves.size();i++){
                if (possibleMoves.get(i)==Mouse.DOWN) {
                possibleDecisions.add(Mouse.DOWN);                      
                }}}
            
            if (cheese.getX() < currentGrid.getX()){
                for (int i=0;i<possibleMoves.size();i++){ 
                if (possibleMoves.get(i)==Mouse.LEFT) {                
                possibleDecisions.add(Mouse.LEFT);                  
            }}} else             
            if (cheese.getX() > currentGrid.getX()){    
                for (int i=0;i<possibleMoves.size();i++){
                if (possibleMoves.get(i)==Mouse.RIGHT) {
                possibleDecisions.add(Mouse.RIGHT);                      
                }}}
            
            
            
            if (cheese.getY() == currentGrid.getY()){
                for (int i=0;i<possibleMoves.size();i++){ 
                if (possibleMoves.get(i)==Mouse.UP) {                
                possibleDecisions.add(Mouse.UP);                  
            }}} else 
            if (cheese.getY() == currentGrid.getY()){    
                for (int i=0;i<possibleMoves.size();i++){
                if (possibleMoves.get(i)==Mouse.DOWN) {
                possibleDecisions.add(Mouse.DOWN);                      
            }}} else 
            if (cheese.getX() == currentGrid.getX()){
                for (int i=0;i<possibleMoves.size();i++){ 
                if (possibleMoves.get(i)==Mouse.LEFT) {                
                possibleDecisions.add(Mouse.LEFT);                  
            }}} else             
            if (cheese.getX() == currentGrid.getX()){    
                for (int i=0;i<possibleMoves.size();i++){
                if (possibleMoves.get(i)==Mouse.RIGHT) {
                possibleDecisions.add(Mouse.RIGHT);                      
                }}}
            
            
            
            
            
            
            
            
            if (possibleDecisions.size() >1){
            lastMove = possibleDecisions.get(random.nextInt(possibleDecisions.size()));
            counter++;
            return lastMove;                                                                   
            } else {
            if (possibleDecisions.size() == 1){    
            lastMove = possibleDecisions.get(0);
            counter++;
            return lastMove;
            }}
            
        }
           
    }
    if (possibleMoves.size()==1){
    lastMove=possibleMoves.get(0);
    return lastMove;         
    }              
    
        lastMove = possibleMoves.get(random.nextInt(possibleMoves.size()));       
        return lastMove;  
    
}
   
    @Override
    public void newCheese() {
    }

    @Override
    public void respawned() {
        
    }
    
}
