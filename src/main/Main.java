package main;

import PostUI.*;
import setting.InitData;

public class Main {
    public static void main(String[] args) {
        // 데이터 경로가 생성되지 않은 경우
        if(!InitData.initPath()){
            System.err.println();
        }
        // UserInfo.dat파일이 생성되지 않은 경우
        if(!InitData.initDataFile()){
            System.err.println();
        }

        MainGUI mainGUI = new MainGUI();
    }
}
