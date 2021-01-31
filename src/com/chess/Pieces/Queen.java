package com.chess.Pieces;
import com.chess.Game.*;
import java.util.ArrayList;
 
public class Queen extends Piece
{
    ArrayList<Spot> moves = new ArrayList<>();
 
    
    public Queen (int color)
    {
        super( color);
        super.BlackPath ="src/com/chess/Pieces/png/queen.png";
        super.WhitePath ="src/com/chess/Pieces/png/queenw.png";
        super.PieceName = "Queen";
    }
    
    public Queen ( int x, int y, int color)
    {
        super(x, y, color);
        super.BlackPath ="src/com/chess/Pieces/png/queen.png";
        super.WhitePath ="src/com/chess/Pieces/png/queenw.png";
        super.PieceName= "Queen";
    }
 
    /**
     *
     * @param board
     * @return
     */
    @Override
    public ArrayList<Spot> possibleMoves(Board board)
    {
        moves.clear();
        int[] X = {1, 2, 3, 4, 5, 6, 7,8};
        int[] Y ={1, 2, 3, 4, 5, 6, 7,8};
 
 
        // queen can move straight and diagonal
        //move Straight   move up , down   
       //y constant     x Is increasing   move up
 
        for(int i = 0 ; i < 8 ; i++)
        {
            int newX = getX()+X[i];
            int newY = getY();
            if (board.isValidPosition(newX, newY) )
           {
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
        }
        //y constant     x Is decreasing   move down
        for(int i = 0 ; i < 8 ; i++)
        {
            int newX = getX()-X[i];
            int newY = getY();
             if (board.isValidPosition(newX, newY) )
           {
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
 
            if(board.isValidPosition(newX, newY) && spot.getPiece() == null )
            {
                moves.add(board.getSpot(newX, newY));
            }
        }
        }
           //move Straight   move right , left
 
             // x constant     y  Is increasing   move right
        for(int i = 0 ; i < 8 ; i++)
        {
            int newX = getX();
            int newY = getY()+Y[i];
            if (board.isValidPosition(newX, newY) )
           {
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
        }
              // x constant     y  is decreasing   move left
        for(int i = 0 ; i < 8 ; i++)
        {
            int newX = getX();
            int newY = getY()-Y[i];
             if (board.isValidPosition(newX, newY) )
           {
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
        }
                           //move Diagonal
              //Right up
        for(int i = 0 ; i < 8 ; i++)
        {
            int newX = getX()+X[i];
            int newY = getY()+Y[i];
           if (board.isValidPosition(newX, newY) )
           {
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
// check if spot is valid and empty OR contains a piece of the opposite color
 
            if(board.isValidPosition(newX, newY) && spot.getPiece()== null )
            {
                moves.add(board.getSpot(newX, newY));
            }
        }
        }
        //Left up
        for(int i = 0 ; i < 8 ; i++)
        {
            int newX = getX()+X[i];
            int newY = getY()-Y[i];
           if (board.isValidPosition(newX, newY) )
           {
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
 
            if(board.isValidPosition(newX, newY) && spot.getPiece()== null )
            {
                moves.add(board.getSpot(newX, newY));
            }
        }
        }
        //Left down
        for(int i = 0 ; i < 8 ; i++)
        {
            int newX = getX()-X[i];
            int newY = getY()-Y[i];
            if (board.isValidPosition(newX, newY) )
           {
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
 
            if(board.isValidPosition(newX, newY) && spot.getPiece()== null )
            {
                moves.add(board.getSpot(newX, newY));
            }
        }
 
        }
        //right down
        for(int i = 0 ; i < 8 ; i++)
        {
            int newX = getX()-X[i];
            int newY = getY()+X[i];
           if (board.isValidPosition(newX, newY) )
           {
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
 
            if(board.isValidPosition(newX, newY) && spot.getPiece()== null )
            {
                moves.add(board.getSpot(newX, newY));
            }
        }
        }  
        return moves;
    }
}