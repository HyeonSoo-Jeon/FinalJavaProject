package examples.ContentPaneSwitchEx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContentPaneSwitchExample {
    public static void main(String[] args) {
        // Create JFrame instance
        JFrame frame = new JFrame("ContentPane Switch Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create CardLayout instance
        CardLayout cardLayout = new CardLayout();
        JPanel container = new JPanel(cardLayout);

        // Panel 1
        JPanel panel1 = new JPanel(new GridBagLayout());
        JButton switchButton1 = new JButton("Switch to Panel 2");
        panel1.add(switchButton1);

        // Panel 2
        JPanel panel2 = new JPanel(new GridBagLayout());
        JButton switchButton2 = new JButton("Switch to Panel 1");
        panel2.add(switchButton2);

        // Add panels to the container
        container.add(panel1, "Panel 1");
        container.add(panel2, "Panel 2");

        // Add action listeners for the buttons
        switchButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(container, "Panel 2");
            }
        });

        switchButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(container, "Panel 1");
            }
        });

        // Add container to JFrame and display
        frame.getContentPane().add(container);
        frame.setVisible(true);
    }
}
