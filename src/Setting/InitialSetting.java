package Setting;

import java.io.File;
import java.io.IOException;

public class InitialSetting {

    public static void initPath() {
        File rootDir = new File("./Data");
        File clientDir = new File("./Data/Client");
        File postDir = new File("./Data/Post");

        // root Directory
        if (!rootDir.exists()) {
            if (rootDir.mkdir()) {
                System.out.println("The [./Data] directory was created successfully.");
            } else {
                System.out.println("Failed to create [./Data] directory.");
            }
        }
        // client Directory
        if (!clientDir.exists()) {
            if (clientDir.mkdir()) {
                System.out.println("The [./Data/Client] directory was created successfully.");
            } else {
                System.out.println("Failed to create [./Data/Client] directory.");
            }
        }

        // post Directory
        if (!postDir.exists()) {
            if (postDir.mkdir()) {
                System.out.println("The [./Data/Post] directory was created successfully.");
            } else {
                System.out.println("Failed to create [./Data/Post] directory.");
            }
        }
    }

    public static void initDataFile(){
        File userFile = new File("./Data/Client/userInfo.dat");
        File postFile = new File("./Data/Post/postInfo.dat");

        // userInfo.dat File
        if (!userFile.exists()) {
            try {
                if (userFile.createNewFile()) {
                    System.out.println("The [./Data/Client/userInfo.dat] file was created successfully.");
                }
                else {
                    System.out.println("Failed to create [./Data/Client/userInfo.dat] file.");
                }
            } catch(IOException e) {
                System.out.println(e.toString());
            }
        }
        else {
            System.out.println("The [./Data/Client/userInfo.dat] file already exists.");
        }
        // postInfo.dat File
        if (!postFile.exists()) {
            try {
                if (postFile.createNewFile()) {
                    System.out.println("The [./Data/Post/postInfo.dat] file was created successfully..");
                }
                else {
                    System.out.println("Failed to create [./Data/Post/postInfo.dat] file.");
                }
            } catch(IOException e) {
                System.out.println(e.toString());
            }
        }
        else {
            System.out.println("The [./Data/Post/postInfo.dat] file already exists.");
        }
    }
}