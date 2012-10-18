import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

//! Classe da janela canvas onde sao desenhados os objetos graficos
public class MainWindow extends JPanel implements MouseListener, MouseMotionListener {

    int x = 0, y = 0;

    int withMousePointer;

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.LIGHT_GRAY);
        // g2d.drawLine(0, 0, 500, 500);
        if(withMousePointer == WithMousePointerType.PROCESS_GRAY_BORDER) {
            g2d.drawRoundRect(x, y, 150, 100, 15, 15);
        }
        else if(withMousePointer == WithMousePointerType.DECISION_GRAY_BORDER) {
            int[] x_l = {x + 0, x + 50, x + 100, x + 50};
            int[] y_l = {y + 50, y + 0, y + 50, y + 100}; 
            g2d.drawPolygon( x_l, y_l, 4);
        }
        // g2d.drawString("To tentando usar java", 100, 100);
        // new GraphicElement();
        // NodePool n = NodePool.getInstance();
    }

    public void mouseClicked(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseMoved(MouseEvent e) { x = e.getX(); y = e.getY(); repaint(); } 
    public void mouseDragged(MouseEvent e) { }

    public void setWithMousePointer(int t) {
        withMousePointer = t;

        /*** Pra mudar ponteiro do mouse
        if(t == WithMousePointerType.PROCESS_GRAY_BORDER || t == WithMousePointerType.DECISION_GRAY_BORDER)
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        else
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ***/
        x = y = 0;
    }
}

//! Tipo de desenho feio quando for fazer algum desses no canvas
class WithMousePointerType {
    static int NONE = 1000;
    static int PROCESS_GRAY_BORDER = 1001;
    static int CONNECT_ONE_TO_ONE = 1002;
    static int WRITE_MENS = 1003;
    static int DECISION_GRAY_BORDER = 1004;
    static int WRITE_LABEL = 1005;
}


