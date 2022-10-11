/*
*   Лабораторная работа №1
*   Выполнила Перелыгина К.В., 9 группа, 3 курс
*
*   Условие задачи:
*   Описать иерархию классов для музыкальных инструментов в оркестре
 */

import models.*;

import java.util.Scanner;
import static supportive.InputCheck.inputIntFromConsole;

public class Main {

    public static int chooseType() {

        System.out.println("Выберите тип инструмента");
        System.out.println("[1] Скрипка");
        System.out.println("[2] Флейта");
        System.out.println("[3] Треугольник");
        System.out.println("Ваш выбор: ");

        return inputIntFromConsole(1, 3);

    }

    public static void main(String[] args) {

        Orchestra orc = new Orchestra();
        Scanner in = new Scanner(System.in);
        int choice = -1;

        do {

            System.out.println("\nВыберите действие");
            System.out.println("[0] Завершить работу");
            System.out.println("[1] Добавить инструмент");
            System.out.println("[2] Удалить инструмент");
            System.out.println("[3] Распечатать инструменты");
            System.out.println("[4] Сравнить инструменты");
            System.out.println("[5] Сыграть мелодию");
            System.out.println("Ваш выбор: ");

            choice = inputIntFromConsole(0, 5);
            System.out.println("\n");

            choice = switch (choice) {

                case 0 -> {

                    System.out.println("Работа программы завершена");

                    yield 0;
                }

                case 1 -> {

                    int typeChoice = chooseType();
                    MusicalInstrument mi;

                    if (typeChoice == 1) {
                        mi = new Violin();
                        mi.inputFromConsole();
                        orc.add(mi);
                    } else if (typeChoice == 2) {
                        mi = new Flute();
                        mi.inputFromConsole();
                        orc.add(mi);
                    } else if (typeChoice == 3) {
                        mi = new Triangle();
                        mi.inputFromConsole();
                        orc.add(mi);
                    }

                    yield 1;

                }

                case 2 -> {

                    if (orc.isEmpty()) {

                        System.out.println("Инструменты не найдены");

                    } else {

                        int indexChoice = inputIntFromConsole(0, orc.getSize());
                        orc.delete(indexChoice);

                    }

                    yield 2;
                }

                case 3 -> {

                    orc.printWithHash();

                    yield 3;
                }

                case 4 -> {

                    if (orc.getSize() < 2) {

                        System.out.println("Слишком мало инструментов");

                    } else {

                        System.out.println("Введите индексы сравниваемых инструментов");
                        int first = inputIntFromConsole(0, orc.getSize());
                        int second = inputIntFromConsole(0, orc.getSize());
                        System.out.println("Инструменты " + (orc.compare(first, second) ? "" : "не ") + "одинаковые");

                    }

                    yield 4;
                }

                case 5 -> {

                    orc.play();

                    yield 5;
                }

                default -> throw new IllegalStateException("Unexpected value: " + choice);
            };

        } while (choice != 0);


    }
}
