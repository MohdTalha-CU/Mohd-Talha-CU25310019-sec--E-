import java.io.*;
import java.util.*;
public class Employee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            FileWriter fw = new FileWriter("employees.txt");
            System.out.print("Enter Employee ID: ");
            String id = sc.nextLine();
            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Department: ");
            String dept = sc.nextLine();
            System.out.print("Enter Salary: ");
            String salary = sc.nextLine();
            fw.write(id + "," + name + "," + dept + "," + salary);
            fw.close();
            System.out.print("Enter ID to search: ");
            String search = sc.nextLine();

            BufferedReader br = new BufferedReader(
                new FileReader("employees.txt"));
            String line;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(search)) {
                    System.out.println("Employee Found:");
                    System.out.println("ID: " + data[0]);
                    System.out.println("Name: " + data[1]);
                    System.out.println("Department: " + data[2]);
                    System.out.println("Salary: " + data[3]);
                    found = true;
                    break;
                }
            }
            br.close();
            if (!found)
                System.out.println("Employee record not found.");
        }
        catch (IOException e) {
            System.out.println("File not found or error occurred.");
        }
        sc.close();
    }
}