package com.chess.Pieces;

import java.util.ArrayList;
public class King extends Piece {
    ArrayList<Spot> KingMoves = new ArrayList<>();
    public King( int color , int xpos , int ypos , boolean fmove )
   {
       super(xpos, ypos,color ,fmove );  
   } 
   @Override
    public boolean isValidMove(int xpos, int ypos , Board board) 
    {
       if( board.IsValidPosition(xpos,ypos) )
       {
           if( xpos == super.getX() || xpos == super.getX() + 1 || xpos == super.getX() - 1  )
           {
               if( ypos == super.getY() || ypos == super.getY() + 1 || ypos == super.getY() - 1 )
               {
                   if( xpos == super.getX() && ypos == super.getY() )
                       return false;
                   else
                       return true;
               }
               else
                   return false;
           }
           else 
               return false;
       }
       else
           return false;
    }
    @Override
    protected ArrayList<Spot> possibleMoves(Board board) {
        KingMoves.clear();
        for ( int i = -1 ; i < 2 ; i++)
        {
            for ( int j = -1 ; j < 2 ; j++)
            {
                int newx = getX() + i;
                int newy = getY() + j;
                if ( i == 0 && j == 0 )
                    continue;
                Spot spot = board.GetSpot(newx, newy);
                if(board.IsValidPosition(newx, newy))
                {
                    if (spot.getPiece()!= null)
                    {
                        if (spot.getPiece().getColor()== this.getColor())
                            continue;
                        KingMoves.add(board.GetSpot(newx, newy));
                    }
                    else
                        KingMoves.add(board.GetSpot(newx, newy));
                }
            
            }
        }
            
        return KingMoves;
    }
    }
    
    
    

