package com.chess.Game;

import javax.swing.*;
import java.awt.*;

public class Board {

    private final Spot[][] board;

    public Board()
    {
        board = new Spot[8][8];
        for(int i =0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                board[i][j] = new Spot(i, j);
            }
        }
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
