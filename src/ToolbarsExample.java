import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ToolbarsExample extends JFrame {

    public ToolbarsExample (){

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


        //Crea barras de herrameintas / accesos directos
        JToolBar toolBar1 = new JToolBar();
        JToolBar toolBar2 = new JToolBar();

        ImageIcon newi = new ImageIcon("new.png");
        ImageIcon open = new ImageIcon("open.png");
        ImageIcon save = new ImageIcon("save.png");
        ImageIcon exit = new ImageIcon("exit.png");

        JButton newB = new JButton(newi);
        JButton openB = new JButton(open);
        JButton saveB = new JButton(save);

        toolBar1.add(newB); toolBar1.add(openB); toolBar1.add(saveB);
        toolBar1.setAlignmentX(0);

        JButton exitB = new JButton(exit);
        toolBar2.add(exitB);
        toolBar2.setAlignmentX(0);

        exitB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(toolBar1); panel.add(toolBar2);

        //Sin esta línea no se muestran las toolbars en el panel
        add(panel, BorderLayout.NORTH);


        setTitle("Toolbars");
        setSize(360,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }// constructor

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ToolbarsExample ex = new ToolbarsExample();
                ex.setVisible(true);
            }
        });
    }
}
