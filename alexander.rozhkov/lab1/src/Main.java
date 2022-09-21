import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите ДНК последовательность:");
        String dnaSequence = getDnaSequenceBetweenLength(10, 105);
        Set<String> result = findRepeatedDnaSequence(dnaSequence);
        System.out.println("Повторяющиеся ДНК подпоследовательности:");
        System.out.println(result);
    }

    private static String getDnaSequenceBetweenLength(int leftBound, int rightBound) {
        while (true) {
            String dnaSequence = getDnaSequence();
            if (dnaSequence.length() < leftBound
                    || dnaSequence.length() > rightBound) {
                System.out.println("Некорректный размер ДНК последовательности!");
                System.out.println("Кол-во символов должно находиться между "
                                    + leftBound + " и " + rightBound);
            } else {
                return dnaSequence;
            }
        }
    }

    private static String getDnaSequence() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String string = scanner.nextLine();
            if (!chekLetterInDnaSequence(string)) {
                System.out.println("ДНК последовательность должна соержать только буквы A, C, G или T!");
            } else {
                return string;
            }
        }
    }

    private static boolean chekLetterInDnaSequence(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != 'A'
                    && string.charAt(i) != 'T'
                    && string.charAt(i) != 'C'
                    && string.charAt(i) != 'G') {
                return false;
            }
        }
        return true;
    }

    public static Set<String> findRepeatedDnaSequence(String dnaSequence) {
        Set<String> result = new HashSet<>();
        Set<String> hashTable = new HashSet<>();

        for (int i = 0; i < dnaSequence.length() - 9; i++) {
            String currentDnaSubsequence = dnaSequence.substring(i, i + 10);
            if (hashTable.contains(currentDnaSubsequence)
                    && !result.contains(currentDnaSubsequence)) {
                result.add(currentDnaSubsequence);
            } else {
                hashTable.add(currentDnaSubsequence);
            }
        }
        return result;
    }
}