package service;

import enums.Subject;
import models.Object;
import models.Form;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class RandomGenerate {
    protected static final int COUNT_SUBJECTS = 7;

    public static Object randomGenerateObject(int pick) {
        Subject subject = Subject.values()[pick];
        int mark = (int) (Math.random() * 4) + 2;
        return new Object(subject, mark);
    }

    public static Form randomGenerateForm() {
        List<Object> objects = new ArrayList<>();
        for (int i = 0; i < COUNT_SUBJECTS; i++) {
            objects.add(randomGenerateObject(i));
        }
        return new Form(objects);
    }

    public static Form randomGenerateFormOnLinkedList() {
        List<Object> objects = new LinkedList<>();
        for (int i = 0; i < COUNT_SUBJECTS; i++) {
            objects.add(randomGenerateObject(i));
        }
        return new Form(objects);
    }
    public static Form randomGenerateFormOnStack() {
        Stack<Object> objects = new Stack<>();
        for (int i = 0; i < COUNT_SUBJECTS; i++) {
            objects.add(randomGenerateObject(i));
        }
        return new Form(objects);
    }


}
