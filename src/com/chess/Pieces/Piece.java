package com.chess.Pieces;

import com.chess.Game.Board;
import com.chess.Game.Spot;

import java.util.ArrayList;

public abstract class Piece {

    protected static final int black = 0;
    protected static final int white = 1;
    private final int color; // 0 for black, 1 for white
    private int x = -1;
    private int y = -1 ;// Position
    private boolean isFirstMove = true;
    protected String BlackPath;
    protected String WhitePath;
    protected String PieceName;
   
   // this constructor is used to create only pieces WITHOUT having to add its position on board
   public Piece(final int color){
        this.color = color;
    } 

    public Piece(int x, int y, final int color){
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public void setX(int x){
        this.x =x;
    }
    public void setY(int y){
        this.y =y;
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
    
    // is related to pawn promotion window
    public String getPieceName(){
        return PieceName;
    }
  
     // generates possible moves for a piece
    public abstract ArrayList<Spot> possibleMoves(Board board);

    public void move(Spot from, Spot to){
        from.removePiece();
        to.insertPiece(this);
        x = to.getX();
        y = to.getY();
        isFirstMove = false;
    }
 
}
