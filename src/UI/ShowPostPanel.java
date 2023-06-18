package UI;

import DataManager.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class ShowPostPanel extends JPanel {
    public JButton backButton, deleteButton;
    ShowPostPanel(PostData post, String currentNickname){
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();

        topPanel.setBorder(new EmptyBorder(15,50,15,50));
        topPanel.setLayout(new BorderLayout());

        // Cancel Button
        JPanel topLeftPanel = new JPanel();
        topLeftPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        backButton = new JButton("Back");
        backButton.setFont(new Fonts.ButtonFont());
        topLeftPanel.add(backButton);
        topPanel.add(topLeftPanel,BorderLayout.WEST);

        // Post Button
        JPanel topRightPanel = new JPanel();
        topRightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        deleteButton = new JButton("DELETE!");
        deleteButton.setFont(new Fonts.ButtonFont());
        if(!post.nickname.equals(currentNickname)){
            deleteButton.setVisible(false);
        }
        topRightPanel.add(deleteButton);
        topPanel.add(topRightPanel,BorderLayout.EAST);

        add(topPanel,BorderLayout.NORTH);

        // Content
        JPanel centerPanel = new JPanel();
        centerPanel.setBorder(new EmptyBorder(10,50,10,50));
        centerPanel.setLayout(new BorderLayout(10,10));

        JLabel titleLabel = new JLabel(post.title);

        titleLabel.setFont(new Fonts.NoPostFont());
        centerPanel.add(titleLabel,BorderLayout.NORTH);

        String content = post.content.replace("\n", "<br>");
        JLabel contentLabel = new JLabel("<html>"+content+"</html>");
        contentLabel.setBorder(new EmptyBorder(15,15,15,15));
        contentLabel.setVerticalAlignment(JLabel.TOP);
        contentLabel.setFont(new Fonts.ContentFont());
        contentLabel.setBackground(Color.white);
        contentLabel.setOpaque(true);
        JScrollPane contentScrollPane = new JScrollPane(contentLabel);
        contentScrollPane.getVerticalScrollBar().setUnitIncrement(10);
        centerPanel.add(contentScrollPane, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        // comments
        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.setBorder(new EmptyBorder(0,50,50,50));
        southPanel.setLayout(new BorderLayout(10,10));

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setLayout(new BorderLayout(10,10));
        JLabel writerNicknameLabel = new JLabel(currentNickname);
        writerNicknameLabel.setFont(new Fonts.ContentFont());
        JTextField commentField = new JTextField();
        commentField.setFont(new Fonts.ContentFont());
        JButton commentButton = new JButton("Comment!");
        commentButton.setFont(new Fonts.ButtonFont());
        inputPanel.add(writerNicknameLabel, BorderLayout.WEST);
        inputPanel.add(commentField, BorderLayout.CENTER);
        inputPanel.add(commentButton, BorderLayout.EAST);
        southPanel.add(inputPanel, BorderLayout.NORTH);

        JPanel commentsPanel = new JPanel();
        commentsPanel.setPreferredSize(new Dimension(100,200));

        // no post
        if(post.comments.size()==0){
            commentsPanel.setLayout(new GridBagLayout());
            commentsPanel.add(new JLabel("There are no comments!"),new GridBagConstraints());
            southPanel.add(commentsPanel,BorderLayout.SOUTH);
        }
        else{
            commentsPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(10,50,10,50);

            for(CommentData comment : post.comments){
                JPanel commentPanel = new JPanel(new BorderLayout());

                JLabel nicknameLabel = new JLabel(comment.nickname);
                nicknameLabel.setFont(new Fonts.ContentFont());
                JLabel commentLabel = new JLabel(comment.content);
                commentLabel.setFont(new Fonts.ContentFont());
                commentPanel.add(nicknameLabel);
                commentPanel.add((commentLabel));
                commentsPanel.add(commentPanel,gbc);
            }
            GridBagConstraints gbcEmpty = new GridBagConstraints();
            gbcEmpty.gridwidth = GridBagConstraints.REMAINDER;
            gbcEmpty.weighty =1;
            gbcEmpty.fill = GridBagConstraints.VERTICAL;
            commentsPanel.add(Box.createVerticalGlue(),gbcEmpty);

            JScrollPane scrollPane = new JScrollPane(commentsPanel);
            southPanel.add(scrollPane, BorderLayout.CENTER);
        }
        add(southPanel, BorderLayout.SOUTH);

    }

    public void deletePost(int idx){
        ArrayList<PostData> posts = PostDataManager.loadPostData();
        posts.remove(idx);
        PostDataManager.savePostData(posts);
        System.out.println("Post Deleted!");
    }

    public static void main(String[] args){
        PostData post = new PostData("title","nickname","hi my name is nickname~!");
        CommentData commentData = new CommentData("hi", "hi");
        for(int i = 0 ; i<10;i++){
            post.comments.add(commentData);

        }
        MainFrame mf = new MainFrame();
        mf.add(new ShowPostPanel(post, "nikckname"));
        mf.setVisible(true);
    }

}
