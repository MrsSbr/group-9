import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.log(Level.INFO, "Начало работы программы...");
        FoxInterview recordsHandler = new FoxInterview();
        Helper.readFile(recordsHandler);
        workWithRecords(recordsHandler);
        logger.log(Level.INFO, "Конец работы программы...");
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
                case 1 -> System.out.println(recordsHandler.getTheMostPopularAnswerForATowns());
                case 2 -> System.out.println(recordsHandler.getTownWithTheMostVariableAnswers());
                case 3 -> System.out.println(recordsHandler.getTownNotLikeMoscow());
                case 0 -> isEnd = true;
            }
        }
    }

}
