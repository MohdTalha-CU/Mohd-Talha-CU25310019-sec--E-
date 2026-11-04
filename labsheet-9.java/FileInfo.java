import java.io.*;
import java.util.*;
public class FileInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String name = sc.nextLine();
        File f = new File(name);
        System.out.println("Exists: " + f.exists());
        System.out.println("File Name: " + f.getName());
        System.out.println("Absolute Path: " + f.getAbsolutePath());
        System.out.println("File Size: " + f.length() + " bytes");
        System.out.println("Is File: " + f.isFile());
        System.out.println("Is Directory: " + f.isDirectory());
        System.out.println("Readable: " + f.canRead());
        System.out.println("Writable: " + f.canWrite());
        sc.close();
    }
}