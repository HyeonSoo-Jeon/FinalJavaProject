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
        backButton.setFont(new Fonts.ContentBoldFont());
        topLeftPanel.add(backButton);
        topPanel.add(topLeftPanel,BorderLayout.WEST);

        // Post Button
        JPanel topRightPanel = new JPanel();
        topRightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        deleteButton = new JButton("DELETE !");
        deleteButton.setFont(new Fonts.ContentBoldFont());

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

        // Title
        JLabel titleLabel = new JLabel(post.title);
        titleLabel.setFont(new Fonts.TitleFont());
        centerPanel.add(titleLabel,BorderLayout.NORTH);

        // Content
        String content = post.content;
        JTextArea contentArea = new JTextArea(content);
        contentArea.setLineWrap(true);
        contentArea.setEditable(false);
        contentArea.setBorder(new EmptyBorder(15,15,15,15));
        contentArea.setFont(new Fonts.ContentFont());
        contentArea.setBackground(Color.white);
        contentArea.setOpaque(true);

        JScrollPane contentScrollPane = new JScrollPane(contentArea);
        contentScrollPane.getVerticalScrollBar().setUnitIncrement(10);
        centerPanel.add(contentScrollPane, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        // Comments
        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.setPreferredSize(new Dimension(100,250));
        southPanel.setBorder(new EmptyBorder(0,50,50,50));
        southPanel.setLayout(new BorderLayout(10,10));

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setLayout(new BorderLayout(10,10));

        JLabel writerNicknameLabel = new JLabel(currentNickname);
        writerNicknameLabel.setFont(new Fonts.ContentBoldFont());

        commentField = new JTextField();
        commentField.setFont(new Fonts.ContentFont());

        commentButton = new JButton("Comment !");
        commentButton.setFont(new Fonts.ContentBoldFont());

        inputPanel.add(writerNicknameLabel, BorderLayout.WEST);
        inputPanel.add(commentField, BorderLayout.CENTER);
        inputPanel.add(commentButton, BorderLayout.EAST);
        southPanel.add(inputPanel, BorderLayout.NORTH);

        // Comment List
        JPanel commentsListPanel = new JPanel();
        commentsListPanel.setLayout(new GridBagLayout());

        // no post
        if(post.comments.size()==0){
            commentsListPanel.add(new JLabel("There are no comments!"),new GridBagConstraints());
            southPanel.add(commentsListPanel,BorderLayout.CENTER);
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

}
