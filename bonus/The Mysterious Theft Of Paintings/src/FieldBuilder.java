import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FieldBuilder {
    public Field buildField(String levelName) {
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream("texts/" + levelName+"/"+levelName+".txt"));
            String text;
            Scanner sc = new Scanner(reader);
            text = sc.nextLine();
            reader.close();

            return new Field(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
