package DataManager;

import java.util.ArrayList;
import java.io.Serializable;

public class PostData implements Serializable{
    public String title;
    public String nickname;

    public String content;
    public ArrayList<CommentData> comments;

    public PostData(String postID, String nickname, String content){
        this.title = postID;
        this.nickname = nickname;
        this.content = content;
        comments = new ArrayList<>();
    }
}
