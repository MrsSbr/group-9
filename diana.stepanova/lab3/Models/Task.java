package Models;

import Enum.ATC;
import Helper.Helper;

import java.util.Collection;
import java.util.*;


public class Task {
    protected static final int NUMBER_OF_ENTRIES = 20000;


    public void addUser(List<User> users) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите ФИО пользователя: ");
        String name = in.nextLine();
        System.out.println("Выберете АТС: ");
        List<ATC> values = Arrays.asList(ATC.values());
        for (int i = 0; i < values.size(); i++) {
            System.out.println((i + 1) + "." + values.get(i).toString());
        }
        int choice = Helper.input(1, values.size());
        String number = String.valueOf(values.get(choice - 1).getNumVal());
        number += Helper.input2();
        users.add(new User(name, number));
        Collections.sort(users, new UserComparator());
    }

    public void rangeForATC(List<User> users) {
        StringBuilder rangeTele2 = new StringBuilder("Tele2: ");
        StringBuilder rangeBeeline = new StringBuilder("Beeline: ");
        StringBuilder rangeMegafon = new StringBuilder("Megafon: ");
        StringBuilder rangeMTC = new StringBuilder("MTC: ");
        for (int i = 0; i < users.size(); i++) {
            if (i + 1 < users.size()) {
                int number1 = Integer.parseInt(users.get(i).getNumber());
                int number2 = Integer.parseInt(users.get(i + 1).getNumber());
                if (number1 / 100000 == ATC.Tele2.getNumVal()) {
                    rangeTele2.append("[").append(number1 + 1).append("-").append(number2 - 1).append("]\n");
                }
                if (number1 / 100000 == ATC.Beeline.getNumVal()) {
                    rangeBeeline.append("[").append(number1 + 1).append("-").append(number2 - 1).append("]\n");
                }
                if (number1 / 100000 == ATC.Megafon.getNumVal()) {
                    rangeMegafon.append("[").append(number1 + 1).append("-").append(number2 - 1).append("]\n");
                }
                if (number1 / 100000 == ATC.MTC.getNumVal()) {
                    rangeMTC.append("[").append(number1 + 1).append("-").append(number2 - 1).append("]\n");
                }
            }
        }
        System.out.println("Свободные диапозоны для каждой АТС: ");
        System.out.println(rangeTele2 + "\n" + rangeMegafon + "\n" + rangeBeeline + "\n" + rangeMTC);
    }

    public void countATC(List<User> users) {
        int countTele2 = 0;
        int countBeeline = 0;
        int countMegafon = 0;
        int countMTC = 0;
        for (User user : users) {
            int number1 = Integer.parseInt(user.getNumber());

            if (number1 / 100000 == ATC.Tele2.getNumVal()) {
                countTele2++;
            }
            if (number1 / 100000 == ATC.Beeline.getNumVal()) {
                countBeeline++;
            }
            if (number1 / 100000 == ATC.Megafon.getNumVal()) {
                countMegafon++;
            }
            if (number1 / 100000 == ATC.MTC.getNumVal()) {
                countMTC++;
            }
        }
        System.out.println("Количество пользователей для каждой АТС: ");
        System.out.println("Tele2: " + countTele2 + "\n" + "Megafon: " + countMegafon + "\n" + "Beeline: " + countBeeline + "\n" + "MTC: " + countMTC);
    }

    public String randomNumber() {
        List<ATC> values = Arrays.asList(ATC.values());
        Random ran = new Random();
        StringBuilder number = new StringBuilder(String.valueOf(values.get(ran.nextInt(values.size())).getNumVal()));
        for (int i = 0; i < 5; i++) {
            number.append(String.valueOf(ran.nextInt(9)));
        }
        return number.toString();
    }

    public void print(List<User> users) {
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    public void task(List<User> users, boolean check) {
        for (int i = 1; i <= NUMBER_OF_ENTRIES; i++) {
            users.add(new User("Пользователь " + i, randomNumber()));
        }
        Collections.sort(users, new UserComparator());
        Scanner in = new Scanner(System.in);
        int choice = -1;
        if (!check) {
            while (choice != 0) {
                System.out.println("""
                        Меню:
                        1. Добавить нового пользователя
                        2. Вывести свободные диапозоны
                        3. Посчитать количество пользователей для каждой АТС
                        4. Распечатать
                        0. Выход""");
                choice = Helper.input(0, 4);
                switch (choice) {
                    case 1:
                        addUser(users);
                        break;

                    case 2:
                        rangeForATC(users);
                        break;
                    case 3:
                        countATC(users);
                        break;
                    case 4:
                        print(users);
                        break;

                    case 0:
                        break;
                }
            }
        } else {
            long start = System.nanoTime();
            countATC(users);
            start = System.nanoTime() - start;
            System.out.printf("Elapsed %,9.3f ms\n", start / 1_000_000.0);
        }


    }


}
