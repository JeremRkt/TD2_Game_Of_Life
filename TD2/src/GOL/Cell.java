package GOL;

public class Cell {
    public int state;
    public int livingNeighbors;

    public Cell(int state, int livingNeighbors){
        this.state = state;
        this.livingNeighbors = livingNeighbors;
    }

    /**
     * Given an initial state for the cell, computes its next state
     * @return
     */
    public int NextState(){
        //When living cell is in contact with 2 or 3 living cell, it survives
        if(state == CellState.ALIVE && (livingNeighbors == 2 || livingNeighbors == 3)) {
            return CellState.ALIVE;
        }

        //When dead cell is in contact with 3 living cell, it becomes alive
        if(state == CellState.DEAD && livingNeighbors == 3) {
            return CellState.ALIVE;
        }

        //If overpopulated, every live cell become dead
        if(state == CellState.ALIVE && livingNeighbors > 3){
            return CellState.DEAD;
        }

        return CellState.DEAD;
    }
}
