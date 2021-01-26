package com.chess.Pieces;

import com.chess.Game.Board;
import com.chess.Game.Spot;

import java.util.ArrayList;

public abstract class Piece {
    protected static final int black = 0;
    protected static final int white = 1;
    private final int color; // 0 for black, 1 for white
    private int x;
    private int y;// Position
    private boolean isFirstMove = true;
    protected String BlackPath;
    protected String WhitePath;
   

    public Piece(int x, int y, final int color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getColor()
    {
        return color;
    }
    public boolean isFirstMove() {
        return isFirstMove;
    }
    public String getWhitePath(){
        return WhitePath;
    }
    public String getBlackPath(){
        return BlackPath;
    }
  
     // generates possible moves for a piece
    public abstract ArrayList<Spot> possibleMoves(Board board);

    //public abstract boolean isValidMove(int xPos, int yPos);
    public void move(Spot from, Spot to){
        from.removePiece();
        to.insertPiece(this);
        x = to.getX();
        y = to.getY();
        isFirstMove = false;
    }
 
}
