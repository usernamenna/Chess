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
    ArrayList <Spot> preposs;

    Board board = new Board();
    Player WhitePlayer = new Player(1);
    Player BlackPlayer = new Player(0);
    int CurrentPlayerColor =1;


    Piece piece;
    int x, y;


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


    }



    // setting up pieces
    public void Setup ()
    {
        // setting up BLACK PIECES
        for(int i = 0 ; i < 2 ; i++)  //represent y-axis
        {
            for(int j = 0 ; j < 8 ; j++) //represnt x-axis
            {
                if (i ==0) //if y = 0
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
                            Piece queen = new Queen(i,j,0);
                            board.getSpot(i, j).insertPiece(queen);
                            break;
                        case 4:
                            Piece king = new King(i,j,0);
                            board.getSpot(i, j).insertPiece(king);
                            break;

                        default:
                            break;
                    }

                }
                else if ( i == 1) //if y = 1
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
                            Piece queen = new Queen(i,j,1);
                            board.getSpot(i, j).insertPiece(queen);
                            break;

                        case 4:
                            Piece king = new King(i,j,1);
                            board.getSpot(i, j).insertPiece(king);
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


    public boolean IsKingCheck(int color)
    {
        ArrayList<Spot> spot;
        boolean result = false;
        for(int i=0; i<8; i++)
        {
            for(int j = 0; j<8; j++)
            {
                if(board.getSpot(i, j).isEmpty() == false)
                {
                    if(board.getSpot(i, j).getPiece().getColor() != color)
                    {
                        spot = board.getSpot(i, j).getPiece().possibleMoves(board);
                        for(int x =0; x<spot.size(); x++)
                        {
                            if(spot.get(x).isEmpty() == false){
                                if(spot.get(x).getPiece().getPieceName().equals("King") && spot.get(x).getPiece().getColor() == color){

                                    result = true;

                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }


    public boolean canMove(int color)
    {
        int first_X_pos, first_Y_pos;
        Piece temp;
        ArrayList<Spot> possibleSpots;
        boolean result = false;

        for (int i=0; i<8; i++)
        {
            for(int j=0; j<8;j++)
            {
                if(board.getSpot(i, j).isEmpty() == false)
                {
                    if(board.getSpot(i, j).getPiece().getColor() == color)
                    {
                        possibleSpots = board.getSpot(i, j).getPiece().possibleMoves(board);
                        for(int k = 0; k < possibleSpots.size(); k++)
                        {
                            temp = possibleSpots.get(k).getPiece();
                            first_X_pos = board.getSpot(i, j).getPiece().getX();
                            first_Y_pos  = board.getSpot(i, j).getPiece().getY();
                            board.getSpot(i, j).getPiece().setX(possibleSpots.get(k).getX());
                            board.getSpot(i, j).getPiece().setY(possibleSpots.get(k).getY());

                            if(IsKingCheck(color))
                            {
                                board.getSpot(i, j).getPiece().setX(first_X_pos);
                                board.getSpot(i, j).getPiece().setY(first_Y_pos);
                                if(temp != null)
                                {
                                    temp.setX(possibleSpots.get(k).getX());
                                    temp.setY(possibleSpots.get(k).getY());
                                }

                            }

                            else
                            {
                                board.getSpot(i, j).getPiece().setX(first_X_pos);
                                board.getSpot(i, j).getPiece().setY(first_Y_pos);
                                if(temp != null)
                                {
                                    temp.setX(possibleSpots.get(k).getX());
                                    temp.setY(possibleSpots.get(k).getY());
                                }
                                result = true;
                            }
                        }

                    }
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
            Spot button = (Spot)source; // casting
            Border border = new LineBorder(Color.black,4);  // LineBorder(Color color, int thickness)
            //Creates a line border with the specified color and thickness.

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
                    pet.forEach((Spot i) -> { i.setBorder(border);});

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
            }
            else if ( button.getdefaultborder() != button.getBorder() )
            {


                board.getSpot(prex, prey).getPiece().move(board.getSpot(prex, prey), button);
                preposs.forEach((i) -> {i.setBorder(button.getdefaultborder());});
                prex =-1;
                prey =-1;

                SwitchPlayer(CurrentPlayerColor);
                //if(IsKingCheck(CurrentPlayerColor))
                //{
                //    System.exit(0);
                //}





            }


        }

    }



}