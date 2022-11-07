import classes.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MainApiary {

    public static void main(String[] args) {
        Statistics st = new Statistics();
        boolean end = false;
        while (!end) {
            System.out.println("Menu:");
            System.out.println("[1] Ввести период");
            System.out.println("[2] Проверить производительность");
            System.out.println("[0] Exit");
            int n = Helper.userInput(0, 2);
            switch (n) {
                case 1:
                    st.countVolume(new ArrayList<>(), false);
                    break;
                case 2:
                    System.out.println("Массив: ");
                    st.countVolume(new ArrayList<>(), true);
                    System.out.println("Связный список: ");
                    st.countVolume(new LinkedList<>(), true);
                    break;
                case 0:
                    end = true;
                    break;
                default:
                    System.out.println("Повторите ввод!");
            }
        }
    }



}
