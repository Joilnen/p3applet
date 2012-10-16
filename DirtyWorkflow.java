import javax.swing.JApplet;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Container;

public class DirtyWorkflow extends JApplet {

    JMenu jmenu_arquivo, jmenu_help;
    JMenuBar jmenuBar;
    int width = 1330, height = 650;

    JButton b_proc, b_decis, b_seta;
    FlowLayout layout;

    public void init() {
        resize(width, height);
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

        add(new MainWindow());

        layout = new FlowLayout();
        addComponentsToPane(getContentPane());
    }

    public void addComponentsToPane(final Container pane) {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.add(new JToggleButton("Processo")); 
        p.add(new JToggleButton("Seta")); 
        p.add(new JToggleButton("Decisao")); 
        p.add(new JToggleButton("Label")); 
        p.add(new JToggleButton("Mensagem")); 
        // p.setLayout(new BoxLayout());
        pane.add(p, BorderLayout.WEST);
    }
}


