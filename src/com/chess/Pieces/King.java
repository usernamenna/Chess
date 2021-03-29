package com.chess.Pieces;

import com.chess.Game.Board;
import com.chess.Game.Spot;
import com.chess.Game.Game;
import java.util.ArrayList;

public class King extends Piece {
    
    ArrayList<Spot> KingMoves = new ArrayList<>();
    boolean [] CCheck = { false, false };
     public King(int color)
   {
       super(color ); 
        super.BlackPath ="src/com/chess/Pieces/png/king.png";
        super.WhitePath ="src/com/chess/Pieces/png/kingw.png";
        super.PieceName = "King";
   }
    public King( int xpos , int ypos , int color)
   {
        super(xpos, ypos,color ); 
        super.BlackPath ="src/com/chess/Pieces/png/king.png";
        super.WhitePath ="src/com/chess/Pieces/png/kingw.png";
        super.PieceName= "King";
   }
  
    @Override
    public ArrayList<Spot> possibleMoves(Board board) {
        KingMoves.clear();
        for ( int i = -1 ; i < 2 ; i++) {
            for (int j = -1; j < 2; j++) {
                int newx = getX() + i;
                int newy = getY() + j;
                if (i == 0 && j == 0)
                    continue;
          
                if (board.isValidPosition(newx, newy)) {
                          Spot spot = board.getSpot(newx, newy);
                    if (spot.isEmpty() == false) {
                        if (spot.getPiece().getColor() == this.getColor())
                            continue;
                        KingMoves.add(board.getSpot(newx, newy));
                    } else
                        KingMoves.add(board.getSpot(newx, newy));
                }

            }
        }
        Castling(board);
        if (CCheck[0])
            KingMoves.add(board.getSpot(getX(), getY()+2));
        if (CCheck[1])
            KingMoves.add(board.getSpot(getX(), getY()-2));
        CCheck[0] = false;
        CCheck[1] = false;
        return KingMoves;
    }

public boolean AvliableSpot(int cy , Board board )
{
    for ( int i =0; i < 8; i++)
    {
        for (int j = 0; j < 8; j++)
        {
            if ( board.getSpot(i, j).isEmpty() == false)
            {
                if (board.getSpot(i, j).getPiece().getColor() != this.getColor())
                {
                    if ( board.getSpot(i, j).getPiece().possibleMoves(board).contains(board.getSpot(getX(), cy)))
                        return false;
                    else
                        return true;
                }
            }
        }
    }
    return false;
}
public void Castling(Board board)
{
    if ( getColor() == 1 )
    {
       int CY11 = getY() + 4;
       int CY12 = getY() - 3;
       if (CY11 >=0 && CY11 <= 7 && CY12 >= 0 && CY12 <= 7)
       {
           if (board.getSpot(getX(), CY11).getPiece().getPieceName() == "Rook" )
           {
               if (this.isFirstMove() == true && board.getSpot(getX(), CY11).getPiece().isFirstMove() == true )
               {
                   if (board.getSpot(getX(), getY()+1).isEmpty()&& board.getSpot(getX(), getY()+2).isEmpty() && board.getSpot(getX(), getY()+3).isEmpty())
                   {
                       if ( AvliableSpot(getY()+3,board) && AvliableSpot(getY()+2,board) && AvliableSpot(getY()+1,board) )
                       {
                           CCheck [0] = true;
                       }
                   }
               }
           }
           if ("Rook".equals(board.getSpot(getX(), CY12).getPiece().getPieceName()))
           {
               if (this.isFirstMove() == true && board.getSpot(getX(), CY12).getPiece().isFirstMove() == true )
               {
                    if (board.getSpot(getX(), getY()-1).isEmpty()&& board.getSpot(getX(), getY()-2).isEmpty() )
                   {
                       if (AvliableSpot(getY()-2,board) && AvliableSpot(getY()-1,board) )
                       {
                           CCheck[1] = true;
                       }
                   }
               }
           }
    }
}
    else if ( getColor() == 0 )
    {
       int CY21 = getY() - 3;
       int CY22 = getY() + 4;
       if (CY21 >=0 && CY21 <= 7 && CY22 >= 0 && CY22 <= 7)
       {
       if (board.getSpot(getX(), CY21).getPiece().getPieceName() == "Rook" )
       {
           if (this.isFirstMove() == true && board.getSpot(getX(), CY21).getPiece().isFirstMove() == true )
           {
                if (board.getSpot(getX(), getY()-1).isEmpty()&& board.getSpot(getX(), getY()-2).isEmpty() )
               {
                   if (AvliableSpot(getY()-2,board) && AvliableSpot(getY()-1,board) )
                   {
                       CCheck[1] = true;
                   }
                   
               }
           }
       }
       if (board.getSpot(getX(), CY22).getPiece().getPieceName() == "Rook")
       {
           if (this.isFirstMove() == true && board.getSpot(getX(), CY22).getPiece().isFirstMove() == true )
           {
               if (board.getSpot(getX(), getY()+1).isEmpty()&& board.getSpot(getX(), getY()+2).isEmpty() && board.getSpot(getX(), getY()+3).isEmpty())
               {
                   if ( AvliableSpot(getY()+3,board) && AvliableSpot(getY()+2,board) && AvliableSpot(getY()+1,board) )
                   {
                       CCheck[0] = true;
                   }
                   
               }
           }
       }
       }
    }
}
    }
    
    
    

