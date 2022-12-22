import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        FoxInterview recordsHandler = new FoxInterview();
        Helper.readFile(recordsHandler);
        workWithRecords(recordsHandler);
    }

    public static void workWithRecords(FoxInterview recordsHandler) {
        boolean isEnd = false;
        while (!isEnd) {

            System.out.println("\nВыберите действие:");
            System.out.println("[1] Наиболее популярный ответ для городов, название, которых начинается на 'А'.");
            System.out.println("[2] Город, в котором дали больше всего разнообразных ответов.");
            System.out.println("[3] Города, где ни разу не ответили так же, как наиболее часто отвечали в Москве.");
            System.out.println("[0] Exit.");

            int choose = Helper.inputIntBetween(0, 3);
            switch (choose) {
                case 1 -> System.out.println(recordsHandler.getTheMostPopularAnswerForATownsStream());
                case 2 -> System.out.println(recordsHandler.getTownWithTheMostVariableAnswersStream());
                case 3 -> System.out.println(recordsHandler.getTownNotLikeMoscowStream());
                case 0 -> isEnd = true;
            }
        }
    }

}