package src;

import java.util.Scanner;

class IntegerToRoman {
    static int[] ch = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String integerToRoman(int value) {
        StringBuilder res = new StringBuilder("");
        for (int i = 0; i < ch.length; i++) {
            while (ch[i] <= value) {
                res.append(roman[i]);
                value -= ch[i];
            }
        }
        return res.toString();
    }

    public static int input() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: \n");
        String integer = in.nextLine();
        int value = checkAndParse(integer);
        while (value < 1 || value > 3999) {
            System.out.print("Введите число в диапазоне [1;3999]: \n");
            integer = in.nextLine();
            value = checkAndParse(integer);
        }
        return value;
    }

    public static int checkAndParse(String str) {
        try {
            int value = Integer.parseInt(str);
            return value;
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели строку!\n");
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean exitFlag = false;

        while (!exitFlag) {
            int str = input();
            System.out.print("Римские цифры: " + integerToRoman(str));

            System.out.println("\nВыйти из программы? 0 - Выйти/1 - Ввести новое число");
            if (in.nextInt() == 0) {
                exitFlag = true;
            }
        }
    }
}