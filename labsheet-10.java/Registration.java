import java.awt.*;
import java.awt.event.*;
public class Registration extends Frame implements ActionListener {
    TextField name, roll, course;
    Checkbox male, female;
    Choice sem;
    Button submit, reset;
    Label result;

    Registration() {
        setLayout(new FlowLayout());
        add(new Label("Student Name:"));
        name = new TextField(20);
        add(name);
        add(new Label("Roll Number:"));
        roll = new TextField(20);
        add(roll);
        add(new Label("Course:"));
        course = new TextField(20);
        add(course);

        add(new Label("Gender:"));
        male = new Checkbox("Male");
        female = new Checkbox("Female");
        add(male);
        add(female);
        add(new Label("Semester:"));
        sem = new Choice();
        sem.add("1st");
        sem.add("2nd");
        sem.add("3rd");
        add(sem);

        submit = new Button("Submit");
        reset = new Button("Reset");
        add(submit);
        add(reset);
        result = new Label("");
        add(result);
        submit.addActionListener(this);
        reset.addActionListener(this);

        setSize(350, 400);
        setTitle("Student Registration");
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            result.setText("Registered: " + name.getText()
                + ", Roll: " + roll.getText());
        } else {
            name.setText("");
            roll.setText("");
            course.setText("");
            male.setState(false);
            female.setState(false);
            sem.select(0);
            result.setText("");
        }
    }
    public static void main(String[] args) {
        new Registration();
    }
}