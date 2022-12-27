import entity.Questionnaire;
import service.RandomGenerate;
import task.StudentTask;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static entity.Helper.userInput;
import static task.StudentTask.task;


public class main5 {
    public static final int COUNT_STUDENTS = 550;

    public static void main(String[] args) {
        List<Questionnaire> forms;
        boolean exit = true;
        while (exit) {
            System.out.println("\nВыберите пункт меню: ");
            System.out.println("1 - Производительность");
            System.out.println("2 - Выполнение задачи");
            System.out.println("0 - Выход");
            int choice = userInput(0, 2);
            switch (choice) {
                case 1:
                    System.out.println("Связный список: ");
                    forms = generateListOfFormOnLinkedList();
                    task(forms, true);
                    System.out.println("Массив: ");
                    forms = generateListOfFormOnArray();
                    task(forms, true);
                    System.out.println("Стэк: ");
                    forms = generateListOfFormOnStack();
                    task(forms, true);
                    break;
                case 2:
                    menuOperatingMode();
                    break;
                case 0:
                    exit = false;
                    break;
            }
        }
    }

    public static void menuOperatingMode() {
        List<Questionnaire> forms;
        System.out.println("Выберите режим работы:");
        System.out.println("1. Список");
        System.out.println("2. Массив");
        System.out.println("3. Стэк");

        int choice = userInput(1, 3);
        switch (choice) {
            case 1:
                forms = generateListOfFormOnLinkedList();

                task(forms, false);
                break;
            case 2:
                forms = generateListOfFormOnArray();
                task(forms, false);
                break;
            case 3:
                forms = generateListOfFormOnStack();
                task(forms, false);
                break;
        }
    }

    public static List<Questionnaire> generateListOfFormOnArray() { //заполнение массива
        List<Questionnaire> forms = new ArrayList<>();
        for (int i = 0; i < COUNT_STUDENTS; i++) {
            forms.add(RandomGenerate.randomGenerateForm());
        }
        return forms;
    }

    public static List<Questionnaire> generateListOfFormOnLinkedList() { //заполнение списка
        List<Questionnaire> forms = new LinkedList<>();
        for (int i = 0; i < COUNT_STUDENTS; i++) {
            forms.add(RandomGenerate.randomGenerateFormOnLinkedList());
        }
        return forms;
    }

    public static List<Questionnaire> generateListOfFormOnStack() { //заполнение стэка
        Stack<Questionnaire> forms = new Stack<>();
        for (int i = 0; i < COUNT_STUDENTS; i++) {
            forms.add(RandomGenerate.randomGenerateFormOnStack());
        }
        return forms;
    }
}