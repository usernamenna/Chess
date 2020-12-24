package com.chess.Game;

public class Board {

    private final Spot[][] board;

    public Board()
    {
        board = new Spot[8][8];
    }
    // To check that the chosen spot is in the board
    public boolean isValidPosition(int xpos , int ypos)
    {
        if(xpos >= 0 && xpos <= 7 && ypos >= 0 && ypos <= 7)
            return true;
        else
            return false;
    }
    public void capturePiece(int x , int y)
    {
        board[x][y].removePiece();
    }
    public Spot getSpot(int x , int y)
    {
        return board[x][y];
    }
}
