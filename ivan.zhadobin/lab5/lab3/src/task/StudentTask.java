package task;

import entity.Questionnaire;
import entity.Subject;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static entity.Helper.userInput;

public class StudentTask {
    private static final int countOfSubject = 7;
    private static Questionnaire recordsOfQuestionnaire;

    public StudentTask(Questionnaire recordsOfQuestionnaire) {
        this.recordsOfQuestionnaire = recordsOfQuestionnaire;
    }


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

    public static int findCountUsefulSubject(List<Questionnaire> forms, Subject nameSubject) { // Сколько студентов назвали полезным предмет
        AtomicInteger count = new AtomicInteger();
        forms.forEach(object -> {
            object.getListOfObject().forEach(i -> {
                if (nameSubject.equals(i.getObject()) && i.getMarks() >= 4)
                    count.getAndIncrement();
            });
        });
        return count.get();
    }

    public static String findMaxMarksSubjects(List<Questionnaire> forms) { // Предмет(-ы) с наибольшей оценкой
        AtomicInteger max = new AtomicInteger();
        StringBuilder subjects = new StringBuilder();
        Subject.stream().forEach(subject -> {
            AtomicInteger tmp = new AtomicInteger();
            forms.forEach(object -> {
                object.getListOfObject().forEach(i -> {
                    if (subject.equals(i.getObject())) {
                        tmp.addAndGet(i.getMarks());
                    }
                });
            });
            if (tmp.get() > max.get()) {
                max.set(tmp.get());
                subjects.replace(0, subjects.length(), String.valueOf(subject));
            } else if (tmp.get() == max.get()) {
                subjects.append(subject);
            }


        });

        return subjects.toString();
    }

    public static int countStudentsLowMarksSubjects(List<Questionnaire> form) { // Кол-во студентов не оценивших положительно ни один предмет

        AtomicInteger countFinal = new AtomicInteger();

        form.forEach(object -> {
            AtomicInteger count = new AtomicInteger();
            object.getListOfObject().forEach(i -> {
                if (i.getMarks() < 3) {
                    count.getAndIncrement();
                }
            });
            if (count.get() == countOfSubject) {
                countFinal.getAndIncrement();
            }
        });
        return countFinal.get();
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
