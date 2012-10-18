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

	int setaSense = 0;

    public void paint(Graphics g) {

        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;

        if(withMousePointer == WithMousePointerType.PROCESS_GRAY_BORDER) {
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.drawRoundRect(x, y, 150, 100, 15, 15);
        }
        else if(withMousePointer == WithMousePointerType.DECISION_GRAY_BORDER) {
            int[] x_l = {x + 0, x + 30, x + 60, x + 30};
            int[] y_l = {y + 30, y + 0, y + 30, y + 60}; 
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.drawPolygon( x_l, y_l, 4);
        }
		else if(withMousePointer == WithMousePointerType.CONNECT_ONE_TO_ONE && setaSense == 1) {
			g2d.setColor(Color.RED);
			g2d.drawLine(0, 0, 300, 300);
		}

        // g2d.drawString("To tentando usar java", 100, 100);
        // new GraphicElement();
        // NodePool n = NodePool.getInstance();
        // NodePool.getInstance().addNode(new GraphicElement(GraphicElementType.NODE_PROC));
        // Contador apenas pra debug
        // g2d.drawString(String.valueOf(NodePool.getInstance().getElements().size()), 300, 300);
        pintaObjeto(g2d);
    }

    public void mouseClicked(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mousePressed(MouseEvent e) { setaSense = 1; }
    public void mouseReleased(MouseEvent e) {
		if(setaSense == 1)
			setaSense = 2;
		else
			setaSense = 0;
	}

    public void mouseDragged(MouseEvent e) { }
    public void mouseMoved(MouseEvent e) { x = e.getX(); y = e.getY(); repaint(); } 

	public void setSetaSense() {
		setaSense = 1;
	}

	public void resetSetaSense() {
		if(setaSense == 1)
			setaSense = 2;
		else
			setaSense = 0;
	}

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

    void addEntity(GraphicElement ge) {
        ge.setX(x);
        ge.setY(y);
        NodePool.getInstance().addNode(ge);
    }

    void pintaObjeto(Graphics2D g2d) {

        for(GraphicElement ge: NodePool.getInstance().getElements()) {

            if(ge.getType() == GraphicElementType.NODE_PROC) {
                  // Descomentar para ter borda
                  // g2d.setColor(Color.BLACK);
                  g2d.setColor(Color.decode("0xF0C3FF"));
                  g2d.fillRoundRect(ge.getX(), ge.getY(), 150, 100, 15, 15); 
                  // g2d.fillRoundRect(ge.getX()+1, ge.getY()+1, 150 - 1, 100 - 1, 15, 15); 
            }
            else if(ge.getType() == GraphicElementType.NODE_DECI) {
                  int aqui_x = ge.getX(), aqui_y = ge.getY();
                  int[] x_l = {aqui_x + 0, aqui_x + 30, aqui_x + 60, aqui_x + 30};
                  int[] y_l = {aqui_y + 30, aqui_y + 0, aqui_y + 30, aqui_y + 60}; 
                  // Descomentar para ter borda
                  // g2d.setColor(Color.BLACK);
                  // g2d.drawPolygon(x_l, y_l, 4);
                  // Comentarios do tipo //x_l[1] soh p ajudar a entender 
                  // x_l[0]++;
                  // x_l[1];
                  // x_l[2]--;
                  // x_l[3];
                  // y_l[0];
                  // y_l[1]++;
                  // y_l[2];
                  // y_l[3]--;
                  g2d.setColor(Color.decode("0xEDCE9E"));
                  g2d.fillPolygon(x_l, y_l, 4);
            }
        }
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


