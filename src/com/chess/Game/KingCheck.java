
package com.chess.Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.*;
import static javax.swing.text.html.CSS.Attribute.FONT_FAMILY;

public class KingCheck extends JFrame{
    
    JPanel p = new JPanel();
    JLabel label = new JLabel("King Check !");
    
    
    
    public KingCheck ()
    {
         super();
        setTitle("King check");
        setSize(600, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLocation(380, 250);
        
        p.setBackground(new java.awt.Color(249, 235, 223));
        add(p); p.setLayout(null);
        
        label.setFont(new java.awt.Font("Cooper Black", 0, 50));
        label.setForeground(new java.awt.Color(51, 0, 25));
        label.setBounds(140, 10,600,100);
        //label.setFont(Font.font(FONT_FAMILY, FontWeight.BOLD, 12));
         p.add(label);
    }
    
    
}
