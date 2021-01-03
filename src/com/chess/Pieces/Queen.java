
package com.chess.Pieces;
import com.chess.Game.*;
import java.util.ArrayList;

public class Queen extends Piece
{
    ArrayList<Spot> QueenMoves = new ArrayList<>();

    public Queen ( int x, int y, final int color)
    {
        super(x, y, color);
        super.BlackPath ="C:\\Users\\Norhan\\Desktop\\112072-chess\\png\\queen.png";
        super.WhitePath ="C:\\Users\\Norhan\\Desktop\\112072-chess\\png\\queenw.png";
    }
    public ArrayList<Spot> possibleMoves(Board board)
    {
        QueenMoves.clear();
        int[] negX = {-7,-6,-5,-4,-3,-2,-1};
        int[] X = {1, 2, 3, 4, 5, 6, 7};
        int[] negY = {-7,-6,-5,-4,-3,-2,-1};
        int[] Y ={1, 2, 3, 4, 5, 6, 7};
        // queen can move straight and diagonal

        //move Straight
        //x constant     y down
        for(int i = 0 ; i < 7 ; i++)
        {
            int newX = getX();
            int newY = getY()+negY[i];
            Spot spot = board.getSpot(newX, newY);

            if(spot.getPiece()!= null)
            {
                if(spot.getPiece().getColor()!= this.getColor()){
                    QueenMoves.add(board.getSpot(newX, newY));
                    break;
                }
                if(spot.getPiece().getColor()== this.getColor()){
                    break;
                }

            }

            // check if spot is valid and empty OR contains a piece of the opposite color
            if(board.isValidPosition(newX, newY) && spot.getPiece()== null )
            {
                QueenMoves.add(board.getSpot(newX, newY));
            }
        }
        //x constant   Y up
        for(int i = 0 ; i < 7 ; i++)
        {
            int newX = getX();
            int newY = getY()+Y[i];
            Spot spot = board.getSpot(newX, newY);

            if(spot.getPiece()!= null)
            {
                if(spot.getPiece().getColor()!= this.getColor()){
                    QueenMoves.add(board.getSpot(newX, newY));
                    break;
                }
                if(spot.getPiece().getColor()== this.getColor()){
                    break;
                }

            }

            if(board.isValidPosition(newX, newY) && spot.getPiece() == null )
            {
                QueenMoves.add(board.getSpot(newX, newY));
            }
        }

        //y constant    X right
        for(int i = 0 ; i < 7 ; i++)
        {
            int newX = getX()+X[i];
            int newY = getY();
            Spot spot = board.getSpot(newX, newY);

            if(spot.getPiece()!= null)
            {
                if(spot.getPiece().getColor()!= this.getColor())
                {
                    QueenMoves.add(board.getSpot(newX, newY));
                    break;
                }
                if(spot.getPiece().getColor()== this.getColor())
                {
                    break;
                }
            }

            if(board.isValidPosition(newX, newY) && (spot.getPiece()== null ))
            {
                QueenMoves.add(board.getSpot(newX, newY));
            }
        }
        //y constant    X left
        for(int i = 0 ; i < 7 ; i++)
        {
            int newX = getX()+negX[i];
            int newY = getY();
            Spot spot = board.getSpot(newX, newY);

            if(spot.getPiece()!= null)
            {
                if(spot.getPiece().getColor()!= this.getColor())
                {
                    QueenMoves.add(board.getSpot(newX, newY));
                    break;
                }
                if(spot.getPiece().getColor()== this.getColor())
                {
                    break;
                }
            }

            if(board.isValidPosition(newX, newY) && (spot.getPiece()== null ))
            {
                QueenMoves.add(board.getSpot(newX, newY));
            }
        }

        //move Diagonal
        //Right up
        for(int i = 0 ; i < 7 ; i++)
        {
            int newX = getX()+X[i];
            int newY = getY()+X[i];
            Spot spot = board.getSpot(newX, newY);

            if(spot.getPiece()!= null){
                if(spot.getPiece().getColor()!= this.getColor()){
                    QueenMoves.add(board.getSpot(newX, newY));
                    break;
                }
                if(spot.getPiece().getColor()== this.getColor()){
                    break;
                }
            }
// check if spot is valid and empty OR contains a piece of the opposite color

            if(board.isValidPosition(newX, newY) && spot.getPiece()== null )
            {
                QueenMoves.add(board.getSpot(newX, newY));
            }
        }

        //Left down
        for(int i = 0 ; i < 7 ; i++)
        {
            int newX = getX()-X[i];
            int newY = getY()-X[i];
            Spot spot = board.getSpot(newX, newY);

            if(spot.getPiece()!= null){
                if(spot.getPiece().getColor()!= this.getColor()){
                    QueenMoves.add(board.getSpot(newX, newY));
                    break;
                }
                if(spot.getPiece().getColor()== this.getColor()){
                    break;
                }
            }

            if(board.isValidPosition(newX, newY) && spot.getPiece()== null )
            {
                QueenMoves.add(board.getSpot(newX, newY));
            }
        }
        //Left up
        for(int i = 0 ; i < 7 ; i++)
        {
            int newX = getX()-X[i];
            int newY = getY()+X[i];
            Spot spot = board.getSpot(newX, newY);

            if(spot.getPiece()!= null){
                if(spot.getPiece().getColor()!= this.getColor()){
                    QueenMoves.add(board.getSpot(newX, newY));
                    break;
                }
                if(spot.getPiece().getColor()== this.getColor()){
                    break;
                }
            }

            if(board.isValidPosition(newX, newY) && spot.getPiece()== null )
            {
                QueenMoves.add(board.getSpot(newX, newY));
            }
        }


        //down_right
        for(int i = 0 ; i < 7 ; i++)
        {
            int newX = getX()+X[i];
            int newY = getY()-X[i];
            Spot spot = board.getSpot(newX, newY);

            if(spot.getPiece()!= null){
                if(spot.getPiece().getColor()!= this.getColor()){
                    QueenMoves.add(board.getSpot(newX, newY));
                    break;
                }
                if(spot.getPiece().getColor()== this.getColor()){
                    break;
                }
            }

            if(board.isValidPosition(newX, newY) && spot.getPiece()== null )
            {
                QueenMoves.add(board.getSpot(newX, newY));
            }
        }

        return QueenMoves;
    }
}