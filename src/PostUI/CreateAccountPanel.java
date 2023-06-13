package PostUI;

import DataManager.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CreateAccountPanel extends JPanel {
    JLabel confirmLabel;
    JTextField newID, newNickname;
    JPasswordField newPW;
    public JButton cancelButton, registerButton, confirmIDButton;
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

        confirmIDButton = new JButton("ID duplicate check");
        inputPanel.add(confirmIDButton);

        confirmLabel = new JLabel("");
        inputPanel.add(confirmLabel);

        inputPanel.add(new JLabel("Nickname"));
        newNickname = new JTextField(10);
        inputPanel.add(newNickname);

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

    public void saveNewAccount(){
        String ID = newID.getText();
        String nickname = newNickname.getText();
        String PW = new String(newPW.getPassword());

        ClientData newClient = new ClientData(ID,nickname,PW);

        ArrayList<ClientData> clientData = ClientDataManager.loadClientData();
        clientData.add(newClient);
        ClientDataManager.saveClientData(clientData);
    }

    public static void main(String[] args){
        MainFrame mf = new MainFrame();
        mf.add(new CreateAccountPanel());
        mf.setVisible(true);
    }
}
