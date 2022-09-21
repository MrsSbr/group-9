import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println("Введите от 1 до 15 римских цифр");
        if (str.length() < 1 || str.length() > 15) {
            System.out.println("Неправильный ввод");
        } else {
            System.out.println(romanToInt(str));
        }
    }

    public static int romanToInt(String str) {
        int num = 0;
        int res = 0;
        int len = str.length();
        for (int i = len - 1; i >= 0; i--) {
            switch (str.charAt(i)) {
                case 'I' -> num = 1;
                case 'V' -> num = 5;
                case 'X' -> num = 10;
                case 'L' -> num = 50;
                case 'C' -> num = 100;
                case 'D' -> num = 500;
                case 'M' -> num = 1000;
            }
            if (num * 3 < res) {
                res -= num;
            } else {
                res += num;
            }
        }
        return res;
    }
}

