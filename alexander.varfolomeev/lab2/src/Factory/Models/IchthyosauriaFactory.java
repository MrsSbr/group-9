package factory.Models;

import factory.Interfaces.DinosaurFactory;
import models.Dinosaur;
import models.Ichthyosauria;
import src.Helper;

import java.util.Scanner;

public class IchthyosauriaFactory implements DinosaurFactory {
    @Override
    public Dinosaur createDinosaur() {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите имя динозавра: ");
        String name = in.nextLine();

        System.out.println("Введите вес динозавра: ");
        double weight = Helper.getPositiveDouble();

        System.out.println("Введите максимальную глубину погружения: ");
        int habitatDepth = Helper.getIntInDiapason(0, Integer.MAX_VALUE);

        return new Ichthyosauria(name, weight, habitatDepth);
    }
}
