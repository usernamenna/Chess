package com.chess.Game;

public class Board {
    private Spot spot[][] = new Spot[8][8];
    public Spot getSpot(int x, int y)
    {
        return spot[x][y];
    }
}
