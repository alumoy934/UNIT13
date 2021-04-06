import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;

public class Notepad extends JFrame{
    private JPanel panel1;
    private JButton buttonSave;
    private JButton buttonLoad;
    private JTextArea textArea;
    UndoManager undoManager;

    public Notepad(String s){
        super("Notepad");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel1.setPreferredSize(new Dimension(500,500));
        setContentPane(panel1);
        pack();

        setJMenuBar(createMenuBar());
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createFileMenu());
        menuBar.add(createEditMenu());
        menuBar.add(new JSeparator());
        menuBar.add(createHelpMenu());
        return menuBar;

    }

    private JMenu createEditMenu() {
        JMenu editMenu = new JMenu("Edit");
        JMenuItem undoItem = new JMenuItem("Undo");
        undoItem.setMnemonic(KeyEvent.VK_U);
        undoItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
        editMenu.add(undoItem);

        JMenuItem redoItem = new JMenuItem("Redo");
        redoItem.setMnemonic(KeyEvent.VK_R);
        redoItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
        editMenu.add(redoItem);

        JMenuItem copyItem = new JMenuItem("Copy");
        copyItem.setMnemonic(KeyEvent.VK_C);
        copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        editMenu.add(copyItem);

        JMenuItem cutItem = new JMenuItem("Cut");
        cutItem.setMnemonic(KeyEvent.VK_U);
        cutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
        editMenu.add(cutItem);

        JMenuItem pasteItem = new JMenuItem("Paste");
        pasteItem.setMnemonic(KeyEvent.VK_P);
        pasteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        editMenu.add(pasteItem);

        undoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (undoManager.canUndo()) {
                    undoManager.undo();
                }
            }
        });
        redoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (undoManager.canRedo()) {
                    undoManager.redo();
                }
            }
        });
        copyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.copy();
            }
        });
        cutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.cut();
            }
        });
        pasteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.paste();
            }
        });
        return editMenu;
    }
    private JMenu createFileMenu() {
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);


        JMenuItem newItem = new JMenuItem("New");
        newItem.setIcon(new ImageIcon("new.png"));
        newItem.setMnemonic(KeyEvent.VK_N);
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        fileMenu.add(newItem);

        JMenuItem openItem = new JMenuItem("Open ...");
        openItem.setIcon(new ImageIcon("open.png"));
        openItem.setMnemonic(KeyEvent.VK_O);
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
        fileMenu.add(openItem);

        JMenuItem saveItem = new JMenuItem("Save ");
        saveItem.setIcon(new ImageIcon("save.png"));
        saveItem.setMnemonic(KeyEvent.VK_S);
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        fileMenu.add(saveItem);

        fileMenu.add(new JSeparator());

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setIcon(new ImageIcon("exit.png"));
        exitItem.setMnemonic(KeyEvent.VK_E);
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
        fileMenu.add(exitItem);

        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newFile();
            }
        });
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                load();
            }
        });
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        return fileMenu;
    }

    private void newFile() {
        int n = JOptionPane.showConfirmDialog(
                this,
                "Do you want to delete the current text?",
                "Remove test?",
                JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            textArea.setText("");
        }
    }

    private void save() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showSaveDialog(this);
        File file = fileChooser.getSelectedFile();

        if (file != null) {
            String fileName = file.getAbsolutePath();

            if (file.exists()) {
                int response = JOptionPane.showConfirmDialog(null, //
                        "Do you want to replace the existing file?", //
                        "Confirm", JOptionPane.YES_NO_OPTION, //
                        JOptionPane.QUESTION_MESSAGE);
                if (response != JOptionPane.YES_OPTION) {
                    return;
                }
            }

            try {
                saveFile(fileName);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error writing file "
                        + fileName, "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void saveFile(String fileName) throws IOException {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(fileName);
            writer.print(textArea.getText());
        } finally {
            if (writer != null) {
                writer.close();
            }

        }
    }

    private void load() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        String s = null;
        if (file != null) {
            String fileName = file.getAbsolutePath();
            System.out.println(fileName);
            try {
                s = loadFile(fileName);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error reading file " + fileName, "ERROR", JOptionPane.WARNING_MESSAGE);
            }
            textArea.setText(s);
        }

    }

    private String loadFile(String fileName) throws IOException {
        StringBuilder str = new StringBuilder();
        BufferedReader reader = null;
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);

            String s;
            while ((s = reader.readLine()) != null) {
                str.append(s + "\n");
            }
        } finally {
            reader.close();
        }
        return str.toString();
    }

    private JMenu createHelpMenu() {
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About ...");
        helpMenu.add(aboutItem);
        aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dialog dialog = new Dialog();
                dialog.pack();
                dialog.setVisible(true);
            }
        });
        return helpMenu;
    }


    public static void main (String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Notepad notepad = new Notepad("My notepad");
                notepad.setVisible(true);
            }
        });
    }

}

