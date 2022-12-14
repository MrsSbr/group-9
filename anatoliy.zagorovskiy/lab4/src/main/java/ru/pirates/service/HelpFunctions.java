package ru.pirates.service;

import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelpFunctions {
    private static final Logger logger = Logger.getLogger(FileOfRecordsReader.class.getName());

    public static int getInt() {
        fileHandlerInit(logger);

        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                return Integer.parseInt(input.next());
            } catch (NumberFormatException exception) {
                logger.log(Level.WARNING, "Введено не целое число");
                System.out.println("Некорректный ввод. Повторите!");
            }
        }
    }

    public static void fileHandlerInit(Logger _logger) {
        try {
            FileHandler fileHandler = new FileHandler("anatoliy.zagorovskiy/lab4/src/logs/logs.txt");
            _logger.addHandler(fileHandler);
        } catch (IOException e) {
            _logger.log(Level.SEVERE, "ошибка при вводе-выводе данных: " + e.getMessage());
        }
    }

    public static int getIntInRange(int left, int right) {
        int result = 0;
        boolean exitFlag = false;

        while (!exitFlag) {
            result = getInt();
            if (result >= left && result <= right) {
                exitFlag = true;
            } else {
                System.out.println("Число должно быть в диапазоне [" + left + ";" + right + "]");
            }
        }
        return result;
    }

    public static <K, V> Map.Entry<K, V> min(Map<K, V> map, Comparator<V> comp) {
        Iterator<Map.Entry<K, V>> entries = map.entrySet().iterator();
        Map.Entry<K, V> min;
        for (min = entries.next(); entries.hasNext(); ) {
            Map.Entry<K, V> value = entries.next();
            if (comp.compare(value.getValue(), min.getValue()) < 0) {
                min = value;
            }
        }
        return min;
    }
}
