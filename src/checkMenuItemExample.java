import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class checkMenuItemExample extends JFrame {

    public checkMenuItemExample() {
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);

        JMenu view = new JMenu("View");
        view.setMnemonic(KeyEvent.VK_V);

        //crea el check y muestra la bara de estado
        JCheckBoxMenuItem sbar = new JCheckBoxMenuItem("Show StatusBar");
        sbar.setState(true);

        //Muestra la barra de estado en la ventana y nos permite esconderla
        JLabel statusbar = new JLabel("Statusbar");
        statusbar.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        add(statusbar, BorderLayout.SOUTH);

        sbar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (statusbar.isVisible()){
                    statusbar.setVisible(false);
                }else{
                    statusbar.setVisible(true);
                }
            }
        });

        view.add(sbar);
        menuBar.add(file);
        menuBar.add(view);

        setJMenuBar(menuBar);



        setTitle("CheckBox menu item");
        setSize(360,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }//constructor

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                checkMenuItemExample ex = new checkMenuItemExample();
                ex.setVisible(true);
            }
        });
    }
}
