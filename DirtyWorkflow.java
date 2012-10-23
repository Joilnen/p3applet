import javax.swing.JApplet;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Container;
import java.awt.Color;

//! Classe inicial 
public class DirtyWorkflow extends JApplet implements MouseListener, MouseMotionListener, KeyListener{

    JMenu jmenu_arquivo, jmenu_help;
    JMenuBar jmenuBar;
    int width = 1330, height = 650;

    JToggleButton b_proc, b_deci, b_seta, b_mens, b_sele, b_yellow, b_roxo, b_green;
    JTextField e_label;
    JLabel l1;
    FlowLayout layout;
    MainWindow mainWindow;

    String text;

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
        mainWindow.addKeyListener(this);
        addKeyListener(this);

        layout = new FlowLayout();
        addComponentsToPane(getContentPane());
    }

    public void addComponentsToPane(final Container pane) {

        JPanel p = new JPanel();
        // p.setLayout(new BorderLayout());
        BoxLayout boxLay = new BoxLayout(p, BoxLayout.Y_AXIS); 
        // boxLay.setMinimumSize(b_proc.getSize().width, 600);
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        pane.add(p, BorderLayout.WEST);

        p.add(b_proc = new JToggleButton("Processo"));
        b_proc.setMaximumSize(new Dimension(Short.MAX_VALUE, 100));

        p.add(b_seta = new JToggleButton("Seta"));
        b_seta.setMaximumSize(new Dimension(Short.MAX_VALUE, 100));

        p.add(b_deci = new JToggleButton("Decisao"));
        b_deci.setMaximumSize(new Dimension(Short.MAX_VALUE, 100));


        p.add(b_mens = new JToggleButton("Mensagem"));
        b_mens.setMaximumSize(new Dimension(Short.MAX_VALUE, 100));

        p.add(b_sele = new JToggleButton("Selecao"));
        b_sele.setMaximumSize(new Dimension(Short.MAX_VALUE, 100));

        p.add(l1 = new JLabel("Label"));
        p.add(e_label = new JTextField());
        e_label.setMaximumSize(new Dimension(Short.MAX_VALUE, 25));
        p.add(b_yellow = new JToggleButton("Amarelo"));
        p.add(b_roxo = new JToggleButton("Roxo"));
        p.add(b_green = new JToggleButton("Verde"));
        l1.setVisible(false);
        e_label.setVisible(false);
        b_yellow.setVisible(false);
        b_roxo.setVisible(false);
        b_green.setVisible(false);


        b_proc.addMouseListener(this);
        b_seta.addMouseListener(this);
        b_deci.addMouseListener(this);
        b_sele.addMouseListener(this);
        b_mens.addMouseListener(this);
    }

    public void mouseExited(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) { 

        if(e.getButton() == MouseEvent.BUTTON1) {
            if(e.getSource() instanceof JToggleButton) {

                if(e.getSource() != b_proc) b_proc.setSelected(false);
                if(e.getSource() != b_seta) b_seta.setSelected(false);
                if(e.getSource() != b_deci) b_deci.setSelected(false);
                if(e.getSource() != b_sele) b_sele.setSelected(false);
                if(e.getSource() != b_mens) b_mens.setSelected(false);

                mainWindow.setWithMousePointer(WithMousePointerType.NONE);
                mainWindow.repaint();

                if(b_proc.isSelected()) {
                    mainWindow.setWithMousePointer(WithMousePointerType.PROCESS_GRAY_BORDER);
                    // mainWindow.repaint();
                }
                else if(b_seta.isSelected()) {
                    mainWindow.setWithMousePointer(WithMousePointerType.CONNECT_ONE_TO_ONE);
                    // mainWindow.repaint();
                }
                else if(b_deci.isSelected()) {
                    mainWindow.setWithMousePointer(WithMousePointerType.DECISION_GRAY_BORDER);
                    // mainWindow.repaint();
                }
                else if(b_sele.isSelected()) {
                    mainWindow.selectEnabled = true;
                    mainWindow.setWithMousePointer(WithMousePointerType.SELECT);

                    l1.setVisible(true);
                    e_label.setVisible(true);
                    b_yellow.setVisible(true);
                    b_roxo.setVisible(true);
                    b_green.setVisible(true);
                }
                else if(b_mens.isSelected()) {
                    mainWindow.setWithMousePointer(WithMousePointerType.WRITE_MENS);
                }
                else
                    mainWindow.setWithMousePointer(WithMousePointerType.NONE);

                if(b_sele.isSelected() == false) {
                    l1.setVisible(false);
                    e_label.setVisible(false);
                    b_yellow.setVisible(false);
                    b_roxo.setVisible(false);
                    b_green.setVisible(false);
                }
            }
            else {
                if(b_proc.isSelected()) {
                    // mudar soh para teste
                    GraphicElement g = new GraphicElement(GraphicElementType.NODE_PROC);
                    // mainWindow.setWithMousePointer(WithMousePointerType.PROCESS_GRAY_BORDER);
                    // mainWindow.repaint();
                    mainWindow.addEntity(g);
                    // JOptionPane.showMessageDialog(null, "Adicionei !");
                }
                else if(b_seta.isSelected()) {
                    if(mainWindow.setaTracing) {
                        mainWindow.addSetaFim();
                        mainWindow.setaTracing = false;
                    }
                    else {
                        mainWindow.setaTracing = true;
                        mainWindow.addSetaInicio(new GraphicElement(GraphicElementType.NODE_CONN));
                    }
                }
                else if(b_deci.isSelected()) {
                    // mudar soh para teste
                    GraphicElement g = new GraphicElement(GraphicElementType.NODE_DECI);
                    // mainWindow.setWithMousePointer(WithMousePointerType.PROCESS_GRAY_BORDER);
                    // mainWindow.repaint();
                    mainWindow.addEntity(g);
                }
                else if(b_sele.isSelected()) {

                }
                else if(b_mens.isSelected()) {
                    mainWindow.enableEditTextMode();
                    e.consume();
                }
            }
        }
    }

    public void mousePressed(MouseEvent e) { }
    public void mouseDragged(MouseEvent e) { }
    public void mouseMoved(MouseEvent e) { mainWindow.mouseMoved(e); }
    public void keyReleased(KeyEvent e) { }
    public void keyPressed(KeyEvent e) { }

    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if(c != KeyEvent.CHAR_UNDEFINED) {
            if(c == KeyEvent.VK_ENTER) mainWindow.addObjectText();
            mainWindow.addText(c);
            e.consume();
        }
    }

}


