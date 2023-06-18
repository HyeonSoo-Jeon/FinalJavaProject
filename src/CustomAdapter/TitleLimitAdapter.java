package CustomAdapter;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TitleLimitAdapter extends KeyAdapter {
    @Override
    public void keyTyped(KeyEvent e) {
        JTextField textField = (JTextField) e.getSource();
        if (textField.getText().length()>23) {
            e.consume();
        }
    }
}
