import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ToolbarExample extends JFrame {

    public ToolbarExample (){
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        menuBar.add(file);
        setJMenuBar(menuBar);


        //Crea barra de herrameintas / accesos directos
        JToolBar toolBar = new JToolBar();
        ImageIcon icon = new ImageIcon("exit.png");

        //JButton exitButton = new JButton("Exit", icon); // icono + texto
        JButton exitButton = new JButton(icon); // sólo icono sin texto
        toolBar.add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Has cerrado el programa correctamente");
                System.exit(0);
            }
        });

        //menuBar.add(toolBar, BorderLayout.NORTH);
        add(toolBar, BorderLayout.NORTH);  // Ubicación de la toolber en el BorderLayout al norte.

        setTitle("Simple Toolbar");
        setSize(300,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }// constructor

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ToolbarExample ex = new ToolbarExample();
                ex.setVisible(true);
            }
        });
    }
}
