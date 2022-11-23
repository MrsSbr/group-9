package Models;

import Enum.ATC;
import Helper.Helper;

import java.util.*;


public class Task {

    protected static final int NUMBER_OF_ENTRIES = 20000;

    public void rangeForATC(Set<User> users) {

        StringBuilder rangeTele2 = new StringBuilder("Tele2: ");
        StringBuilder rangeBeeline = new StringBuilder("Beeline: ");
        StringBuilder rangeMegafon = new StringBuilder("Megafon: ");
        StringBuilder rangeMTC = new StringBuilder("MTC: ");
        List<User> arr = new ArrayList<>(users);

        for (int i = 0; i < arr.size(); i++) {
            if (i + 1 < arr.size()) {
                int number1 = Integer.parseInt(arr.get(i).getNumber());
                int number2 = Integer.parseInt(arr.get(i + 1).getNumber());
                if (number1 / 100000 == ATC.Tele2.getNumVal()) {
                    rangeTele2.append("[").append(number1 + 1).append("-").append(number2 - 1).append("]\n");
                } else if (number1 / 100000 == ATC.Beeline.getNumVal()) {
                    rangeBeeline.append("[").append(number1 + 1).append("-").append(number2 - 1).append("]\n");
                } else if (number1 / 100000 == ATC.Megafon.getNumVal()) {
                    rangeMegafon.append("[").append(number1 + 1).append("-").append(number2 - 1).append("]\n");
                } else {
                    rangeMTC.append("[").append(number1 + 1).append("-").append(number2 - 1).append("]\n");
                }
            }
        }
        System.out.println("Свободные диапозоны для каждой АТС: ");
        System.out.println(rangeTele2 + "\n" + rangeMegafon + "\n" + rangeBeeline + "\n" + rangeMTC);
    }

    public void countATC(Set<User> users) {
        int countTele2 = 0;
        int countBeeline = 0;
        int countMegafon = 0;
        int countMTC = 0;
        for (User user : users) {
            int number1 = Integer.parseInt(user.getNumber());

            if (number1 / 100000 == ATC.Tele2.getNumVal()) {
                countTele2++;
            } else if (number1 / 100000 == ATC.Beeline.getNumVal()) {
                countBeeline++;
            } else if (number1 / 100000 == ATC.Megafon.getNumVal()) {
                countMegafon++;
            } else {
                countMTC++;
            }
        }
        System.out.println("Количество пользователей для каждой АТС: ");
        System.out.println("Tele2: " + countTele2 + "\n" + "Megafon: " + countMegafon + "\n" + "Beeline: " + countBeeline + "\n" + "MTC: " + countMTC);
    }

    public String randomNumber() {
        List<ATC> values = Arrays.asList(ATC.values());
        Random ran = new Random();
        int t = values.get(ran.nextInt(values.size())).getNumVal();
        String tmp = String.valueOf(t);
        StringBuilder number = new StringBuilder(tmp);
        for (int i = 0; i < 5; i++) {
            number.append(String.valueOf(ran.nextInt(9)));
        }
        return number.toString();
    }

    public void print(Set<User> users) {
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    public void task(Set<User> users, boolean check) {
        for (int i = 2; i <= NUMBER_OF_ENTRIES; i++) {

            users.add(new User("Пользователь " + i, randomNumber()));
        }
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
                        Scanner in = new Scanner(System.in);
                        System.out.println("Введите ФИО пользователя: ");
                        String name = in.nextLine();
                        System.out.println("Выберете АТС: ");
                        List<ATC> values = Arrays.asList(ATC.values());
                        for (int i = 0; i < values.size(); i++) {
                            System.out.println((i + 1) + "." + values.get(i).toString());
                        }
                        int choice2 = Helper.input(1, values.size());
                        String number = String.valueOf(values.get(choice2 - 1).getNumVal());
                        number += Helper.input2();
                        name += number;
                        users.add(new User(name, number));
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
