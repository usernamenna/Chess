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

 public ArrayList<Spot> possibleMoves(Board board)
 {
     moves.clear();
    Spot f = new Spot( 2, 4) ;
    Spot  s= new Spot(3, 5) ;
    Spot t = new Spot(4, 6) ;
     moves.add(f);
     moves.add(s);
     moves.add(t);
     return moves;
 }
    // TODO Fix this
//    private boolean possibleMoves(Board board)
//    {
//        int xPosition = this.getX();
//        int yPosition = this.getY();
//        
//        int one_step;
//        int two_step;
//
//        if (this.getColor() == black){
//            one_step = 1;
//            two_step = 2;
//        }
//        else{
//            one_step = -1;
//            two_step = -2;
//        }
//
//        // Moving one step forward
//        if (xPosition - this.getX() == one_step )
//        {
//            // Straight
//            if (yPosition == this.getY()&&location == null )
//            {
//                return true;
//            }
//            // Diagonal
//            if (Math.abs(this.getY() - yPosition) == 1&&location != null )
//            {
//                return true;
//            }
//        }
//        // Two spaces
//        else if (false)
//        {
//            if (xPosition - this.getX() == two_step)
//            {
//                if (yPosition == this.getY()&& location == null)
//                {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}