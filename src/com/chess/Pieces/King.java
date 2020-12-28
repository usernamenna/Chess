package com.chess.Pieces;

import com.chess.Game.Board;
import com.chess.Game.Spot;

import java.util.ArrayList;
public class King extends Piece {
    ArrayList<Spot> KingMoves = new ArrayList<>();

    public King(int x, int y, int color, boolean isFirstMove) {
        super(x, y, color, isFirstMove);
    }
    @Override
    public boolean isValidMove(int xPos, int yPos, Board board)
    {
       if( board.isValidPosition(xPos, yPos) )
       {
           if( xPos == super.getX() || xPos == super.getX() + 1 || xPos == super.getX() - 1  )
           {
               if( yPos == super.getY() || yPos == super.getY() + 1 || yPos == super.getY() - 1 )
               {
                   if( xPos == super.getX() && yPos == super.getY() )
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
    protected ArrayList<Spot> possibleMoves(Board board)
    {
        KingMoves.clear();
        for ( int i = -1 ; i < 2 ; i++) {
            for (int j = -1; j < 2; j++) {
                int newX = getX() + i;
                int newY = getY() + j;
                if (i == 0 && j == 0)
                    continue;
                Spot spot = board.getSpot(newX, newY);
                if (board.isValidPosition(newX, newY)) {
                    if (spot.getPiece() != null) {
                        if (spot.getPiece().getColor() == this.getColor())
                            continue;
                        KingMoves.add(board.getSpot(newX, newY));
                    } else
                        KingMoves.add(board.getSpot(newX, newY));
                }

            }
        }
        return KingMoves;
    }
    }
    
    
    

