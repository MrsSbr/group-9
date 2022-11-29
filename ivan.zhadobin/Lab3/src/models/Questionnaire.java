package models;

import java.util.List;

public class Questionnaire {
    private List<QuestionnaireItem> listOfObject;

    public Questionnaire(List<QuestionnaireItem> listOfObject) {
        this.listOfObject = listOfObject;
    }

    public List<QuestionnaireItem> getListOfObject() {
        return listOfObject;
    }
}

