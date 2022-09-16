import java.util.Scanner;

public class Candies {

    static byte countOfDifferent(byte[] candyType) {
        byte n = 0;
        for (int i = 0; i < candyType.length; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                if (candyType[i] == candyType[j])
                    count++;
            }
            if (count == 0) {
                n++;
            }
        }
        return n;
    }

    public static byte distributeCandies(byte[] candyType) {
        int n = candyType.length;
        int k = countOfDifferent(candyType);
        if (k >= n / 2) {
            return (byte) (n / 2);
        } else {
            return (byte) k;
        }
    }

    public static void main(String[] args) {
        byte validNum;
        byte size = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива");
        if ((validNum = in.nextByte()) <= 104 && validNum >= 2 && validNum % 2 == 0) {
            size = validNum;
        } else {
            System.out.println("Input error");
        }
        byte[] candyType = new byte[size];
        System.out.println("Вводите эл-ты");
        for (int i = 0; i < size; i++) {
            if ((validNum = in.nextByte()) <= 105 && validNum >= -105) {
                candyType[i] = validNum;
            } else {
                i--;
                System.out.println("Input error");
            }
        }
        System.out.println("Кол-во различных конфет: " + distributeCandies(candyType));
    }
}
