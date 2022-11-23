import java.util.Scanner;

public class Main {
    static final String ROMAN_SYMBOLS = "IVXLCDM";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите от 1 до 15 римских цифр");
        String str = in.nextLine();
        if (!checkStr(str)) {
            System.out.println("Неправильный ввод");
        } else {
            System.out.println("Результат " + romanToInt(str));
        }
    }

    public static boolean checkStr(String str) {
        int len = str.length();
        for (int i = len - 1; i >= 0; i--) {
            if (ROMAN_SYMBOLS.indexOf(str.charAt(i)) == -1) {
                return false;
            }
        }
        if (len == 1) {
            return true;
        }
        int cntRimNumbers = 0;
        for (int i = len - 1; i > 0; i--) {
            if ((str.charAt(i) == 'V' || str.charAt(i) == 'X') && str.charAt(i - 1) == 'I') {
                cntRimNumbers++;
                i--;
            } else if ((str.charAt(i) == 'L' || str.charAt(i) == 'C') && str.charAt(i - 1) == 'X') {
                cntRimNumbers++;
                i--;
            } else if ((str.charAt(i) == 'D' || str.charAt(i) == 'M') && str.charAt(i - 1) == 'C') {
                cntRimNumbers++;
                i--;
            } else {
                cntRimNumbers++;
            }
        }
        return cntRimNumbers < 15;
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
            if (i != 0) {
                if ((str.charAt(i) == 'V' || str.charAt(i) == 'X') && str.charAt(i - 1) == 'I') {
                    res -= 1;
                    i--;
                } else if ((str.charAt(i) == 'L' || str.charAt(i) == 'C') && str.charAt(i - 1) == 'X') {
                    res -= 10;
                    i--;
                } else if ((str.charAt(i) == 'D' || str.charAt(i) == 'M') && str.charAt(i - 1) == 'C') {
                    res -= 100;
                    i--;
                }
            }
            res += num;
        }
        return res;
    }
}

