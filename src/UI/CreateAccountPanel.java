package UI;

import CustomAdapter.NoSpaceAdapter;
import DataManager.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateAccountPanel extends JPanel {
    JLabel confirmIDLabel, confirmNicknameLabel, confirmPWLabel;
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

        // Title label
        JLabel titleLabel = new JLabel("Create New Account", SwingConstants.CENTER);
        titleLabel.setPreferredSize(new Dimension(100,300));
        titleLabel.setFont(new Fonts.MainTitleFont());
        add(titleLabel, BorderLayout.NORTH);

        // ID and password input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(new EmptyBorder(50,0,40,0));

        // ID
        JPanel idPanel = new JPanel(new FlowLayout());

        JLabel idLabel = new JLabel("ID");
        idLabel.setFont(new Fonts.ContentBoldFont());
        idLabel.setPreferredSize(new Dimension(100,30));
        idPanel.add(idLabel);

        newID = new JTextField(20);
        newID.setFont(new Fonts.ContentFont());
        newID.addKeyListener(new NoSpaceAdapter());
        idLabel.setPreferredSize(new Dimension(100,30));

        idPanel.add(newID);

        confirmIDButton = new JButton("Duplicate check");
        confirmIDButton.setFont(new Fonts.ContentBoldFont());
        confirmIDButton.setPreferredSize(new Dimension(150,25));
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
        inputPanel.add(idPanel);

        JPanel confirmIdPanel = new JPanel(new FlowLayout());
        confirmIDLabel = new JLabel(" ");
        confirmIdPanel.add(confirmIDLabel);
        inputPanel.add(confirmIdPanel);


        // Nickname
        JPanel nicknamePanel = new JPanel(new FlowLayout());

        JLabel nicknameLabel = new JLabel("Nickname");
        nicknameLabel.setFont(new Fonts.ContentBoldFont());
        nicknameLabel.setPreferredSize(new Dimension(100,30));
        nicknamePanel.add(nicknameLabel);

        newNickname = new JTextField(20);
        newNickname.setFont(new Fonts.ContentFont());
        newNickname.setPreferredSize(new Dimension(100,30));
        newNickname.addKeyListener(new NoSpaceAdapter());
        nicknamePanel.add(newNickname);

        confirmNicknameButton = new JButton("Duplicate check");
        confirmNicknameButton.setFont(new Fonts.ContentBoldFont());
        confirmNicknameButton.setPreferredSize(new Dimension(150,25));
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
        inputPanel.add(nicknamePanel);

        JPanel confirmNicknamePanel = new JPanel(new FlowLayout());
        confirmNicknameLabel = new JLabel(" ");
        confirmNicknamePanel.add(confirmNicknameLabel);
        inputPanel.add(confirmNicknamePanel);

        // Password
        JPanel pwPanel = new JPanel(new FlowLayout());

        JLabel pwLabel = new JLabel("Password");
        pwLabel.setFont(new Fonts.ContentBoldFont());
        pwLabel.setPreferredSize(new Dimension(100,30));
        pwPanel.add(pwLabel);

        newPW = new JPasswordField(20);
        newPW.addKeyListener(new NoSpaceAdapter());
        newPW.setFont(new Fonts.ContentFont());
        newPW.setPreferredSize(new Dimension(100,30));
        pwPanel.add(newPW);

        JLabel tempLable = new JLabel();
        tempLable.setPreferredSize(new Dimension(150,30));
        pwPanel.add(tempLable);

        inputPanel.add(pwPanel);

        JPanel confirmPWPanel = new JPanel(new FlowLayout());
        confirmPWLabel = new JLabel(" ");
        confirmPWPanel.add(confirmPWLabel);
        inputPanel.add(confirmPWPanel);

        add(inputPanel, BorderLayout.CENTER);

        // Login and register buttons panel
        JPanel buttonsPanel = new JPanel();

        buttonsPanel.setLayout(new FlowLayout());
        buttonsPanel.setPreferredSize(new Dimension(0,150));

        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Fonts.ContentBoldFont());

        registerButton = new JButton("Create New Account");
        registerButton.setFont(new Fonts.ContentBoldFont());

        buttonsPanel.add(cancelButton);
        buttonsPanel.add(registerButton);
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    public boolean saveNewAccount(){
        if(!isConfirmedID){
            confirmIDLabel.setForeground(Color.RED);
            confirmIDLabel.setText("Please confirm your ID");
        }
        if(!isConfirmedNickname){
            confirmNicknameLabel.setForeground(Color.RED);
            confirmNicknameLabel.setText("Please confirm your Nickname");
        }
        if(isConfirmedID&&isConfirmedNickname){
            if(newPW.getPassword().length==0){
                confirmPWLabel.setForeground(Color.RED);
                confirmPWLabel.setText("Please write your Password");
                return false;
            }
            String ID = newID.getText();
            String nickname = newNickname.getText();
            String PW = new String(newPW.getPassword());

            ClientData newClient = new ClientData(ID, nickname, PW);

            clients.add(newClient);
            ClientDataManager.saveClientData(clients);
            return true;
        }
        return false;
    }
}
