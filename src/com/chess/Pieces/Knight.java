package com.chess.Pieces;

import com.chess.Game.Board;
import com.chess.Game.Spot;

import java.util.ArrayList;

public class Knight extends Piece{
    

    ArrayList<Spot> moves = new ArrayList<>();
    public Knight(int x, int y, int color) {
        super(x, y, color);
        super.BlackPath ="src/com/chess/Pieces/png/knight.png";
        super.WhitePath ="src/com/chess/Pieces/png/knightw.png";
    }

    /*@Override
    public boolean isValidMove(int xPos, int yPos, Board board) {
        // Knight can move one square and two squares in any direction
        if (Math.abs(xPos - getX()) == 1 && Math.abs(yPos - getY()) == 2)
            return true;
        else if (Math.abs(xPos - getX()) == 2 && Math.abs(yPos - getY()) == 1)
            return true;
        return false;
    }
*/
    @Override
    public ArrayList<Spot> possibleMoves(Board board) {
        moves.clear();
        // Knight can move two squares and one square in any direction
        int[] X = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] Y = {2, -2, 2, -2, 1, -1, 1, -1};
        int newX , newY;
        for(int i = 0 ; i < 8 ; i++)
        {
             newX = this.getX()+X[i];
             newY = this.getY()+Y[i];
         
            
           if (board.isValidPosition(newX, newY) )
           {
               Spot spot = board.getSpot(newX, newY);
            // check if spot is valid and empty OR contains a piece of the opposite color
            if( spot.isEmpty() || (!spot.isEmpty() && spot.getPiece().getColor()!= this.getColor())   )
            {   
                //did = true;
                moves.add(spot); 
            }
           }
        }
        return moves;
    }
}
