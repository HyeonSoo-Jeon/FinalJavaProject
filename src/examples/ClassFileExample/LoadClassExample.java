package examples.ClassFileExample;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadClassExample {
    public static void main(String[] args) {
        // 직렬화된 파일 읽기
        try {
            // 파일 입력 스트림 생성
            FileInputStream fileIn = new FileInputStream("myclass.dat");
            // 객체 입력 스트림 생성
            ObjectInputStream in = new ObjectInputStream(fileIn);

            // 파일에서 MyClass 인스턴스를 읽어들임
            MyClass myClass = (MyClass) in.readObject();

            // 객체 입력 스트림 닫기
            in.close();
            // 파일 입력 스트림 닫기
            fileIn.close();

            // MyClass 인스턴스 정보 출력
            System.out.println("Name: " + myClass.name);
            System.out.println("Age: " + myClass.age);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
