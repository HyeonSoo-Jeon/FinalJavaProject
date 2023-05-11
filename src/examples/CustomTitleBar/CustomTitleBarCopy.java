package examples.CustomTitleBar;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomTitleBarCopy extends JFrame {
    private JFrame mainFrame;
    private int mouseX, mouseY;
    private Point prevLocation;

    public CustomTitleBarCopy() {
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
        titleBar.setBorder(new LineBorder(Color.BLACK));
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

        // Minimize button
        JButton minimizeButton = new JButton("-");
        minimizeButton.addActionListener(e -> mainFrame.setState(JFrame.ICONIFIED));

        // Maximize or Restore button
        JButton maximizeButton = new JButton("[]");
        maximizeButton.addActionListener(e -> toggleMaximizeRestore());

        // Close button
        JButton closeButton = new JButton("X");
        closeButton.addActionListener(e -> System.exit(0));

        // Add buttons to the title bar
        titleBar.add(minimizeButton);
        titleBar.add(maximizeButton);
        titleBar.add(closeButton);

        // Add title bar to the main frame
        mainFrame.add(titleBar, BorderLayout.NORTH);

        // Main panel containing three buttons
        JPanel mainPanel = new JPanel(new GridLayout(3, 1));
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
        SwingUtilities.invokeLater(() -> new CustomTitleBarCopy());
    }
}
