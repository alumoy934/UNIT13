import javax.swing.*;
import java.awt.*;

public class GridLayoutExample extends JFrame {

    public GridLayoutExample (){

        JPanel panel = new JPanel();

        //Crea un espacio entre el borde del marco  y los elementos
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        panel.setLayout(new GridLayout(5,4,10,10));

        String [] buttons = {"Cls", "Bck", "", "Cerrar", "7", "8", "9", "/", "4",
                "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"};

        for (int i = 0; i < buttons.length; i++) {
            //Al poner una etiqueta en esa posición no se muestra botón y queda como si fuera un espacio.
            if (i==2){
                panel.add(new JLabel(buttons[i]));
            }else{
                panel.add(new JButton(buttons[i]));
            }

        }

        add(panel);

        setTitle("GridLayout");
        setSize(350,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }//Constructor

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GridLayoutExample ex = new GridLayoutExample();
                ex.setVisible(true);
            }
        });
    }
}
