package DataManager;

import java.util.ArrayList;
import java.io.Serializable;

public class ClientData implements Serializable{
    public String userID;
    public String nickname;
    public String password;

    public ClientData(String userID, String nickname, String password){
        this.userID = userID;
        this.nickname = nickname;
        this.password = password;
    }
}