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
    private static final String PATH = "lisa.kolesnikova/lab4/src/WhatDoesTheFoxSay.txt";

    public static int inputIntBetween(int left, int right) {
        int result;
        try {
            Scanner scanner = new Scanner(System.in);
            result = scanner.nextInt();
            if (result < left || result > right) {
                System.out.println("Недопустимый ввод, повторите попытку.\n Введите число между " + left + " и " + right);
                result = inputIntBetween(left, right);
            }
        } catch (InputMismatchException exception) {
            System.out.println("Введите число.");
            logger.log(Level.SEVERE, "Несоответствие типов.");
            result = inputIntBetween(left, right);
        }
        return result;
    }


    public static void readFile(FoxInterview recordsHandler) {
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] elements = line.split(";");
                Fox foxData =
                        new Fox(elements[0], Integer.parseInt(elements[1]), elements[2]);
                recordsHandler.addRecord(foxData);
            }
        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, "Файл не найден. ", e);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка считывания файла.", e);
        }
    }
}
