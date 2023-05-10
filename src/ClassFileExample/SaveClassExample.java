package ClassFileExample;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveClassExample {
    public static void main(String[] args) {
        // 클래스의 인스턴스 생성
        MyClass myClass = new MyClass();
        myClass.name = "홍길동";
        myClass.age = 30;

        try {
            // 파일 출력 스트림 생성
            FileOutputStream fileOut = new FileOutputStream("myclass.dat");
            // 객체 출력 스트림 생성
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            // 객체 직렬화 및 파일에 쓰기
            out.writeObject(myClass);
            // 출력 스트림 닫기
            out.close();
            // 파일 출력 스트림 닫기
            fileOut.close();
            System.out.println("Serialization is done.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
