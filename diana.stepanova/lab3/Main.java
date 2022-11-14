/*Вводятся данные о пользователях АТС ФИО, номер телефона (2 символа номер АТС + 5 символов номер пользователя),
всего 20 000 записей(подумайте, как можно смоделировать ввод с помощью случайных чисел)
Известно, что записи упорядочены по номеру телефона
Программа обработки данных пользователей должна иметь следующий функционал:
1. Добавить нового пользователя, сохранив упорядоченность
2. Вывести свободные диапазоны номеров по каждой АТС
3. Посчитать количество пользователей каждой АТС

В задаче должны использоваться коллекции (за исключением Map),
необходимо сравнить производительность различных коллекций для этой задачи, выбрать наиболее подходящую
(подходящие), аргументировать свой выбор*/

import Helper.Helper;
import Models.Task;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Task task = new Task();
        Scanner in = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("\nМеню:\n" +
                    "1. Задание\n" +
                    "2. Сравнение производительности\n" +
                    "0. Выход");
            choice = Helper.input(0, 2);
            switch (choice) {
                case 1:
                    task.task(new ArrayList<>(), false);
                    break;
                case 2:

                    System.out.println("Linked list: ");
                    task.task(new LinkedList<>(), true);
                    System.out.println("Array: ");
                    task.task(new ArrayList<>(), true);
                    break;
                case 0:
                    break;
            }

        }
    }

}















