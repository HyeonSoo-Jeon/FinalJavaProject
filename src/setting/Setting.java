package setting;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Setting extends JFrame{

    private static JFrame mainFrame;
    private static int mouseX;
    private static int mouseY;

    public static void CustomTitleBar() {
        mainFrame = new JFrame();
        mainFrame.setUndecorated(true);

        // Custom title bar panel
        JPanel titleBar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        titleBar.setBorder(new LineBorder(Color.BLACK));

        // Add MouseListener for dragging the window
        titleBar.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        titleBar.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen() - mouseX;
                int y = e.getYOnScreen() - mouseY;
                mainFrame.setLocation(x, y);
            }
        });

        // Minimize button
        JButton minimizeButton = new JButton("_");
        minimizeButton.addActionListener(e -> mainFrame.setState(JFrame.ICONIFIED));

        // Maximize or Restore button
        JButton maximizeButton = new JButton("□");
        maximizeButton.addActionListener(e -> {
            if (mainFrame.getExtendedState() != JFrame.MAXIMIZED_BOTH) {
                mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            } else {
                mainFrame.setExtendedState(JFrame.NORMAL);
            }
        });

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
    public Setting(){
        // 데이터 경로가 생성되지 않은 경우
        if(!InitData.initPath()){
            System.err.println();
        }
        // UserInfo.dat파일이 생성되지 않은 경우
        if(!InitData.initDataFile()){
            System.err.println();
        }
    }

    public static void main(String[] args){

        new Setting();
        SwingUtilities.invokeLater(() -> CustomTitleBar());
    }
}
