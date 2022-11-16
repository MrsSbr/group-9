import models.Object;
import models.Subject;
import service.RandomGenerateObject;

import java.util.*;

import static service.Helper.userInput;

public class Main {
    protected static final int COUNT_STUDENTS = 550;
    protected static final int COUNT_SUBJECTS = 7;

    public static void main(String[] args) {
        List<Object> objects = new ArrayList<Object>();
        task(objects);
        boolean exit = true;
        while (exit) {
            System.out.println("Выберите пункт меню: ");
            System.out.println("1 - Производительность");
            System.out.println("2 - Выполнение задачи");
            System.out.println("0 - Выход");
            int choice = userInput(0, 2);
            ;
            switch (choice) {
                case 1:
                    break;
                case 2:
                    menu_task();
                    break;
                case 0:
                    exit = false;
                    break;
                default:
                    System.out.println("Введите корректные данный! (0-2)");
            }
        }
    }

    public static void menu_task() {
        Scanner sc = new Scanner(System.in);
        boolean exit = true;
        while (exit) {
            System.out.println("Выберите пункт меню: ");
            System.out.println("1 - По заданному предмету определить сколько студентов назвали его полезным");
            System.out.println("2 - Предмет(ы) с наибольшей оценкой");
            System.out.println("3 - Сколько студентов не оценили положительно ни один предмет");
            System.out.println("0 - Выход");
            int choice = userInput(0, 3);
            switch (choice) {
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    exit = false;
                    break;
                default:
                    System.out.println("Введите корректные данный! (0-3)");
            }
        }
    }

    public static int task1(List<Object> objects) {
        int count = 0;
        Subject nameSubject = menu_task1();

        for (Object o : objects) {
            if (nameSubject == o.getObject() && o.getMarks() >= 4)
                count++;
        }

        return count;
    }

    public static Subject task2(List<Object> objects) {
        Subject subject = null;
        double averageMax=0;
        for(Subject s : Subject.values()) {
            int count=0;
            double tmp=0;
            for(Object o : objects){
                if(o.getObject() == s){
                    tmp+=o.getMarks();
                    count++;
                }
            }
            tmp=tmp/count;
            if(tmp>averageMax){
                averageMax=tmp;
                subject =s;
            }
        }
        return subject;
    }

    public static Subject menu_task1() {
        Subject object = null;
        System.out.println("Выберите предмет: ");
        System.out.println("1 - Математический анализ");
        System.out.println("2 - Алгебра");
        System.out.println("3 - Информатика");
        System.out.println("4 - Численные методы");
        System.out.println("5 - Дифференциальные уравнения");
        System.out.println("6 - Теория вероятностей");
        System.out.println("7 - Функциональный анализ");
        int choice = userInput(0, 7);
        switch (choice) {
            case 1:
                object = Subject.MathAn;
                break;
            case 2:
                object = Subject.ALgebra;
                break;
            case 3:
                object = Subject.Inform;
                break;
            case 4:
                object = Subject.ChislMethod;
                break;
            case 5:
                object = Subject.DU;
                break;
            case 6:
                object = Subject.TerVer;
                break;
            case 7:
                object = Subject.FunkAn;
                break;
            default:
                System.out.println("Введите корректные данный! (0-3)");
        }
        return object;
    }


    public static void task(List<Object> objects) {
        int marks = 0;

        for (int i = 0; i < COUNT_STUDENTS; i++) {
            int pickIndex = 0;
            for (int j = 0; j < COUNT_SUBJECTS; j++) {
                objects.add(RandomGenerateObject.randomGenerate(pickIndex));
                pickIndex++;
            }
        }

        //int task1 = task1(objects);
        //System.out.println(task1);
        //Subject task2 = task2(objects);
        //System.out.println(task2);
    }
}