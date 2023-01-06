package org.example;

import entity.Cat;
import entity.JsonSerializer;
import org.apache.commons.text.StringEscapeUtils;
public class Main {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        Cat cat = new Cat();
        System.out.println(JsonSerializer.serialize(cat));
    }
}