import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        System.out.println("Дорогой игрок, пожалуйста, введи свое имя.");
        Scanner sc = new Scanner(System.in);
        String playerName = sc.nextLine();
        System.out.println("Привет, " + playerName + "! Давай начнем наши завоевания!");

        new Game().run("level_1");
    }
}
