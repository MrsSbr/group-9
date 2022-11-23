package factory.Models;

import factory.Interfaces.DinosaurFactory;
import models.Dinosaur;
import models.Saurischia;
import src.Helper;

import java.util.Scanner;

public class SaurischiaFactory implements DinosaurFactory {
    @Override
    public Dinosaur createDinosaur() {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите имя динозавра: ");
        String name = in.nextLine();

        System.out.println("Введите вес динозавра: ");
        double weight = Helper.getPositiveDouble();

        System.out.println("Введите количество ног: ");
        int countOfLegs = Helper.getIntInDiapason(0, Integer.MAX_VALUE);

        return new Saurischia(name, weight, countOfLegs);
    }
}
