package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CourtCaseGenerator {
    private static final int MIN_YEAR = 1900;
    private static final int MAX_YEAR = 2023;
    private static final List<String> names = new ArrayList<>(Arrays.asList("Дмитрий", "Борис", "Роберт", "Илья",
            "Леонид", "Александр", "Кирилл", "Никита", "Петр", "Егор", "Сергей", "Андрей"));
    private static final List<String> articles = new ArrayList<>(Arrays.asList("Мошенничество", "Убийство", "Грабеж",
            "Разбой", "Вымогательство", "Повреждение имущества", "Контрабанда"));

    private static String randName() {
        Random random = new Random();
        int nameIndex = random.nextInt(0, names.size());
        return names.get(nameIndex);
    }

    private static boolean randConvicted() {
        Random random = new Random();
        return random.nextBoolean();
    }

    private static LocalDate randDate() {
        Random random = new Random();
        int minDay = (int) LocalDate.of(MIN_YEAR, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(MAX_YEAR, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    private static String randArticle() {
        Random rand = new Random();
        int articleIndex = rand.nextInt(0, articles.size());
        return articles.get(articleIndex);
    }

    public static CourtCase randCase() {
        return new CourtCase(randName(), randName(), randDate(), randArticle(), randConvicted());
    }



}