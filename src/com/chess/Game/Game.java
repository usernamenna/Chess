package com.chess.Game;

import javax.swing.*;
import java.awt.*;
import com.chess.Pieces.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class Game extends JFrame implements ActionListener {
    int prex =-1, prey=-1;
    Piece piece;
    ArrayList <Spot> preposs;
    
    
    Board board = new Board();
    Player WhitePlayer = new Player(1);
    Player BlackPlayer = new Player(0);
    int CurrentPlayerColor =1;
    
    
    ArrayList <Piece> BlackPieces = new ArrayList<Piece>(0); 
    ArrayList <Piece> WhitePieces = new ArrayList<Piece>(1); 
    
    King black_king ;
    King white_king ;
   
    
    public Game()
    {   
        super();
        setTitle("Chess");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLocation(380, 50);
        setLayout(new GridLayout(8,8, 0, 0));
      // validate();   
    }
 
    // setting up pieces
    public void Setup ()
    {
    // setting up BLACK PIECES 
         for(int i = 0 ; i < 2 ; i++)
        {
            for(int j = 0 ; j < 8 ; j++)
            {
                if (i ==0)
                {
                    switch (j) {
                        case 0:
                        case 7:
                            Piece rook = new Rook(i,j,0);
                            board.getSpot(i, j).insertPiece(rook);
                            BlackPieces.add(rook);
                            break;
                        case 1:
                        case 6:
                            Piece knight = new Knight(i,j,0);
                            board.getSpot(i, j).insertPiece(knight);
                            BlackPieces.add(knight);
                            break;
                        case 2:
                        case 5:
                            Piece bishop = new Bishop(i,j,0);
                            board.getSpot(i, j).insertPiece(bishop);
                            BlackPieces.add(bishop);
                            break;
                        case 3:
                            Piece king = new King(i,j,0);
                            board.getSpot(i, j).insertPiece(king);
                            BlackPieces.add(king);
                            black_king = (King) king;
                            break;
                        case 4:
                            Piece queen = new Queen(i,j,0);
                            board.getSpot(i, j).insertPiece(queen);
                            BlackPieces.add(queen);
                            break;
                        default:
                            break;
                    }
                   
                }
                else if ( i == 1)
                {
                    Piece pawn = new Pawn(i,j,0);
                    board.getSpot(i, j).insertPiece(pawn);
                    BlackPieces.add(pawn);
                }
            }
        }
        
    // setting up WHITE PIECES 
        for(int i = 7 ; i >=6 ; i--)
        {
            for(int j = 0 ; j < 8 ; j++)
            {
                if (i ==7)
                {
                    switch (j) {
                        case 0:
                        case 7:
                            Piece rook = new Rook(i,j,1);
                            board.getSpot(i, j).insertPiece(rook);
                            WhitePieces.add(rook);
                            break;
                        case 1:
                        case 6:
                            Piece knight = new Knight(i,j,1);
                            board.getSpot(i, j).insertPiece(knight);
                            WhitePieces.add(knight);
                            break;
                        case 2:
                        case 5:
                            Piece bishop = new Bishop(i,j,1);
                            board.getSpot(i, j).insertPiece(bishop);
                            WhitePieces.add(bishop);
                            break;
                        case 3:
                            Piece king = new King(i,j,1);
                            board.getSpot(i, j).insertPiece(king);
                            WhitePieces.add(king);
                            white_king = (King) king;
                            break;
                        case 4:
                            Piece queen = new Queen(i,j,1);
                            board.getSpot(i, j).insertPiece(queen);
                            WhitePieces.add(queen);
                            break;
                        default:
                            break;
                    }
                   
                }
                else if ( i == 6)
                {
                    Piece pawn = new Pawn(i,j,1);
                    board.getSpot(i, j).insertPiece(pawn);
                    WhitePieces.add(pawn);
                }
            }
        }
      
       
        
    }
   
    
    public void addspots ()
    {
        // adding spots 
        for(int i = 0 ; i < 8 ; i++)
        {
            for(int j = 0 ; j < 8 ; j++)
            {
              Spot spot = board.getSpot(i, j);
              add(spot);
            }
        }
        setLayout(new GridLayout(8,8, 0, 0));
        doLayout();
       
         //  adding action listener
          for(int i = 0 ; i < 8 ; i++)
        {
            for(int j = 0 ; j < 8 ; j++)
            {
               board.getSpot(i, j).addActionListener(this);
               board.getSpot(i, j).setdefaultborder(board.getSpot(i, j).getBorder());
            }
        }
    }
     
    public void SwitchPlayer ( int color)
    {
        if ( color == WhitePlayer.getcolor())
        {
            CurrentPlayerColor= BlackPlayer.getcolor();
        }
        else if ( color == BlackPlayer.getcolor())
        {
            CurrentPlayerColor= WhitePlayer.getcolor();
        }
    }
    
    public boolean isKingCheck(int color){
		boolean result = false;
		
		ArrayList<Piece> piecesList;
		King kingInQuestion;
		
		if (CurrentPlayerColor ==1){
			piecesList = WhitePieces;
			kingInQuestion = black_king;
		} else {
			piecesList = BlackPieces;
			kingInQuestion = white_king;
		}
		
		int x_pos_King = kingInQuestion.getX();
		int y_pos_King = kingInQuestion.getY();
		
		for (Piece currentPiece : piecesList){
			ArrayList<Spot> spots = currentPiece.possibleMoves(board);
                        for(int i=0; i<spots.size();i++)
                        {
                            if((spots.get(i).getX() == x_pos_King) && (spots.get(i).getY() == y_pos_King))
                            {
                                result = true;
                                break;
                            }
                        }
		}
		
		return result;
	}
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
           Object source = ae.getSource();
          
           if (source instanceof Spot)
           {
            Spot button = (Spot)source;
            Border border = new LineBorder(Color.black,4);
           
            
            // this function is related to pawn promotion
           if ((button.getdefaultborder() == button.getBorder()  && button.isEmpty() == false)&&(button.getPiece().getPieceName() == "Pawn") && (button.getPiece().getX()== 0 || button.getPiece().getX()== 7 ) )
            {
               PawnPromotion window = new PawnPromotion(board,button.getX(), button.getY(),button.getPiece().getColor());
            }
           // to check the border of the clicked button if it is normal Spot or a possible move Spot
           else if (button.getdefaultborder() == button.getBorder()  && button.isEmpty() == false)
            {
                // to check if the current player color is the same color of the selected piece
                if ( CurrentPlayerColor == button.getPiece().getColor() )
                {
                    //to check if there were a clicked spot before AND it has its possible moves spots Bordered
                    if ( prex != -1 && prey !=-1)
                    {
                     preposs.forEach((i) -> {i.setBorder(button.getdefaultborder());}); 
                    }
                    
                  
            // getting possible moves of the spot 
            ArrayList<Spot> pet = button.getPiece().possibleMoves(board);
            pet.forEach((i) -> { i.setBorder(border);});
            
            prex = button.getX();
            prey = button.getY();
            preposs = pet; 
  
                }
            }
          else if (  button.getdefaultborder() == button.getBorder() && button.isEmpty() == true)
          {
              if ( prex != -1 && prey !=-1)
                    {
                     preposs.forEach((i) -> {i.setBorder(button.getdefaultborder());}); 
                    }
            prex =-1;
            prey =-1;
          }
            else if ( button.getdefaultborder() != button.getBorder() )
            {
            board.getSpot(prex, prey).getPiece().move(board.getSpot(prex, prey), button);
            preposs.forEach((i) -> {i.setBorder(button.getdefaultborder());});
            prex =-1;
            prey =-1;
             if (isKingCheck(CurrentPlayerColor))
                    {
                     KingCheck window = new KingCheck(); 
                    }
            
            SwitchPlayer(CurrentPlayerColor);
            }
         
            
           }
           
    }

   
    
}