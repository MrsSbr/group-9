import java.util.Scanner;
public class Main {
    public static void main(String[] arg) {
        System.out.println("введите кол-во: ");
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] seats = new int[N];
        TaskMaximizeDistanceToClosestPerson.fill(seats, N);
        TaskMaximizeDistanceToClosestPerson.output(seats, N, TaskMaximizeDistanceToClosestPerson.task(seats, N));
     }
}
