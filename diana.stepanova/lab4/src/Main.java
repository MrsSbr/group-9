/*Кондитерская ведет учёт выполненных заказов, для этого в файл записывается информация в следующем формате:
дата выполнения заказа;наименование торта;масса;стоимость

- найти месяц, в котором кондитерская получила самый низкий доход
- вывести самый тяжелый торт в каждом месяце этого года
- вывести список заказов тортов по месяцам

В этой задаче нельзя использовать элементы функционального программирования*/


import Confectionery.Confectionery;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final File f = new File("src/Confectionery/orders.txt");

    public static void main(String[] args) {

        logger.log(Level.INFO, "Начало работы");
        Scanner scan = new Scanner(System.in);
        int choise = -1;
        String input = "";
        Confectionery confectionery = new Confectionery();
        readFile(confectionery);

        while (!"0".equals(input)) {

            System.out.println("1. Найти месяц с самым низким доходом");
            System.out.println("2. Найти самый тяжелый торт каждого месяца этого года");
            System.out.println("3. Вывести список заказов по месяцам");
            System.out.println("0. Для выхода из приложения\n");
            input = scan.next();

            try {
                choise = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");
                logger.log(Level.WARNING, "Неверный ввод " + Arrays.toString(e.getStackTrace()));
            }

            switch (choise) {
                case 1 -> System.out.println("Месяц с самым низким доходом " + confectionery.worstMonth());
                case 2 ->
                        System.out.println("Самый тяжелый торт каждого месяца\n " + confectionery.mustMassMonth().toString());
                case 3 -> System.out.println("Список заказов по месяцам " + confectionery.ordersToMonth().toString());
            }

        }

        logger.log(Level.OFF, "Конец работы");
        System.out.println("Конец работы...");

    }


    public static void readFile(Confectionery confectionery) {


        try (FileReader fr = new FileReader(f); BufferedReader reader = new BufferedReader(fr)) {

            String line = reader.readLine();

            while (line != null) {

                confectionery.add(line);
                line = reader.readLine();

            }

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка работы с файлом ", e);
        }

    }
}