package entity;

public class QuestionnaireItem {
    protected Subject object;
    protected int marks;

    public QuestionnaireItem(Subject object, int marks) {
        this.object = object;
        this.marks = marks;
    }

    public QuestionnaireItem() {
        object = null;
        marks = 0;
    }

    public Subject getObject() {
        return object;
    }

    public int getMarks() {
        return marks;
    }

    public void setObject(Subject object, int marks) {
        this.object = object;
        this.marks = marks;
    }

    public String toString() {
        return "Название предмета: " + object +
                " Оценки: " + marks;
    }

}