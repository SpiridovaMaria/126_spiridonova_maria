import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class HiddenFieldBuilder {
    public HiddenField buildHiddenField(String levelName) {
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(levelName + "/hiddenField"));
            Scanner sc = new Scanner(reader);
            int lines = sc.nextInt();
            sc.nextLine();
            String wrong = sc.nextLine();
            String right = sc.nextLine();
            char[][] cells = new char[lines][];
            for(int i = 0; i < lines; ++i) {
                String line = sc.nextLine();
                cells[i] = line.toCharArray();
            }
            reader.close();

            return new HiddenField(cells, right.charAt(0), wrong.charAt(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
