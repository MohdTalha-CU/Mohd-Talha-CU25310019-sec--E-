import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Marksheet extends JFrame implements ActionListener {
    JTextField[] marks = new JTextField[5];
    JButton calculate;
    JLabel result;
    Marksheet() {
        setLayout(new FlowLayout());
        String[] subjects = {
            "English", "Mathematics", "Java",
            "DBMS", "Computer Networks"
        };
        for (int i = 0; i < 5; i++) {
            add(new JLabel(subjects[i]));
            marks[i] = new JTextField(10);
            add(marks[i]);
        }
        calculate = new JButton("Calculate Result");
        add(calculate);
        result = new JLabel("Result will appear here");
        add(result);
        calculate.addActionListener(this);
        setTitle("Student Marksheet");
        setSize(300, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        int total = 0;
        for (int i = 0; i < 5; i++) {
            int m = Integer.parseInt(marks[i].getText());
            if (m < 0 || m > 100) {
                result.setText("Enter marks between 0 and 100");
                return;
            }
            total += m;
        }
        double per = total / 5.0;
        String grade = per >= 90 ? "A" :
                       per >= 75 ? "B" :
                       per >= 60 ? "C" :
                       per >= 40 ? "D" : "F";

        String status = per >= 40 ? "Pass" : "Fail";
        result.setText("<html>Total: " + total +
            "<br>Percentage: " + per +
            "%<br>Grade: " + grade +
            "<br>Status: " + status + "</html>");
    }
    public static void main(String[] args) {
        new Marksheet();
    }
}