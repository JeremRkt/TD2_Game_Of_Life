package com.company;
import GOL.Coord;
import GOL.GameOfLife;

public class Main {

    public static Coord[] InitialAliveCells(){
        Coord[] coords = new Coord[] {
                new Coord(3,2),
                new Coord(3,3),
                new Coord(4,2),
                new Coord(3,4),
                new Coord(2,4),
               // new Coord(2,2),
                new Coord(3,1),
        };

        return coords;
    }

    public static void main(String[] args) {
        Coord[] initialCells = InitialAliveCells();
        GameOfLife gol = new GameOfLife(5, 5, initialCells);
        gol.ComputeNthGeneration(10);
    }
}
