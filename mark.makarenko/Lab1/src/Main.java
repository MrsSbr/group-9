
import java.util.Scanner;
public class Main {
    public static void main(String[] arg) {

        int[] seats;
        int N = 5;
        seats = new int[N];
        func.Fill(seats, N);
        func.Output(seats, N, func.Task(seats, N));
    }
}
