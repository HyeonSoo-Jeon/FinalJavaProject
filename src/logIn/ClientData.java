package logIn;

import java.util.ArrayList;

public class ClientData {
    String userID;
    String password;
    ArrayList<String> posts;

    ClientData(String userID, String password){
        this.userID = userID;
        this.password = password;
        posts = new ArrayList<>();
    }
}