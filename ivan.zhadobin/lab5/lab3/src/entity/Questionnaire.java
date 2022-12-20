package entity;

import java.util.List;

public class Questionnaire {
    List<QuestionnaireItem> listofobject;

    public Questionnaire(List<QuestionnaireItem> listofobject) {
        this.listofobject = listofobject;
    }

    public List<QuestionnaireItem> getListOfObject() {
        return listofobject;
    }
}

