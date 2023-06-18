package UI;

import DataManager.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class ShowPostPanel extends JPanel {
    public JButton backButton, deleteButton, commentButton;
    JTextField commentField;
    PostData post;

    ShowPostPanel(PostData post, String currentNickname){
        this.post = post;

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
        southPanel.setPreferredSize(new Dimension(100,250));
        southPanel.setBorder(new EmptyBorder(0,50,50,50));
        southPanel.setLayout(new BorderLayout(10,10));

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setLayout(new BorderLayout(10,10));

        JLabel writerNicknameLabel = new JLabel(currentNickname);
        writerNicknameLabel.setFont(new Fonts.ContentFont());

        commentField = new JTextField();
        commentField.setFont(new Fonts.ContentBoldFont());

        commentButton = new JButton("Comment!");
        commentButton.setFont(new Fonts.ButtonFont());

        inputPanel.add(writerNicknameLabel, BorderLayout.WEST);
        inputPanel.add(commentField, BorderLayout.CENTER);
        inputPanel.add(commentButton, BorderLayout.EAST);
        southPanel.add(inputPanel, BorderLayout.NORTH);


        JPanel commentsListPanel = new JPanel();
        commentsListPanel.setLayout(new GridBagLayout());

        // no post
        if(post.comments.size()==0){
            commentsListPanel.add(new JLabel("There are no comments!"),new GridBagConstraints());
            southPanel.add(commentsListPanel,BorderLayout.SOUTH);
        }
        else{
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(10,10,10,10);

            for(CommentData comment : post.comments){
                JPanel commentPanel = new JPanel(new BorderLayout(10,0));

                JLabel nicknameLabel = new JLabel(comment.nickname);
                nicknameLabel.setFont(new Fonts.ContentBoldFont());

                JLabel commentLabel = new JLabel(comment.content);
                commentLabel.setFont(new Fonts.ContentFont());

                commentPanel.add(nicknameLabel, BorderLayout.WEST);
                commentPanel.add(commentLabel, BorderLayout.CENTER);

                commentsListPanel.add(commentPanel,gbc);
            }

            GridBagConstraints gbcEmpty = new GridBagConstraints();
            gbcEmpty.gridwidth = GridBagConstraints.REMAINDER;
            gbcEmpty.weighty = 1;
            gbcEmpty.fill = GridBagConstraints.VERTICAL;
            commentsListPanel.add(Box.createVerticalGlue(),gbcEmpty);

            JScrollPane scrollPane = new JScrollPane(commentsListPanel);
            scrollPane.getVerticalScrollBar().setUnitIncrement(10);
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

    public String getComment(){
        return commentField.getText();
    }
    public PostData getPost(){
        return post;
    }
    public static void main(String[] args){
        PostData post = new PostData("title","nickname","hi my name is nickname~!");
        CommentData commentData = new CommentData("hi", "875hi");
        for(int i = 0 ; i<2;i++){
            post.comments.add(commentData);

        }
        MainFrame mf = new MainFrame();
        mf.add(new ShowPostPanel(post, "nikckname"));
        mf.setVisible(true);
    }

}
