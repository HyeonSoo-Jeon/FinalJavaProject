package setting;

import java.io.File;
import java.io.IOException;

public class SetInitialFile {

    public static boolean checkPath(){
        File directory = new File("C:/javaFinal");

        // javaFinal 디렉토리가 없으면 생성
        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println("C:/javaFinal 디렉토리를 생성했습니다.");
            }
            else {
                System.err.println("C:/javaFinal 디렉토리를 생성하지 못했습니다.");
                return false;
            }
        }
        return true;
    }

    public static boolean checkUserInfoFile(){
        File file = new File("C:/javaFinal/userInfo.dat");

        // userInfo.dat 파일이 없으면 생성
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("C:/javaFinal/userInfo.dat 파일을 생성했습니다.");
                    return true;
                }
                else {
                    System.err.println("C:/javaFinal/userInfo.dat 파일을 생성하지 못했습니다.");
                    return false;
                }
            } catch(IOException e) {
                System.err.println(e.toString());
                return false;
            }
        }
        else {
            System.out.println("C:/javaFinal/userInfo.dat 파일이 이미 존재합니다.");
            return true;
        }
    }
}