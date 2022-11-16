package service;

import models.Subject;
import models.Object;

public class RandomGenerateObject {

    public static Object randomGenerate(int pick) {
        Subject subject = Subject.values()[pick];
        int mark = (int)(Math.random()*5) +2;
        return new Object(subject,mark);
    }

}
