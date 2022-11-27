package models;

import java.util.List;

public class Questionnaire {
    private List<QuestionnaireItem> listofobject;

    public Questionnaire(List<QuestionnaireItem> listofobject) {
        this.listofobject = listofobject;
    }

    public List<QuestionnaireItem> getListOfObject() {
        return listofobject;
    }
}

