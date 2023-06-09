package DataManager;

import java.io.*;
import java.util.ArrayList;

public class PostDataManager {
    static String path = "./Data/Post/postInfo.dat";
    public static ArrayList<PostData> loadPostData(){
        ArrayList<PostData> dataList = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            dataList = (ArrayList<PostData>) ois.readObject();
            System.out.println("Load postInfo.dat file successfully.");
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("ERROR : " + e.getMessage());
        }
        return dataList;
    }

    public static void saveClientData(ArrayList<PostData> posts){
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(posts);
            oos.close();
            fos.close();
            System.out.println("Save postInfo.dat file successfully.");
        } catch (IOException e) {
            System.err.println("ERROR : " + e.getMessage());
        }
    }

}
