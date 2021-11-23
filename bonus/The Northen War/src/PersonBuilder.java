import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PersonBuilder {
    public Person buildPerson(String levelName, Field field, HiddenField hiddenField) {
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(levelName + "/person"));
            Scanner sc = new Scanner(reader);
            int moveNumber = sc.nextInt();
            int rightNumber = sc.nextInt();
            sc.nextLine();
            String symbolR = sc.nextLine();
            String symbolW = sc.nextLine();
            reader.close();

            return new Person(moveNumber, rightNumber, symbolR.charAt(0), symbolW.charAt(0), field, hiddenField);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
