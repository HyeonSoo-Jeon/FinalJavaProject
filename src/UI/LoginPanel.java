package UI;

import CustomAdapter.NoSpaceAdapter;
import DataManager.ClientData;
import DataManager.ClientDataManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class LoginPanel extends JPanel {

    ArrayList<ClientData> clients;
    JTextField inputID;
    JPasswordField inputPW;
    public JButton createNewAccountButton, loginButton;

    JLabel loginErrorLabel;
    public LoginPanel(){
        clients = ClientDataManager.loadClientData();
        if(clients==null){
            clients = new ArrayList<ClientData>();
        }

        setLayout(new BorderLayout());

        // "JAVA FINAL" label
        JLabel titleLabel = new JLabel("JAVA FINAL", SwingConstants.CENTER);
        titleLabel.setPreferredSize(new Dimension(100,200));
        titleLabel.setFont(new Fonts.TitleFont());
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(titleLabel, BorderLayout.NORTH);

        // ID and password input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(new EmptyBorder(50,0,20,0));

        // ID
        JPanel idPanel = new JPanel(new FlowLayout());
        JLabel idLabel = new JLabel("ID");
        idLabel.setFont(new Fonts.ButtonFont());
        idLabel.setPreferredSize(new Dimension(100,30));
        idPanel.add(idLabel);

        inputID = new JTextField(20);
        inputID.addKeyListener(new NoSpaceAdapter());
        inputID.setFont(new Fonts.ContentFont());
        inputID.setPreferredSize(new Dimension(100,30));
        idPanel.add(inputID);

        // PASSWORD
        JPanel pwPanel = new JPanel(new FlowLayout());

        JLabel pwLabel = new JLabel("Password");
        pwLabel.setFont(new Fonts.ButtonFont());
        pwLabel.setPreferredSize(new Dimension(100,30));
        pwPanel.add(pwLabel);
        inputPW = new JPasswordField(20);
        inputPW.addKeyListener(new NoSpaceAdapter());
        inputPW.setFont(new Fonts.ContentFont());
        inputPW.setPreferredSize(new Dimension(100,30));
        pwPanel.add(inputPW);

        JPanel errorPanel = new JPanel(new FlowLayout());
        loginErrorLabel = new JLabel(" ");
        errorPanel.add(loginErrorLabel);

        inputPanel.add(idPanel);
        inputPanel.add(pwPanel);
        inputPanel.add(errorPanel);

        add(inputPanel, BorderLayout.CENTER);

        // Login and register buttons panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        buttonsPanel.setPreferredSize(new Dimension(0,200));
        loginButton = new JButton("Login");
        loginButton.setFont(new Fonts.ButtonFont());
        buttonsPanel.add(loginButton);
        createNewAccountButton = new JButton("Register");
        createNewAccountButton.setFont(new Fonts.ButtonFont());
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
    public String verifyAccount(){
        String inputID = getID();
        String inputPW = getPW();
        if(inputID.equals("")){
            loginErrorLabel.setText("Please Write ID");
            loginErrorLabel.setForeground(Color.RED);
            return null;
        }
        if(inputPW.equals("")){
            loginErrorLabel.setText("Please Write PassWord");
            loginErrorLabel.setForeground(Color.RED);
            return null;
        }

        String nickname = null;
        for(ClientData client : clients){
            if(inputID.equals(client.userID) && inputPW.equals(client.password)){
                nickname = client.nickname;
                break;
            }
        }

        if(nickname==null){
            loginErrorLabel.setText("Please Check Your ID/PW");
            loginErrorLabel.setForeground(Color.RED);
        }
        return nickname;
    }

    public static void main(String[] args){
        MainFrame mf = new MainFrame();
        mf.add(new LoginPanel());
        mf.setVisible(true);
    }
}
