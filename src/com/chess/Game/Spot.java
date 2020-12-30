package com.chess.Game;

import com.chess.Pieces.Piece;

import javax.swing.*;

public class Spot extends JButton {
    private final int x;
    private final int y;
    private boolean empty;
    private Piece piece;

    public Spot(final int x, final int y)
    {
        super();
        this.x = x;
        this.y = y;
        //setEnabled(false);
        setVisible(true);
        if((x+y)%2==0)
        {
            setBackground(new java.awt.Color(145, 63, 45));
        }
        else
        {
            setBackground(new java.awt.Color(255,255,220));
        }
        setOpaque(true);
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
    public void insertPiece(Piece piece)
    {
        empty = false;
        this.piece = piece;
        setEnabled(true);
    }
    public void removePiece()
    {
        empty = true;
        piece = null;
        setEnabled(false);
    }
    public Piece getPiece()
    {
        return piece;
    }
}
