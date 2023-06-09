package examples;

import javax.swing.*;
import java.awt.*;

public class GifExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("GIF Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        // GIF 파일을 이미지 아이콘으로 읽어서 레이블에 추가
        ImageIcon gifIcon = new ImageIcon("./Source/cat.gif");
        JLabel gifLabel = new JLabel(gifIcon);
        frame.getContentPane().add(gifLabel);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
