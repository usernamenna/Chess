package com.chess.Pieces;

import com.chess.Game.*;

public abstract class Piece {
    private static final int black = 0;
    private static final int white = 1;
    private final int color; // 0 for black, 1 for white
    private int x;
    private int y;// Position
    private boolean isFirstMove;

    public Piece(int x, int y, final int color, boolean isFirstMove){
        this.x = x;
        this.y = y;
        this.color = color;
        this.isFirstMove = isFirstMove;
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
    public abstract boolean isValidMove(int xPos, int yPos);
    public void move(Spot from, Spot to){
        from.removePiece();
        to.insertPiece(this);
        x = to.getX();
        y = to.getY();
    }
    // generates possible moves for a piece
    protected abstract void possibleMoves();
    protected boolean canMoveStraight(int toX, int toY,Board board)
    {
        if(toX==x && toY == y)
        {
            return false;
        }
        if(toX == x) // moving on y
        {
            int small = Math.min(y, toY);
            int big = Math.max(y, toY);
            // check if there's an occupied spot on the way
            for(int i = small;i < big; i++)
            {
                if(!board.getSpot(x, i).isEmpty()) {
                    return false;
                }
            }
            return true;
        }
        if(toY == y) // moving on x
        {
            int small = Math.min(x, toX);
            int big = Math.max(x, toX);
            // check if there's an occupied spot on the way
            for(int i = small;i < big; i++)
            {
                if(!board.getSpot(i, y).isEmpty()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    protected boolean canMoveDiagonal(int toX, int toY, Board board)
    {
        if(x == toX && y == toY)
        {
            return false;
        }
        // right diagonal
        if((toX > x && toY > y) || (toX < x && toY < y))
        {
            // check if a spot is occupied in the way
            for(int i = x; i < Math.abs(toX - x); i++)
            {
                if(toX > x && toY > y)
                {
                    if(!board.getSpot(x+i, y+i).isEmpty())
                    {
                        return false;
                    }
                }
                else
                {
                   if(!board.getSpot(x-i, y-i).isEmpty())
                   {
                       return false;
                   }
                }
            }
        }
        // left diagonal
        else if((toX>x && toY < y)|| (toX < x && toY > y))
        {
            // check if a spot is occupied in the way
            for(int i = x; i < Math.abs(toX - x); i++)
            {
                if(toX > x && toY < y)
                {
                    if(!board.getSpot(x+i, y-i).isEmpty())
                    {
                        return false;
                    }
                }
                else if(toX < x && toY > y)
                {
                    if(!board.getSpot(x-i, y+i).isEmpty())
                    {
                        return false;
                    }
                }
            }
        }
        return false;
    }

}
