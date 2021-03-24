import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class absolutExample extends JFrame {

    public absolutExample (){

        setLayout(null); // No usamos ningún layout

        JButton ok = new JButton("Ok");
        ok.setBounds(50,50,80,25);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Seguimos con el programa abierto");
                System.out.println("El programa sigue abierto");
            }
        });

        JButton exit = new JButton("Exit");
        exit.setBounds(150,50,80,25);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Saliendo del programa");
                System.out.println("Ha salido del programa correctamente");
                System.exit(0);
            }
        });

        //posiciona los botones en el marco
        add(ok);
        add(exit);

        setTitle("Absolute positioning");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }//constructor

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                absolutExample ex = new absolutExample();
                ex.setVisible(true);
            }
        });
    }
}
