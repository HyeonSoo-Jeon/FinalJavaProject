package setting;

import java.io.File;
import java.io.IOException;

public class SetInitialFile {

    public static boolean checkPath() {
        File rootDir = new File("./Data");
        File clientDir = new File("./Data/Client");
        File postDir = new File("./Data/Post");

        // root Directory
        if (!rootDir.exists()) {
            if (rootDir.mkdir()) {
                System.out.println("The [./Data] directory was created successfully.");
            } else {
                System.err.println("Failed to create [./Data] directory.");
                return false;
            }
        }
        // client Directory
        if (!clientDir.exists()) {
            if (clientDir.mkdir()) {
                System.out.println("The [./Data/Client] directory was created successfully.");
            } else {
                System.err.println("Failed to create [./Data/Client] directory.");
                return false;
            }
        }

        // post Directory
        if (!postDir.exists()) {
            if (postDir.mkdir()) {
                System.out.println("The [./Data/Post] directory was created successfully.");
            } else {
                System.err.println("Failed to create [./Data/Post] directory.");
                return false;
            }
        }
        return true;
    }

    public static boolean checkUserInfoFile(){
        File file = new File("./Data/Client/userInfo.dat");

        // userInfo.dat File
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("Created [./Data/Client/userInfo.dat] file.");
                    return true;
                }
                else {
                    System.err.println("Failed to create [./Data/Client/userInfo.dat] file.");
                    return false;
                }
            } catch(IOException e) {
                System.err.println(e.toString());
                return false;
            }
        }
        else {
            System.out.println("The [./Data/Client/userInfo.dat] file already exists.");
            return true;
        }
    }
}