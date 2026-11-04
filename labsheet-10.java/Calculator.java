import java.awt.*;
import java.awt.event.*;
public class Calculator extends Frame implements ActionListener {
    TextField t1, t2;
    Label result;
    Calculator() {
        setLayout(new FlowLayout());
        t1 = new TextField(10);
        t2 = new TextField(10);
        add(new Label("First Number:"));
        add(t1);
        add(new Label("Second Number:"));
        add(t2);
        String[] ops = {"+", "-", "*", "/"};
        for (String op : ops) {
            Button b = new Button(op);
            add(b);
            b.addActionListener(this);
        }
        result = new Label("Result: ");
        add(result);

        setSize(300, 200);
        setTitle("Simple Calculator");
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        double a = Double.parseDouble(t1.getText());
        double b = Double.parseDouble(t2.getText());
        double r = 0;
        String op = e.getActionCommand();
        if (op.equals("+")) r = a + b;
        else if (op.equals("-")) r = a - b;
        else if (op.equals("*")) r = a * b;
        else if (op.equals("/")) {
            if (b == 0) {
                result.setText("Cannot divide by zero");
                return;
            }
            r = a / b;
        }
        result.setText("Result: " + r);
    }
    public static void main(String[] args) {
        new Calculator();
    }
}