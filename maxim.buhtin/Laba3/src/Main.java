public class Main {
    public static void main(String[] args) {

        int choice = -1;
        while (choice != 0) {

            System.out.println("\nMain menu\n" +
                    "1. Use ArrayList\n" +
                    "2. Use LinkedList\n" +
                    "0. Exit");
            choice = checkInputData.checkMenuItem(0, 2);

            choice = switch (choice) {

                case 1 -> {

                    Menu.employeeArrayListMenu();
                    yield 1;

                }
                case 2 -> {

                    Menu.employeeLinkedListMenu();
                    yield 2;

                }
                case 0 -> {

                    System.out.println("The end!");
                    yield 0;

                }
                default -> {

                    System.out.println("Error");
                    yield -1;

                }

            };

        }
    }
}