package UI;

import DataManager.PostData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainGUI {

    String currentNickname;
    int idx;
    PostData post;

    MainFrame mainFrame;
    CardLayout cardLayout;
    JPanel container;
    LoginPanel loginPanel;
    CreateAccountPanel createAccountPanel;
    FullPostPanel fullPostPanel;
    ShowPostPanel showPostPanel;
    CreatePostPanel createPostPanel;

    public MainGUI() {

        mainFrame = new MainFrame();
        cardLayout = new CardLayout();
        container = new JPanel(cardLayout);

        loginPanel = new LoginPanel();

        container.add(loginPanel,"LoginPanel");

        initLoginActionListeners();

        mainFrame.getContentPane().add(container);
        mainFrame.setVisible(true);
    }

    void initLoginActionListeners(){
        loginPanel.loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentNickname = loginPanel.verifyAccount();
                if(currentNickname!=null){
                    fullPostPanel = new FullPostPanel();
                    container.add(fullPostPanel, "FullPostPanel");
                    initFullPostPanelActionListeners();
                    cardLayout.show(container, "FullPostPanel");
                }
            }
        });
        loginPanel.createNewAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAccountPanel = new CreateAccountPanel();
                container.add(createAccountPanel, "CreateAccountPanel");
                initCreateAccountPanelActionListeners();
                cardLayout.show(container, "CreateAccountPanel");
            }
        });
    }
    void initCreateAccountPanelActionListeners(){
        createAccountPanel.cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginPanel = new LoginPanel();
                container.add(loginPanel,"LoginPanel");
                initLoginActionListeners();
                cardLayout.show(container, "LoginPanel");
            }
        });
        createAccountPanel.registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(createAccountPanel.saveNewAccount()) {
                    loginPanel = new LoginPanel();
                    container.add(loginPanel, "LoginPanel");
                    initLoginActionListeners();
                    cardLayout.show(container, "LoginPanel");
                }
            }
        });
    }
    void initFullPostPanelActionListeners(){
        fullPostPanel.createPostButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createPostPanel = new CreatePostPanel(currentNickname);
                createPostPanelButtonMapping();
                container.add(createPostPanel, "CreatePostPanel");
                cardLayout.show(container, "CreatePostPanel");
            }
        });

        for(JPanel postPanel : fullPostPanel.postPanels){
            postPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    idx = fullPostPanel.postPanels.indexOf(postPanel);
                    post = fullPostPanel.posts.get(idx);
                    System.out.println(post.title + "/" + post.nickname);
                    showPostPanel = new ShowPostPanel(post,idx,currentNickname);
                    initShowPostPanelActionListeners();
                    container.add(showPostPanel, "ShowPostPanel");
                    cardLayout.show(container, "ShowPostPanel");

                }
            });
        }
    }

    void initShowPostPanelActionListeners(){
        showPostPanel.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fullPostPanel = new FullPostPanel();
                container.add(fullPostPanel, "FullPostPanel");
                initFullPostPanelActionListeners();
                cardLayout.show(container, "FullPostPanel");
            }
        });
        showPostPanel.deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPostPanel.deletePost(idx);
                fullPostPanel = new FullPostPanel();
                container.add(fullPostPanel, "FullPostPanel");
                initFullPostPanelActionListeners();
                cardLayout.show(container, "FullPostPanel");
            }
        });
    }
    void createPostPanelButtonMapping(){
        createPostPanel.cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fullPostPanel = new FullPostPanel();
                container.add(fullPostPanel, "FullPostPanel");
                initFullPostPanelActionListeners();
                cardLayout.show(container, "FullPostPanel");
            }
        });

        createPostPanel.postButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createPostPanel.savePost();
                fullPostPanel = new FullPostPanel();
                container.add(fullPostPanel, "FullPostPanel");
                initFullPostPanelActionListeners();
                cardLayout.show(container, "FullPostPanel");
            }
        });
    }
    public static void main(String[] args){
        MainGUI mg = new MainGUI();
    }
}
