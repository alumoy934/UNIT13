import javax.swing.*;
import java.awt.event.*;

public class MainForm extends JFrame{
    private JTextField textFieldMiles;
    private JButton convertToKmButton;
    private JTextField textFieldKilometers;
    private JButton convertToMlButton;
    private JPanel mainPanel;

    public static final float KMS_IN_A_MILE = 1.60934f;

    public MainForm (String title){
        //super(title);
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack(); //Ajusta el tamaño del marco al contenido del panel principal

        convertToKmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textFieldMiles.getText();
                float miles = 0;
                try {
                    miles = Float.parseFloat(text);
                }catch (NumberFormatException ex){

                }
                float kms = convertMilesToKms(miles);
                String kmsStr = String.format("%.4f",kms);
                textFieldKilometers.setText(kmsStr);

            }
        });

        convertToMlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textFieldKilometers.getText();
                float kilometeres = 0;
                try {
                    kilometeres = Float.parseFloat(text);
                }catch (NumberFormatException ex){

                }
                float miles = convertKmsToMiles(kilometeres);
                String milesStr = String.format("%.4f",miles);
                textFieldMiles.setText(milesStr);
            }
        });
    }

    private float convertKmsToMiles(float kilometeres) {
        return kilometeres / KMS_IN_A_MILE;
    }

    private float convertMilesToKms(float miles) {
        return miles * KMS_IN_A_MILE;
    }

    public static void main(String[] args) {

        MainForm miframe = new MainForm("Converter");
        miframe.setVisible(true);
        miframe.setLocation(500,400);

    }
}
