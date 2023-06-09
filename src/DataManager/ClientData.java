package DataManager;

import java.util.ArrayList;
import java.io.Serializable;

public class ClientData implements Serializable{
    String userID;
    String nickname;
    String password;
    ArrayList<String> posts;

    public ClientData(String userID, String nickname, String password){
        this.userID = userID;
        this.nickname = nickname;
        this.password = password;
        posts = new ArrayList<>();
    }
}