import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public abstract class Helper {
    public Helper() {
    }

    public static Calendar getCalendar() {
        System.out.println("Введите дату в формате yyyy-mm-dd");
        Scanner in = new Scanner(System.in);

        while(true) {
            try {
                String result = in.next();
                String[] arr = result.split("-");

                if(arr[0].length() != 4 || arr[1].length() != 2 || arr[2].length() != 2) {
                    throw new Exception("Введены неверные данные");
                }

                int year = Integer.parseInt(arr[0]);
                int month = Integer.parseInt(arr[1]);
                int day = Integer.parseInt(arr[2]);

                if(year > 2023 || year < 0 || month > 12 || month < 0 || day > 31 || day < 0) {
                    throw new Exception("Введены неверные данные");
                }

                Calendar calendar = new GregorianCalendar(year, month, day);
                return calendar;
            } catch (Exception var3) {
                var3.printStackTrace();
                System.out.println("Некорректный ввод. Повторите!");
            }
        }
    }

    public static int getInt() {
        Scanner in = new Scanner(System.in);

        while(true) {
            try {
                int result = Integer.parseInt(in.next());
                return result;
            } catch (Exception var3) {
                var3.printStackTrace();
                System.out.println("Некорректный ввод. Повторите!");
            }
        }
    }

    public static int getIntInDiapason(int start, int end) {
        int result = 0;
        boolean exitFlag = false;

        while(true) {
            while(!exitFlag) {
                result = getInt();
                if (result >= start && result <= end) {
                    exitFlag = true;
                } else {
                    System.out.println("Число должно находится в диапазоне от " + start + " до " + end);
                }
            }

            return result;
        }
    }

    public static double getPositiveDouble() {
        Scanner in = new Scanner(System.in);

        while(true) {
            try {
                double result = Double.parseDouble(in.next());
                if (result < 0.0) {
                    throw new IllegalStateException();
                }

                return result;
            } catch (Exception var4) {
                var4.printStackTrace();
                System.out.println("Некорректный ввод. Повторите!");
            }
        }
    }
}
