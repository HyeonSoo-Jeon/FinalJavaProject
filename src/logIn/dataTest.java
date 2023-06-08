package logIn;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class dataTest implements java.io.Serializable {
    public static void main(String[] args) {
        ClientData data1 = new ClientData();
        data1.userID = "user1";
        data1.content = "Some content";
        data1.comments.add("First comment");

        ClientData data2 = new ClientData();
        data2.userID = "user2";
        data2.content = "Some content";
        data2.comments.add("First comment");

        List<ClientData> dataList = new ArrayList<>();
        dataList.add(data1);
        dataList.add(data2);
        saveDataList("data.dat", dataList);

        List<ClientData> loadedDataList = loadDataList("data.dat");
        for (ClientData data : loadedDataList) {
            System.out.println("User ID: " + data.userID);
            System.out.println("Content: " + data.content);
            System.out.println("Comments: " + data.comments);
            System.out.println("---");
        }
    }

    public static void saveDataList(String fileName, List<ClientData> dataList) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(dataList);
            objectOut.close();
            fileOut.close();
            System.out.println("Data list saved in file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving data list: " + e.getMessage());
        }
    }

    public static List<ClientData> loadDataList(String fileName) {
        List<ClientData> dataList = null;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            dataList = (List<ClientData>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading data list: " + e.getMessage());
        }
        return dataList;
    }
}
