import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class BorderLayoutExampleComplet extends JFrame {

    public BorderLayoutExampleComplet (){

        //Creo la barra de menús con el menú file
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        menuBar.add(file);
        setJMenuBar(menuBar);

        //Creo la toolbar
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);

        //Creo el botón con la imagen y lo añado a la toolbar
        ImageIcon exiticon = new ImageIcon("exit.png");
        JButton exitbtn = new JButton(exiticon);
        exitbtn.setBorder(new EmptyBorder(5,5,5,5));
        toolBar.add(exitbtn);

        add(toolBar, BorderLayout.NORTH);

        //Creo la toolbar vertical
        JToolBar vertical = new JToolBar(JToolBar.VERTICAL);
        vertical.setFloatable(false);
        vertical.setMargin(new Insets(10,5,5,5));

        ImageIcon select = new ImageIcon("unit.png");
        ImageIcon computer = new ImageIcon("monitor.png");
        ImageIcon printer = new ImageIcon("printer.png");

        JButton selectbtn = new JButton(select);
        selectbtn.setBorder(new EmptyBorder(3,0,3,0));

        JButton computerbtn = new JButton(computer);
        computerbtn.setBorder(new EmptyBorder(3,0,3,0));

        JButton printerbtn = new JButton(printer);
        printerbtn.setBorder(new EmptyBorder(3,0,3,0));

        vertical.add(selectbtn); vertical.add(computerbtn); vertical.add(printerbtn);
        add(vertical,BorderLayout.WEST);

        add(new JTextArea(), BorderLayout.CENTER);

        //Crea la barra de estado
        JLabel statusBar = new JLabel("StatusBar");
        statusBar.setPreferredSize(new Dimension(-1,22));
        statusBar.setBorder(LineBorder.createGrayLineBorder());
        add(statusBar, BorderLayout.SOUTH);

        setSize(350,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);




    }// contructor

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BorderLayoutExampleComplet ex = new BorderLayoutExampleComplet();
                ex.setVisible(true);
            }
        });
    }
}
