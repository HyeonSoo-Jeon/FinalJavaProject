package CustomAdapter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NoSpaceAdapter extends KeyAdapter {
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == ' ') {
            e.consume();
        }
    }
}
