import java.util.Scanner;

class IntegerToRoman_ {
    static int[] ch = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String integer_to_roman(String str_integer) {
        int int_integer = Integer.parseInt(str_integer);
        String res = "";
        for (int i = 0; i < ch.length; i++) {
            while (ch[i] <= int_integer) {
                res += roman[i];
                int_integer -= ch[i];
            }
        }
        return res;
    }

    public static String input() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: \n");
        String integer = in.nextLine();
        while (Integer.parseInt(integer) < 1 || Integer.parseInt(integer) > 3999) {
            System.out.print("Введите число в диапазоне [1;3999]: \n");
            integer = in.nextLine();
        }
        return integer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean exitFlag = false;

        while (!exitFlag) {
            String str = input();
            str = integer_to_roman(str);
            System.out.print("Римские цифры: " + str);

            System.out.println("\nВыйти из программы? 0 - Выйти/1 - Ввести новое число");
            if (in.nextInt() == 0) {
                exitFlag = true;
            }
        }
    }
}