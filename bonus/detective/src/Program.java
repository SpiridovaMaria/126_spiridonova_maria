import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.println("Дорогой пользователь, сегодня Вам предстоит решить одну запутанную, но очень интересную загадку. Но прежде чем начать, давай познакомимся. Как Вас зовут?");
        Scanner sc = new Scanner(System.in);
        String playerName = sc.nextLine();
        System.out.println("Возвращаясь домой с дачи, Вы слышите по радио: 'Недавно в вашем городе произошло ужасное преступление. Из галереи, расположенной на одной улице с вашим домом украли три картины стоимость 1 000 000$. Преступники отключили все камеры, но последний кого они успели запечатлеть последнего человека у галереи, кто является на данный момент главным подозреваемым и которого упорно ищет полиция. Если вы знаете "+playerName+", пожалуйста, сообщите по номеру 02!'");
            new Game().run("level_1");
        }

}
