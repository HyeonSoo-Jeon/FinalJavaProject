package DataManager;

import java.util.ArrayList;
import java.io.Serializable;

public class ClientData implements Serializable{
    String userID;
    String password;
    ArrayList<String> posts;

    ClientData(String userID, String password){
        this.userID = userID;
        this.password = password;
        posts = new ArrayList<>();
    }
}