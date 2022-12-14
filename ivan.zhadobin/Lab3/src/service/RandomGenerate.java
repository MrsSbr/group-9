package service;

import enums.Subject;
import entity.QuestionnaireItem;
import entity.Questionnaire;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class RandomGenerate {
    protected static final int COUNT_SUBJECTS = 7;

    public static QuestionnaireItem randomGenerateObject(int pick) {
        Subject subject = Subject.values()[pick];
        int mark = (int) (Math.random() * 4) + 2;
        return new QuestionnaireItem(subject, mark);
    }

    public static Questionnaire randomGenerateForm() {
        List<QuestionnaireItem> objects = new ArrayList<>();
        for (int i = 0; i < COUNT_SUBJECTS; i++) {
            objects.add(randomGenerateObject(i));
        }
        return new Questionnaire(objects);
    }

    public static Questionnaire randomGenerateFormOnLinkedList() {
        List<QuestionnaireItem> objects = new LinkedList<>();
        for (int i = 0; i < COUNT_SUBJECTS; i++) {
            objects.add(randomGenerateObject(i));
        }
        return new Questionnaire(objects);
    }
    public static Questionnaire randomGenerateFormOnStack() {
        Stack<QuestionnaireItem> objects = new Stack<>();
        for (int i = 0; i < COUNT_SUBJECTS; i++) {
            objects.add(randomGenerateObject(i));
        }
        return new Questionnaire(objects);
    }
}
