package src;

import java.util.Scanner;

class IntegerToRoman {
    static int[] ch = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String integerToRoman(String strInteger) {
        int intInteger = Integer.parseInt(strInteger);
        StringBuilder res = new StringBuilder("");
        for (int i = 0; i < ch.length; i++) {
            while (ch[i] <= intInteger) {
                res.append(roman[i]);
                intInteger -= ch[i];
            }
        }
        return res.toString();
    }

    public static String input() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: \n");
        String integer = in.nextLine();

        while (!checkStr(integer) || Integer.parseInt(integer) < 1 || Integer.parseInt(integer) > 3999) {
            System.out.print("Введите число в диапазоне [1;3999]: \n");
            integer = in.nextLine();
        }
        return integer;
    }

    public static boolean checkStr(String str) {
        try {
            int value = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Вы ввели строку! Введите число в диапазоне [1;3999]: \n");
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean exitFlag = false;

        while (!exitFlag) {
            String str = input();
            str = integerToRoman(str);
            System.out.print("Римские цифры: " + str);

            System.out.println("\nВыйти из программы? 0 - Выйти/1 - Ввести новое число");
            if (in.nextInt() == 0) {
                exitFlag = true;
            }
        }
    }
}