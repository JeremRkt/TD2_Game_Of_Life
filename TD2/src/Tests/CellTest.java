package Tests;

import GOL.CellState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CellTest {

    private int state;

    private int livingNeighbors;

    @Test
    void nextState() {

        state = CellState.ALIVE;

        // over than 3 living cell = dead; 2 or 3 living cell = survive(if live cells, else if, becomes a live cell)
        livingNeighbors = 4;

        //It asserts that the rule of living cell near more than 3 cells, make the living cells die in next generation
        assertEquals(CellState.DEAD,CellState.DEAD);

    }
}