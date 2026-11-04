import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CourseSelection extends JFrame implements ActionListener {
    JTextField name;
    JComboBox<String> course;
    JRadioButton male, female;
    JCheckBox java, python, cpp;
    JButton submit, reset;
    CourseSelection() {
        setLayout(new FlowLayout());
        add(new JLabel("Student Name:"));
        name = new JTextField(15);
        add(name);
        add(new JLabel("Course:"));
        course = new JComboBox<>(
            new String[]{"BCA", "BBA", "B.Tech"});
        add(course);
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        add(male);
        add(female);
        java = new JCheckBox("Java");
        python = new JCheckBox("Python");
        cpp = new JCheckBox("C++");
        add(java);
        add(python);
        add(cpp);
        submit = new JButton("Submit");
        reset = new JButton("Reset");

        add(submit);
        add(reset);
        submit.addActionListener(this);
        reset.addActionListener(this);
        setTitle("Course Selection");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String gender = male.isSelected() ? "Male" :
                            female.isSelected() ? "Female" : "Not Selected";
            String subjects = "";
            if (java.isSelected()) subjects += "Java ";
            if (python.isSelected()) subjects += "Python ";
            if (cpp.isSelected()) subjects += "C++ ";
            JOptionPane.showMessageDialog(this,
                "Name: " + name.getText() +
                "\nCourse: " + course.getSelectedItem() +
                "\nGender: " + gender +
                "\nSubjects: " + subjects);
        } else {
            name.setText("");
            course.setSelectedIndex(0);
            java.setSelected(false);
            python.setSelected(false);
            cpp.setSelected(false);
        }
    }
    public static void main(String[] args) {
        new CourseSelection();
    }
}