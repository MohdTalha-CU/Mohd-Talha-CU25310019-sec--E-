import javax.swing.*;
import java.awt.*;
public class Banking extends JFrame {
    JTextField acc, name, balance, amount;
    Banking() {
        setLayout(new FlowLayout());
        add(new JLabel("Account Number:"));
        acc = new JTextField(12); add(acc);
        add(new JLabel("Customer Name:"));
        name = new JTextField(12); add(name);
        add(new JLabel("Current Balance:"));
        balance = new JTextField("5000", 12);
        balance.setEditable(false);
        add(balance);
        add(new JLabel("Amount:"));
        amount = new JTextField(12); add(amount);

        JButton deposit = new JButton("Deposit");
        JButton withdraw = new JButton("Withdraw");
        JButton check = new JButton("Check Balance");
        JButton clear = new JButton("Clear");
        add(deposit); add(withdraw); add(check); add(clear);
        deposit.addActionListener(e -> transaction(true));
        withdraw.addActionListener(e -> transaction(false));
        check.addActionListener(e ->
            JOptionPane.showMessageDialog(this, "Balance: Rs. " + balance.getText()));

        clear.addActionListener(e -> {
            acc.setText("");
            name.setText("");
            amount.setText("");
        });
        setSize(350, 300);
        setTitle("Mini Banking Application");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    void transaction(boolean add) {
        try {
            double b = Double.parseDouble(balance.getText());
            double a = Double.parseDouble(amount.getText());
            if (a <= 0)
                JOptionPane.showMessageDialog(this, "Enter valid amount!");
            else if (!add && a > b)
                JOptionPane.showMessageDialog(this, "Insufficient Balance!");
            else {
                b = add ? b + a : b - a;
                balance.setText(String.valueOf(b));
                JOptionPane.showMessageDialog(this, "Transaction Successful!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Enter valid amount!");
        }
    }
    public static void main(String[] args) {
        new Banking();
    }
}