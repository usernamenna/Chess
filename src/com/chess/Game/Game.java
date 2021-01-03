package com.chess.Game;

import javax.swing.*;
import java.awt.*;
import com.chess.Pieces.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Game extends JFrame implements ActionListener {
    Board board = new Board();
    public Game()
    {
        super();
        setTitle("Chess");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        for(int i = 0 ; i < 8 ; i++)
        {
            for(int j = 0 ; j < 8 ; j++)
            {
              Spot spot = board.getSpot(i, j);
              add(spot);
              spot.getVisibleRect();
              spot.invalidate();
            }
        }
        Setup();
        setLayout(new GridLayout(8,8, 0, 0));
        doLayout();
        setVisible(true);
        validate(); 
    }
    
    // setting up pieces
    public void Setup ()
    {
        
         for(int i = 0 ; i < 2 ; i++)
        {
            for(int j = 0 ; j < 8 ; j++)
            {
                if (i ==0)
                {
                    if ( j == 0 || j ==7 )
                    {
                        Piece rook = new Rook(i,j,0);
                        board.getSpot(i, j).insertPiece(rook);
                    }
                    else if ( j == 1 || j ==6 )
                    {
                        Piece knight = new Knight(i,j,0);
                        board.getSpot(i, j).insertPiece(knight);
                    }
                    else if ( j == 2 || j == 5)
                    {
                        Piece bishop = new Bishop(i,j,0);
                        board.getSpot(i, j).insertPiece(bishop);
                    }
                    else if ( j == 3)
                    {
                        Piece king = new King(i,j,0);
                        board.getSpot(i, j).insertPiece(king);
                    }
                    else if ( j == 4)
                    {
                        Piece queen = new Queen(i,j,0);
                        board.getSpot(i, j).insertPiece(queen);
                    }
                   
                }
                else if ( i == 1)
                {
                    Piece pawn = new Pawn(i,j,0);
                    board.getSpot(i, j).insertPiece(pawn);
                }
            }
        }
        
        
        for(int i = 7 ; i >=6 ; i--)
        {
            for(int j = 0 ; j < 8 ; j++)
            {
                if (i ==7)
                {
                    if ( j == 0 || j ==7 )
                    {
                        Piece rook = new Rook(i,j,1);
                        board.getSpot(i, j).insertPiece(rook);
                    }
                    else if ( j == 1 || j ==6 )
                    {
                        Piece knight = new Knight(i,j,1);
                        board.getSpot(i, j).insertPiece(knight);
                    }
                    else if ( j == 2 || j == 5)
                    {
                        Piece bishop = new Bishop(i,j,1);
                        board.getSpot(i, j).insertPiece(bishop);
                    }
                    else if ( j == 3)
                    {
                        Piece king = new King(i,j,1);
                        board.getSpot(i, j).insertPiece(king);
                    }
                    else if ( j == 4)
                    {
                        Piece queen = new Queen(i,j,1);
                        board.getSpot(i, j).insertPiece(queen);
                    }
                   
                }
                else if ( i == 6)
                {
                    Piece pawn = new Pawn(i,j,1);
                    board.getSpot(i, j).insertPiece(pawn);
                }
            }
        }
        
        //  adding mouse listener
          for(int i = 0 ; i < 8 ; i++)
        {
            for(int j = 0 ; j < 8 ; j++)
            {
               board.getSpot(i, j).addActionListener(this);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
            Object source = ae.getSource();
           
           if (source instanceof Spot) {
                Spot button = (Spot)source;
              //  button.setBackground(Color.yellow);
           if(!button.isEmpty())
           {
               ArrayList<Spot>pet = button.getPiece().possibleMoves(board);
               
               for(Spot i : pet)
               {
                   i.setBackground(Color.yellow);
               }
           }
           }  
//                button.getPiece();

             // System.out.println(pet.get(0));
           
//
//        for (int i = 0 ; i < pet.lastIndexOf(pet); i++)
//           {
//                pet.get(i).setBackground(Color.yellow);
//           }
           
    }
}