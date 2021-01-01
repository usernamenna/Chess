package com.chess.Pieces;

import com.chess.Game.Board;
import com.chess.Game.Spot;
import java.util.ArrayList;

public class King extends Piece {
    
    ArrayList<Spot> KingMoves = new ArrayList<>();
    
    public King( int xpos , int ypos , int color)
   {
       super(xpos, ypos,color ); 
        super.BlackPath ="src/com/chess/Pieces/png/king.png";
        super.WhitePath ="src/com/chess/Pieces/png/kingw.png";
   }
   /*@Override
    public boolean isValidMove(int xpos, int ypos , Board board)
    {
       if( board.isValidPosition(xpos,ypos) )
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
    }*/
    @Override
    protected ArrayList<Spot> possibleMoves(Board board) {
        KingMoves.clear();
        for ( int i = -1 ; i < 2 ; i++) {
            for (int j = -1; j < 2; j++) {
                int newx = getX() + i;
                int newy = getY() + j;
                if (i == 0 && j == 0)
                    continue;
                Spot spot = board.getSpot(newx, newy);
                if (board.isValidPosition(newx, newy)) {
                    if (spot.getPiece() != null) {
                        if (spot.getPiece().getColor() == this.getColor())
                            continue;
                        KingMoves.add(board.getSpot(newx, newy));
                    } else
                        KingMoves.add(board.getSpot(newx, newy));
                }

            }
        }
        return KingMoves;
    }
    }
    
    
    

