import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(romanToInt(str));
    }

    public static int romanToInt(String str) {
        int num = 0;
        int res = 0;
        int len = str.length();
        for (int i = len - 1; i >= 0; i--) {
            switch (str.charAt(i)) {
                case 'I':
                    num = 1;
                    break;
                case 'V':
                    num = 5;
                    break;
                case 'X':
                    num = 10;
                    break;
                case 'L':
                    num = 50;
                    break;
                case 'C':
                    num = 100;
                    break;
                case 'D':
                    num = 500;
                    break;
                case 'M':
                    num = 1000;
                    break;
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

