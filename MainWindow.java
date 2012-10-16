import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;

public class MainWindow extends JPanel {

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.BLUE);
        g2d.drawLine(0, 0, 500, 500);

        g2d.drawString("To tentando usar java", 100, 100);
    }
}

