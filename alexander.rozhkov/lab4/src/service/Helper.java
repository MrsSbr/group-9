package service;

import logic.RecordsHandler;
import models.TempleData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Helper {
    private static final Logger logger = Logger.getLogger(Helper.class.getName());
    private static final String PATH = "alexander.rozhkov/lab4/src/resources/donation.txt";
    public static int inputIntBetween(int left,int right) {
        int result;
        try {
            System.out.println("Введите число между " + left + " и " + right);
            Scanner scanner = new Scanner(System.in);
            result = scanner.nextInt();
            if(result < left || result > right) {
                System.out.println("Ошибка ввода! Введите число между " + left + " и " + right);
                result = inputIntBetween(left,right);
            }
        } catch (InputMismatchException exception) {
            System.out.println("Введите число!");
            logger.log(Level.SEVERE, "Несоответсвие типов");
            result = inputIntBetween(left,right);
        }
        return result;
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
}
