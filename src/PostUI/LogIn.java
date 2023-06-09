package PostUI;

import javax.swing.*;
import java.awt.*;

public class LogIn extends JPanel {
    JTextField inputID;
    JPasswordField inputPW;
    public JButton createNewAccountButton;
    public LogIn(){
        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);

        // "JAVA FINAL" label
        JLabel titleLabel = new JLabel("JAVA FINAL", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // ID and password input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4,1));
        //inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(new JLabel("ID"));
        inputID = new JTextField(10);
        inputPanel.add(inputID);
        inputPanel.add(new JLabel("Password"));
        inputPW = new JPasswordField(10);
        inputPanel.add(inputPW);

        add(inputPanel, BorderLayout.CENTER);

        // Login and register buttons panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        JButton loginButton = new JButton("Login");
        buttonsPanel.add(loginButton);
        createNewAccountButton = new JButton("Register");
        buttonsPanel.add(createNewAccountButton);
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    public String getID(){
        return inputID.getText();
    }
    public String getPW(){
        char[] pw = inputPW.getPassword();
        return new String(pw);
    }
}
