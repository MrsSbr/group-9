package Models;

import Enum.ATC;
import Helper.Helper;

import java.util.*;
import java.util.stream.IntStream;


public class Task {

    protected static final int NUMBER_OF_ENTRIES = 20000;

    public void rangeForATC(Set<User> users) {

        StringBuilder rangeTele2 = new StringBuilder("Tele2: ");
        StringBuilder rangeBeeline = new StringBuilder("Beeline: ");
        StringBuilder rangeMegafon = new StringBuilder("Megafon: ");
        StringBuilder rangeMTC = new StringBuilder("MTC: ");
        List<User> arr = new ArrayList<>(users);
        IntStream.range(0, arr.size()).forEach(i -> {
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

        });
        System.out.println("Свободные диапозоны для каждой АТС: ");
        System.out.println(rangeTele2 + "\n" + rangeMegafon + "\n" + rangeBeeline + "\n" + rangeMTC);
    }

    public void countATC(Set<User> users) {
        Integer countTele2 = (int) users.stream().filter(user -> Integer.parseInt(user.getNumber()) / 100000 == ATC.Tele2.getNumVal()).count();
        Integer countBeeline = (int) users.stream().filter(user -> Integer.parseInt(user.getNumber()) / 100000 == ATC.Beeline.getNumVal()).count();
        Integer countMegafon = (int) users.stream().filter(user -> Integer.parseInt(user.getNumber()) / 100000 == ATC.Megafon.getNumVal()).count();
        Integer countMTC = (int) users.stream().filter(user -> Integer.parseInt(user.getNumber()) / 100000 == ATC.MTC.getNumVal()).count();

        System.out.println("Количество пользователей для каждой АТС: ");
        System.out.println("Tele2: " + countTele2 + "\n" + "Megafon: " + countMegafon + "\n" + "Beeline: " + countBeeline + "\n" + "MTC: " + countMTC);
    }

    public String randomNumber() {
        List<ATC> values = Arrays.asList(ATC.values());
        Random ran = new Random();
        int t = values.get(ran.nextInt(values.size())).getNumVal();
        String tmp = String.valueOf(t);
        StringBuilder number = new StringBuilder(tmp);
        IntStream.range(0, 5).forEach(i -> {
            number.append(String.valueOf(ran.nextInt(9)));
        });


        return number.toString();
    }

    public void print(Set<User> users) {
        users.forEach(user -> System.out.println(user.toString()));

    }


    public void task(Set<User> users, boolean check) {
        IntStream.range(2, NUMBER_OF_ENTRIES).forEach(i -> {
            users.add(new User("Пользователь " + i, randomNumber()));
        });


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
                        IntStream.range(0, values.size()).forEach(i -> {
                            System.out.println((i + 1) + "." + values.get(i).toString());
                        });
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