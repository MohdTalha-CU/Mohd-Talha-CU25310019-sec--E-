import javax.swing.*;
import java.awt.event.*;
public class Temperature extends JFrame implements ActionListener {
    JTextField temp;
    JRadioButton c, f;
    JButton convert, clear;
    JLabel result;
    Temperature() {
        setLayout(new java.awt.FlowLayout());
        add(new JLabel("Temperature:"));
        temp = new JTextField(10); add(temp);
        c = new JRadioButton("Celsius to Fahrenheit", true);
        f = new JRadioButton("Fahrenheit to Celsius");

        ButtonGroup bg = new ButtonGroup();
        bg.add(c); bg.add(f);
        add(c); add(f);
        convert = new JButton("Convert");
        clear = new JButton("Clear");
        add(convert); add(clear);
        result = new JLabel("Result:");
        add(result);
        convert.addActionListener(this);
        clear.addActionListener(this);
        setSize(350, 200);
        setTitle("Temperature Converter");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear) {
            temp.setText("");
            result.setText("Result:");
            return;
        }
        try {
            double t = Double.parseDouble(temp.getText());
            double ans = c.isSelected() ? (t * 9 / 5) + 32 :
                         (t - 32) * 5 / 9;
            result.setText("Result: " + ans);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Enter valid temperature!");
        }
    }
    public static void main(String[] args) {
        new Temperature();
    }
}