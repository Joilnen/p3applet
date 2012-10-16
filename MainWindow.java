import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;


public class MainWindow extends JPanel implements MouseListener, MouseMotionListener {

    int x = 0, y = 0;

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.BLUE);
        g2d.drawLine(0, 0, 500, 500);
        g2d.drawRect(x, y, 100, 100);
        g2d.drawString("To tentando usar java", 100, 100);
    }

    public void mouseClicked(MouseEvent e) {  }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) {  }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }

    public void mouseDragged(MouseEvent e) { }
    public void mouseMoved(MouseEvent e) { x = e.getX() - 100; y = e.getY() - 20; repaint(); } 
}

