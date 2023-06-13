package PostUI;

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
    LogIn logIn;
    CreateAccountPanel createAccountPanel;
    FullPostPanel fullPostPanel;
    ShowPostPanel showPostPanel;
    CreatePostPanel createPostPanel;

    public MainGUI() {
        post = new PostData("Temp","nickname","Temp");

        mainFrame = new MainFrame();
        cardLayout = new CardLayout();
        container = new JPanel(cardLayout);

        logIn = new LogIn();
        createAccountPanel = new CreateAccountPanel();
        createPostPanel = new CreatePostPanel(currentNickname);

        container.add(logIn,"LogIn");
        container.add(createAccountPanel,"CreateAccountPanel");


        buttonMapping();

        mainFrame.getContentPane().add(container);
        mainFrame.setVisible(true);
    }

    void buttonMapping(){
        logIn.loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //currentNickname = logIn.verifyAccount();
                currentNickname = "nickname";
                fullPostPanel = new FullPostPanel();
                container.add(fullPostPanel, "FullPostPanel");
                fullPostPanelButtonMapping();
                cardLayout.show(container, "FullPostPanel");
            }
        });
        logIn.createNewAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(container, "CreateAccountPanel");
            }
        });
        createAccountPanel.cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(container, "LogIn");
            }
        });
    }
    void fullPostPanelButtonMapping(){
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
                    showPostPanelButtonMapping();
                    container.add(showPostPanel, "ShowPostPanel");
                    cardLayout.show(container, "ShowPostPanel");

                }
            });
        }
    }

    void showPostPanelButtonMapping(){
        showPostPanel.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fullPostPanel = new FullPostPanel();
                container.add(fullPostPanel, "FullPostPanel");
                fullPostPanelButtonMapping();
                cardLayout.show(container, "FullPostPanel");
            }
        });
        showPostPanel.deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPostPanel.deletePost(idx);
                fullPostPanel = new FullPostPanel();
                container.add(fullPostPanel, "FullPostPanel");
                fullPostPanelButtonMapping();
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
                fullPostPanelButtonMapping();
                cardLayout.show(container, "FullPostPanel");
            }
        });

        createPostPanel.postButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createPostPanel.savePost();
                fullPostPanel = new FullPostPanel();
                container.add(fullPostPanel, "FullPostPanel");
                fullPostPanelButtonMapping();
                cardLayout.show(container, "FullPostPanel");
            }
        });
    }
    public static void main(String[] args){
        MainGUI mg = new MainGUI();
    }
}
