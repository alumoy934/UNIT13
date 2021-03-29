import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class TipOfDayExample extends JFrame {

    public TipOfDayExample(){

        JPanel basic = new JPanel();
        basic.setLayout(new BoxLayout(basic, BoxLayout.Y_AXIS));
        add(basic);

        JPanel topPanel = new JPanel(new BorderLayout(0,0));
        topPanel.setMaximumSize(new Dimension(450, 0));

        JLabel hint = new JLabel("JDevelopers Productivity Hints");
        hint.setBorder(BorderFactory.createEmptyBorder(0,25,0,0));
        topPanel.add(hint);

        ImageIcon icon = new ImageIcon("monitor.png");
        JLabel label = new JLabel(icon);
        label.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        topPanel.add(label,BorderLayout.EAST);

        JSeparator separator = new JSeparator();
        separator.setForeground(Color.gray);

        topPanel.add(separator,BorderLayout.SOUTH);

        basic.add(topPanel);

        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setBorder(BorderFactory.createEmptyBorder(15,25,15,25));

        JTextPane pane = new JTextPane();
        pane.setContentType("text/html");

        String text =
                "<p> <b> Cerrar ventanas con la rueda del mouse </b> </p>" +
                "<p> Al hacer clic con la rueda del mouse en una pestaña del editor, se cierra la ventana. " +
                "Este método también funciona con ventanas acoplables o Log pestañas de ventana. </p>";

        pane.setText(text);
        pane.setEditable(false);
        textPanel.add(pane);

        basic.add(textPanel);

        JPanel boxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,20,0));
        JCheckBox box = new JCheckBox("Show tips at startup");
        box.setMnemonic(KeyEvent.VK_C);

        boxPanel.add(box);
        basic.add(boxPanel);

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton ntip = new JButton("Next Tip");
        JButton close = new JButton("Close");
        bottom.add(ntip);
        bottom.add(close);
        basic.add(bottom);

        bottom.setMaximumSize(new Dimension(450,0));

        setTitle("Tip of de Day");
        setSize (new Dimension(450,350));
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

    }//

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TipOfDayExample ex = new TipOfDayExample();
                ex.setVisible(true);
            }
        });
    }


}
