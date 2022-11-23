package models;

import interfaces.GroupFactory;
import java.util.Scanner;

public class Department implements GroupFactory {
    @Override
    public Group createGroup() {
        Scanner input = new Scanner(System.in);
        //name
        System.out.println("Введите название кафедры: ");
        String name = input.nextLine();
        //S
        System.out.println("Введите направление ");
        String direction = input.nextLine();
        //personnel
        System.out.println("Введите количество преподавателей: ");
        int countOfDepartmentTeachers = Input.userInput(0,Integer.MAX_VALUE);

        return new Teacher(name, direction, countOfDepartmentTeachers);
    }
}
