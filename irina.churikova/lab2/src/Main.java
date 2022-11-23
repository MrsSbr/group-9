import interfaces.GroupFactory;
import models.*;
import enums.GroupTypes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean isExit = false;
        List<Group> groups = new ArrayList<>();
        while (!isExit) {
            System.out.println("-Выберите пункт меню-\n" +
                    "[1] Группа студентов\n" +
                    "[2] Кафедра преподавателей\n" +
                    "[3] Информация об объектах\n" +
                    "[4] Сравнить два объекта\n" +
                    "[0] Выход.");

            int choice = Input.userInput(0, 4);

            if (choice == 0) {
                isExit = true;
            } else if (choice == 3) {
                workWithGroups(groups);
            } else if (choice == 4) {
                equalObj(groups);
            } else {
                groups.add(createGroup(choice));
            }
        }

    }

    public static void workWithGroups(List<Group> groups) {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Выберите объект:\n[0] Выход.");

            for (int i = 0; i < groups.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + groups.get(i).getName());
            }

            int choice = Input.userInput(0, groups.size());
            Group chosenPort;

            if (choice == 0) {
                isExit = true;
            } else {
                chosenPort = groups.get(choice - 1);
                if (chosenPort instanceof Student) {
                    Student student = (Student) chosenPort;
                    System.out.println("Группа " + student.getName() + " тип группы " + student.getTypeOfGroup() + "\nНаправление:" + student.getDirection() + "\nКоличество студентов: " + student.getCapacity() + "\n" + student);
                } else if (chosenPort instanceof Teacher) {
                    Teacher teacher = (Teacher) chosenPort;
                    System.out.println("Кафедра " + teacher.getName() + " тип группы " + teacher.getTypeOfGroup() + "\n Нааправлене:" + teacher.getDirection() + "\nКоличество преподавателей: " + teacher.getCount() + "\n" + teacher);
                }
            }
        }
    }

    public static void equalObj(List<Group> groups) {
        boolean isExit = false;
        boolean equal = false;
        while (!isExit) {
            System.out.println("Выберите два объекта:\n[0] Выход.");

            for (int i = 0; i < groups.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + groups.get(i).getName());
            }

            int choice1 = Input.userInput(0, groups.size());
            int choice2 = Input.userInput(0, groups.size());
            Group chosenGroup1, chosenGroup2;

            if (choice1 == 0) {
                isExit = true;
            } else {
                chosenGroup1 = groups.get(choice1 - 1);
                chosenGroup2 = groups.get(choice2 - 1);
                if (chosenGroup1 instanceof Student && chosenGroup2 instanceof Student) {
                    Student student1 = (Student) chosenGroup1;
                    Student student2 = (Student) chosenGroup2;
                    equal = student1.equals(student2);
                    isExit = true;
                } else if (chosenGroup1 instanceof Teacher && chosenGroup2 instanceof Teacher) {
                    Teacher teacher1 = (Teacher) chosenGroup1;
                    Teacher teacher2 = (Teacher) chosenGroup2;
                    equal = teacher1.equals(teacher2);
                isExit = true;
                } else {
                    equal = false;
                }
            }
        }
        if (equal) {
            System.out.println("Объекты равны");
        } else {
            System.out.println("Объекты не равны");
        }
    }

    public static Group createGroup(int type) throws Exception{
        GroupFactory groupFactory = switch (type) {
            case 1 -> GroupFactory.createGroupFactoryType(GroupTypes.STUDENTS);
            case 2 -> GroupFactory.createGroupFactoryType(GroupTypes.TEACHERS);
            default -> throw new ClassNotFoundException();
        };
        return groupFactory.createGroup();
    }
}

