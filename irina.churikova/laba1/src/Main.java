import java.util.Scanner;

public class Main {
    public static void printMas(int[] mas, int n) {
        System.out.print("[");
        for (int i = 0; i < n-1; i++) {
            System.out.print(mas[i]);
            System.out.print(", ");
        }
        System.out.print(mas[n-1]);
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите таргет");
        int target ;
        target = in.nextInt();
        while (target > 500 || target <1) {
            System.out.println("Некорректное значение цели! Повторите ввод");
            target = in.nextInt();
        }
        System.out.println("Значение цели:");
        System.out.println(target);

        int count = 0;
        System.out.println("Введите количество кандидатов");
        while (count < 1 || count > 30) {
            count = in.nextInt();
            System.out.println("Число должно находится в диапазоне от 1 до 30");
        }

        int[] candidates = new int[count];
        for (int i = 0; i < count; i++) {
            candidates[i] = in.nextInt();
        }
        Candidat candidat = new Candidat(candidates,count,7);
        int[][]answer = candidat.answerByTarget(target);
            for (int i = 0; i < candidat.getCountOfAnswers(); i++) {
                printMas(answer[i], candidat.getMinSize());
            }

        }
    }
