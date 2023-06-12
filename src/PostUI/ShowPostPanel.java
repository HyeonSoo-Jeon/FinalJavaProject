package PostUI;

import DataManager.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class ShowPostPanel extends JPanel {
    public JButton createPostButton;
    ShowPostPanel(){
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // post button
        createPostButton = new JButton("Create POST!");
        topPanel.add(createPostButton);
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();

        ArrayList<PostData> posts = null;
        posts = PostDataManager.loadPostData();
        // no post
        if(posts==null){
            centerPanel.setLayout(new GridBagLayout());
            centerPanel.add(new JLabel("There are no posts!"),new GridBagConstraints());
            add(centerPanel,BorderLayout.CENTER);
        }
        else{
            centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
            for(PostData post : posts) {
                JPanel postPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                postPanel.setPreferredSize(new Dimension(50,50));
                JPanel titlePanel = new JPanel(new FlowLayout());

                JLabel titleLabel = new JLabel(post.title);
                JLabel nicknameLabel = new JLabel(post.nickname);
                titlePanel.add(titleLabel);
                titlePanel.add(nicknameLabel);
                postPanel.add(titlePanel, BorderLayout.NORTH);

                // protect to many "enter"
                int end = Math.min(post.content.length(), 30);
                String content = post.content.substring(0, end).replace('\n', ' ');
                JLabel contentLabel = new JLabel(content);
                postPanel.add(contentLabel, BorderLayout.CENTER);
                centerPanel.add(postPanel);
                System.out.println(post.title + " / " + post.content);
            }
            JScrollPane scrollPane = new JScrollPane(centerPanel);
            add(scrollPane, BorderLayout.CENTER);

        }

    }

    public static void main(String[] args){
        MainFrame mf = new MainFrame();
        mf.add(new ShowPostPanel());
        mf.setVisible(true);
    }

}
