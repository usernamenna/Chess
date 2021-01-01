package com.chess.Pieces;

import com.chess.Game.Board;
import com.chess.Game.Spot;

import java.util.ArrayList;

public class Pawn extends Piece
{

    Spot location;
    public Pawn(int x, int y, final int color)
    {
        super(x, y, color);
        super.BlackPath ="C:\\Users\\Norhan\\Desktop\\112072-chess\\png\\pawn.png";
        super.WhitePath ="C:\\Users\\Norhan\\Desktop\\112072-chess\\png\\pawnw.png";
    }

    @Override
    protected ArrayList<Spot> possibleMoves(Board board) {
        return null;
    }
    // TODO Fix this
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