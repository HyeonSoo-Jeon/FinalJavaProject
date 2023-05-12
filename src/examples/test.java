package examples;

import java.awt.Color;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class test extends JFrame {

    private LineBorder border = new LineBorder(Color.BLUE,2);
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu("File");
    private JMenuItem item = new JMenuItem("Nothing");

    public test() {
        menu.add(item);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
        this.setUndecorated(true);
        this.getRootPane().setBorder(border);
        this.setSize(400,340);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new test();
    }
}