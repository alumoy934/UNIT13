import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BorderLayoutExample extends JFrame {

    public BorderLayoutExample (){
        JPanel panel = new JPanel(new BorderLayout());

        JPanel top = new JPanel();

        //panel.setPreferredSize(new Dimension(500,500));

        top.setPreferredSize(new Dimension(300, 300));
        top.setBackground(Color.blue);

        panel.add(top);
        panel.setBorder(new EmptyBorder(new Insets(10,10,10,10)));

        add(panel);
        pack();

        setTitle("Border Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }// constructor

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BorderLayoutExample ex = new BorderLayoutExample();
                ex.setVisible(true);
            }
        });
    }
}
