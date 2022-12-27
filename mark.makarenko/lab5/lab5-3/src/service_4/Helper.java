package service_4;

import entity_4.CoffeeType;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Helper {
    private final static String FILE_NAME = "mark.makarenko/lab4/src/txt/file1.txt";

    public static List<CoffeeType> readFromFile() throws FileNotFoundException {
        File PATH = new File(FILE_NAME);
        List<CoffeeType> result = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] elements = line.split(";");
                CoffeeType templeData =
                        new CoffeeType(elements[0], elements[1], elements[2], elements[3], Integer.parseInt(elements[4]));
                result.add(templeData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

