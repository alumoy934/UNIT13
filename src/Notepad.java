import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Notepad extends JFrame {

    public Notepad(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Notepad CutreVersion 1.0");
        setSize(850,650);
        setLocationRelativeTo(null);
        pack();


        JPanel basic = new JPanel();
        basic.setLayout(new BoxLayout(basic,BoxLayout.Y_AXIS));
        add(basic);

        setJMenuBar(createMenuBar());

        basic.add(createToolBar());
        basic.add(createArea());

    }// constructor

    private Component createArea() {
        JTextArea textArea = new JTextArea("Text Area");
        return textArea;
    }


    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createFileMenu());
        menuBar.add(createEditMenu());
        return menuBar;
    }

    private JMenu createFileMenu() {
        JMenu fileMenu = new JMenu("Fichero");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        ImageIcon iconNew = new ImageIcon("new.png");
        JMenuItem newItem = new JMenuItem("New", iconNew);
        newItem.setMnemonic(KeyEvent.VK_N);
        fileMenu.add(newItem);

        ImageIcon iconOpen = new ImageIcon("open.png");
        JMenuItem openItem = new JMenuItem("Abrir fichero...",iconOpen);
        openItem.setMnemonic(KeyEvent.VK_A);
        fileMenu.add(openItem);

        ImageIcon iconSave = new ImageIcon("Save.png");
        JMenuItem saveItem = new JMenuItem("Guardar", iconSave);
        saveItem.setMnemonic(KeyEvent.VK_G);
        fileMenu.add(saveItem);

        JSeparator separator = new JSeparator();
        separator.setForeground(Color.BLACK);
        fileMenu.add(separator);

        ImageIcon iconExit = new ImageIcon("exit.png");
        JMenuItem exitItem = new JMenuItem("Salir", iconExit);
        exitItem.setMnemonic(KeyEvent.VK_S);
        fileMenu.add(exitItem);

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ha salido del programa correctamente");
                System.exit(0);
            }
        });

        return fileMenu;
    }

    private JMenu createEditMenu() {
        JMenu editMenu = new JMenu("Editar");
        editMenu.setMnemonic(KeyEvent.VK_E);

        ImageIcon cutIcon = new ImageIcon("cut.png");
        JMenuItem cutItem = new JMenuItem("Cortar", cutIcon);
        cutItem.setMnemonic(KeyEvent.VK_C);
        editMenu.add(cutItem);

        ImageIcon copyIcon = new ImageIcon("copy.png");
        JMenuItem copyItem = new JMenuItem("Copiar",copyIcon);
        copyItem.setMnemonic(KeyEvent.VK_P);
        editMenu.add(copyItem);

        ImageIcon pasteIcon = new ImageIcon("paste.png");
        JMenuItem pasteItem = new JMenuItem("Pegar", pasteIcon);
        pasteItem.setMnemonic(KeyEvent.VK_P);
        editMenu.add(pasteItem);
        return editMenu;
    }

    private JToolBar createToolBar(){
        JToolBar toolBar = new JToolBar();
        JButton guardar = new JButton("Guardar"); // sólo icono sin texto
        toolBar.add(guardar);

        JButton cargar = new JButton("Cargar"); // sólo icono sin texto
        toolBar.add(guardar);
        toolBar.add(cargar);
        toolBar.setAlignmentX(0);
        toolBar.setBorder(new EmptyBorder(new Insets(15,0,0,0)));
        return toolBar;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Notepad note = new Notepad();
                note.setVisible(true);
            }
        });
    }
}
