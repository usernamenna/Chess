package com.chess.Game;

import com.chess.Pieces.Piece;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;


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
      // setOpaque(true);
       setVisible(true);
       //repaint();
      // revalidate();
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
    public void setdefaultborder( Border border)
    {
        defaultborder = border;
    }
    public Border getdefaultborder()
    {
        return defaultborder;
    }
    
    public void insertPiece(Piece piece)
    {
        String path = "null"; 
        if (piece.getColor() == 0)
        {
        path = piece.getBlackPath();
        }
        else if (piece.getColor() ==1)
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
    }
    public void removePiece()
    {    
        this.setIcon(null);
        empty = true;
        piece = null;
       
    }
    public Piece getPiece()
    {
        return piece;
    }

}
