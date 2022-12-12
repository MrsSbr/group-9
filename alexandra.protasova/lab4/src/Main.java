import models.Dict;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.log(Level.INFO, "Начало работы");
        Dict dict = new Dict();
        int choice = -1;
        ArrayList<String> words = read();
        while (choice != 0) {
            System.out.println("Выберите пункт меню: ");
            System.out.println("1 - составить частотный словарь и вывести самое часто встречающееся слово (слова)");
            System.out.println("2 - найти самое длинное слово из тех, которые встречаются более 10 раз");
            System.out.println("3 - найти самое короткое слово, которое начинается с большой буквы и содерджит 2 буквы о");
            System.out.println("4 - подсчитать количество тех слов в тексте, которые хотя бы один раз написаны с большой буквы");
            System.out.println("0 - выход");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Частотный словарь:\n" + dict.countWords(words));
                    break;
                case 2:
                    System.out.println("Самое длинное слово: " + dict.countWordsOverTen(words));
                    break;
                case 3:
                    System.out.println("Самое короткое слово: " + dict.findSmallestWordWithTwoO(words));
                    break;
                case 4:
                    System.out.println("Кол-во слов: " + dict.countUpperWords(words));
                    break;
                case 0:
                    logger.log(Level.INFO, "end");
                    break;
                default:
                    System.out.println("Нет такого пункта меню");
                    break;
            }
        }
    }


    public static ArrayList<String> read() {
        String path = new File("alexandra.protasova/lab4/src/text/test.txt").getAbsolutePath();
        File file = new File(path);
        ArrayList<String> list = new ArrayList<String>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String s = bufferedReader.readLine();
            while (s != null) {
                String[] words = s.split("\\W+");
                System.out.println(s);
                list.addAll(Arrays.asList(words));
                s = bufferedReader.readLine();
            }
        } catch (IOException e) {
            logger.log(Level.WARNING, e.getLocalizedMessage());
        }
        return list;
    }
}
