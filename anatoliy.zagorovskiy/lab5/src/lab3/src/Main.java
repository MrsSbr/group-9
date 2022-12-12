package lab3.src;

import static lab3.src.service.MainService.*;

public class Main {

    public static void main(String[] args) {
        int choice = 1;
        while (choice != 0) {
            printMenu();
            choice = lab3.src.service.Helper.getIntInRange(0, 2);
            switch (choice) {
                case 1 -> testMode();
                case 2 -> compareMode();
            }
        }
    }

}
