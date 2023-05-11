package examples.CustomTitleBar;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class CustomTitleBar extends JFrame {
    private JFrame mainFrame;
    private int mouseX, mouseY;
    private Point prevLocation;

    public CustomTitleBar() {
        mainFrame = new JFrame();
        // 타이틀바 제거
        mainFrame.setUndecorated(true);
        // 최소 크기 지정
        mainFrame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                mainFrame.setMinimumSize(new Dimension(500, 500));
            }
        });

        // Custom title bar panel
        JPanel titleBar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        // titleBar.setBorder(new LineBorder(Color.BLACK));
        titleBar.setBackground(Color.GRAY);

        // Double click to maximize/restore
        // 더블클릭 사이즈 변경
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

        // Dragging the window only works in normal state
        // 타이틀바 드래그
        titleBar.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (mainFrame.getExtendedState() != JFrame.MAXIMIZED_BOTH) {
                    int x = e.getXOnScreen() - mouseX;
                    int y = e.getYOnScreen() - mouseY;
                    mainFrame.setLocation(x, y);
                } else {
                    mainFrame.setExtendedState(JFrame.NORMAL);
                    mainFrame.setLocation(prevLocation);
                }
            }
        });

        // 마우스 색깔 바꾸는 리스너
        MouseAdapter buttonMouseListener = new MouseAdapter() {
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

        // Minimize button
        JButton minimizeButton = new JButton("_");
        minimizeButton.setBackground(Color.GRAY);
        minimizeButton.setForeground(Color.LIGHT_GRAY);
        minimizeButton.addActionListener(e -> mainFrame.setState(JFrame.ICONIFIED));
        minimizeButton.addMouseListener(buttonMouseListener);

        // Maximize or Restore button
        JButton maximizeButton = new JButton("□");
        maximizeButton.setBackground(Color.GRAY);
        maximizeButton.setForeground(Color.LIGHT_GRAY);
        maximizeButton.addActionListener(e -> toggleMaximizeRestore());
        maximizeButton.addMouseListener(buttonMouseListener);

        // Close button
        JButton closeButton = new JButton("X");
        closeButton.setBackground(Color.GRAY);
        closeButton.setForeground(Color.LIGHT_GRAY);
        closeButton.addActionListener(e -> System.exit(0));
        closeButton.addMouseListener(buttonMouseListener);

        // Add buttons to the title bar
        titleBar.add(minimizeButton);
        titleBar.add(maximizeButton);
        titleBar.add(closeButton);

        // Add title bar to the main frame
        mainFrame.add(titleBar, BorderLayout.NORTH);

        // Main panel containing three buttons
        JPanel mainPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        mainPanel.add(new JButton("Button 1"));
        mainPanel.add(new JButton("Button 2"));
        mainPanel.add(new JButton("Button 3"));

        // Add main panel to the main frame
        mainFrame.add(mainPanel, BorderLayout.CENTER);

        // Display the main frame
        mainFrame.setSize(300, 200);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    private void toggleMaximizeRestore() {
        if (mainFrame.getExtendedState() != JFrame.MAXIMIZED_BOTH) {
            prevLocation = mainFrame.getLocation();
            mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        } else {
            mainFrame.setExtendedState(JFrame.NORMAL);
            mainFrame.setLocation(prevLocation);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CustomTitleBar());
    }
}
