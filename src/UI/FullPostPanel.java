package UI;

import DataManager.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class FullPostPanel extends JPanel {
    public JButton createPostButton;
    public ArrayList<JPanel> postPanels;
    ArrayList<PostData> posts;

    FullPostPanel(){
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setBorder(new EmptyBorder(15,15,15,15));
        topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // post button
        createPostButton = new JButton("Create POST!");
        createPostButton.setFont(new Fonts.ButtonFont());
        topPanel.add(createPostButton);
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();

        posts = null;
        posts = PostDataManager.loadPostData();
        postPanels = new ArrayList<>();
        // no post
        if(posts==null || posts.size()==0){
            centerPanel.setLayout(new GridBagLayout());
            JLabel noPostLabel = new JLabel("There are no posts!");
            noPostLabel.setFont(new Fonts.NoPostFont());
            centerPanel.add(noPostLabel,new GridBagConstraints());
            add(centerPanel,BorderLayout.CENTER);
        }
        else{
            centerPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(10,50,10,50);

            for(PostData post : posts) {
                JPanel postPanel = new JPanel();

                postPanel.setLayout(new BorderLayout(0,10));
                postPanel.setPreferredSize(new Dimension(0,100));
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
                centerPanel.add(postPanel, gbc);
                postPanels.add(postPanel);
            }
            // fill Empty Space
            GridBagConstraints gbcEmpty = new GridBagConstraints();
            gbcEmpty.gridwidth = GridBagConstraints.REMAINDER;
            gbcEmpty.weighty =1;
            gbcEmpty.fill = GridBagConstraints.VERTICAL;
            centerPanel.add(Box.createVerticalGlue(),gbcEmpty);

            centerPanel.add(new JLabel());
            JScrollPane scrollPane = new JScrollPane(centerPanel);
            scrollPane.getVerticalScrollBar().setUnitIncrement(10);
            add(scrollPane, BorderLayout.CENTER);

        }
    }

    public static void main(String[] args){
        MainFrame mf = new MainFrame();
        mf.add(new FullPostPanel());
        mf.setVisible(true);
    }

}
