package setting;

import javax.swing.*;

public class Setting extends JFrame{
    public Setting(){
        // 데이터 경로가 생성되지 않은 경우
        if(!SetInitialFile.checkPath()){
            System.err.println();
        }
        // UserInfo.dat파일이 생성되지 않은 경우
        if(!SetInitialFile.checkUserInfoFile()){
            System.err.println();
        }
    }
}
