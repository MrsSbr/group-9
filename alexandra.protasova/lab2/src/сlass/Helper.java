package сlass;

import java.util.Scanner;

public class Helper {
    static boolean intToBool(int n){
        if(n<0 || n>1){
            throw new IllegalArgumentException("Неверное число");
        }
        return n==1;
    }

    public static int checkInput(int l, int r) {
        Scanner input = new Scanner(System.in);
        boolean f = true;
        int n = 0;
        while(f) {
            try {
                n = input.nextInt();
                if (n >= l && n <= r) {
                    f = false;
                } else {
                    System.out.println("Ошибка ввода!\n");
                }
            } catch (NumberFormatException e){
                System.out.println(e.getLocalizedMessage());
            }
        }
        return n;
    }
}
