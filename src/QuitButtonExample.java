import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuitButtonExample extends JFrame {


    public QuitButtonExample() {
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        setTitle("Quit Button");
        setSize(300,200);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton quitButton = new JButton("Quit");
        quitButton.setBounds(50,60,80,30);

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(quitButton);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                QuitButtonExample mybutton = new QuitButtonExample();
                mybutton.setVisible(true);
            }
        });
    }
}
