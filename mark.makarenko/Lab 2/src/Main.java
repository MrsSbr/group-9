import Models.Cow;
import Models.Horse;
import Models.Pig;
import Interface.Farmable;

import java.util.List;

import AnimalConstruction.Animal;

import java.util.ArrayList;
import java.util.Scanner;

import Models.Solution;


public class Main {

    public static void main(String[] args) {
        List<Animal>  animals = new ArrayList();
        Solution solution = new Solution();
        solution.createRecordsOfAnimals(animals);
        solution.printRecords(animals);
    }
}







