import java.io.*;
import java.util.*;
public class SearchWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        try {
            BufferedReader br = new BufferedReader(
                new FileReader("notes.txt"));
            System.out.print("Enter word to search: ");
            String word = sc.nextLine();
            String line;
            while ((line = br.readLine()) != null) {
                for (String w : line.split("\\s+")) {
                    if (w.equalsIgnoreCase(word))
                        count++;
                }
            }
            br.close();
            if (count > 0)
                System.out.println("Word found " + count + " times.");
            else
                System.out.println("Word not found.");
        }
        catch (IOException e) {
            System.out.println("File not found.");
        }
        sc.close();
    }
}