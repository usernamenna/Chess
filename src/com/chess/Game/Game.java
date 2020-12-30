package com.chess.Game;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    Board board = new Board();
    Game()
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
                spot.revalidate();
                spot.repaint();
            }
        }
        setLayout(new GridLayout(8,8, 0, 0));
        setVisible(true);
    }
    public static void main(String[] args)
    {
        Game game = new Game();
    }
}
