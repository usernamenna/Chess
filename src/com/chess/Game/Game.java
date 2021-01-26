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
    int prex, prey;
    Piece piece;
    ArrayList <Spot> preposs;
    
    Board board = new Board();
    Player WhitePlayer = new Player(1);
    Player BlackPlayer = new Player(0);
    int CurrentPlayerColor =1;
    
    public Game()
    {   
        super();
        setTitle("Chess");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridLayout(8,8, 0, 0));
        doLayout();
        setVisible(true);
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
                            break;
                        case 1:
                        case 6:
                            Piece knight = new Knight(i,j,0);
                            board.getSpot(i, j).insertPiece(knight);
                            break;
                        case 2:
                        case 5:
                            Piece bishop = new Bishop(i,j,0);
                            board.getSpot(i, j).insertPiece(bishop);
                            break;
                        case 3:
                            Piece king = new King(i,j,0);
                            board.getSpot(i, j).insertPiece(king);
                            break;
                        case 4:
                            Piece queen = new Queen(i,j,0);
                            board.getSpot(i, j).insertPiece(queen);
                            break;
                        default:
                            break;
                    }
                   
                }
                else if ( i == 1)
                {
                    Piece pawn = new Pawn(i,j,0);
                    board.getSpot(i, j).insertPiece(pawn);
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
                            break;
                        case 1:
                        case 6:
                            Piece knight = new Knight(i,j,1);
                            board.getSpot(i, j).insertPiece(knight);
                            break;
                        case 2:
                        case 5:
                            Piece bishop = new Bishop(i,j,1);
                            board.getSpot(i, j).insertPiece(bishop);
                            break;
                        case 3:
                            Piece king = new King(i,j,1);
                            board.getSpot(i, j).insertPiece(king);
                            break;
                        case 4:
                            Piece queen = new Queen(i,j,1);
                            board.getSpot(i, j).insertPiece(queen);
                            break;
                        default:
                            break;
                    }
                   
                }
                else if ( i == 6)
                {
                    Piece pawn = new Pawn(i,j,1);
                    board.getSpot(i, j).insertPiece(pawn);
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
    @Override
    public void actionPerformed(ActionEvent ae) {
        
           Object source = ae.getSource();
          
           if (source instanceof Spot)
           {
            Spot button = (Spot)source;
            Border border = new LineBorder(Color.black,4);
            
            
            if (  button.getdefaultborder() == button.getBorder()  && button.isEmpty() == false)
            {
                if ( CurrentPlayerColor == button.getPiece().getColor() )
                {
            ArrayList<Spot> pet = button.getPiece().possibleMoves(board);
            pet.forEach((Spot i) -> { i.setBorder(border);});
            
            prex = button.getX();
            prey = button.getY();
            preposs = pet;
            SwitchPlayer(CurrentPlayerColor);
                }
            }
         
            else if (   button.getdefaultborder() != button.getBorder() )
            {
              board.getSpot(prex, prey).getPiece().move(board.getSpot(prex, prey), button);
              preposs.forEach((i) -> {i.setBorder(button.getdefaultborder());});

            }
            
           }
           
    }
    
}