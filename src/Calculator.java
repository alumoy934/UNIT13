import javax.swing.*;
import java.awt.event.*;

public class Calculator extends JFrame{
    private JTextField textField1;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton buttonsuma;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton buttonmenos;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton buttonmultiplicar;
    private JButton buttoncoma;
    private JButton button0;
    private JButton buttonC;
    private JButton buttondividir;
    private JButton buttonigual;
    private JPanel mainPanel;
    private JButton buttonborrar;

    public Calculator(String title) {
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();

    }



    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {

        Calculator miframe = new Calculator("Calculator");
        miframe.setVisible(true);
        //miframe.setLocation(500,400);

    }
}
