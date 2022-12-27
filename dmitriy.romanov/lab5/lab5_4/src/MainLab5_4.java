import models.Input;
import models.SubscriptionMap;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainLab5_4 {

    private static final Logger logger = Logger.getLogger(MainLab5_4.class.getName());

    public static void main(String[] args) {
        logger.log(Level.INFO, "start");
        int choice = -1;
        SubscriptionMap subs = new SubscriptionMap();
        readFile(subs);
        //subs.printMap();
        while (choice != 0) {
            System.out.println("Выберите пункт меню: ");
            System.out.println("1 - По заданному месяцу и названию найти количество экземпляров, подлежащих доставке");
            System.out.println("2 - По заданным ФИО вывести список подписных изданий данного подписчика");
            System.out.println("3 - По заданному названию и месяцу определите участок, получающий больше всего экземпляров для доставки");
            System.out.println("0 - Выход");

            choice = Input.userInput(0, 3);
            Scanner sc = new Scanner(System.in);
            int month = 0;
            String name = "";
            switch (choice) {
                case 1:
                    System.out.println("Введите месяц: ");
                    month = Input.userInput(1, 12);
                    System.out.println("Введите название издания:");
                    name = sc.nextLine();
                    System.out.println("Кол-во экземпляров для доставки: " + subs.countDelivery(month, name));
                    break;
                case 2:
                    System.out.println("Введите ФИО: ");
                    String fio = sc.nextLine();
                    System.out.println("Введите адрес: ");
                    String adres = sc.nextLine();
                    subs.printJournalOfUser(fio, adres);
                    break;
                case 3:
                    System.out.println("Введите месяц: ");
                    month = Input.userInput(1, 12);
                    System.out.println("Введите название издания:");
                    name = sc.nextLine();
                    System.out.println(subs.topDeliveringRegion(name, month));
                    break;
                case 0:
                    logger.log(Level.INFO, "end");
                    break;
                default:
                    System.out.println("Нет такого пункта меню");
                    break;
            }
        }

    }


    public static void readFile(SubscriptionMap subscription) {
        String path = new File("dmitriy.romanov\\lab4\\src\\res\\test.txt").getAbsolutePath();
        File file = new File(path);
        try (FileReader fr = new FileReader(file); BufferedReader reader = new BufferedReader(fr)) {
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                subscription.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            logger.log(Level.WARNING, e.getLocalizedMessage());
        }
    }

}
