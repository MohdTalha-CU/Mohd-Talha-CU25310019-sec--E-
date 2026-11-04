import java.io.*;
public class CharacterCount {
    public static void main(String[] args) {
        int v = 0, c = 0, d = 0, s = 0;
        try {
            FileReader fr = new FileReader("input.txt");
            int ch;
            while ((ch = fr.read()) != -1) {
                char x = (char) ch;
                if ("aeiouAEIOU".indexOf(x) != -1)
                    v++;
                else if (Character.isLetter(x))
                    c++;
                else if (Character.isDigit(x))
                    d++;
                else if (x == ' ')
                    s++;
            }
            fr.close();
            System.out.println("Vowels: " + v);
            System.out.println("Consonants: " + c);
            System.out.println("Digits: " + d);
            System.out.println("Spaces: " + s);
        }
        catch (IOException e) {
            System.out.println("File not found.");
        }
    }
}