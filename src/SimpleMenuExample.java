import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class SimpleMenuExample extends JFrame {

    public SimpleMenuExample (){
        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        //file.setMnemonic(keyEvent.VK_F);

        ImageIcon icon = new ImageIcon("exit.png");
        JMenuItem eMenuItem = new JMenuItem("Exit",icon);
        //eMenuItem.setMnemonic(keyEvent.VK_E);
        eMenuItem.setToolTipText("Exit application");
        eMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ha salido del programa");
                System.exit(0);
            }
        });

        file.add(eMenuItem);
        menuBar.add(file);

        setJMenuBar(menuBar);

        setTitle("Simple Menu");
        setSize(300,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }//constructor

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleMenuExample ex = new SimpleMenuExample();
                ex.setVisible(true);
            }
        });
    }
}
