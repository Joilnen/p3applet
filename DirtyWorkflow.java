import javax.swing.JApplet;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DirtyWorkflow extends JApplet {

    JMenu jmenu_arquivo, jmenu_help;
    JMenuBar jmenuBar;
    int width = 1330, height = 650;

    public void init() {
        resize(width, height);
        add(new MainWindow());
        jmenuBar = new JMenuBar();

        jmenu_arquivo = new JMenu("Arquivo");
        jmenu_arquivo.add(new JMenuItem("Abrir"));
        jmenu_arquivo.add(new JMenuItem("Salvar"));
        jmenu_arquivo.add(new JMenuItem("Salvar Como"));
        /***
        JMenuItem sair = new JMenuItem("Sair");
            
        sair.setMnemonic('S');

        sair.addMouseListener(new MouseListener() {
            public void mouseExited(MouseEvent e) { }
            public void mouseEntered(MouseEvent e) { }
            public void mouseReleased(MouseEvent e) { }
            public void mouseClicked(MouseEvent e) { }

            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }

        });
        ****/

        jmenuBar.add(jmenu_arquivo);

        jmenu_help = new JMenu("Ajuda");
        jmenu_help.add(new JMenuItem("Como usar"));
        jmenu_help.add(new JMenuItem("Sobre"));
        jmenuBar.add(jmenu_help);

        setJMenuBar(jmenuBar);
    }
}


