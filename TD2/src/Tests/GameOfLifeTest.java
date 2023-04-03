package Tests;

import GOL.Cell;
import GOL.CellState;
import GOL.Coord;
import GOL.GameOfLife;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.company.Main.InitialAliveCells;
import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeTest {

    Coord[] initialCells = InitialAliveCells();



    @BeforeEach
    void setUp(){
        GameOfLife gol = new GameOfLife(5,5, initialCells);
        gol.ComputeNthGeneration(10);
    }
    @Test
    void init() {

        Coord[] initialCells = new Coord[]{
                new Coord(3,2),
                new Coord(3,3),
                new Coord(4,2),
                new Coord(3,4),
                new Coord(2,4),
                new Coord(3,1),
        };

        GameOfLife game = new GameOfLife(5,5,initialCells);

        //Check initial position and state of each Cell
        Assertions.assertEquals(game.grid[3][2], CellState.ALIVE);
        Assertions.assertEquals(game.grid[3][3], CellState.ALIVE);
        Assertions.assertEquals(game.grid[4][2], CellState.ALIVE);
        Assertions.assertEquals(game.grid[3][4], CellState.ALIVE);
        Assertions.assertEquals(game.grid[2][4], CellState.ALIVE);
        Assertions.assertEquals(game.grid[3][1], CellState.ALIVE);

    }

    @Test
    void countlivingNeighbours() {
        Coord[] coords = new Coord[]{
                new Coord(3,2),
                new Coord(3,3),
                new Coord(4,2),
                new Coord(3,4),
                new Coord(2,4),
                new Coord(3,1),
        };

        GameOfLife game = new GameOfLife(5,5, coords);

        //Check if c2-r2 have 3 living neighbour ==> which is the case, normally
        Assertions.assertEquals(game.countlivingNeighbours(2,2),3);
        /* It will have an error since c4-r1 have only two living neighbour but
        *if we replace by this line it will become true
        * Assertions.assertEquals(game.countlivingNeighbours(1,4),1);
        */
        Assertions.assertEquals(game.countlivingNeighbours(1,4),2);

    }

    @Test
    void computeNextGeneration() {

        Coord[] coords = new Coord[]{
                new Coord(3,2),
                new Coord(3,3),
                new Coord(4,2),
                new Coord(3,4),
                new Coord(2,4),
                new Coord(3,1),
        };
        GameOfLife game = new GameOfLife(5,5,coords);

        game.computeNextGeneration();

        Assertions.assertEquals(game.grid[2][2],CellState.ALIVE); // Living cell because 3 neighbours (C3-R3/C2-R3/C1-R3)
        Assertions.assertEquals(game.grid[3][3],CellState.DEAD); // Dead cell because 4 neighbours (C4-R2/C4-R3/C2-R3/C2-R4)
        Assertions.assertEquals(game.grid[2][1],CellState.ALIVE); // Living cell because 2 neighbours (C1-R3/C2-R3)

    }
}