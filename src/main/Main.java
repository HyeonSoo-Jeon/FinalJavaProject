package main;

import PostUI.*;
import setting.SetInitialFile;

public class Main {
    public static void main(String[] args) {
        // 데이터 경로가 생성되지 않은 경우
        if(!SetInitialFile.checkPath()){
            System.err.println();
        }
        // UserInfo.dat파일이 생성되지 않은 경우
        if(!SetInitialFile.checkDataFiles()){
            System.err.println();
        }

        MainGUI mainGUI = new MainGUI();
    }
}
