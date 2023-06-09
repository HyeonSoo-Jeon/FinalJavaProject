package logIn;

import java.util.ArrayList;

import static logIn.ClientDataManager.*;

public class LogIn {

    public static void main(String[] args){
        ClientData cd1 = new ClientData("user1","1234");
        ClientData cd2 = new ClientData("user2","1234");
        ClientData cd3 = new ClientData("user3","1234");

        ArrayList<ClientData> clients = new ArrayList<>();
        clients.add(cd1);
        clients.add(cd2);
        clients.add(cd3);

        saveClientData(clients);


    }



}
