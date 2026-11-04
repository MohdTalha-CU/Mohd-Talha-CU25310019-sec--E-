import java.io.*;
public class CountFile {
    public static void main(String[] args) {
        int lines = 0, words = 0, chars = 0;
        try {
            BufferedReader br = new BufferedReader(
                new FileReader("data.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                lines++;
                chars += line.length();

                String[] w = line.trim().split("\\s+");
                if (!line.trim().isEmpty())
                    words += w.length;
            }
            br.close();
            System.out.println("Lines: " + lines);
            System.out.println("Words: " + words);
            System.out.println("Characters: " + chars);
        }
        catch (IOException e) {
            System.out.println("File not found.");
        }
    }
}