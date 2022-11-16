package models;

import java.util.List;

public class Form {
    List<Object> listofobject;

    public Form(List<Object> listofobject) {
        this.listofobject = listofobject;
    }
    public List<Object>  getListOfObject(){
        return listofobject;
    }
}

