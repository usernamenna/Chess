package com.chess.Pieces;

import com.chess.Game.Board;
import com.chess.Game.Spot;

import java.util.ArrayList;

public class Pawn extends Piece
{
    ArrayList<Spot> moves = new ArrayList<>();
    Spot location;
    
    public Pawn(int x, int y,  int color)
    {
        super(x, y, color);
        super.BlackPath ="src/com/chess/Pieces/png/pawn.png";
        super.WhitePath ="src/com/chess/Pieces/png/pawnw.png";
    }
    
 @Override
  public ArrayList<Spot> possibleMoves(Board board) 
     {
       moves.clear();  
 
       int[] Y = {1};
       int[] X= {1};
 
           // pawn can move one  space Straight if sopt doesnot contain any pieces  
 
          //x constant   Y up
          for(int i = 0 ; i < 1 ; i++)
          {
           int newX = getX();
           int newY = getY()+Y[i];
           Spot spot = board.getSpot(newX, newY);
 
           // check if spot is valid and empty OR contains a piece of the opposite color
           if(board.isValidPosition(newX, newY) && spot.getPiece()== null )
            {
             moves.add(board.getSpot(newX, newY));
            }
          }
 
       // pawn can move one space diagonal , right and left , if spot contains piece of the opposite color 
 
                   //move Diagonal
        //Right up
       for(int i = 0 ; i < 1 ; i++)
        {
          int newX = getX()+X[i];
          int newY = getY()+X[i];
          Spot spot = board.getSpot(newX, newY);
 
          if(spot.getPiece()!= null){
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
       }
 
 
               //Left up
       for(int i = 0 ; i <1 ; i++)
        {
            int newX = getX()-X[i];
            int newY = getY()+X[i];
            Spot spot = board.getSpot(newX, newY);
 
            if(spot.getPiece()!= null){
                if(spot.getPiece().getColor()!= this.getColor()){
                    moves.add(board.getSpot(newX, newY));
                    break;
                }
                if(spot.getPiece().getColor()== this.getColor()){
                    break;
                }
            }
        }
 
        return moves;
     }
}