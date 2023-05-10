package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFileExample {
    public static void main(String[] args) {
        try {
            // 파일 이름과 경로를 지정합니다.
            FileWriter fileWriter = new FileWriter("user_info.txt");

            // 파일에 쓸 내용을 작성합니다.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("user1,password1");
            bufferedWriter.newLine();
            bufferedWriter.write("user2,password2");
            bufferedWriter.newLine();

            // 파일을 닫습니다.
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
