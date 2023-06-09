package PostUI;

import DataManager.ClientData;

import javax.swing.*;
import java.awt.*;

public class CreateAccount extends JPanel {
    JTextField newID;
    JPasswordField newPW;
    public JButton cancelButton, registerButton;
    public CreateAccount(){
        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);

        // "JAVA FINAL" label
        JLabel titleLabel = new JLabel("Create New Account", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // ID and password input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4,1));
        //inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(new JLabel("ID"));
        newID = new JTextField(10);
        inputPanel.add(newID);
        inputPanel.add(new JLabel("Password"));
        newPW = new JPasswordField(10);
        inputPanel.add(newPW);

        add(inputPanel, BorderLayout.CENTER);

        // Login and register buttons panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        cancelButton = new JButton("Cancel");
        buttonsPanel.add(cancelButton);
        registerButton = new JButton("Create New Account");
        buttonsPanel.add(registerButton);
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    public String getID(){
        return newID.getText();
    }
    public String getPW(){
        char[] pw = newPW.getPassword();
        return new String(pw);
    }

    public void saveNewAccount(){
        ClientData newClient = new ClientData(getID(),getPW());
    }
}
