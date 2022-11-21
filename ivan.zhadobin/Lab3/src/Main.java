import models.Form;
import models.Object;
import enums.Subject;
import service.RandomGenerate;

import java.util.*;

import static service.Helper.userInput;

public class Main {
    protected static final int COUNT_STUDENTS = 550;

    public static void main(String[] args) {
        List<Form> forms;
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
        List<Form> forms;
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


    public static Subject menuForTheFirstTask() {
        Subject object = null;
        System.out.println("Выберите предмет: ");
        System.out.println("1 - Математический анализ");
        System.out.println("2 - Алгебра");
        System.out.println("3 - Информатика");
        System.out.println("4 - Численные методы");
        System.out.println("5 - Дифференциальные уравнения");
        System.out.println("6 - Теория вероятностей");
        System.out.println("7 - Функциональный анализ");

        int choice = userInput(1, 7);
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
        }
        return object;
    }

    public static List<Form> generateListOfFormOnArray() { //заполнение массива
        List<Form> forms = new ArrayList<>();
        for (int i = 0; i < COUNT_STUDENTS; i++) {
            forms.add(RandomGenerate.randomGenerateForm());
        }
        return forms;
    }

    public static List<Form> generateListOfFormOnLinkedList() { //заполнение списка
        List<Form> forms = new LinkedList<>();
        for (int i = 0; i < COUNT_STUDENTS; i++) {
            forms.add(RandomGenerate.randomGenerateFormOnLinkedList());
        }
        return forms;
    }

    public static List<Form> generateListOfFormOnStack() { //заполнение стэка
        Stack<Form> forms = new Stack<>();
        for (int i = 0; i < COUNT_STUDENTS; i++) {
            forms.add(RandomGenerate.randomGenerateForm());
        }
        return forms;
    }


    public static void task(List<Form> forms, boolean operatingMode) {// admin task
        long startTime = System.nanoTime();
        int countUsefulSubject = findCountUsefulSubject(forms, Subject.MathAn);
        StringBuilder maxMarksSubjects = findMaxMarksSubjects(forms);
        int studentsLowMarksSubjects = countStudentsLowMarksSubjects(forms);

        if (operatingMode) {
            startTime = System.nanoTime() - startTime;
            System.out.printf("Время: %,9.3f ms\n", startTime / 1_000_000.0);
        }

        if (!operatingMode) {
            Subject nameSubject = menuForTheFirstTask();
            countUsefulSubject = findCountUsefulSubject(forms, nameSubject);
            System.out.printf("Сколько студентов назвали полезным предмет " + nameSubject + ": " + countUsefulSubject + "\n");
            System.out.printf("Предмет(-ы) с наибольшей оценкой: " + maxMarksSubjects + "\n");
            System.out.printf("Кол-во студентов не оценивших положительно ни один предмет: " + studentsLowMarksSubjects);
        }
    }

    public static int findCountUsefulSubject(List<Form> forms, Subject nameSubject) { // 1 задача
        int count = 0;
        for (Form o : forms) {
            for (Object objects : o.getListOfObject())
                if (nameSubject == objects.getObject() && objects.getMarks() >= 4) count++;
        }
        return count;
    }

    public static StringBuilder findMaxMarksSubjects(List<Form> forms) { // 2 задача
        int count;
        double tmp;
        double averageMax = 0;
        StringBuilder subjects = new StringBuilder();
        for (Subject s : Subject.values()) {
            tmp = 0;
            count = 0;
            for (Form form : forms) {
                for (Object obj : form.getListOfObject()) {
                    if (s == obj.getObject()) {
                        tmp += obj.getMarks();
                        count++;
                    }
                }
            }
            tmp = (double) Math.round(tmp / count * 100d) / 100d;
            if (tmp > averageMax) {
                subjects = new StringBuilder();
                subjects.append(s);
                averageMax = tmp;
            } else if (tmp == averageMax) {
                subjects.append(s);
            }
        }
        return subjects;
    }

    public static int countStudentsLowMarksSubjects(List<Form> form) { // 3 задача
        int count = 0;
        boolean flagMarks;
        for (Form f : form) {
            flagMarks = true;
            for (Object object : f.getListOfObject()) {
                if (object.getMarks() >= 3) {
                    flagMarks = false;
                    break;
                }
            }
            if (flagMarks) count++;
        }
        return count;
    }
}