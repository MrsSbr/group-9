package models;
import java.util.List;

public class Object {
    protected Subject object;
    protected int marks;

    public Object(Subject object, int marks) {
        this.object = object;
        this.marks = marks;
    }

    public Object() {
        object = null;
        marks = 0;
    }

    public Subject getObject(){
        return object;
    }

    public void setObject(Subject object, int marks){
        this.object = object;
        this.marks = marks;
    }

    public int getMarks(){
        return marks;
    }

    public String toString(){
        return "Анкета:\n" +
                "Название предмета: " + object +
                "Оценки: " + marks;
    }

}