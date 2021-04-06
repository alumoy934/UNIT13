import javax.swing.*;

public class SimpleDragandDrop extends JFrame {

    public SimpleDragandDrop(){
        setTitle("Simple Drag and Drop");
        setLayout(null);

        JButton button = new JButton("Botón");
        button.setBounds(200, 50, 90, 25);

        JTextField field = new JTextField();
        field.setBounds(30,50,150,25);

        add(button);
        add(field);

        field.setDragEnabled(true);
        button.setTransferHandler(new TransferHandler("text"));

        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleDragandDrop ex = new SimpleDragandDrop();
                ex.setVisible(true);
            }
        });
    }
}
