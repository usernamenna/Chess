package com.chess.Pieces;

import com.chess.Game.Board;
import com.chess.Game.Spot;

public abstract class Pawn extends Piece
{

    Spot location;
    public Pawn(int x, int y, final int color)
    {
        super(x, y, color);
    }

    /**
     * @param xPos
     * @param yPos
     * @param board
     * @return
     */
    @Override
     public  boolean isValidMove(int xPos, int yPos, Board board)
    {
        if(board.isValidPosition(xPos, yPos)   )
        {
            return possibleMoves( xPos,  yPos);
        }
        return false;
    }

    private boolean possibleMoves(int xPosition, int yPosition)
    {
        int one_step;
        int two_step;

        if (this.getColor() == black){
            one_step = 1;
            two_step = 2;
        }
        else{
            one_step = -1;
            two_step = -2;
        }

        // Moving one step forward
        if (xPosition - this.getX() == one_step )
        {
            // Straight
            if (yPosition == this.getY()&&location == null )
            {
                return true;
            }
            // Diagonal
            if (Math.abs(this.getY() - yPosition) == 1&&location != null )
            {
                return true;
            }
        }
        // Two spaces
        else if (false)
        {
            if (xPosition - this.getX() == two_step)
            {
                if (yPosition == this.getY()&& location == null)
                {
                    return true;
                }
            }
        }
        return false;
    }
}