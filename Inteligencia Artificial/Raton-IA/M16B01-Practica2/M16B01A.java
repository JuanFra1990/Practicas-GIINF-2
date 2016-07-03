package mouserun.mouse;		
import mouserun.game.*;		
import java.util.*;

public class M16B01A extends Mouse {

	private Grid lastGrid;
        private ArrayList<Grid> Grids = new ArrayList<>();
        private ArrayList<Grid> exploredGrids;

	public M16B01A()
	{
		super("Lovecraft2");
                
                exploredGrids=new ArrayList<Grid>();
	}
	
        
        private boolean visitedGrid(Grid currentGrid){
        
        for (int i=0;i<exploredGrids.size();i++){
            if (exploredGrids.get(i)==currentGrid) {
                return true;
            }
        }
        exploredGrids.add(currentGrid);
        return false;
        }
        
	public int move(Grid currentGrid, Cheese cheese){
		
            Random random = new Random();       
            /*se añaden al array possibleMoves los movimientos posibles desde el grid */
            ArrayList<Integer> possibleMoves = setMovimientos(currentGrid);
                
            /*si el Grid no ha sido visitado, se añade aumentan los Grids 
            visitados*/
            boolean visited = visitedGrid(currentGrid);
            if (!visited) this.incExploredGrids();
                                
            /*Si hay solo 1 movimiento posible, se realiza*/
            if (possibleMoves.size() == 1){    
            /*se guarda el actual como el último Grid*/    
            lastGrid = currentGrid;
            /*se añade al array lastGrids el grid actual*/    
            Grids.add(currentGrid);
            /*se devuelve el único movimiento posible*/    
            return possibleMoves.get(0);
            }
                
                else{
                    
                /*Si hay más de un movimiento posible se elimina la opcion ya visitada de los posibles movimientos*/		
                possibleMoves = limpiaVisitados (possibleMoves, currentGrid);
                                       
                /*Si se han eliminado todos los movimientos, se añaden de nuevo los movimientos 
                posibles desde el grid*/
                
		if (possibleMoves.size() == 0){
                            
		possibleMoves = setMovimientos(currentGrid);
                
                /*si el Grid al que se iría siguiendo la dirección ya está visitado, se elimina esa opción*/
                
                possibleMoves = limpiaGrids (possibleMoves, currentGrid);
                
		lastGrid = currentGrid;
                Grids.add(currentGrid);
                
                /*se devuelve un movimiento random entre los posibles*/
                return possibleMoves.get(random.nextInt(possibleMoves.size()));
                }
                        
                /*Si hay más de 1 movimiento posible, sin repetir uno dado se usa la medida h para decidir el movimiento*/
			
                    else{       
                            
                /*si el queso está arriba y a la derecha del currentGrid se eliminan las opciones izquierda y abajo*/
                        if (currentGrid.getX() < cheese.getX() && currentGrid.getY() < cheese.getY()){
                        possibleMoves.remove((Integer)Mouse.LEFT);
                        possibleMoves.remove((Integer)Mouse.DOWN);
                                    
                        /*Si se han eliminado todos los movimientos, se añaden los posibles desde el grid*/
                        if (possibleMoves.size() == 0){
                                        
                        possibleMoves = setMovimientos(currentGrid);
                                        
                        possibleMoves = limpiaVisitados (possibleMoves, currentGrid);
                                        
                        lastGrid = currentGrid;
                        Grids.add(currentGrid);
                        return possibleMoves.get(random.nextInt(possibleMoves.size()));
                        }}
                                
                        /*si el queso está abajo y a la izquierda del currentGrid se eliminan las opciones izquierda y arriba*/
                        if (currentGrid.getX() < cheese.getX() && currentGrid.getY() > cheese.getY()){
                        possibleMoves.remove((Integer)Mouse.LEFT);
                        possibleMoves.remove((Integer)Mouse.UP);
                                    
                        /*Si se han eliminado todos los movimientos, se añaden los posibles desde el grid*/
                        if (possibleMoves.size() == 0){
                            
                        possibleMoves = setMovimientos(currentGrid);
                                        
                        possibleMoves = limpiaVisitados (possibleMoves, currentGrid);
                        
                        lastGrid = currentGrid;
                        Grids.add(currentGrid);
                        return possibleMoves.get(random.nextInt(possibleMoves.size()));
                        }}
                                
                        /*si el queso está abajo y a la izquierda del currentGrid se eliminan las opciones derecha y arriba*/
                        if (currentGrid.getX() > cheese.getX() && currentGrid.getY() < cheese.getY()){
                        possibleMoves.remove((Integer)Mouse.RIGHT);
                        possibleMoves.remove((Integer)Mouse.UP);
                                    
                        /*Si se han eliminado todos los movimientos, se añaden los posibles desde el grid*/
                        if (possibleMoves.size() == 0){
                        possibleMoves = setMovimientos(currentGrid);
                                        
                        possibleMoves = limpiaVisitados (possibleMoves, currentGrid);
                        
                        lastGrid = currentGrid;
                        Grids.add(currentGrid);
                        return possibleMoves.get(random.nextInt(possibleMoves.size()));
                        }}
                                
                        /*si el queso está abajo y a la izquierda*/
                        if (currentGrid.getX() > cheese.getX() && currentGrid.getY() > cheese.getY()){
                        possibleMoves.remove((Integer)Mouse.RIGHT);
                        possibleMoves.remove((Integer)Mouse.UP);
                        if (possibleMoves.size() == 0){
                        
                        possibleMoves = setMovimientos(currentGrid);
                                        
                        possibleMoves = limpiaVisitados (possibleMoves, currentGrid);
                        
                        lastGrid = currentGrid;
                        Grids.add(currentGrid);
                        return possibleMoves.get(random.nextInt(possibleMoves.size()));
                        }}
                        
                        /*si el queso tiene la misma coordenada X y esta arriba del currentGrid*/
                        if (currentGrid.getX() == cheese.getX() && currentGrid.getY() < cheese.getY()){
                        possibleMoves.remove((Integer)Mouse.LEFT);
                        possibleMoves.remove((Integer)Mouse.RIGHT);
                        possibleMoves.remove((Integer)Mouse.DOWN);
                        
                        if (possibleMoves.size() == 0){
                                        
                            possibleMoves = setMovimientos(currentGrid);
                                        
                        possibleMoves = limpiaVisitados (possibleMoves, currentGrid);
                        
                            lastGrid = currentGrid;
                            Grids.add(currentGrid);
                            return possibleMoves.get(random.nextInt(possibleMoves.size()));
                                    }}
                            
                                /*si el queso tiene la misma coordenada X y esta abajo del currentGrid*/
                        if (currentGrid.getX() == cheese.getX() && currentGrid.getY() > cheese.getY()){
                            possibleMoves.remove((Integer)Mouse.RIGHT);
                            possibleMoves.remove((Integer)Mouse.UP);
                            possibleMoves.remove((Integer)Mouse.LEFT);
                            
                            if (possibleMoves.size() == 0){
                                        
                            possibleMoves = setMovimientos(currentGrid);
                                        
                            possibleMoves = limpiaVisitados (possibleMoves, currentGrid);
                                lastGrid = currentGrid;
                                Grids.add(currentGrid);
                                return possibleMoves.get(random.nextInt(possibleMoves.size()));
                                }}
                                
                            /*si el queso tiene la misma coordenada Y y esta arriba del currentGrid*/
                            if (currentGrid.getX() < cheese.getX() && currentGrid.getY() == cheese.getY()){
                                possibleMoves.remove((Integer)Mouse.LEFT);
                                possibleMoves.remove((Integer)Mouse.UP);
                                possibleMoves.remove((Integer)Mouse.DOWN);
                                    
                                if (possibleMoves.size() == 0){
                                        
                                possibleMoves = setMovimientos(currentGrid);
                                        
                                possibleMoves = limpiaVisitados (possibleMoves, currentGrid);
                                    lastGrid = currentGrid;
                                    Grids.add(currentGrid);
                                    return possibleMoves.get(random.nextInt(possibleMoves.size()));
                                    }}
                            
                                /*si el queso tiene la misma coordenada Y y esta abajo del currentGrid*/
                            if (currentGrid.getX() > cheese.getX() && currentGrid.getY() == cheese.getY()){
                                possibleMoves.remove((Integer)Mouse.RIGHT);
                                possibleMoves.remove((Integer)Mouse.UP);
                                possibleMoves.remove((Integer)Mouse.DOWN);
                                
                                if (possibleMoves.size() == 0){
                                    
                                possibleMoves = setMovimientos(currentGrid);
                                        
                                possibleMoves = limpiaVisitados (possibleMoves, currentGrid);
                                lastGrid = currentGrid;
                                Grids.add(currentGrid);
                                return possibleMoves.get(random.nextInt(possibleMoves.size()));
                                    }}
                                
				lastGrid = currentGrid;
                                Grids.add(currentGrid);
				return possibleMoves.get(random.nextInt(possibleMoves.size()));
			}
		}
		
	}
	
