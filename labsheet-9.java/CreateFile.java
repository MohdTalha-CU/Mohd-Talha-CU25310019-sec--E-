import java.io.*;
public class CreateFile {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("student.txt");
            fw.write("Student Name: Rahul\n");
            fw.write("Roll Number: 101\n");
            fw.write("Course: BCA\n");
            fw.write("Semester: 3rd\n");
            fw.close();
            System.out.println("File created and data written successfully.");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}