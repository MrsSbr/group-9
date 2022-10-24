import horse.Races;

import java.io.*;
import java.util.Scanner;
import java.util.logging.*;

public class Main {
    public static void main(String[] args) {

        Logger log = Logger.getLogger(Main.class.getName());
        log.info("Начало работы");
        Scanner scan = new Scanner(System.in);
        int choise = -1;
        String input = "";
        Races races = new Races();
        readFile(races,log);

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
                log.info("Неверный ввод строка 28");
                e.printStackTrace();
            }

            switch (choise) {
                case 1 -> StaticHorse(races);
                case 2 -> System.out.println("Самая успешная лошадь " + races.mostSuccessful() + " при учете правила " +
                        "1 балл за 3 место, 2 балла за 2, 3 балла за первое");
                case 3 -> System.out.println("Самая активная лошадь " + races.mostActive());
            }

        }
        log.info("Конец работы");
        System.out.println("Конец работы...");

    }

    public static void StaticHorse(Races races) {

        Scanner scan = new Scanner(System.in);
        String input = "";
        System.out.println("Введите имя лошади");
        input = scan.next();
        System.out.println(races.statisticHorse(input));

    }


    public static void readFile(Races races,Logger log) {

        try {

            File file = new File("src/horse/horse.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {

                races.add(line);
                line = reader.readLine();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            log.info("Ошибка работы с файлом");
        } catch (IOException e) {
            e.printStackTrace();
            log.info("Ошибка работы с файлом");
        }

    }
}