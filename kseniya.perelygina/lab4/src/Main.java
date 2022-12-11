import Models.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static final File FILE = new File("src/Resources/Orders.txt");
    public static String LINE = "---------------------------------------";

    public static void readFile(FlowerShop records) {

        try (FileReader fr = new FileReader(FILE); BufferedReader reader = new BufferedReader(fr)) {

            String line = reader.readLine();

            while (line != null) {

                records.putLine(line);
                line = reader.readLine();

            }

        } catch (IOException e) {

            LOGGER.log(Level.SEVERE, "Ошибка работы с файлом ", e);

        }
    }

    public static void main(String[] args) {

        LOGGER.log(Level.INFO, "Начало работы");
        Scanner scan = new Scanner(System.in);
        String input = "";
        FlowerShop records = new FlowerShop();
        readFile(records);

        int choice = -1;

        do {

            System.out.println("Выберите действие");
            System.out.println("[0] Завершить работу");
            System.out.println("[1] Найти месяц, в который заказывают букеты,\nсостоящие из наиболее разнообразных цветов");
            System.out.println("[2] Найти, сколько заработал флорист\nпо каждому типу букетов за последний год");
            System.out.println("[3] Для каждого цветка узнать:\nего чаще доставляют, или забирают самовывозом");
            System.out.println("Ваш выбор: ");

            input = scan.next();
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода");
                LOGGER.log(Level.WARNING, "Ошибка ввода" + Arrays.toString(e.getStackTrace()));
            }
            System.out.println(LINE);

            choice = switch (choice) {

                case 0 -> {

                    System.out.println("Работа программы завершена");
                    LOGGER.log(Level.OFF, "Работа программы завершена");

                    yield 0;
                }

                case 1 -> {

                    System.out.println("Месяц: " + records.getMonthWithMostVersatileBouquets());

                    yield 1;
                }

                case 2 -> {

                    System.out.println("Текущий год: " + LocalDate.now().getYear());

                    Map<String, Double> types = records.getTypeTotalSales();

                    for (Map.Entry<String, Double> type : types.entrySet()) {

                        System.out.println(type.getKey() + ": " + type.getValue());

                    }

                    yield 2;
                }

                case 3 -> {

                    Map<String, DeliveryPickupCasesAmount> flowers = records.getFlowersWithDeliveryFrequency();

                    for (Map.Entry<String, DeliveryPickupCasesAmount> flower : flowers.entrySet()) {

                        String message = flower.getValue().whatsMore().toString();

                        if (message.equals("-")) {

                            message = "одинаково";

                        }

                        System.out.println(flower.getKey() + ": " + message);


                    }

                    yield 3;
                }

                default -> throw new IllegalStateException("Unexpected value: " + choice);
            };

            System.out.println(LINE);

        } while (choice != 0);

    }
}
