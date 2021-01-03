package com.chess.Pieces;

import com.chess.Game.Board;
import com.chess.Game.Spot;

import java.util.ArrayList;

public class Knight extends Piece{

    ArrayList<Spot> moves = new ArrayList<>();
    public Knight(int x, int y, int color) {
        super(x, y, color);
        super.BlackPath ="C:\\Users\\Norhan\\Desktop\\112072-chess\\png\\knight.png";
        super.WhitePath ="C:\\Users\\Norhan\\Desktop\\112072-chess\\png\\knightw.png";
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
        for(int i = 0 ; i < 8 ; i++)
        {
            int newX = getX()+X[i];
            int newY = getY()+Y[i];
            Spot spot = board.getSpot(newX, newY);
            // check if spot is valid and empty OR contains a piece of the opposite color
            if(board.isValidPosition(newX, newY) && (spot.isEmpty() || (!spot.isEmpty() && spot.getPiece().getColor()!= this.getColor()) )  )
            {
                moves.add(board.getSpot(newX, newY));
            }
        }
        return moves;
    }
}
