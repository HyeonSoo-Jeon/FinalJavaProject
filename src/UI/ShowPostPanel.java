package UI;

import DataManager.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class ShowPostPanel extends JPanel {
    public JButton backButton, deleteButton;
    ShowPostPanel(PostData post, int idx, String currentNickname){
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();


        topPanel.setBorder(new EmptyBorder(10,10,10,10));
        topPanel.setLayout(new BorderLayout());

        // Cancel Button
        JPanel topLeftPanel = new JPanel();
        topLeftPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        backButton = new JButton("Back");
        topLeftPanel.add(backButton);
        topPanel.add(topLeftPanel,BorderLayout.WEST);

        // Post Button
        JPanel topRightPanel = new JPanel();
        topRightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        deleteButton = new JButton("DELETE!");
        if(!post.nickname.equals(currentNickname)){
            deleteButton.setVisible(false);
        }
        topRightPanel.add(deleteButton);
        topPanel.add(topRightPanel,BorderLayout.EAST);



        add(topPanel,BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setBorder(new EmptyBorder(10,50,50,50));
        centerPanel.setLayout(new BorderLayout(10,10));
        JLabel titleLabel = new JLabel(post.title);
        centerPanel.add(titleLabel,BorderLayout.NORTH);
        JLabel contentLabel = new JLabel(post.content);
        contentLabel.setBackground(Color.white);
        contentLabel.setVerticalAlignment(JLabel.TOP);
        contentLabel.setBorder(new EmptyBorder(15,15,15,15));
        contentLabel.setOpaque(true);
        centerPanel.add(contentLabel, BorderLayout.CENTER);


        JPanel southPanel = new JPanel();
        southPanel.setPreferredSize(new Dimension(100,200));

        // no post
        if(post.comments.size()==0){
            southPanel.setLayout(new GridBagLayout());
            southPanel.add(new JLabel("There are no comments!"),new GridBagConstraints());
            centerPanel.add(southPanel,BorderLayout.SOUTH);
        }
        else{
            southPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
            for(CommentData comment : post.comments){
                JPanel commentPanel = new JPanel(new BorderLayout());

                JLabel nickname = new JLabel(comment.nickname);
                JLabel commentLabel = new JLabel(comment.content);
                commentPanel.add(contentLabel, BorderLayout.CENTER);

                JScrollPane scrollPane = new JScrollPane(centerPanel);
                centerPanel.add(scrollPane, BorderLayout.SOUTH);
            }
        }
        add(centerPanel, BorderLayout.CENTER);

    }

    public void deletePost(int idx){
        ArrayList<PostData> posts = PostDataManager.loadPostData();
        posts.remove(idx);
        PostDataManager.savePostData(posts);
        System.out.println("Post Deleted!");
    }

    public static void main(String[] args){
        PostData post = new PostData("title","nickname","hi my name is nickname~!");
        MainFrame mf = new MainFrame();
        mf.add(new ShowPostPanel(post, 1,"nikckname"));
        mf.setVisible(true);
    }

}
