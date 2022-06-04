import java.util.Scanner;
import java.io.*;


public class Game {
    private int counter;
    private String level;
    private int choice;
    private Field field;

    public Game(){
        level = "level_1";
        counter = 1;
    }
    public String levelMover(){
        return level;
    }

    public int choiceMover(){
        return choice;
    }
    public int counterMover(){
        return counter;
    }

    public void run(String levelName) {
        prepareGame(levelName);
        drawField();
        if(!isLastLevel()) {
            processCommand();
        }
        endingGame();
    }

    private void prepareGame(String levelName) {
        field = new FieldBuilder().buildField(levelName);
    }
    private void drawField() {
        System.out.println(field.getText());
    }
    public boolean isLastLevel(){
        return counter>2;
    }

    private void endingGame() {
        if(!isLastLevel()) {
            if(choice!=0) {
                counter++;
                level = levelMover() + "." + choiceMover();
            }
            run(level);
        }
        else {
            System.out.println("Спасибо за игру, юный детектив!");
        }
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    private void processCommand() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        if(x==1) {
           choice = 1;
        }
        else if (x==2) {
            choice = 2;
        }
        else if (x==3) {
            choice = 3;
        }
        else{
            System.out.println("Команда выполнена неверно.");
            choice=0;
        }

    }
}
