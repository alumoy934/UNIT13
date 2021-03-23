import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class popMenuExample extends JFrame {


    public popMenuExample (){
        JPopupMenu pmenu = new JPopupMenu();

        JMenuItem maxitem = new JMenuItem("Maximize");
        maxitem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });

        pmenu.add(maxitem);

        JMenuItem minitem = new JMenuItem("Minimize");
        minitem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setExtendedState(JFrame.NORMAL);
            }
        });

        pmenu.add(minitem);


        JMenuItem quititem = new JMenuItem("Quit");
        quititem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Saliste del programa correctamente");
                System.exit(0);
            }
        });

        pmenu.add(quititem);

        //captura el evento del mouse al hacer clic derecho
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3){
                    pmenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        setTitle("JPopupMenu");
        setSize(300, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }// Constructor

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                popMenuExample ex = new popMenuExample();
                ex.setVisible(true);
            }
        });
    }
}
