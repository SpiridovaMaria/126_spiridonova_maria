import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.println("Дорогой игрок, пожалуйста, введи свое имя, чтобы начать игру.");
        Scanner sc = new Scanner(System.in);
        String playerName = sc.nextLine();
        System.out.println("Приветсвую тебя, " + playerName + "! Швеция разгромила наших союзников при попытке осадить один из её городов, и теперь вся надежда на вас!");
        System.out.println("Готовы ли вы стать правителем великой державы и почувствовать силу и великолепие Российской империи? ");
            new Game().run("level_1");
        }

}
