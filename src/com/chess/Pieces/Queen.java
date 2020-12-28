package com.chess.Pieces;

import com.chess.Game.Board;
import com.chess.Game.Spot;

import java.util.ArrayList;

public class Queen extends Piece
{
    Spot location;

    public Queen(int x, int y, final int color, Board board)
    {
        super(x, y, color);

    }


    protected ArrayList<Spot> possibleMoves(Board board) {

    }
    @Override
    public  boolean isValidMove (int xPos, int yPos,Board board)
    {
   /*     if(board.isValidPosition(xPos, yPos)   )
        {
            if (location==null)
            {
                return possibleMoves( xPos, yPos , board);
            }
            return false;
        }
        return false;*/
    }



//    private boolean possibleMoves(int X, int Y,Board board){
//        if (canMoveDiagonal(X, Y,board) ||
//                canMoveStraight( X, Y, board))
//        {
//            return true;
//        }
//        return false;
//    }
}