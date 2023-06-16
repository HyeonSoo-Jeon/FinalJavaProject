package UI;

import java.awt.*;

public class Fonts {
    public static class TitleFont extends Font{
        public TitleFont() {
            super("Dialog", Font.BOLD, 70);
        }
    }

    public static class ContentFont extends Font{
        public ContentFont() {
            super("SansSerif", Font.PLAIN, 15);
        }
    }

    public static class ButtonFont extends Font{
        public ButtonFont() {
            super("SansSerif", Font.BOLD, 15);
        }
    }

    public static class NoPostFont extends Font{
        public NoPostFont() {
            super("SansSerif", Font.BOLD, 40);
        }
    }
}
