package demo.other;

import java.awt.*;
import javax.swing.*;
 
class BorderLayoutTest extends JFrame
{
    public BorderLayoutTest()
    {
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(new JButton("North"), BorderLayout.NORTH);
        getContentPane().add(new JButton("South"), BorderLayout.SOUTH);
        getContentPane().add(new JButton("West"), BorderLayout.WEST);
        getContentPane().add(new JButton("East"), BorderLayout.EAST);
        getContentPane().add(new JButton("Center"), BorderLayout.CENTER);
 
        setBounds(100,100,400,300);
    }
 
    public static void main(String[] args)
    {
        BorderLayoutTest flt = new BorderLayoutTest();
        flt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flt.setVisible(true);
    }
}