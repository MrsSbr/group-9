import Models.Company;
import Supportive.Supportive;

public class Main {

    public static void typeChoice() {

        System.out.println("Какую коллекцию использовать?");
        System.out.println("[1] ArrayList");
        System.out.println("[2] LinkedList");
        System.out.println("Ваш выбор: ");

        int choice = Supportive.inputIntFromConsole(1, 2);

        System.out.println(Supportive.LINE);

        if (choice == 1) {

            Company c = new Company(true, Supportive.DEFAULT_YEARS_SINCE_FOUNDATION);
            Tasks.performTasks(c, true);

        } else {

            Company c = new Company(false, Supportive.DEFAULT_YEARS_SINCE_FOUNDATION);
            Tasks.performTasks(c, true);
        }

    }

    public static void main(String[] args) {
        int choice = -1;

        do {

            System.out.println("Выберите действие");
            System.out.println("[0] Завершить работу");
            System.out.println("[1] Выполнить задания");
            System.out.println("[2] Провести тесты производительности");
            System.out.println("Ваш выбор: ");

            choice = Supportive.inputIntFromConsole(0, 2);
            System.out.println(Supportive.LINE);

            choice = switch (choice) {

                case 0 -> {

                    System.out.println("Работа программы завершена");

                    yield 0;
                }

                case 1 -> {

                    typeChoice();

                    yield 1;
                }

                case 2 -> {

                    Tasks.performComparisonTest();

                    yield 2;
                }

                default -> throw new IllegalStateException("Unexpected value: " + choice);
            };

            System.out.println(Supportive.LINE);

        } while (choice != 0);

    }

}
