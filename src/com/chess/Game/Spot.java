package com.chess.Game;

import com.chess.Pieces.Piece;


import javax.swing.*;
import java.awt.*;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class Spot extends JButton {

    private final int x;
    private final int y;
    private boolean empty = true;
    private Piece piece = null;
    private Border defaultborder;

    public Spot ()
    {
        super();
       this.x = 0;
       this.y = 0; 
    }

    public Spot(final int x, final int y)
    {
        super();
        this.x = x;
        this.y = y;
        
        if((x+y)%2==0)
        {
            setBackground(new java.awt.Color(203, 228, 249));
        }
        else
        {
            setBackground(new java.awt.Color(249, 235, 223));
        }
   
       setVisible(true);
      
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public boolean isEmpty()
    {
        return empty;
    }
    
    // those functions are related to GUI handling
    public void setdefaultborder( Border border)
    {
        defaultborder = border;
    }
    public Border getdefaultborder()
    {
        return defaultborder;
    }
    
    // piece insertion in GUI
    public void insertPiece(Piece piece)
    {
        String path = null;
        if (piece.getColor() == 0)
        {
            path = piece.getBlackPath();
        }
        else if (piece.getColor() == 1)
        {
            path = piece.getWhitePath();
        }
        ImageIcon icon = new ImageIcon(path);
        Image bf = icon.getImage();
        Image af = bf.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(af);
        this.setIcon(icon);
        empty = false;
        this.piece = piece;
        piece.setX(this.x);
        piece.setY(this.y);
    }
    public void removePiece()
    {    
        piece.setX(-1);
        piece.setY(-1);
        this.setIcon(null);
        empty = true;
        piece = null;
    }
    public Piece getPiece()
    {
        return piece;
    }

}
