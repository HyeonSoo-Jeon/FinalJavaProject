package PostUI;

import DataManager.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreatePostPanel extends JPanel {
    public JButton cancelButton, postButton;
    JTextField titleField, contentField;
    String nickname;
    CreatePostPanel(String nickname){
        this.nickname = nickname;
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setBorder(new EmptyBorder(10,10,10,10));
        topPanel.setLayout(new BorderLayout());

        // Cancel Button
        JPanel topLeftPanel = new JPanel();
        topLeftPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        cancelButton = new JButton("Cancel");
        topLeftPanel.add(cancelButton);
        topPanel.add(topLeftPanel,BorderLayout.WEST);

        // Post Button
        JPanel topRightPanel = new JPanel();
        topRightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        postButton = new JButton("POST!");
        topRightPanel.add(postButton);
        postButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                savePost();
            }
        });
        topPanel.add(topRightPanel,BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);


        JPanel centerPanel = new JPanel();
        centerPanel.setBorder(new EmptyBorder(10,50,50,50));
        centerPanel.setLayout(new BorderLayout(10,10));
        titleField = new JTextField("Write Title Here!");
        centerPanel.add(titleField,BorderLayout.NORTH);
        contentField = new JTextField("Write Content Here!");
        contentField.setBackground(Color.white);
        contentField.setBorder(new EmptyBorder(15,15,15,15));
        contentField.setOpaque(true);
        centerPanel.add(contentField, BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);

    }

    public void savePost(){
        PostData post = new PostData(titleField.getText(),nickname,contentField.getText());
        ArrayList<PostData> posts = PostDataManager.loadPostData();
        if(posts == null) {
            posts = new ArrayList<>();
        }
        posts.add(0,post);
        PostDataManager.savePostData(posts);
        System.out.println("post!");
    }

    public static void main(String[] args){
        MainFrame mf = new MainFrame();
        mf.add(new CreatePostPanel("nickname"));
        mf.setVisible(true);
    }

}
