package logIn;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogIn {

    public void func(){
        ClientData cd;
        String path = "./Data/Client/userInfo.dat";

        List<ClientData> dataList = null;
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            dataList = (List<ClientData>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading data list: " + e.getMessage());
        }

    }

    public static void main(String[] args){
        String path = "./Data/Client/userInfo.dat";

        List<ClientData> dataList = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            dataList = (List<ClientData>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading data list: " + e.getMessage());
        }
        ClientData cd = new ClientData();
        cd.userID = "temp";
        cd.content = "2";
        dataList.add(cd);
        for(ClientData temp : dataList){
            System.out.println(temp.userID);
        }
    }



}
