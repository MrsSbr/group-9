package service;

import entity.Khanate;

import java.io.IOException;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Helper {
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
            fileHandler = new FileHandler("ivan.zhadobin\\lab5\\Lab4\\logs");
            _logger.addHandler(fileHandler);
        } catch (IOException e) {
            _logger.log(Level.SEVERE, "ошибка при вводе-выводе данных: " + e.getMessage());
        }
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

    public static <K, V extends Comparable<V>>
    Map.Entry<K, V>
    getMaxEntryInMapBasedOnValue(Map<K, V> map) {
        Map.Entry<K, V> entryWithMaxValue = null;
        for (Map.Entry<K, V> currentEntry :
                map.entrySet()) {

            if (
                    entryWithMaxValue == null
                            || currentEntry.getValue().compareTo(
                            entryWithMaxValue.getValue())
                            > 0) {

                entryWithMaxValue = currentEntry;
            }
        }
        return entryWithMaxValue;
    }

    public static <K, V> K getKey(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
