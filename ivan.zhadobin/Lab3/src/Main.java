import models.Form;
import models.Object;
import models.Subject;
import service.RandomGenerate;

import java.util.*;

import static service.Helper.userInput;

public class Main {
    protected static final int COUNT_STUDENTS = 550;
    protected static final int COUNT_SUBJECTS = 7;

    public static void main(String[] args) {
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
                    task(new LinkedList<>(), true);
                    System.out.println("Массив: ");
                    task(new ArrayList<>(), true);
                    System.out.println("Stack: ");
                    task(new Stack<>(), true);
                    break;
                case 2:
                    task(new ArrayList<>(), false);
                    break;
                case 0:
                    exit = false;
                    break;
                default:
                    System.out.println("Введите корректные данный! (0-2)");
            }
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
            default:
                System.out.println("Введите корректные данный! (0-7)");
        }
        return object;
    }

    public static int findCountUsefulSubject(List<Object> objects, Subject nameSubject) { // 1 задача
        int count = 0;
        for (Object o : objects) {
            if (nameSubject == o.getObject() && o.getMarks() >= 4) count++;
        }
        return count;
    }

    public static StringBuilder findMaxMarksSubjects(List<Object> objects) { // 2 задача
        int count;
        double tmp;
        double averageMax = 0;
        StringBuilder subjects = new StringBuilder();
        for (Subject s : Subject.values()) {
            tmp = 0;
            count = 0;
            for (Object o : objects) {
                if (o.getObject() == s) {
                    tmp += o.getMarks();
                    count++;
                }
            }
            tmp = (double) Math.round(tmp / count * 10d) / 10d;
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
        boolean Flag;
        for (Form f : form) {
            Flag = true;
            for (Object object : f.getListOfObject()) {
                if (object.getMarks() >= 3) {
                    Flag = false;
                    break;
                }
            }
            if (Flag) count++;
        }
        return count;
    }

    public static void task(List<Object> objects, boolean flag) {// admin task
        List<Form> forms = new ArrayList<>();
        StringBuilder subjects = new StringBuilder();
        for (int i = 0; i < COUNT_STUDENTS; i++) {
            int pickIndex = 0;
            for (int j = 0; j < COUNT_SUBJECTS; j++) {
                objects.add(RandomGenerate.randomGenerateObject(pickIndex));
                forms.add(RandomGenerate.randomGenerateForm());
                pickIndex++;
            }
        }
        long startTime = System.nanoTime();
        int countUsefulSubject = findCountUsefulSubject(objects, Subject.MathAn);
        StringBuilder maxMarksSubjects = findMaxMarksSubjects(objects);
        int studentsLowMarksSubjects = countStudentsLowMarksSubjects(forms);
        if (flag) {
            startTime = System.nanoTime() - startTime;
            System.out.printf("Время: %,9.3f ms\n", startTime / 1_000_000.0);
        }
        if (!flag) {
            Subject nameSubject = menuForTheFirstTask();
            countUsefulSubject = findCountUsefulSubject(objects, nameSubject);
            System.out.printf("Сколько студентов назвали полезным предмет " + nameSubject + ": " + countUsefulSubject);
            subjects.append(findMaxMarksSubjects(objects));
            System.out.printf("\nПредмет(-ы) с наибольшей оценкой: " + subjects);
            studentsLowMarksSubjects = countStudentsLowMarksSubjects(forms);
            System.out.printf("\nКол-во студентов не оценивших положительно ни один предмет: " + studentsLowMarksSubjects);
        }
    }
}