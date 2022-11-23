import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        char[][] board = inputBoard();
        if (isValidSudoku(board)) {
            System.out.println("Доска валидна.");
        } else {
            System.out.println("Доска не валидна.");
        }
    }

    public static char[][] inputBoard() {
        char[][] board = new char[9][9];
        String bufString;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 9 строк (каждая строка это 9 символов (цифра от 1 до 9 или символ '.'), разделяемые пробелами.");
        for (int i = 0; i < 9; i++) {
            bufString = scanner.nextLine();
            while (!isCorrectLine(bufString)) {
                System.out.println("Ввод некорректен!");
                System.out.println("Введите строку!");
                bufString = scanner.nextLine();
            }
            for (int q = 0; q < 17; q += 2) {
                board[i][q/2] = bufString.charAt(q);
            }
        }
        return board;
    }

    public static boolean isCorrectLine(String line) {
        if (line.length() != 17) {
            return false;
        }
        for (int i = 0; i < 17; i += 2) {
            if (line.charAt(i) != '.' && line.charAt(i) != '1' && line.charAt(i) != '2' && line.charAt(i) != '3' && line.charAt(i) != '4'
                    && line.charAt(i) != '5' && line.charAt(i) != '6' && line.charAt(i) != '7' && line.charAt(i) != '8' && line.charAt(i) != '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] wasDigit = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (wasDigit[board[i][j] - '1']) {
                        return false;
                    }
                    wasDigit[board[i][j] - '1'] = true;
                }
            }
        }
        for (int j = 0; j < 9; j++) {
            boolean[] wasDigit = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    if (wasDigit[board[i][j] - '1']) {
                        return false;
                    }
                    wasDigit[board[i][j] - '1'] = true;
                }
            }
        }
        for (int iStart = 0; iStart < 9; iStart += 3) {
            for (int jStart = 0; jStart < 9; jStart += 3) {
                boolean[] wasDigit = new boolean[9];
                for (int i = iStart; i < iStart + 3; i++) {
                    for (int j = jStart; j < jStart + 3; j++) {
                        if (board[i][j] != '.') {
                            if (wasDigit[board[i][j] - '1']) {
                                return false;
                            }
                            wasDigit[board[i][j] - '1'] = true;
                        }
                    }
                }
            }
        }
        return true;
    }
}