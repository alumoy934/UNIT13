import javax.swing.*;
import java.awt.*;

public class BoxLayoutTwoButtonsExample extends JFrame {

    public BoxLayoutTwoButtonsExample (){
        JPanel basic = new JPanel();
        basic.setLayout(new BoxLayout(basic,BoxLayout.Y_AXIS));
        add(basic);

        basic.add((Box.createVerticalGlue()));

        JPanel bottom = new JPanel();
        bottom.setAlignmentX(1f);
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));

        JButton ok = new JButton("Ok");
        JButton close = new JButton("Close");

        bottom.add(ok);
        bottom.add(Box.createRigidArea(new Dimension(5,0)));
        bottom.add(close);
        bottom.add(Box.createRigidArea(new Dimension(5,0)));

        basic.add(bottom);
        basic.add(Box.createRigidArea(new Dimension(0,5)));

        setTitle("Dos botones con BoxLayoutManager");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }// constructor

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BoxLayoutTwoButtonsExample ex = new BoxLayoutTwoButtonsExample();
                ex.setVisible(true);
            }
        });
    }
}
