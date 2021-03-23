import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolTipExample extends JFrame {


    public ToolTipExample() {
        JPanel panel = new JPanel();
        getContentPane().add(panel);

        panel.setLayout(null);
        panel.setToolTipText("A panel container");

        JButton button = new JButton("Button");
        button.setBounds(100,60,100,30);
        button.setToolTipText("A button component");

        panel.add(button);

        setTitle("Tooltip");
        setSize(300,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Fín de programa");
                System.exit(0);
            }
        });

    }//Constructor

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ToolTipExample ex = new ToolTipExample();
                ex.setVisible(true);
            }
        });
    }

}
