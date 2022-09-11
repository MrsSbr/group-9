import java.util.Scanner;

public class Candies {

    static byte countOfDifferent(byte[] candyType){
        byte n=0;
        for (int i=0; i<candyType.length; i++){
            int count = 0;
            for (int j=0; j<i; j++) {
                if (candyType[i] == candyType[j])
                    count++;
            }
            if(count==0){
                n++;
            }
        }
        return n;
    }

    public static byte distributeCandies(byte[] candyType) {
        int n = candyType.length;
        int k = countOfDifferent(candyType);
        if(k>=n/2)
            return (byte) (n/2);
        else
            return (byte) k;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива");
        byte size=in.nextByte();
        byte[] candyType=new byte[size];
        System.out.println("Вводите эл-ты");
        for(int i=0; i<size; i++) {
            candyType[i]=in.nextByte();
        }
        System.out.println("Кол-во различных конфет: " + distributeCandies(candyType));
    }
}
