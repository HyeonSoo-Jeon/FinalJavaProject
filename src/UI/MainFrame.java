package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {
    private int mouseX, mouseY;
    private Point prevLocation;

    public MainFrame() {
        // Remove TitleBar
        setUndecorated(true);

        // Custom title
        JPanel titleBar = new JPanel(new BorderLayout());
        titleBar.setBackground(Color.GRAY);

        // Double click to [maximize/restore]
        titleBar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {
                    toggleMaximizeRestore();
                }
            }
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        // Title bar drag
        titleBar.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (getExtendedState() != JFrame.MAXIMIZED_BOTH) {
                    int x = e.getXOnScreen() - mouseX;
                    int y = e.getYOnScreen() - mouseY;
                    setLocation(x, y);
                } else {
                    setExtendedState(JFrame.NORMAL);
                    setLocation(prevLocation);
                }
            }
        });

        // Change button color when mouse is up
        MouseAdapter buttonChangeColor = new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                JButton button = (JButton) e.getSource();
                button.setBackground(Color.LIGHT_GRAY);
                button.setForeground(Color.WHITE);
            }

            public void mouseExited(MouseEvent e) {
                JButton button = (JButton) e.getSource();
                button.setBackground(Color.GRAY);
                button.setForeground(Color.LIGHT_GRAY);
            }
        };
        MouseAdapter XbuttonChangeColor = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton button = (JButton) e.getSource();
                button.setBackground(Color.RED);
                button.setForeground(Color.WHITE);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                JButton button = (JButton) e.getSource();
                button.setBackground(Color.GRAY);
                button.setForeground(Color.LIGHT_GRAY);
            }
        };

        JPopupMenu menuPopup = new JPopupMenu();
        JMenuItem logoutItem = new JMenuItem("Log Out");
        JMenuItem exitItem = new JMenuItem("Exit");

        menuPopup.add(logoutItem);
        menuPopup.add(exitItem);


        ImageIcon img = new ImageIcon("./Source/cat24x24.gif");
        JLabel imgLabel = new JLabel(img);

        // Menu button
        JButton menuButton = new JButton("☰");
        menuButton.setBackground(Color.GRAY);
        menuButton.setForeground(Color.LIGHT_GRAY);
        menuButton.addActionListener(e -> menuPopup.show(menuButton, 0, menuButton.getHeight()));
        menuButton.addMouseListener(buttonChangeColor);


        // Minimize button
        JButton minimizeButton = new JButton("_");
        minimizeButton.setBackground(Color.GRAY);
        minimizeButton.setForeground(Color.LIGHT_GRAY);
        minimizeButton.addActionListener(e -> setState(JFrame.ICONIFIED));
        minimizeButton.addMouseListener(buttonChangeColor);

        // Maximize or Restore button
        JButton maximizeButton = new JButton("□");
        maximizeButton.setBackground(Color.GRAY);
        maximizeButton.setForeground(Color.LIGHT_GRAY);
        maximizeButton.addActionListener(e -> toggleMaximizeRestore());
        maximizeButton.addMouseListener(buttonChangeColor);

        // Close button
        JButton closeButton = new JButton("X");
        closeButton.setBackground(Color.GRAY);
        closeButton.setForeground(Color.LIGHT_GRAY);
        closeButton.addActionListener(e -> System.exit(0));
        closeButton.addMouseListener(XbuttonChangeColor);

        // Add buttons to the title bar
        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftPanel.setBackground(Color.GRAY);
        leftPanel.add(imgLabel);
        leftPanel.add(menuButton);

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.setBackground(Color.GRAY);
        rightPanel.add(minimizeButton);
        rightPanel.add(maximizeButton);
        rightPanel.add(closeButton);

        titleBar.add(leftPanel, BorderLayout.WEST);
        titleBar.add(rightPanel, BorderLayout.EAST);

        // Add title bar to the main frame
        add(titleBar, BorderLayout.NORTH);

        ImageIcon menuIcon = new ImageIcon("./Source/icon48x48.png");
        setIconImage(menuIcon.getImage());



        setSize(1000, 800);
        setResizable(true);
        setLocationRelativeTo(null);
    }

    private void toggleMaximizeRestore() {
        if (getExtendedState() != JFrame.MAXIMIZED_BOTH) {
            prevLocation = getLocation();
            setExtendedState(JFrame.MAXIMIZED_BOTH);
        } else {
            setExtendedState(JFrame.NORMAL);
            setLocation(prevLocation);
        }
    }

    public static void main(String[] args) {
        System.out.println("mainFrame");
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
    }
}
