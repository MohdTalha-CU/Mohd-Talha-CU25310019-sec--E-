import java.io.*;
import java.util.Scanner;
public class AppendFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            FileWriter fw = new FileWriter("students.txt", true);
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();
            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();
            fw.write("\nName: " + name);
            fw.write("\nRoll Number: " + roll);
            fw.write("\nMarks: " + marks + "\n");
            fw.close();
            System.out.println("Student record added successfully.");
        }
        catch (IOException e) {
            System.out.println("File error occurred.");
        }
        sc.close();
    }
}