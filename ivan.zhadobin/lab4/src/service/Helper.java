package service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Helper {
    private static final Logger logger = Logger.getLogger(FileReader.class.getName());

    public static int userInput(int l, int r) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        Integer i = null;
        while (run) {
            String inputText = sc.nextLine();
            try {
                i = Integer.parseInt(inputText);
                if (i >= l && i <= r) {
                    run = false;
                } else {
                    System.out.println("Число не в диапазоне");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: " + e.getLocalizedMessage());
            }
        }
        return i;
    }

    public static void fileHandlerInit(Logger _logger) {
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("C:\\Users\\zhado\\IdeaProjects\\groupe-9\\ivan.zhadobin\\lab4\\logs\\logs.txt");
            _logger.addHandler(fileHandler);
        } catch (IOException e) {
            _logger.log(Level.SEVERE, "ошибка при вводе-выводе данных: " + e.getMessage());
        }
    }
}
