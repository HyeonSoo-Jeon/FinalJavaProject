package main;

public class Main {
    public static void main(String[] args) {

        String enteredUsername = "johndoe";
        String enteredPassword = "12345";
        if (Login.authenticateUser(enteredUsername, enteredPassword)) {
            System.out.println("로그인 성공!");
        } else {
            System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
        }
    }
}
