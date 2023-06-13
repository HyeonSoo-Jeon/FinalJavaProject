package PostUI;

import DataManager.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateAccountPanel2 extends JPanel {
    JLabel confirmIDLabel, confirmNicknameLabel;
    JTextField newID, newNickname;
    JPasswordField newPW;
    JButton cancelButton, registerButton, confirmIDButton, confirmNicknameButton;
    ArrayList<ClientData> clients;

    boolean isConfirmedID, isConfirmedNickname;

    public CreateAccountPanel2(){
        // Load ClientData
        clients = ClientDataManager.loadClientData();
        if(clients==null){
            clients = new ArrayList<>();
        }

        isConfirmedID = false;
        isConfirmedNickname = false;

        setLayout(new BorderLayout());

        // "Create New Account" label
        JLabel titleLabel = new JLabel("Create New Account", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(titleLabel, BorderLayout.NORTH);

        // ID and password input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ID
        JPanel idPanel = new JPanel(new FlowLayout());
        idPanel.setMaximumSize(new Dimension(400, 40));
        idPanel.add(new JLabel("ID"));
        newID = new JTextField(10);
        idPanel.add(newID);

        confirmIDButton = new JButton("ID duplicate check");
        confirmIDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newIDString = newID.getText();

                if(newIDString.isEmpty()){
                    confirmIDLabel.setForeground(Color.RED);
                    confirmIDLabel.setText("Please write new ID");
                }
                else{
                    boolean isDuplicate = false;
                    for(ClientData client : clients){
                        if(client.userID.equals(newIDString)){
                            isDuplicate= true;
                            break;
                        }
                    }

                    if(isDuplicate){
                        confirmIDLabel.setForeground(Color.RED);
                        confirmIDLabel.setText("Duplicate ID");
                    }
                    else{
                        confirmIDLabel.setForeground(Color.GREEN);
                        confirmIDLabel.setText("Confirm!");
                        newID.setEditable(false);
                        isConfirmedID = true;
                    }
                }
            }
        });
        idPanel.add(confirmIDButton);

        confirmIDLabel = new JLabel("");
        idPanel.add(confirmIDLabel);
        inputPanel.add(idPanel);

        // Nickname
        JPanel nicknamePanel = new JPanel(new FlowLayout());
        nicknamePanel.setMaximumSize(new Dimension(400, 40));
        nicknamePanel.add(new JLabel("Nickname"));
        newNickname = new JTextField(10);
        nicknamePanel.add(newNickname);

        confirmNicknameButton = new JButton("Nickname duplicate check");
        confirmNicknameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String newNicknameString = newNickname.getText();

                if(newNicknameString.isEmpty()){
                    confirmNicknameLabel.setForeground(Color.RED);
                    confirmNicknameLabel.setText("Please write new Nickname");
                }
                else{
                    boolean isDuplicate = false;
                    for(ClientData client : clients){
                        if(client.nickname.equals(newNicknameString)){
                            isDuplicate = true;
                            break;
                        }
                    }

                    if(isDuplicate){
                        confirmNicknameLabel.setForeground(Color.RED);
                        confirmNicknameLabel.setText("Duplicate Nickname");
                    }
                    else{
                        confirmNicknameLabel.setForeground(Color.GREEN);
                        confirmNicknameLabel.setText("Confirm!");
                        newNickname.setEditable(false);
                        isConfirmedNickname = true;
                    }
                }
            }
        });
        nicknamePanel.add(confirmNicknameButton);

        confirmNicknameLabel = new JLabel("hh");
        nicknamePanel.add(confirmNicknameLabel);
        inputPanel.add(nicknamePanel);


        // Password
        JPanel pwPanel = new JPanel(new FlowLayout());
        pwPanel.setMaximumSize(new Dimension(400, 40));
        pwPanel.add(new JLabel("Password"));
        newPW = new JPasswordField(10);
        pwPanel.add(newPW);
        inputPanel.add(pwPanel);

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

        ClientData newClient = new ClientData(ID, nickname, PW);

        ArrayList<ClientData> clientData = ClientDataManager.loadClientData();
        clientData.add(newClient);
        ClientDataManager.saveClientData(clientData);
    }

    public static void main(String[] args){
        MainFrame mf = new MainFrame();
        mf.add(new CreateAccountPanel2());
        mf.setVisible(true);
    }
}
