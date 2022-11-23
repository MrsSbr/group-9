import horse.Races;

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

    public static void main(String[] args) {

        logger.log(Level.INFO, "Начало работы");
        Scanner scan = new Scanner(System.in);
        int choise = -1;
        String input = "";
        Races races = new Races();
        readFile(races);

        while (!"0".equals(input)) {

            System.out.println("1. Узнать статистику лошади");
            System.out.println("2. Найти самую успешную лошадь");
            System.out.println("3. Найти самую активную лошадь");
            System.out.println("0. Для выхода из приложения\n");
            input = scan.next();

            try {
                choise = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");
                logger.log(Level.WARNING, "Неверный ввод " + Arrays.toString(e.getStackTrace()));
            }

            switch (choise) {
                case 1 -> staticHorse(races);
                case 2 -> System.out.println("Самая успешная лошадь " + races.mostSuccessful() + " при учете правила " +
                        "1 балл за 3 место, 2 балла за 2, 3 балла за первое");
                case 3 -> System.out.println("Самая активная лошадь " + races.mostActive());
            }

        }

        logger.log(Level.OFF, "Конец работы");
        System.out.println("Конец работы...");

    }

    public static void staticHorse(Races races) {

        Scanner scan = new Scanner(System.in);
        String input;
        System.out.println("Введите имя лошади");
        input = scan.next();
        System.out.println(races.statisticHorse(input));

    }


    public static void readFile(Races races) {

        File file = new File("src/horse/horse.txt");

        try (FileReader fr = new FileReader(file); BufferedReader reader = new BufferedReader(fr)) {

            String line = reader.readLine();

            while (line != null) {

                races.add(line);
                line = reader.readLine();

            }

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка работы с файлом ", e);
        }

    }
}