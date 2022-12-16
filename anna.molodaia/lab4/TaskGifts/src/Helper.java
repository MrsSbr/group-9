import enums.ColorGift;
import enums.SizeGift;
import enums.TypeGift;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                logger.log(Level.INFO,"Число должно находится в диапазоне от %s до %s ".formatted(start , end));
                logger.log(Level.WARNING, "Невалидный ввод числа");
            }
        }

        logger.log(Level.OFF, "Конец getIntInDiapason метода.");
        return result;
    }

    public static List<Gift> readFileInListGift(String path) {
        List<Gift> gifts = new ArrayList<>();
        File file = Paths.get(path).toFile();

        try (var is = new FileInputStream(file);
             var reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            reader.readLine(); //пропуск заголовка

            String line = reader.readLine();
            int index = 1;

            while (line != null) {
                var f = line.trim().split(";");
                try {
                    int year = Integer.parseInt(f[0]);
                    var size = SizeGift.getSize(f[1].trim());
                    if (size == SizeGift.NOT_DEFINE) {
                        throw new NoSuchFieldException("Нет такого размера подарка");
                    }
                    double weight = Double.parseDouble(f[2]);
                    TypeGift type;
                    type = TypeGift.getType(f[3].trim());
                    if (type == TypeGift.NOT_DEFINE) {
                        throw new NoSuchFieldException("Нет такого типа подарка");
                    }
                    ColorGift color;
                    color = ColorGift.getColor(f[4].trim());
                    if (color == ColorGift.NOT_DEFINE) {
                        throw new NoSuchFieldException("Нет такого цвета упаковочной бумаги");
                    }
                    Gift gift = new Gift(year, size, weight, type, color);
                    gifts.add(gift);
                    line = reader.readLine();
                    index++;

                } catch (NumberFormatException exception) {
                    logger.log(Level.SEVERE, "Ошибка парсинга числа в %s строке".formatted(index), exception);
                } catch (NoSuchFieldException exception) {
                    logger.log(Level.SEVERE, "Ошибка парсинга строки в enum в %s строке".formatted(index), exception);
                }
            }
        } catch (IOException exception) {
            logger.log(Level.SEVERE, "Ошибка работы с файлом ",exception);
        }
        return gifts;
    }
}

