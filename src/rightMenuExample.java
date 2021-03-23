import javax.swing.*;
import java.awt.event.KeyEvent;
import java.security.Key;

public class rightMenuExample extends JFrame {

    public rightMenuExample (){
        JMenuBar menuBar = new JMenuBar();

        JMenu filem = new JMenu("File");
        filem.setMnemonic(KeyEvent.VK_F);
        JMenu viewm = new JMenu("View");
        viewm.setMnemonic(KeyEvent.VK_V);
        JMenu toolsm = new JMenu("Tools");
        toolsm.setMnemonic(KeyEvent.VK_T);
        JMenu helpm = new JMenu("Help");
        helpm.setMnemonic(KeyEvent.VK_H);

        menuBar.add(filem);
        menuBar.add(viewm);
        menuBar.add(toolsm);
        menuBar.add(Box.createGlue());
        menuBar.add(helpm);

        setJMenuBar(menuBar);

        setTitle("Right menu");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }//constructor

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                rightMenuExample ex = new rightMenuExample();
                ex.setVisible(true);
            }
        });
    }
}
