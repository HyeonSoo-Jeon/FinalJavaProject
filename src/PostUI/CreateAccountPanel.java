package PostUI;

import DataManager.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateAccountPanel extends JPanel {
    JLabel confirmLabel;
    JTextField newID, newNickname;
    JPasswordField newPW, confirmPW;
    public JButton cancelButton, registerButton, confirmButton;
    public CreateAccountPanel(){
        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);

        // "JAVA FINAL" label
        JLabel titleLabel = new JLabel("Create New Account", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // ID and password input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        inputPanel.add(new JLabel("ID"));
        newID = new JTextField(10);
        inputPanel.add(newID);

        inputPanel.add(new JLabel("Nickname"));
        newNickname = new JTextField(10);
        inputPanel.add(newNickname);

        inputPanel.add(new JLabel("Password"));
        newPW = new JPasswordField(10);
        inputPanel.add(newPW);

        inputPanel.add(new JLabel("Confirm Password"));
        confirmPW = new JPasswordField(10);
        inputPanel.add(confirmPW);

        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pw1 = new String(newPW.getPassword());
                String pw2 = new String(confirmPW.getPassword());
                if(pw1.equals(pw2)){
                   confirmLabel.setText("Success");
                }
                else {
                    confirmLabel.setText("The password is not the same.");
                }
            }
        });
        inputPanel.add(confirmButton);

        confirmLabel = new JLabel("");
        inputPanel.add(confirmLabel);


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

    public void saveNewAccount(){
        String ID = newID.getText();
        String nickname = newNickname.getText();
        String PW = new String(newPW.getPassword());

        ClientData newClient = new ClientData(ID,nickname,PW);

        ArrayList<ClientData> clientData = ClientDataManager.loadClientData();
        clientData.add(newClient);
        ClientDataManager.saveClientData(clientData);
    }
}
