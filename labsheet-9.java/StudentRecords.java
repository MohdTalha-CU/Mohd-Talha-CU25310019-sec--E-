import java.io.*;
import java.util.*;
public class StudentRecords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            FileWriter fw = new FileWriter("student_records.txt");
            for (int i = 1; i <= 5; i++) {
                System.out.print("Enter Roll Number: ");
                String roll = sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Course: ");
                String course = sc.nextLine();
                System.out.print("Enter Marks: ");
                String marks = sc.nextLine();
                fw.write(roll + ", " + name + ", " +
                         course + ", " + marks + "\n");
            }
            fw.close();
            BufferedReader br = new BufferedReader(
                new FileReader("student_records.txt"));
            System.out.println("\nStudent Records:");
            String line;
            while ((line = br.readLine()) != null)
                System.out.println(line);
            br.close();
        }
        catch (IOException e) {
            System.out.println("File error occurred.");
        }
        sc.close();
    }
}