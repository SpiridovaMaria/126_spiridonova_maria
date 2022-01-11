import java.util.Scanner;

public class Game {
    private Field field;
    private Person person;
    private HiddenField hiddenField;
    private int level;

    public Game(){
        level = 1;
    }

    public int levelMover(){
        return level;
    }

    public void run(String levelName) {
        prepareGame(levelName);
        drawField();
        while(gameInProcess()) {
            processCommand();
        }
        endingGame();
    }

    private void endingGame() {
        if(person.getRightNumber()==0 && level<5) {
            System.out.println("Вы выиграли эту битву и перешли на новый уровень!");
            level++;
            System.out.println(level+" уровень");
            run("level_"+levelMover());
        }
        else if(person.getRightNumber()==0 && level == 5){
            System.out.println("Поздравляю! Вы победили в войне, прорубив окно в Европу и сделав Россию могущественной державой! Для завершения нажмите Enter");
        }
        else{
            System.out.println("К сожалению, вы проиграли в битве! Но вы не проиграли войне! Возьмите реванш, чтобы разгромить врага!");
            System.out.println(level+" уровень");
            run("level_"+levelMover());
        }
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    private void processCommand() {

        System.out.println("У вас осталось "+person.getMoveNumber()+" ходов");
        System.out.println("У вас осталось "+person.getRightNumber()+" ненайденных ловушек");
        System.out.print("Введите x: ");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.print("Введите y: ");
        int y = sc.nextInt();

        person.setR(x, y);

        if(person.setR(x, y)==1) {
            drawR();
            person.reduceMoves();
            person.reduceRightMoves();
        }
        else if (person.setR(x, y)==0) {
            drawW();
            person.reduceMoves();
        }
        else{ System.out.println("Координаты введены не верно.");}

    }


    private void drawR() {
        for (int i = 0; i < field.getCells().length; ++i) {
            for (int j = 0; j < field.getCells()[i].length; ++j) {
                if(i == person.getY() && j == person.getX()) {
                    System.out.print(person.getVisualR());
                    field.getCells()[i][j] = '#';
                }
                else
                    System.out.print(field.getCells()[i][j]);
            }
            System.out.println();
        }
    }
    private void drawW() {
        for (int i = 0; i < field.getCells().length; ++i) {
            for (int j = 0; j < field.getCells()[i].length; ++j) {
                if(i == person.getY() && j == person.getX()) {
                    System.out.print(person.getVisualW());
                    field.getCells()[i][j] = '*';
                }
                else
                    System.out.print(field.getCells()[i][j]);
            }
            System.out.println();
        }
    }
    private void drawField() {
        for (int i = 0; i < field.getCells().length; ++i) {
            for (int j = 0; j < field.getCells()[i].length; ++j) {
                System.out.print(field.getCells()[i][j]);
            }
            System.out.println();
        }
        System.out.println("У вас есть "+ person.getMoveNumber()+" ходов");
    }

    private boolean gameInProcess() {
       return person.getMoveNumber()>0 && person.getRightNumber()>0;
    }

    private void prepareGame(String levelName) {
        field = new Fieldbuilder().buildField(levelName);
        hiddenField = new HiddenFieldBuilder().buildHiddenField(levelName);
        person = new PersonBuilder().buildPerson(levelName, field, hiddenField);

    }
}
