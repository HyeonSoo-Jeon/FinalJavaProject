package UI;

import CustomAdapter.TitleLimitAdapter;
import DataManager.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class CreatePostPanel extends JPanel {
    public JButton cancelButton, postButton;
    JTextField titleField;
    JTextArea contentField;
    String nickname;
    CreatePostPanel(String nickname){
        this.nickname = nickname;
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setBorder(new EmptyBorder(15,50,15,50));
        topPanel.setLayout(new BorderLayout());

        // Cancel Button
        JPanel topLeftPanel = new JPanel();
        topLeftPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Fonts.ContentBoldFont());
        topLeftPanel.add(cancelButton);
        topPanel.add(topLeftPanel,BorderLayout.WEST);

        // Post Button
        JPanel topRightPanel = new JPanel();
        topRightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        postButton = new JButton("POST !");
        postButton.setFont(new Fonts.ContentBoldFont());
        topRightPanel.add(postButton);
        topPanel.add(topRightPanel,BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);


        JPanel centerPanel = new JPanel();
        centerPanel.setBorder(new EmptyBorder(10,50,50,50));
        centerPanel.setLayout(new BorderLayout(10,10));

        titleField = new JTextField("Write Title Here!");
        titleField.setBorder(new EmptyBorder(5,15,5,15));
        titleField.setFont(new Fonts.TitleFont());
        titleField.addKeyListener(new TitleLimitAdapter());
        centerPanel.add(titleField,BorderLayout.NORTH);

        contentField = new JTextArea("Write Content Here!");
        contentField.setBorder(new EmptyBorder(15,15,15,15));
        contentField.setFont(new Fonts.ContentFont());
        contentField.setBackground(Color.white);
        contentField.setLineWrap(true);
        contentField.setOpaque(true);


        JScrollPane contentScrollPane = new JScrollPane(contentField);
        centerPanel.add(contentScrollPane, BorderLayout.CENTER);

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
}
