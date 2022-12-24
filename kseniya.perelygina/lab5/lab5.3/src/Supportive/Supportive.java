package Supportive;

import java.util.Scanner;

public class Supportive {

    public static int CURRENT_YEAR = 2022;
    public static int DEFAULT_YEARS_SINCE_FOUNDATION = 50;
    public static String LINE = "---------------------------------------";
    public static String[] DEPARTMENTS = {"Отдел управления", "Отдел кадров", "Отдел маркетинга", "Отдел продаж",
            "Отдел продукта", "Отдел контроля качества", "Отдел финансов"};
    public static String[] NAMES = {"Даниил", "Максим", "Владислав", "Никита", "Артем", "Иван", "Кирилл", "Егор",
            "Илья", "Андрей"};
    public static String[] SURNAMES = {"Иванов", "Смирнов", "Кузнецов", "Попов", "Васильев", "Петров", "Соколов",
            "Лазарев", "Медведев", "Ершов"};

    public static int inputIntFromConsole(int leftBorder, int rightBorder) {

        Scanner in = new Scanner(System.in);
        int result = leftBorder - 1;

        do {

            while (!in.hasNextInt()) {
                System.out.println("Некорректное число, попробуйте снова: ");
                in.next();
            }

            result = in.nextInt();

            if (result < leftBorder || result > rightBorder) {
                System.out.println("Некорректный ввод, попробуйте снова: ");
            }

        } while (result < leftBorder || result > rightBorder);

        return result;
    }

}
