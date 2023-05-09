package logIn;

import java.io.*;

public class LogIn {
    public static void main(String[] args){
        ClientData cd;
        String path = "C:/javaFinal/data.dat";
        try{
            FileOutputStream fos = new FileOutputStream(path);
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }


    }
}
