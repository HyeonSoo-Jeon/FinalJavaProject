package main;

import PostUI.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        MainFrame mf = new MainFrame();

        CardLayout cardLayout = new CardLayout();
        JPanel container = new JPanel(cardLayout);

        LogIn lp = new LogIn();
        CreateAccountPanel ca = new CreateAccountPanel();

        container.add(lp,"LogIn");
        container.add(ca,"CreateAccount");

        lp.createNewAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(container, "CreateAccount");
            }
        });

        mf.getContentPane().add(container);
        mf.setVisible(true);
    }
}
