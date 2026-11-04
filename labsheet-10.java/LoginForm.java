import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class LoginForm extends JFrame implements ActionListener {
    JTextField user;
    JPasswordField pass;
    JButton login, reset;
    LoginForm() {
        setLayout(new FlowLayout());
        add(new JLabel("Username:"));
        user = new JTextField(15);
        add(user);
        add(new JLabel("Password:"));
        pass = new JPasswordField(15);
        add(pass);
        login = new JButton("Login");
        reset = new JButton("Reset");
        add(login);
        add(reset);
        login.addActionListener(this);
        reset.addActionListener(this);

        setTitle("Student Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            if (user.getText().equals("admin") &&
                new String(pass.getPassword()).equals("1234"))
                JOptionPane.showMessageDialog(this, "Login Successful");
            else
                JOptionPane.showMessageDialog(this, "Invalid Login");
        } else {
            user.setText("");
            pass.setText("");
        }
    }
    public static void main(String[] args) {
        new LoginForm();
    }
}