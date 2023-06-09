package DataManager;

import java.util.ArrayList;
import java.io.Serializable;

public class PostData implements Serializable{
    String postID;
    String content;
    ArrayList<String> comments;

    PostData(String postID, String content){
        this.postID = postID;
        this.content = content;
        comments = new ArrayList<>();
    }
}
