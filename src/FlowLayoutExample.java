import javax.swing.*;
import java.awt.*;

public class FlowLayoutExample extends JFrame {

    public FlowLayoutExample() {

        JPanel panel = new JPanel();
        JTextArea area = new JTextArea("Text Area");
        area.setPreferredSize(new Dimension(100,100));

        JButton button = new JButton("Botón");
        panel.add(button);

        JTree tree = new JTree();
        panel.add(tree);
        panel.add(area);

        add(panel);
        pack();

        setTitle("FlowLayout Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }// consructor

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FlowLayoutExample ex = new FlowLayoutExample();
                ex.setVisible(true);
            }
        });
    }
}
