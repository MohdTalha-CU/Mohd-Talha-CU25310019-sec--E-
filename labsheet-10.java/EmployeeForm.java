import java.awt.*;
import java.awt.event.*;
public class EmployeeForm extends Frame implements ActionListener {
    TextField id, name, des, salary;
    Choice dept;
    Checkbox male, female;
    CheckboxGroup gender;
    TextArea result;
    Button submit, clear;
    EmployeeForm() {
        setLayout(new FlowLayout());
        add(new Label("Employee ID:"));
        id = new TextField(15); add(id);
        add(new Label("Name:"));
        name = new TextField(15); add(name);
        add(new Label("Department:"));
        dept = new Choice();
        dept.add("IT"); dept.add("HR"); dept.add("Finance");
        add(dept);
        add(new Label("Designation:"));
        des = new TextField(15); add(des);
        add(new Label("Salary:"));
        salary = new TextField(15); add(salary);

        gender = new CheckboxGroup();
        male = new Checkbox("Male", gender, false);
        female = new Checkbox("Female", gender, false);
        add(male); add(female);
        submit = new Button("Submit");
        clear = new Button("Clear");
        add(submit); add(clear);
        result = new TextArea(5, 30);
        add(result);
        submit.addActionListener(this);
        clear.addActionListener(this);
        setSize(350, 450);
        setTitle("Employee Registration");
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            result.setText("ID: " + id.getText() +
                "\nName: " + name.getText() +
                "\nDepartment: " + dept.getSelectedItem() +
                "\nDesignation: " + des.getText() +
                "\nSalary: " + salary.getText() +
                "\nGender: " +
                (gender.getSelectedCheckbox() == null ? "Not Selected" :
                gender.getSelectedCheckbox().getLabel()));
        } else {
            id.setText("");
            name.setText("");
            des.setText("");
            salary.setText("");
            gender.setSelectedCheckbox(null);
            dept.select(0);
            result.setText("");
        }
    }
    public static void main(String[] args) {
        new EmployeeForm();
    }
}