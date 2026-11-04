import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class Notepad extends JFrame implements ActionListener {
    JTextArea area;
    JMenuItem n, o, s, x;
    Notepad() {
        area = new JTextArea();
        add(new JScrollPane(area));
        JMenu file = new JMenu("File");
        n = new JMenuItem("New");
        o = new JMenuItem("Open");
        s = new JMenuItem("Save");
        x = new JMenuItem("Exit");

        file.add(n); file.add(o);
        file.add(s); file.add(x);
        JMenuBar bar = new JMenuBar();
        bar.add(file);
        setJMenuBar(bar);
        n.addActionListener(this);
        o.addActionListener(this);
        s.addActionListener(this);
        x.addActionListener(this);

        setSize(400, 300);
        setTitle("Simple Notepad");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == n) {
                area.setText("");
            } else if (e.getSource() == o) {
                JFileChooser fc = new JFileChooser();
                if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
                    area.setText(new String(java.nio.file.Files.readAllBytes(
                        fc.getSelectedFile().toPath())));
            } else if (e.getSource() == s) {
                JFileChooser fc = new JFileChooser();
                if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
                    java.nio.file.Files.write(
                        fc.getSelectedFile().toPath(),
                        area.getText().getBytes());
            } else {
                System.exit(0);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "File Error!");
        }
    }
    public static void main(String[] args) {
        new Notepad();
    }
}