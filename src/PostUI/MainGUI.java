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
        showPostPanel = new ShowPostPanel(post,idx,currentNickname);
        createPostPanel = new CreatePostPanel(currentNickname);

        container.add(logIn,"LogIn");
        container.add(createAccountPanel,"CreateAccountPanel");
        container.add(showPostPanel, "ShowPostPanel");

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
        createAccountPanel.confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

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

        for(int i = 0 ; i < fullPostPanel.postPanels.size();i++){
            JPanel postPanel = fullPostPanel.postPanels.get(i);
            int finalI = i;
            postPanel.addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    idx = finalI;
                    post = fullPostPanel.posts.get(finalI);
                    cardLayout.show(container, "ShowPostPanel");
                }
            });

        }
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
