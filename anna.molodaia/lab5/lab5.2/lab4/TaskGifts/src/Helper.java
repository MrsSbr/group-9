import enums.ColorGift;
import enums.SizeGift;
import enums.TypeGift;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Helper {
    private static final Logger logger = Logger.getLogger(Helper.class.getName());

    public static int getInt() {
        logger.log(Level.INFO, "Старт getInt метода.");

        Scanner in = new Scanner(System.in);

        int result = 0;
        boolean exit = false;
        while (!exit) {
            try {
                result = Integer.parseInt(in.next());
                exit = true;
            } catch (NumberFormatException exception) {
                logger.log(Level.SEVERE, "Ошибка парсинга int", exception);
            }
        }

        logger.log(Level.OFF, "Конец getInt метода.");
        return result;
    }

    public static int getIntInDiapason(int start, int end) {
        logger.log(Level.INFO, "Старт getIntInDiapason метода");

        int result = 0;
        boolean exit = false;

        while (!exit) {
            result = getInt();
            if (result >= start && result <= end) {
                exit = true;
            } else {
                logger.log(Level.INFO, "Число должно находится в диапазоне от %s до %s ".formatted(start, end));
                logger.log(Level.WARNING, "Невалидный ввод числа");
            }
        }

        logger.log(Level.OFF, "Конец getIntInDiapason метода.");
        return result;
    }

    public static TeodorAnalysis readFileInListGift(String path) {
        TeodorAnalysis gifts = new TeodorAnalysis(new ArrayList<>());

        File file = Paths.get(path).toFile();
        try (var is = new FileInputStream(file);
             var reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            reader.readLine(); //пропуск заголовка
            reader.lines().forEach(gifts::add);

        } catch (NumberFormatException exception) {
            logger.log(Level.SEVERE, "Ошибка парсинга числа", exception);
        } catch (IOException exception) {
            logger.log(Level.SEVERE, "Ошибка работы с файлом ", exception);
        }
        return gifts;
    }
}

