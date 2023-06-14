package Main;

import UI.*;
import Setting.InitialSetting;

public class Main {
    public static void main(String[] args) {
        InitialSetting.initPath();
        InitialSetting.initDataFile();

        MainGUI mainGUI = new MainGUI();
    }
}
