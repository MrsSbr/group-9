import logic.RecordsHandler;
import models.TempleData;
import service.Helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final String PATH = "alexander.rozhkov/lab4/src/resources/donation.txt";

    public static void main(String[] args) {
        logger.log(Level.INFO, "Начало работы программы...");
        RecordsHandler recordsHandler = new RecordsHandler();
        readFile(recordsHandler);
        workWithRecords(recordsHandler);
        logger.log(Level.INFO, "Конец работы программы...");
    }

    public static void workWithRecords(RecordsHandler recordsHandler) {
        while (true) {
            printMenu();
            int choose = Helper.inputIntBetween(0, 3);
            switch (choose) {
                case 1 -> System.out.println(recordsHandler.getListOfPeoplesWhoDonateInAllTemples());
                case 2 -> System.out.println(recordsHandler.getGodWhoHaveLargestNumberDonors());
                case 3 -> System.out.println(recordsHandler.getTempleWithMinimumSumOfDonation());
                case 0 -> {
                    return;
                }
            }
        }
    }

    public static void readFile(RecordsHandler recordsHandler) {
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] elements = line.split(";");
                TempleData templeData =
                        new TempleData(elements[1], elements[0], elements[2], Integer.parseInt(elements[3]));
                recordsHandler.addRecord(templeData);
            }
        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, "Файл не найден ", e);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка считывания с файла", e);
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
