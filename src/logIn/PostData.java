package logIn;

import java.util.ArrayList;

public class PostData {
    String postID;
    String content;
    ArrayList<String> comments;

    PostData(String postID, String content){
        this.postID = postID;
        this.content = content;
        comments = new ArrayList<>();
    }
}
