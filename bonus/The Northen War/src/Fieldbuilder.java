import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Fieldbuilder {
    public Field buildField(String levelName) {
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(levelName + "/field"));
            Scanner sc = new Scanner(reader);
            int lines = sc.nextInt();
            sc.nextLine();
            String floor = sc.nextLine();
            char[][] cells = new char[lines][];
            for(int i = 0; i < lines; ++i) {
                String line = sc.nextLine();
                cells[i] = line.toCharArray();
            }
            reader.close();

            return new Field(cells, floor.charAt(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
