package demo.skippy;

import java.awt.*;
import javax.swing.*;

/**
 * ComponentOrientationTest
 * http://www.skipy.ru/technics/layouts.html
 * @author Eugene Matyushkin
 */
public class ComponentOrientationTest extends JFrame {

    private final static int WIDTH = 410;
    private final static int HEIGHT = 220;

    public ComponentOrientationTest(boolean orientation, boolean useOrientation) {
        super("Component orientation test – RTL=" + orientation + ";use=" + useOrientation);
        JPanel content = new JPanel(new BorderLayout(5, 5));
        content.add(createLabel("Top"), (useOrientation) ? BorderLayout.PAGE_START : BorderLayout.NORTH);
        content.add(createLabel("Bottom"), (useOrientation) ? BorderLayout.PAGE_END : BorderLayout.SOUTH);
        content.add(createLabel("Left"), (useOrientation) ? BorderLayout.LINE_START : BorderLayout.WEST);
        content.add(createLabel("Right"), (useOrientation) ? BorderLayout.LINE_END : BorderLayout.EAST);
        content.add(createLabel("Center"), BorderLayout.CENTER);
        if (orientation) {
            content.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        setContentPane(content);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JLabel createLabel(String caption) {
        JLabel lbl = new JLabel(caption);
        lbl.setPreferredSize(new Dimension(100, 50));
        lbl.setHorizontalAlignment(JLabel.CENTER);
        lbl.setBorder(BorderFactory.createLineBorder(new Color(0xff8000), 3));
        return lbl;
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        ComponentOrientationTest cot = new ComponentOrientationTest(false, false);
        cot.setLocation(size.width/2-WIDTH, size.height/2-HEIGHT);
        cot.setVisible(true);
        cot = new ComponentOrientationTest(false, true);
        cot.setLocation(size.width/2-WIDTH, size.height/2);
        cot.setVisible(true);
        cot = new ComponentOrientationTest(true, false);
        cot.setLocation(size.width/2, size.height/2-HEIGHT);
        cot.setVisible(true);
        cot = new ComponentOrientationTest(true, true);
        cot.setLocation(size.width/2, size.height/2);
        cot.setVisible(true);
    }
}