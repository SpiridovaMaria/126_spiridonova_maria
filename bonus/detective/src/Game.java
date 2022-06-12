import java.util.Scanner;
import java.io.*;


public class Game {
    private int counter;
    private String level;
    private int choice;
    private Field field;
    private Choice choiceB;

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
        drawField(levelName);
        if(!isLastLevel()) {
            drawChoice(levelName);
            processCommand();
        }
        endingGame();
    }

    private void drawField(String levelName) {
        field = new FieldBuilder().buildField(levelName);
        System.out.println(field.getText());

    }
    private void drawChoice(String levelName){
        for(int i=1;i<=2;i++){
            choiceB = new ChoiceBuilder().buildChoice(levelName,i);
            System.out.println(choiceB.getText());
        }
    }
    public boolean isLastLevel(){
        return counter>6;
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
        String option = sc.nextLine();

        if( option.equals("1")) {
            choice = 1;
        }
        else if (option.equals("2")) {
            choice = 2;
        }

        else{
            System.out.println("Команда выполнена неверно.");
            choice=0;
            endingGame();
        }


    }
}
