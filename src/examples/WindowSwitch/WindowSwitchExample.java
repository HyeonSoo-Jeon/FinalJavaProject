package examples.WindowSwitch;

import javax.swing.*;
import java.awt.event.*;

public class WindowSwitchExample {
    public static void main(String[] args) {
        // Create the first frame
        JFrame frame1 = new JFrame("First Window");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(300, 200);

        // Create a button that switches to the second window
        JButton button = new JButton("Switch to Second Window");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create the second frame
                JFrame frame2 = new JFrame("Second Window");
                frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // dispose on close
                frame2.setSize(300, 200);

                // Add window listener to show the first frame when the second frame is closed
                frame2.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        frame1.setVisible(true);
                    }
                });

                // Set the second frame's location to the first frame's location
                frame2.setLocation(frame1.getLocation());

                // Hide the first frame and show the second frame
                frame1.setVisible(false);
                frame2.setVisible(true);
            }
        });

        // Add the button to the first frame
        frame1.getContentPane().add(button);

        // Display the first frame
        frame1.setVisible(true);
    }
}
