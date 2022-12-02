package models;

import interfaces.GroupFactory;
import java.util.Scanner;

public class GroupOfStudent implements GroupFactory {

    public static Student createGroup() {
        Scanner input = new Scanner(System.in);
        //name
        System.out.println("Введите название группы: ");
        String name = input.nextLine();
        //direction
        System.out.println("Введите профиль группы: ");
        String direction = input.nextLine();

        System.out.println("Введите максимальное количество обучающихся: ");
        int Capacity = Input.userInput(0, Integer.MAX_VALUE);

        return new Student(name, direction, Capacity);
    }

}
