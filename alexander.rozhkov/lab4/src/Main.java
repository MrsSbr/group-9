import logic.RecordsHandler;
import service.Helper;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.log(Level.INFO, "Начало работы программы...");
        RecordsHandler recordsHandler = new RecordsHandler();
        Helper.readFile(recordsHandler);
        workWithRecords(recordsHandler);
        logger.log(Level.INFO, "Конец работы программы...");
    }

    public static void workWithRecords(RecordsHandler recordsHandler) {
        while (true) {
            printMenu();
            int choose = Helper.inputIntBetween(0, 3);
            switch (choose) {
                case 1 -> System.out.println(recordsHandler.getListOfPeoplesWhoDonateInAllTemples());
                case 2 -> System.out.println(recordsHandler.getGodWhoHaveLargestNumberDonors(Integer::compareTo));
                case 3 -> System.out.println(recordsHandler.getTempleWithMinimumSumOfDonation(Integer::compareTo));
                case 0 -> {
                    return;
                }
            }
        }
    }

    public static void printMenu() {
        System.out.println("\nВыберите действие, которое хотите выполнить:");
        System.out.println("[1] Получить список людей, которые жертвовали во всех храмах");
        System.out.println("[2] Выбрать Бога, который имеет наибольшее число последователей");
        System.out.println("[3] Выбрать храм, с наименьшим количетсвом пожертвований");
        System.out.println("[0] Закончить выполнение программы");
    }
}
