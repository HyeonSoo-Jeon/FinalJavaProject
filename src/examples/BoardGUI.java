package examples;

import javax.swing.*;
import java.awt.*;

public class BoardGUI {

    public static void main(String[] args) {
        // Create the JFrame
        JFrame frame = new JFrame("게시판 GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Create the main JPanel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Create the [post] button and add it to north of the mainPanel
        JButton postBtn = new JButton("post");
        mainPanel.add(postBtn, BorderLayout.NORTH);

        // Create a JPanel for posts and set GridLayout with a minimum row height
        JPanel postsPanel = new JPanel();
        postsPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        for (int i = 0; i < 3; i++) { // Replace with the actual number of posts
            JPanel post = new JPanel(new GridLayout(3, 1));
            post.setPreferredSize(new Dimension(0, 50));
            post.add(new JLabel("Title " + (i + 1)));
            post.add(new JLabel("Nickname " + (i + 1)));
            post.add(new JLabel("Content " + (i + 1)));
            postsPanel.add(post, gbc);
        }

        GridBagConstraints gbcGlue = new GridBagConstraints();
        gbcGlue.gridwidth = GridBagConstraints.REMAINDER;
        gbcGlue.weighty = 1;
        gbcGlue.fill = GridBagConstraints.VERTICAL;
        postsPanel.add(Box.createVerticalGlue(), gbcGlue); // Add empty space

        // Create a JScrollPane and add the postsPanel
        JScrollPane scrollPane = new JScrollPane(postsPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
