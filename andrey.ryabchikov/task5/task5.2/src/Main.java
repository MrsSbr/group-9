import horse.Races;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

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

        Path path = Paths.get("src/horse/horse.txt");

        try (Stream<String> lineStream = Files.newBufferedReader(path).lines()) {

            List<String> lines = lineStream.toList();
            lines.forEach(races::add);

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка работы с файлом ", e);
        }


    }
}