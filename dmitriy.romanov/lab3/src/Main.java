import models.Input;
import models.Tasks;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        boolean end = false;
        Tasks tasks = new Tasks();
        while (!end) {
            System.out.println("Выберите пункт меню: ");
            System.out.println("1 - Производительность");
            System.out.println("2 - Task");
            System.out.println("0 - Выход");

            int choice = Input.userInput(0, 2);
            switch (choice) {
                case 1 -> {
                    System.out.println("Связный список: ");
                    tasks.task(new LinkedList<>(), true);
                    System.out.println("Массив: ");
                    tasks.task(new ArrayList<>(), true);
                    System.out.println("Stack: ");
                    tasks.task(new Stack<>(), true);
                }
                case 2 -> tasks.task(new ArrayList<>(), false);
                case 0 -> end = true;
                default -> System.out.println("Нет такого пункта меню");
            }
        }

    }

}
