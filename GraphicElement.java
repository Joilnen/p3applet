import java.util.List;
import java.awt.Color;

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
 
    // Nao usar out por enquanto passei a responsabilidade
    // disso para Connection
    List in, out;
    GraphicElementType type;

    //! Utilisado apenas quando o elemento eh coneccao para pinta a ponta 
    //! da seta
    boolean arrow_1, arrow_2;

    GraphicElement() {

    }
}

//! Tipo do Elemento grafico, um unico objeto representa
//! qualquer objeto isto aqui o distingue
class GraphicElementType {
    static int NODE_PROC = 1000;
    static int NODE_DECI = 1001;
    static int NODE_CONN = 1002;
    static int NODE_MENS = 1003;
}

class Represent {
    static int NODE_SHOW = 1000;
    static int NODE_HIDE = 1001;
    static int NODE_HIGHTLIGHT = 1002;
    static int NODE_TRACEJADO = 1003;
}


