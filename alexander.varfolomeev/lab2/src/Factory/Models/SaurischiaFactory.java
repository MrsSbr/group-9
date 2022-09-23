package Factory.Models;

import Factory.Interfaces.DinosaurFactory;
import Models.Dinosaur;
import Models.Saurischia;
import src.Helper;

import java.util.Scanner;

public class SaurischiaFactory implements DinosaurFactory {
    @Override
    public Dinosaur createDinosaur() {
        String name;
        double weight;
        int countOfLegs;

        Scanner in = new Scanner(System.in);

        System.out.println("Введите имя динозавра: ");
        name = in.nextLine();

        System.out.println("Введите вес динозавра: ");
        weight = Helper.getPositiveDouble();

        System.out.println("Введите количество ног: ");
        countOfLegs = Helper.getIntInDiapason(0, Integer.MAX_VALUE);

        return new Saurischia(name, weight, countOfLegs);
    }
}