        /*cuando hay un nuevo queso se limpia el array Grids*/
	public void newCheese(){
            Grids.clear();
	}
	
	public void respawned(){}
	
        /*devuelve true si no hay lastGrid o es distinto del anterior*/
	private boolean testGrid(int movimiento, Grid currentGrid){
		if (lastGrid == null){
		return true;
		}	
	
                /*las coordenadas del currentGrid*/
		int x = currentGrid.getX();
		int y = currentGrid.getY();
		
		switch (movimiento){
			
                    case Mouse.UP: 
			y += 1;
			break;
				
                    case Mouse.DOWN:
			y -= 1;
			break;
				
                    case Mouse.LEFT:
			x -= 1;
			break;
				
                    case Mouse.RIGHT:
			x += 1;
			break;
		}
		
                /*devuelve false si grid es igual al anterior visitado*/
		return !(lastGrid.getX() == x && lastGrid.getY() == y);
		
	}
        
        /*si en Grids está el grid al que se iría siguiendo la dirección
        devuelve false y true si no está o si Grids está vacío*/
        private boolean compruebaGrids(int movimiento, Grid currentGrid){
            
		if (Grids.size() == 0){
                    return true;
		}
	
		int x = currentGrid.getX();
		int y = currentGrid.getY();
                		
		switch (movimiento){
                    
			case Mouse.UP: 
				y += 1;
				break;
				
			case Mouse.DOWN:
				y -= 1;
				break;
				
			case Mouse.LEFT:
				x -= 1;
				break;
				
			case Mouse.RIGHT:
				x += 1;
				break;
		}
                
		for(int i=0;i<Grids.size();i++){
                    if(Grids.get(i).getX() == x && Grids.get(i).getY() == y){
                        return false;
                    }}
                
		return true;		
	}
	
public ArrayList<Integer> setMovimientos (Grid cg){
    ArrayList<Integer> Movimientos = new ArrayList<>();
    if (cg.canGoUp()) Movimientos.add(Mouse.UP);
    if (cg.canGoDown()) Movimientos.add(Mouse.DOWN);
    if (cg.canGoLeft()) Movimientos.add(Mouse.LEFT);
    if (cg.canGoRight()) Movimientos.add(Mouse.RIGHT);		
    return Movimientos;            
}
 
public ArrayList<Integer> limpiaVisitados (ArrayList<Integer> possibleMoves, Grid cg){
                
    ArrayList<Integer> p = possibleMoves;
                if (!compruebaGrids(Mouse.UP, cg)) possibleMoves.remove((Integer)Mouse.UP);
		if (!compruebaGrids(Mouse.DOWN, cg)) possibleMoves.remove((Integer)Mouse.DOWN);
		if (!compruebaGrids(Mouse.LEFT, cg)) possibleMoves.remove((Integer)Mouse.LEFT);
		if (!compruebaGrids(Mouse.RIGHT, cg)) possibleMoves.remove((Integer)Mouse.RIGHT);
                        
return p;
}

public ArrayList<Integer> limpiaGrids (ArrayList<Integer> possibleMoves, Grid cg){

        ArrayList<Integer> p = possibleMoves;
                if (!testGrid(Mouse.UP, cg)) possibleMoves.remove((Integer)Mouse.UP);
                if (!testGrid(Mouse.DOWN, cg)) possibleMoves.remove((Integer)Mouse.DOWN);
                if (!testGrid(Mouse.LEFT, cg)) possibleMoves.remove((Integer)Mouse.LEFT);
                if (!testGrid(Mouse.RIGHT, cg)) possibleMoves.remove((Integer)Mouse.RIGHT);
                                
return p;
}

}