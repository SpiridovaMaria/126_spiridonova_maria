import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        System.out.println("Дорогой игрок, пожалуйста, введи свое имя, чтобы начать игру.");
        Scanner sc = new Scanner(System.in);
        String playerName = sc.nextLine();
        System.out.println("Приветсвую тебя, " + playerName + "! Швеция разгромила наших союзников, и теперь вся надежда на вас!");
        System.out.println("Готовы ли вы стать правителем великой державы и почувствовать силу и великолепие Российской империи? ");
        System.out.println("Завоюйте европейские земли, остановите злейшего врага, получите желанный выход к Балтийскому морю и измените ход истории!");
        System.out.println("Давайте начнем наши завоевания!");

        new Game().run("level_1");
    }
}
