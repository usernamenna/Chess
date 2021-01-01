package com.chess.Pieces;

import com.chess.Game.Board;
import com.chess.Game.Spot;

import java.util.ArrayList;

public class Rook extends Piece{


    ArrayList<Spot> moves = new ArrayList<>();

    public Rook( int xLoc, int yLoc , int color)
    {
        super(xLoc, yLoc,color );
        super.BlackPath ="src/com/chess/Pieces/png/rook.png";
        super.WhitePath ="src/com/chess/Pieces/png/rookw.png";
    }

/*
    @Override
    public boolean isValidMove(int xPos, int yPos,Board board) {
        return board.isValidPosition(xPos, yPos);
    }
*/
    @Override
    protected ArrayList<Spot> possibleMoves(Board board) {
        moves.clear();

        int[] negX = {-7,-6,-5,-4,-3,-2,-1};
        int[] X = {7,6,5,4,3,2,1};
        int[] negY = {-7,-6,-5,-4,-3,-2,-1};
        int[] Y ={1, 2, 3, 4, 5, 6, 7};

        //const x in down y-axis
        for(int i = 0 ; i < 7 ; i++)
        {
            int newX = getX();
            int newY = getY()+negY[i];
            Spot spot = board.getSpot(newX, newY);

            if(spot.getPiece()!= null)
            {
                if(spot.getPiece().getColor()!= this.getColor()){
                    moves.add(board.getSpot(newX, newY));
                    break;
                }
                if(spot.getPiece().getColor()== this.getColor()){

                    break;
                }

            }


            if(board.isValidPosition(newX, newY) && spot.getPiece()== null )
            {
                moves.add(board.getSpot(newX, newY));
            }
        }
        //const x in up Y
        for(int i = 0 ; i < 7 ; i++)
        {
            int newX = getX();
            int newY = getY()+Y[i];
            Spot spot = board.getSpot(newX, newY);

            if(spot.getPiece()!= null)
            {
                if(spot.getPiece().getColor()!= this.getColor()){
                    moves.add(board.getSpot(newX, newY));
                    break;
                }
                if(spot.getPiece().getColor()== this.getColor()){

                    break;
                }

            }
            // check if spot is valid and empty OR contains a piece of the opposite color

            if(board.isValidPosition(newX, newY) && spot.getPiece()== null )
            {
                moves.add(board.getSpot(newX, newY));
            }
        }

        //const y to Right X
        for(int i = 0 ; i < 7 ; i++)
        {
            int newX = getX()+X[i];
            int newY = getY();
            Spot spot = board.getSpot(newX, newY);

            if(spot.getPiece()!= null)
            {
                if(spot.getPiece().getColor()!= this.getColor())
                {
                    moves.add(board.getSpot(newX, newY));
                    break;
                }
                if(spot.getPiece().getColor()== this.getColor())
                {
                    break;
                }
            }

            if(board.isValidPosition(newX, newY) && (spot.getPiece()== null ))
            {
                moves.add(board.getSpot(newX, newY));
            }
        }
        //const y to left  X
        for(int i = 0 ; i < 7 ; i++)
        {
            int newX = getX()+negX[i];
            int newY = getY();
            Spot spot = board.getSpot(newX, newY);

            if(spot.getPiece()!= null)
            {
                if(spot.getPiece().getColor()!= this.getColor())
                {
                    moves.add(board.getSpot(newX, newY));
                    break;
                }
                if(spot.getPiece().getColor()== this.getColor())
                {
                    break;
                }
            }

            if(board.isValidPosition(newX, newY) && (spot.getPiece()== null ))
            {
                moves.add(board.getSpot(newX, newY));
            }
        }

        return moves;
    }


}
