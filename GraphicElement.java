import java.util.List;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

//! Classe que representa elementos graficos que
//! serao desenhados no canvas segue o padrao de design Composite
class GraphicElement {

    int x, y, dx, dy;

    Color color_borda;
    Color color_preen;
    Color color_label;
    Color color_descricao;

    String label;
    String descricao;

	Rectangle bound;
 
    // Nao usar out por enquanto passei a responsabilidade
    // disso para Connection
    List in, out;
    int type; // GraphicElementType
    int represent; // Represent

    //! Utilisado apenas quando o elemento eh coneccao para pinta a ponta 
    //! da seta
    boolean arrow_1, arrow_2;

    GraphicElement(int a) {

        type = a;
        color_borda = new Color(0, 0, 0, 1);
        color_preen = new Color(1, 0, 0, 1);

        x = y = 0;
        dx = 150;
        dy = 100;

        if(type == GraphicElementType.NODE_PROC) {
            dx = 150;
            dy = 100;
        }

        if(type == GraphicElementType.NODE_DECI) {
            dx = 50;
            dy = 100;
        }

		bound = new Rectangle(x, y, dx, dy);
        represent = Represent.NODE_SHOW;
    }

    public void setX(int i) {
        x = i;
    }

    public int getX() { return x; }

    public void setY(int i) {
        y = i;
    }
    public int getY() { return y; }

    public int getDx() { return dx; }
    public int getDy() { return dy; }
    
    void setType(int a) {
       type = a; 
    }
    public int getType() { return type; }

    void setRepresent(int a) {
        represent = a;
    }

    void paint(Graphics2D g2d) {
        g2d.setColor(color_preen);
        if(type == GraphicElementType.NODE_PROC) {
            g2d.fillRoundRect(x, y, 150, 100, 15, 15);
        }
        if(type == GraphicElementType.NODE_DECI) {
            int[] x_l = {x + 0, x + 50, x + 100, x + 50};
            int[] y_l = {y + 50, y + 0, y + 50, y + 100}; 
            g2d.fillPolygon(x_l, y_l, 4);
        }
    }

	public Rectangle getBound() {

		bound.x = x;
		bound.y = y;
		bound.width = dx;
		bound.height = dy;

		return bound;
	}
}

//! Tipo do Elemento grafico, um unico objeto representa
//! qualquer objeto isto aqui o distingue class GraphicElementType {
class GraphicElementType { 
    static int NODE_PROC = 1000;
    static int NODE_DECI = 1001;
    static int NODE_CONN = 1002;
    static int NODE_MENS = 1003;
}

//! Representacao do objeto grafico q pode
class Represent {
    static int NODE_SHOW = 1000;
    static int NODE_HIDE = 1001;
    static int NODE_HIGHTLIGHT = 1002;
    static int NODE_TRACEJADO = 1003;
}


