package ClassFileExample;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadClassArray {
    public static void main(String[] args) {
        try {
            FileInputStream fileIn = new FileInputStream("myclass_array.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            MyClass[] myClassArray = (MyClass[]) in.readObject();

            in.close();
            fileIn.close();

            for(int i = 0 ; i < myClassArray.length ; i++){
                System.out.println("Name: " + myClassArray[i].name);
                System.out.println("Age: " + myClassArray[i].age);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
