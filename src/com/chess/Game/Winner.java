package com.chess.Game;

import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
// import javax.swing.SwingConstants;


public class Winner extends JFrame   {

    JLabel label;

    public Winner(int color)
    {
        super();
        if(color == 0)
        {
            label = new JLabel("<Black Wins>", JLabel.CENTER);
        }
        else
        {
            label = new JLabel("<White Wins>", JLabel.CENTER);
        }
        setSize(600, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLocation(380, 250);

        getContentPane().setBackground(new java.awt.Color(249, 235, 223));
        Component add = add(label);
        label.setFont(new java.awt.Font("No Virus", 0, 90));
        label.setAlignmentX(0);
        label.setAlignmentY(0);
        //label.setBounds(175, 10, 300, 40);


    }

}
