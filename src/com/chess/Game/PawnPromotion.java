
package com.chess.Game;


import com.chess.Pieces.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.*;


public class PawnPromotion extends JFrame implements ActionListener {
    JButton[] button = new JButton[4];
    Piece[] piece = new Piece[4];

    JPanel p = new JPanel();
    JLabel label = new JLabel("Choose a Piece ");
    Board board2;
    int selectedX ,selectedY;

    public PawnPromotion(Board board ,int X, int Y , int color)
    {
        super();
        board2 = board;
        selectedX = X;
        selectedY = Y;
        setTitle("Pawn Promotion");
        setSize(600, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLocation(380, 250);

        addelemnts();
        AddPieces ( color);
    }
    public void addelemnts(){
        // setting up label
        label.setFont(new java.awt.Font("Cooper Black", 0, 30));
        label.setForeground(new java.awt.Color(51, 0, 25));
        label.setBounds(175, 10, 300, 40);

        // setting up buttons
        for (int i=0; i < 4; i++)
        {
            button[i] = new JButton();
            button[i].setBackground(new java.awt.Color(203, 228, 249));
            button[i].addActionListener(this);
        }

        button[0].setBounds(70,65, 80, 80);
        button[1].setBounds(190,65, 80, 80);
        button[2].setBounds(310,65, 80, 80);
        button[3].setBounds(430,65, 80, 80);



        // adjusting the panel color , layout and adding it to frame (153, 51, 255)
        p.setBackground(new java.awt.Color(249, 235, 223));
        add(p); p.setLayout(null);

        // adding label & buttons
        p.add(label);
        for (int i=0 ; i <4 ; i++)
        {
            p.add(button[i]);
        }
    }


    public void AddPieces (int color)
    {
        String path = "null";


        piece[0] = new Rook(color);
        piece[1] = new Bishop(color);
        piece[2] = new Knight(color);
        piece[3] = new Queen(color);


        for ( int i=0 ; i < 4; i++){
            if (color == 0)
            {
                path = piece[i].getBlackPath();
            }
            else if (color ==1)
            {
                path = piece[i].getWhitePath();
            }
            ImageIcon icon = new ImageIcon(path);
            Image bf = icon.getImage();
            Image af = bf.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(af);
            button[i].setIcon(icon);
        }

    }
    public void close(){

        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        for (int i=0 ; i<4; i++){
            if (ae.getSource() == button[i]){
                board2.getSpot(selectedX, selectedY).removePiece();
                board2.getSpot(selectedX, selectedY).insertPiece(piece[i]);
                board2.getSpot(selectedX, selectedY).getPiece().setX(selectedX);
                board2.getSpot(selectedX, selectedY).getPiece().setY(selectedY);
                close();
            }
        }
    }
}
