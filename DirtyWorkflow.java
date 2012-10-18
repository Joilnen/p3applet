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
import java.awt.event.MouseMotionListener;
import java.awt.Container;

//! Classe inicial 
public class DirtyWorkflow extends JApplet implements MouseListener, MouseMotionListener {

    JMenu jmenu_arquivo, jmenu_help;
    JMenuBar jmenuBar;
    int width = 1330, height = 650;

    JToggleButton b_proc, b_deci, b_seta, b_mens, b_label;
    FlowLayout layout;
    MainWindow mainWindow;

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

        mainWindow = new MainWindow();
        add(mainWindow);
        mainWindow.addMouseListener(this);
        mainWindow.addMouseMotionListener(this);

        layout = new FlowLayout();
        addComponentsToPane(getContentPane());
    }

    public void addComponentsToPane(final Container pane) {

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        // p.setLayout(new BoxLayout());
        pane.add(p, BorderLayout.WEST);
        p.add(b_proc = new JToggleButton("Processo"));
        p.add(b_seta = new JToggleButton("Seta"));
        p.add(b_deci = new JToggleButton("Decisao"));
        p.add(b_label = new JToggleButton("Label"));
        p.add(b_mens = new JToggleButton("Mensagem"));

        b_proc.addMouseListener(this);
        b_seta.addMouseListener(this);
        b_deci.addMouseListener(this);
        b_label.addMouseListener(this);
        b_mens.addMouseListener(this);
    }

    public void mouseExited(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) { 

        if(e.getSource() instanceof JToggleButton) {

            if(e.getSource() != b_proc) b_proc.setSelected(false);
            if(e.getSource() != b_seta) b_seta.setSelected(false);
            if(e.getSource() != b_deci) b_deci.setSelected(false);
            if(e.getSource() != b_label) b_label.setSelected(false);
            if(e.getSource() != b_mens) b_mens.setSelected(false);

            mainWindow.setWithMousePointer(WithMousePointerType.NONE);
            mainWindow.repaint();

            if(b_proc.isSelected()) {
                mainWindow.setWithMousePointer(WithMousePointerType.PROCESS_GRAY_BORDER);
                mainWindow.repaint();
            }
            else if(e.getSource() == b_seta) {

            }
            else if(b_deci.isSelected()) {
                mainWindow.setWithMousePointer(WithMousePointerType.DECISION_GRAY_BORDER);
                mainWindow.repaint();
            }
            else if(e.getSource() == b_label) {

            }
            else if(e.getSource() == b_mens) {

            }
        }
        else {
            if(b_proc.isSelected()) {
                // mainWindow.setWithMousePointer(WithMousePointerType.PROCESS_GRAY_BORDER);
                // mainWindow.repaint();
            }
            else if(e.getSource() == b_seta) {

            }
            else if(b_deci.isSelected()) {
                mainWindow.setWithMousePointer(WithMousePointerType.DECISION_GRAY_BORDER);
                mainWindow.repaint();
            }
            else if(e.getSource() == b_label) {

            }
            else if(e.getSource() == b_mens) {

            }

        }
    }

    public void mousePressed(MouseEvent e) { }
    public void mouseDragged(MouseEvent e) { }
    public void mouseMoved(MouseEvent e) { mainWindow.mouseMoved(e); }
}


