package DataManager;

import java.util.ArrayList;

import static DataManager.ClientDataManager.*;

public class LogIn {

    public static void main(String[] args){
        ClientData cd1 = new ClientData("user1","1234");
        cd1.posts.add("1");
        cd1.posts.add("1");
        cd1.posts.add("1");
        ClientData cd2 = new ClientData("user2","1234");
        ClientData cd3 = new ClientData("user3","1234");
        cd3.posts.add("3");
        cd3.posts.add("3");
        cd3.posts.add("3");
        cd3.posts.add("3");
        cd3.posts.add("3");
        cd3.posts.add("3");
        cd3.posts.add("3");
        cd3.posts.add("3");

        ArrayList<ClientData> clients = new ArrayList<>();
        clients.add(cd1);
        clients.add(cd2);
        clients.add(cd3);

        saveClientData(clients);

        ArrayList<ClientData> c = loadClientData();
        for(ClientData cd : c){
            ArrayList<String> cmt = cd.posts;
            for(String o : cmt)
                System.out.println(o);
        }

    }
}
