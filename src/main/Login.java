package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Login {
    public static boolean authenticateUser(String enteredUsername, String enteredPassword) {
        boolean isAuthenticated = false;
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader("user_info.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] userInfo = line.split(",");
                if (userInfo[0].equals(enteredUsername) && userInfo[1].equals(enteredPassword)) {
                    isAuthenticated = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return isAuthenticated;
    }
}
