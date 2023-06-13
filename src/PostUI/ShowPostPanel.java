package PostUI;

import DataManager.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class ShowPostPanel extends JPanel {
    public JButton createPostButton;
    public ArrayList<JPanel> postPanels;
    ArrayList<PostData> posts;
    String currentNickname;
    ShowPostPanel(String currentNickname){
        this.currentNickname = currentNickname;
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // post button
        createPostButton = new JButton("Create POST!");
        topPanel.add(createPostButton);
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();

        posts = null;
        posts = PostDataManager.loadPostData();
        postPanels = new ArrayList<>();
        // no post
        if(posts==null){
            centerPanel.setLayout(new GridBagLayout());
            centerPanel.add(new JLabel("There are no posts!"),new GridBagConstraints());
            add(centerPanel,BorderLayout.CENTER);
        }
        else{
            centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
            centerPanel.setBorder(new EmptyBorder(50,50,50,50));

            for(PostData post : posts) {
                JPanel postPanel = new JPanel();

                postPanel.setLayout(new BorderLayout(0,10));
                postPanel.setPreferredSize(new Dimension(800,100));
                postPanel.setBackground(Color.white);
                postPanel.setOpaque(true);
                postPanel.setBorder(new LineBorder(Color.BLACK,1));

                JPanel titlePanel = new JPanel();
                titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

                JLabel titleLabel = new JLabel(post.title);
                JLabel nicknameLabel = new JLabel(post.nickname);
                titlePanel.add(titleLabel);
                titlePanel.add(nicknameLabel);
                postPanel.add(titlePanel,BorderLayout.NORTH);

                // protect to many "enter"
                int end = Math.min(post.content.length(), 30);
                String content = post.content.substring(0, end).replace('\n', ' ');
                JLabel contentLabel = new JLabel(content);
                contentLabel.setVerticalAlignment(JLabel.TOP);
                contentLabel.setBorder(new EmptyBorder(0,15,0,15));
                postPanel.add(contentLabel,BorderLayout.CENTER);
                centerPanel.add(postPanel);
                postPanels.add(postPanel);
                centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

                System.out.println(post.title + " / " + post.content);
            }
            JScrollPane scrollPane = new JScrollPane(centerPanel);
            scrollPane.getVerticalScrollBar().setUnitIncrement(10);
            add(scrollPane, BorderLayout.CENTER);

        }
    }

    public PostData getPost(int idx){
        return posts.get(idx);
    }

    public String getCurrentNickname(){
        return currentNickname;
    }

    public static void main(String[] args){
        MainFrame mf = new MainFrame();
        mf.add(new ShowPostPanel("nickname"));
        mf.setVisible(true);
    }

}
