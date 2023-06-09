package DataManager;

import java.io.*;
import java.util.ArrayList;

public class ClientDataManager {
    static String path = "./Data/Client/userInfo.dat";
    public static ArrayList<ClientData> loadClientData(){
        ArrayList<ClientData> dataList = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            dataList = (ArrayList<ClientData>) ois.readObject();
            System.out.println("Load userInfo.dat file successfully.");
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("ERROR : " + e.getMessage());
        }
        return dataList;
    }

    public static void saveClientData(ArrayList<ClientData> clients){
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(clients);
            oos.close();
            fos.close();
            System.out.println("Save userInfo.dat file successfully.");
        } catch (IOException e) {
            System.err.println("ERROR : " + e.getMessage());
        }
    }
}
