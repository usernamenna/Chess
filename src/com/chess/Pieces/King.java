package com.chess.Pieces;

import com.chess.Game.Board;
import com.chess.Game.Spot;
import java.util.ArrayList;

public class King extends Piece {
    
    ArrayList<Spot> KingMoves = new ArrayList<>();
    
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
        super.PieceName= "king";
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

   /* public ArrayList<Spot> Castling(Board board)
    {
        //-2, +3
        boolean c1 = true;
        boolean c2 = true;
        ArrayList<Spot>spots = new ArrayList<>();
        if(!board.getSpot(getX(),getY()-3).isEmpty())
        {
            Piece piece = board.getSpot(getX(), getY()-3).getPiece();
            if(piece.getColor()==getColor() && piece.getPieceName().equals("Rook") && piece.isFirstMove())
            {
                for(int i=1;i<3;i++)
                {
                    if(inCheck(board.getSpot(getX(),getY()-i), board))
                        c1 = false;
                }
            }
        }
        if(!board.getSpot(getX(),getY()+4).isEmpty())
        {
            Piece piece = board.getSpot(getX(), getY()+4).getPiece();
            if(piece.getColor()==getColor() && piece.getPieceName().equals("Rook") && piece.isFirstMove())
            {
                for(int i=1;i<4;i++)
                {
                    if(inCheck(board.getSpot(getX(),getY()+i), board))
                        c2 = false;
                }
            }
        }
        if(c1)
            spots.add(board.getSpot(getX(),getY()-2));
        if(c2)
            spots.add(board.getSpot(getX(),getY()+2));
        return spots;
    }
    private boolean inCheck(Spot spot,Board board)
    {
        ArrayList<Piece>oppColor = new ArrayList<>();
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                if(!board.getSpot(i,j).isEmpty())
                {
                    Piece piece = board.getSpot(i,j).getPiece();
                    if(piece.getColor()!=getColor())
                    {
                        oppColor.add(piece);
                    }
                }
            }
        }
        for(Piece piece: oppColor)
        {
            ArrayList<Spot>spots = piece.possibleMoves(board);
            for(Spot s: spots)
                if(s.getX() == spot.getX() && s.getY() == spot.getY())
                    return true;
        }
        return false;
    }


    */
}
    
    
    

