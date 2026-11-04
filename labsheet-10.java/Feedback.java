import javax.swing.*;
import java.awt.*;
public class Feedback extends JFrame {
    JTextField name, roll, course;
    JRadioButton[] rating = new JRadioButton[5];
    JCheckBox[] feedback = new JCheckBox[4];
    JTextArea comments;
    Feedback() {
        setLayout(new FlowLayout());
        add(new JLabel("Student Name:"));
        name = new JTextField(15); add(name);
        add(new JLabel("Roll Number:"));
        roll = new JTextField(15); add(roll);
        add(new JLabel("Course:"));
        course = new JTextField(15); add(course);
        String[] rates = {"Excellent", "Very Good", "Good", "Average", "Poor"};
        ButtonGroup bg = new ButtonGroup();

        for (int i = 0; i < 5; i++) {
            rating[i] = new JRadioButton(rates[i]);
            bg.add(rating[i]);
            add(rating[i]);
        }
        String[] items = {"Teaching", "Laboratory", "Course Material", "Assignments"};
        for (int i = 0; i < 4; i++) {
            feedback[i] = new JCheckBox(items[i]);
            add(feedback[i]);
        }
        add(new JLabel("Comments:"));
        comments = new JTextArea(3, 20);
        add(comments);
        JButton submit = new JButton("Submit");
        JButton reset = new JButton("Reset");
        add(submit); add(reset);
        submit.addActionListener(e -> {
            String r = "Name: " + name.getText() +
                "\nRoll: " + roll.getText() +
                "\nCourse: " + course.getText() + "\nRating: ";
            for (JRadioButton b : rating)
                if (b.isSelected()) r += b.getText();

            r += "\nFeedback: ";
            for (JCheckBox b : feedback)
                if (b.isSelected()) r += b.getText() + " ";

            r += "\nComments: " + comments.getText();
            JOptionPane.showMessageDialog(this, r);
        });
        reset.addActionListener(e -> {
            name.setText("");
            roll.setText("");
            course.setText("");
            bg.clearSelection();
            for (JCheckBox b : feedback) b.setSelected(false);
            comments.setText("");
        });
        setSize(350, 450);
        setTitle("Student Feedback");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Feedback();
    }
}