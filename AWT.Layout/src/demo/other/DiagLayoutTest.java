package demo.other;
import java.awt.*;
import javax.swing.*;
 
class DiagLayoutTest extends JFrame
{
    public DiagLayoutTest()
    {
        getContentPane().setLayout(new DiagLayout());
        for(int k=0; k<5; k++) {
          getContentPane().add(new JButton(""+k));
        }
        for(int k=0; k<5; k++) {
          getContentPane().add(new JLabel(""+k, JLabel.CENTER));
        }
 
        setBounds(100,100,600,400);
    }
 
    public static void main(String[] args)
    {
        DiagLayoutTest flt = new DiagLayoutTest();
        flt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flt.setVisible(true);
    }
}