package examples.ClassFileExample;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveClassArray {
    public static void main(String[] args) {
        MyClass[] myClassArray = new MyClass[3];

        myClassArray[0] = new MyClass();
        myClassArray[0].name = "홍길동";
        myClassArray[0].age = 30;

        myClassArray[1] = new MyClass();
        myClassArray[1].name = "김철수";
        myClassArray[1].age = 25;

        myClassArray[2] = new MyClass();
        myClassArray[2].name = "박영희";
        myClassArray[2].age = 20;

        try {
            FileOutputStream fileOut = new FileOutputStream("myclass_array.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(myClassArray);
            out.close();
            fileOut.close();
            System.out.println("Serialization is done.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
