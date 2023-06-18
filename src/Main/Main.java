package Main;

import UI.MainGUI;
import Setting.InitialSetting;

public class Main {
    public static void main(String[] args) {
        InitialSetting.initPath();
        InitialSetting.initDataFile();

        MainGUI mainGUI = new MainGUI();
    }
}
