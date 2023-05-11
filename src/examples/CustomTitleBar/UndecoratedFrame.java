package examples.CustomTitleBar;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.LineBorder;

public class UndecoratedFrame extends JFrame {

    private LineBorder border = new LineBorder(Color.BLUE,2);
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu("File");
    private JMenuItem item = new JMenuItem("Nothing");

    public UndecoratedFrame() {
        menu.add(item);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
        this.setUndecorated(true);
        this.getRootPane().setBorder(border);
        this.setSize(400,340);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new UndecoratedFrame();
    }
}