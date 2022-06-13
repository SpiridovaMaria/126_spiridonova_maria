import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ChoiceBuilder {
    public Choice buildChoice(String levelName,int i) {
            InputStreamReader reader = null;
            try {
                reader = new InputStreamReader(new FileInputStream("texts/" + levelName + "/" + i + ".txt"));
                String text;
                Scanner sc = new Scanner(reader);
                text = sc.nextLine();
                reader.close();

                return new Choice(text);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
    }
}
