package tasks;

import enums.Subject;
import models.Questionnaire;
import models.QuestionnaireItem;

import java.util.List;

import static service.Helper.userInput;


public class StudentTask {
    public static void task(List<Questionnaire> forms, boolean operatingMode) {// admin task
        long startTime = System.nanoTime();
        int countUsefulSubject = findCountUsefulSubject(forms, Subject.MathAn);
        String maxMarksSubjects = findMaxMarksSubjects(forms);
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

    public static int findCountUsefulSubject(List<Questionnaire> forms, Subject nameSubject) { // 1 задача
        int count = 0;
        for (Questionnaire o : forms) {
            for (QuestionnaireItem objects : o.getListOfObject())
                if (nameSubject.equals(objects.getObject()) && objects.getMarks() >= 4) count++;//добавить икволс
        }
        return count;
    }

    public static String findMaxMarksSubjects(List<Questionnaire> forms) { // 2 задача
        double tmp;
        double maxMarks = 0;
        StringBuilder subjects = new StringBuilder();
        for (Subject s : Subject.values()) {
            tmp = 0;
            for (Questionnaire form : forms) {
                for (QuestionnaireItem obj : form.getListOfObject()) {
                    if (s.equals(obj.getObject())) {
                        tmp += obj.getMarks();
                    }
                }
            }
            if (tmp > maxMarks) {
                subjects.append(s);
                maxMarks = tmp;
            } else if (tmp == maxMarks) {
                subjects.append(s);
            }
            //стринг обход
        }
        return subjects.toString();
    }

    public static int countStudentsLowMarksSubjects(List<Questionnaire> form) { // 3 задача
        int count = 0;
        boolean flagMarks;
        for (Questionnaire f : form) {
            flagMarks = true;
            for (QuestionnaireItem object : f.getListOfObject()) {
                if (object.getMarks() >= 3) {
                    flagMarks = false;
                    break;
                }
            }
            if (flagMarks) count++;
        }
        return count;
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
}
