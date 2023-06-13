package PostUI;

import DataManager.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateAccountPanel extends JPanel {
    JLabel confirmIDLabel, confirmNicknameLabel;
    JTextField newID, newNickname;
    JPasswordField newPW;
    JButton cancelButton, registerButton, confirmIDButton, confirmNicknameButton;
    ArrayList<ClientData> clients;

    boolean isConfirmedID, isConfirmedNickname;

    public CreateAccountPanel(){
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
        titleLabel.setPreferredSize(new Dimension(100,200));
        titleLabel.setFont(new Font("Serif", Font.BOLD, 40));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(titleLabel, BorderLayout.NORTH);

        // ID and password input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(new EmptyBorder(50,0,50,0));

        // ID
        JPanel idPanel = new JPanel(new FlowLayout());
        idPanel.add(new JLabel("ID"));
        newID = new JTextField(10);
        idPanel.add(newID);

        confirmIDButton = new JButton("Duplicate check");
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
        nicknamePanel.add(new JLabel("Nickname"));
        newNickname = new JTextField(10);
        nicknamePanel.add(newNickname);

        confirmNicknameButton = new JButton("Duplicate check");
        confirmNicknameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newNicknameString = newNickname.getText();

                if(newNicknameString.isEmpty()){
                    confirmNicknameLabel.setText("Please write new Nickname");
                    confirmNicknameLabel.setForeground(Color.RED);
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

        confirmNicknameLabel = new JLabel("");
        nicknamePanel.add(confirmNicknameLabel);
        inputPanel.add(nicknamePanel);


        // Password
        JPanel pwPanel = new JPanel(new FlowLayout());
        //pwPanel.setMaximumSize(new Dimension(400, 40));
        pwPanel.add(new JLabel("Password"));
        newPW = new JPasswordField(10);
        pwPanel.add(newPW);
        inputPanel.add(pwPanel);

        add(inputPanel, BorderLayout.CENTER);

        // Login and register buttons panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        buttonsPanel.setPreferredSize(new Dimension(0,200));
        cancelButton = new JButton("Cancel");
        buttonsPanel.add(cancelButton);
        registerButton = new JButton("Create New Account");
        buttonsPanel.add(registerButton);
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    public boolean saveNewAccount(){
        if(!isConfirmedID){
            confirmIDLabel.setText("Please confirm your ID");
        }
        if(!isConfirmedNickname){
            confirmNicknameLabel.setText("Please confirm your ID");
        }
        if(isConfirmedID&&isConfirmedNickname){
            String ID = newID.getText();
            String nickname = newNickname.getText();
            String PW = new String(newPW.getPassword());

            ClientData newClient = new ClientData(ID, nickname, PW);

            ArrayList<ClientData> clientData = ClientDataManager.loadClientData();
            clientData.add(newClient);
            ClientDataManager.saveClientData(clientData);
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        MainFrame mf = new MainFrame();
        mf.add(new CreateAccountPanel());
        mf.setVisible(true);
    }
}
