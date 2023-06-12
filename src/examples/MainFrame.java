package examples;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        // 프레임 설정
        setTitle("JScrollPane Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

        // 버튼 생성
        JButton button = new JButton("버튼");
        button.setPreferredSize(new Dimension(80, 30)); // 버튼 크기 작게 조정

        // 버튼 패널 생성
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // 오른쪽 정렬
        buttonPanel.add(button); // 버튼 패널에 버튼 추가

        // JPanel에 게시글, 댓글 컴포넌트 추가
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        for (int i = 1; i <= 20; i++) {
            JLabel article = new JLabel(i + "번째 게시글입니다.");
            JLabel author = new JLabel("글쓴이: User" + i);
            JButton comment = new JButton("댓글 작성");
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panel.add(article);
            panel.add(author);
            panel.add(comment);
            contentPanel.add(panel);
        }

        // JScrollPane 생성하여 뷰포트에 패널 추가
        JScrollPane scrollPane = new JScrollPane(contentPanel);

        // 버튼 패널을 상위 패널에 BorderLayout으로 배치함
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(buttonPanel, BorderLayout.EAST);

        // JPanel을 상위 패널의 중앙에 배치함
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
