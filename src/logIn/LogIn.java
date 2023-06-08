package logIn;

import java.io.FileOutputStream;
import java.io.IOException;

public class LogIn {

    public void func(){
        ClientData cd;
        String path = "./Data/Client/userInfo.dat";
        try{
            FileOutputStream fos = new FileOutputStream(path);
        }
        catch (IOException e){
            System.out.println("File not found");
        }
    }
}
