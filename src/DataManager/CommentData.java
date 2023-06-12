package DataManager;

import java.io.Serializable;
import java.util.ArrayList;

public class CommentData implements Serializable{
    public String nickname;

    public String content;

    public CommentData(String nickname, String content){
        this.nickname = nickname;
        this.content = content;
    }
}
