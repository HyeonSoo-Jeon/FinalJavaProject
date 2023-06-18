package UI;

import java.awt.*;

public class Fonts {

    public static class MainTitleFont extends Font{
        public MainTitleFont() {
            super("Dialog", Font.BOLD, 70);
        }
    }
    public static class TitleFont extends Font{
        public TitleFont() {
            super("Monospaced", Font.BOLD, 60);
        }
    }

    public static class ContentFont extends Font{
        public ContentFont() {
            super("SansSerif", Font.PLAIN, 15);
        }
    }
    public static class MiniContentFont extends Font{
        public MiniContentFont() {
            super("SansSerif", Font.PLAIN, 12);
        }
    }
    public static class ContentBoldFont extends Font{
        public ContentBoldFont() {
            super("SansSerif", Font.BOLD, 15);
        }
    }

    public static class NoPostFont extends Font{
        public NoPostFont() {
            super("SansSerif", Font.BOLD, 40);
        }
    }

    public static class MenuFont extends Font{
        public MenuFont(){
            super("Dialog", Font.PLAIN,15);
        }
    }
}
